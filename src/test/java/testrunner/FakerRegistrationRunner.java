
package testrunner;

import com.github.javafaker.Faker;
import config.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FakerRagistrationPage;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class FakerRegistrationRunner extends Setup {
    Faker  faker = new Faker();
    @Test
    public void completeRegistration() throws InterruptedException, IOException, ParseException {
        FakerRagistrationPage registrationPage = new FakerRagistrationPage(driver);
        registrationPage.linkRegister.click();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = "fab@123";
        String phoneNumber ="01111"+ Utils.genarateRandom(100000,90000);
        String address = faker.address().fullAddress();
        registrationPage.fillCredentials(firstname,lastname,email,password,phoneNumber,address);
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast")));
        String toastMessage= driver.findElement(By.className("Toastify__toast")).getText();
        String toastMessageExpected="Registration failed. Please try again.";
        System.out.println(toastMessage);
        //Assert.assertTrue(toastMessage.contains(toastMessageExpected));
        // Thread.sleep(1000);
        registrationPage.btnLoginAgain.click();

        JSONObject  userObject = new JSONObject();
        userObject.put("firstName",firstname);
        userObject.put("lastName",lastname);
        userObject.put("email",email);
        userObject.put("password",password);
        userObject.put("phoneNumber",phoneNumber);
        userObject.put("address",address);

        Utils.saveUserInfo("./src/test/resources/users.json",userObject);



    }
}
