package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    //Чтобы настроить браузер и открыть его
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

    }
    //Чтобы закрыть браузер
    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}

