package pages;
import config.UserModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ModelRegistrationPage {
    @FindBy(linkText = "Register")
    public WebElement linkRegister;

    @FindBy(id="firstName")
    WebElement txtFirstName;

    @FindBy (id = "lastName")
    WebElement txtLastName;

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "phoneNumber")
    WebElement txtPhoneNumber;
    @FindBy (id = "address")
    WebElement txtAddress;

    @FindBy(css = "[type='radio']")
    List<WebElement> btnGender;

    @FindBy(css = "input[type='checkbox']")
    WebElement btnCheckbox;

    @FindBy(id ="register")
    WebElement btnRegister;

    @FindBy(css = "a[href='/login']")
    public WebElement btnLoginAgain;


    public ModelRegistrationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void fillCredentials(UserModal userModal)  {
        txtFirstName.sendKeys(userModal.getFirstName());
        txtLastName.sendKeys(userModal.getLastName()!=null?userModal.getLastName():"");
        txtEmail.sendKeys(userModal.getEmail());
        txtPassword.sendKeys(userModal.getPassword());
        txtPhoneNumber.sendKeys(userModal.getPhoneNumber());
        txtAddress.sendKeys(userModal.getAddress()!=null?userModal.getAddress():"");
        btnGender.get(0).click();
        btnCheckbox.click();
        btnRegister.click();

    }

}


