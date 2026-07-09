import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class myTest {
    @Test
    public static void testMethod() {
        Allure.step("Авторизация пользователя");
        //Создаём обьект браузер и говорим ему, что нам нужен Chrome
        WebDriver driver = new ChromeDriver();
        //Просим браузер открыть веб-страницу
        driver.get("https://www.saucedemo.com/");

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.cssSelector("[data-test='password']"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        driver.quit();
    }
}
