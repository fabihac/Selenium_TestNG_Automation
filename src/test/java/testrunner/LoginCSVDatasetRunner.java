package testrunner;

import config.LoginDatasetCSV;
import config.Setup;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginCSVDatasetRunner extends Setup {
    @Test(dataProvider="LoginCSVData", dataProviderClass= LoginDatasetCSV.class)
    public void doLogin(String email, String password) {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.doLogin(email,password);

    }
}
