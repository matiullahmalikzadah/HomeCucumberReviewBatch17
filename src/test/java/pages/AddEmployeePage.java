package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utiles.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(id="firstName")
    public WebElement firstNameLoc;

    @FindBy(id="middleName")
    public WebElement middleNameLoc;

    @FindBy(id="lastName")
    public WebElement lastNameLoc;

    @FindBy(id="photofile")
    public WebElement photograph;

    @FindBy(id="chkLogin")
    public WebElement CheckBox;

    @FindBy(id="user_name")
    public WebElement EmpUserName;

    @FindBy(id="user_password")
    public WebElement EmpUserPassword;

    @FindBy(id="re_password")
    public WebElement EmpUserRePassword;

    @FindBy(id="btnSave")
    public WebElement saveBtnLoc;

    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }
}
