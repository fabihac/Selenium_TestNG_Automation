
package testrunner;

import config.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;



public class SecureLoginCredRunner extends Setup {
    @Test( description = "Admin login with wrong cred")
    public void wrongCredentials()  {
        LoginPage loginPage = new LoginPage(driver);//page factory te element gula initiate korte pare and driver er maddhome activity korte pare
        String username = System.getProperty("username");
        String password = System.getProperty("password");
        loginPage.doLogin(username,password);

        String headerActual = driver.findElement(By.tagName("p")).getText();
        String headerExpected = "Invalid email or password";
        Assert.assertTrue(headerActual.contains(headerExpected));

    }


}
//gradle clean test -Pusername="admin@gmail.com" && -Ppassword="1234"