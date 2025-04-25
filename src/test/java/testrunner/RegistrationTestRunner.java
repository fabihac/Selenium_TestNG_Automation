package testrunner;

import config.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.time.Duration;

public class RegistrationTestRunner extends Setup {
    @Test
    public void completeregistration() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.linkRegister.click();
        String firstname = "Fab";
        String lastname = "Fab";
        String email = "fab@gmail.com";
        String password = "fab@123";
        String phoneNumber = "123456789";
        String address = "Mohakhali dohs";
        registrationPage.fillCredentials(firstname,lastname,email,password,phoneNumber,address);
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(110));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast")));
        String toastMessage= driver.findElement(By.className("Toastify__toast")).getText();
        String toastMessageExpected="Registration failed. Please try again.";
        System.out.println(toastMessage);
       // Assert.assertTrue(toastMessage.contains(toastMessageExpected));
         Thread.sleep(1000);
         registrationPage.btnLoginAgain.click();



    }
}
