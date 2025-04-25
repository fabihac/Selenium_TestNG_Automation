package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FakerRagistrationPage {
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


    public FakerRagistrationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void fillCredentials(String firstName, String lastName, String email, String password, String phoneNumber, String address) throws InterruptedException {
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        txtPhoneNumber.sendKeys(phoneNumber);
        txtAddress.sendKeys(address);
        btnGender.get(0).click();
        btnCheckbox.click();
        btnRegister.click();


    }

}

