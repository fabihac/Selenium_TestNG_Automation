

package testrunner;

import com.github.javafaker.Faker;
import config.Setup;
import config.UserModal;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.ModelRegistrationPage;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class ModelRagistrationRunner extends Setup {
    Faker faker = new Faker();
    @Test
    public void mandatoryRegistration() throws InterruptedException, IOException, ParseException {
        ModelRegistrationPage modelRegistrationPage = new ModelRegistrationPage(driver);
        modelRegistrationPage.linkRegister.click();
        String firstname = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = "fab@123";
        String phoneNumber ="01111"+ Utils.genarateRandom(100000,90000);

        //setting variables
        UserModal userModal = new UserModal();
        userModal.setFirstName(firstname);
        userModal.setEmail(email);
        userModal.setPassword(password);
        userModal.setPhoneNumber(phoneNumber);

        modelRegistrationPage.fillCredentials(userModal);

        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast")));
        String toastMessage= driver.findElement(By.className("Toastify__toast")).getText();
        String toastMessageExpected="Registration failed. Please try again.";
        System.out.println(toastMessage);
        //Assert.assertTrue(toastMessage.contains(toastMessageExpected));
        // Thread.sleep(1000);
        modelRegistrationPage.btnLoginAgain.click();
        //saving data to json
        JSONObject userObject = new JSONObject();
        userObject.put("firstName",firstname);
        userObject.put("email",email);
        userObject.put("password",password);
        userObject.put("phoneNumber",phoneNumber);


        Utils.saveUserInfo("./src/test/resources/users.json",userObject);



    }
}
