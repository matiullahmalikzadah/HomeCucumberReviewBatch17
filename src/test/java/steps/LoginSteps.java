package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utiles.CommonMethods;
import utiles.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

   // public WebDriver driver;


    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() throws InterruptedException {
        //driver = new ChromeDriver();
        //driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        //Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        openBrowserAndLaunchApplication();
    }
    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() throws InterruptedException {
        //object of the login page class to access all the web elements
        //LoginPage lg=new LoginPage();
        //WebElement usernameTextField = driver.findElement(By.xpath("//*[@id='txtUsername']"));
        //usernameTextField.sendKeys("admin");
        sendText(loginPage.usernameTextField, ConfigReader.getPropertyValue("username"));
        //Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // WebElement passwordTextField = driver.findElement(By.xpath("//*[@id='txtPassword']"));
       sendText(loginPage.passwordTextField, ConfigReader.getPropertyValue("password"));
        //passwordTextField.sendKeys("Hum@nhrm123");

    }
    @When("user click on login button")
    public void user_click_on_login_button() throws InterruptedException {
        //WebElement loginBtn = driver.findElement(By.cssSelector("input#btnLogin"));
        click(loginPage.loginButton);
        // loginBtn.click();
        //Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        //System.out.println(1/0);
        System.out.println("my test passed");
        //ASSERTIONS TO CHECK IF THE ELEMENTEXIST
        //the moment assertion finds error, it stops the execution
       // Assert.assertEquals();
        //it is a boolean condition we write to check if it returns true or fals
        Assert.assertTrue(dashboardPage.welcomeAdminOption.isDisplayed());

    }

}
