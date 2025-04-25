package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Setup {
    public WebDriver driver;
    @BeforeClass()
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://dailyfinance.roadtocareer.net/");

    }
    @AfterTest()
    public void tearDown(){
        driver.quit();

    }
}
