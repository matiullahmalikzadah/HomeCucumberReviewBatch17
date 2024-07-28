package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utiles.CommonMethods;
import utiles.Constants;
import utiles.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class addEmployeeSteps extends CommonMethods {

    @When("user click on add employee option")
    public void user_click_on_add_employee_option() {
        //WebElement addEmployeeBtn = driver.findElement(By.id("menu_pim_addEmployee"));
        click(dashboardPage.addEmployeeOption);
    }
    @When("user enters firtsName midleName and lastName")
    public void user_enters_firts_name_midle_name_and_last_name() {
        //WebElement fistNamefield = driver.findElement(By.id("firstName"));
        //WebElement mildeNamefield = driver.findElement(By.id("middleName"));
        // WebElement lastamefield = driver.findElement(By.id("lastName"));

        sendText(addEmployeePage.firstNameLoc, "Matii");
        sendText(addEmployeePage.middleNameLoc, "joon");
        sendText(addEmployeePage.lastNameLoc, "khannn");

    }
    @When("user click on save button")
    public void user_click_on_save_button() {
        //WebElement saveBtn = driver.findElement(By.xpath("//*[@id='btnSave']"));
        click(addEmployeePage.saveBtnLoc);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("employee added");
    }
    @Then("user close the browser")
    public void user_close_the_browser() {
        CloseBrowser();
    }
    @When("user enters {string} AND {string} and {string}")
    public void user_enters_and_and(String firstN, String middleN, String lastN) {
        //WebElement fistNamefield = driver.findElement(By.id("firstName"));
       // WebElement mildeNamefield = driver.findElement(By.id("middleName"));
        //WebElement lastamefield = driver.findElement(By.id("lastName"));

        sendText(addEmployeePage.lastNameLoc, firstN);
        sendText(addEmployeePage.middleNameLoc, middleN);
        sendText(addEmployeePage.lastNameLoc, lastN);
    }
    @When("user enters {string} AND {string} and enters {string}")
    public void user_enters_and_and_enters(String firstN, String middleN, String lastN) {
       // WebElement fistNamefield = driver.findElement(By.id("firstName"));
       // WebElement mildeNamefield = driver.findElement(By.id("middleName"));
       // WebElement lastamefield = driver.findElement(By.id("lastName"));

        sendText(addEmployeePage.firstNameLoc, firstN);
        sendText(addEmployeePage.middleNameLoc, middleN);
        sendText(addEmployeePage.lastNameLoc, lastN);
    }

    @When("user add multiple employees from excel file using {string} and verify them")
    public void user_add_multiple_employees_from_excel_file_using_and_verify_them(String sheetName) throws InterruptedException {
        List<Map<String, String>> newEmployees =
        ExcelReader.read(sheetName, Constants.TESTDATA_FILEPATH);

        //from the list pf maps, we need one map at one point of time
        //this iterator will give me one map to add one employee at a time
        Iterator<Map<String ,String>> itr = newEmployees.iterator();
        //it checks whether we have values in map or not
        while (itr.hasNext()){
            //it will return the keys and the value of the map which we store in this variable
            Map<String , String> employeeMap = itr.next();
            sendText(addEmployeePage.firstNameLoc, employeeMap.get("firstName"));
            sendText(addEmployeePage.middleNameLoc, employeeMap.get("MiddleName"));
            sendText(addEmployeePage.lastNameLoc, employeeMap.get("LastName"));
            sendText(addEmployeePage.photograph, employeeMap.get("photograph"));
            if (!addEmployeePage.CheckBox.isEnabled()){
                click(addEmployeePage.CheckBox);
            }
            sendText(addEmployeePage.EmpUserName, employeeMap.get("userName"));
            sendText(addEmployeePage.EmpUserPassword, employeeMap.get("password"));
            sendText(addEmployeePage.EmpUserRePassword, employeeMap.get("confirmPassword"));
            click(addEmployeePage.saveBtnLoc);
            Thread.sleep(2000);

            // because we want to add many employees
            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);
            //verification of employee still pending

        }

    }
    @When("user adds multiple employees from data table")
    public void user_adds_multiple_employees_from_data_table
            (io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        for (Map<String, String> map:employeeNames) {
            sendText(addEmployeePage.firstNameLoc, map.get("firstName"));
            sendText(addEmployeePage.middleNameLoc, map.get("middleName"));
            sendText(addEmployeePage.lastNameLoc, map.get("lastName"));
            click(addEmployeePage.saveBtnLoc);
            Thread.sleep(2000);
            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);
        }

    }
}
