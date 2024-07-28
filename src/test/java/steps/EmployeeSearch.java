package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utiles.CommonMethods;

import java.time.Duration;

public class EmployeeSearch extends CommonMethods {

    @When("user click on PIM option")
    public void user_click_on_pim_option() throws InterruptedException {

        //WebElement clickPim = driver.findElement(By.id("menu_pim_viewPimModule"));
        //clickPim.click();
        click(dashboardPage.pimOption);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @When("user click on employee List option")
    public void user_click_on_employee_list_option() throws InterruptedException {
       // WebElement listEmployee = driver.findElement(By.id("menu_pim_viewEmployeeList"));
       // listEmployee.click();
        click(dashboardPage.empListOption);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("user enters employee id")
    public void user_enters_employee_id() {
       // WebElement enterId = driver.findElement(By.id("empsearch_id"));
        //enterId.sendKeys("109759A");
        sendText(employeeSearchPage.empSearchIdField, "109759A");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("user click on search button")
    public void user_click_on_search_button() throws InterruptedException {
        //WebElement clickBtn = driver.findElement(By.id("searchBtn"));
        //clickBtn.click();
        click(employeeSearchPage.SearchBtn);

    }
    @Then("user should be able to see employee details")
    public void user_should_be_able_to_see_employee_details() {

        System.out.println("your id successfully searched ");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
       // WebElement name= driver.findElement(By.id("empsearch_employee_name_empName"));
        //name.sendKeys("Bushra Atina");
        sendText(employeeSearchPage.empSearchIdField, "Bushra Atina");
    }
}
