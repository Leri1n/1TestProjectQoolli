package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;//Импорт класса ожидания
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;//Импорт класса Duration для задания временного ожидания

public class BaseTest {
    //Переменная браузера. Protected означает, что она доступна во всех классах-наследниках
    protected WebDriver driver;
    //Позволяет дождаться появления элемента на странице
    protected WebDriverWait wait;

    //Чтобы настроить браузер и открыть его
    @BeforeMethod //Метод выполняется ПЕРЕД каждым тестом
    public void setup(){
        //Создаём новый экземпляр браузера Chrome
        driver = new ChromeDriver();
        //Создаем объект явного ожидания. Selenium будет ждать элемент (пока он загрузится) до 10 секунд.
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Открываем тестовый сайт.
        driver.get("https://www.saucedemo.com/");

    }
    //Чтобы закрыть браузер
    @AfterMethod //Метод выполняется ПОСЛЕ каждого теста
    public void tearDown(){
        //Проверка, что браузер существует
        if (driver != null){
            //Полностью закрываем браузер
            driver.quit();
        }
    }

}

