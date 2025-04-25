package testrunner;

import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LoginTestRunner extends Setup {
    @Test(priority = 1 , description = "Admin login with wrong cred",enabled = false)
    public void wrongCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);//page factory te element gula initiate korte pare and driver er maddhome activity korte pare
        loginPage.doLogin("admin@test.123","admin123");

        String headerActual = driver.findElement(By.tagName("p")).getText();
        String headerExpected = "Invalid email or password";
        Assert.assertTrue(headerActual.contains(headerExpected));
        clearCredentials();

    }

    @Test(priority = 2 , description = "Admin login with right cred", enabled = false)
    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("test1@gmail.com", "12345");
        String headerActual = driver.findElement(By.tagName("h2")).getText();
        String headerExpected = "Admin Dashboard";
        Assert.assertTrue(headerActual.contains(headerExpected));

    }
    @Test(priority = 3 , description = "clear feild", enabled = false)
    public void clearCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.txtEmail.sendKeys(Keys.COMMAND,"a");
        loginPage.txtEmail.sendKeys(Keys.BACK_SPACE);
        loginPage.txtPassword.sendKeys(Keys.COMMAND,"a");
        loginPage.txtPassword.sendKeys(Keys.BACK_SPACE);
    }
    @Test(priority = 1 , description = "Admin login with json file", groups="smoke")
    public void doLogin() throws IOException, ParseException {
        LoginPage loginPage = new LoginPage(driver);
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/test/resources/users.json"));
        JSONObject user = (JSONObject) jsonArray.get(jsonArray.size()-1);
        String email = (String) user.get("email");
        String password = (String) user.get("password");
        loginPage.doLogin(email,password);

    }

}
