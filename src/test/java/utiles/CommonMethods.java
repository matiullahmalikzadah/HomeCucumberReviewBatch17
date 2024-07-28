package utiles;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.PanelUI;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer{

    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                driver= new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        initializePageObjects();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
    }

    public static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);

    }

    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

     public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
     }

     public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);
     }

     public void CloseBrowser(){
        driver.quit();
     }

     //take screenshot method for capturing all the screenshots
    public static byte[] takeScreenshot(String fileName){
        TakesScreenshot ts= (TakesScreenshot) driver;
        //in cucumber screenshot should be taken in array of byte format
        //since the size of the image is in byte, that's why the return type of this
        //method is array of byte
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile= ts.getScreenshotAs(OutputType.FILE);
        //we will pass the path of screenshot from constants class
        try {
            FileUtils.copyFile
                    (sourceFile, new File(Constants.SCREENSHOT_FILEPATH +
                            fileName+" "+getTimeStamp("YYYY-MM-dd-HH-mm-ss")
                            +".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return picByte;
    }
    //in java we have a module which returns current data and time
    public static String getTimeStamp(String pattern){

        // note: here pattern is style of date like: MM/DD/YYYY OR DD/MM/YYYY ....
        Date date = new Date();
        //after getting the date, I need to format it as per my requirement
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        //it will return the formatted date as per the pattern in string format
        return sdf.format(date);
    }

    }

