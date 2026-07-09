package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait; //Переменная явного ожидания

    private By username = By.id("user-name");
    private By password = By.cssSelector("[data-test='password']");
    private By loginButton = By.xpath("//input[@id='login-button']");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver; //Сохраняем браузер
        this.wait = wait; //Сохраняем ожидание.
    }
    //Когда создается объект LoginPage, в него передается браузер и ожидание.


    public void login(String user, String pass){
        Allure.step("Авторизация пользователя"); //Добавляем шаг в отчет Allure
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)); //Ждем пока поле Username загрузится
        driver.findElement(username).sendKeys(user); //Вводим логин.
        driver.findElement(password). sendKeys(pass); //Вводим пароль.
        driver.findElement(loginButton).click(); //Нажимаем Login.
    }

    public String getErrorText(){
        Allure.step("Получение текста ошибки"); //Добавляем шаг в отчет Allure.
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)); // Ждем появления сообщения об ошибке.
        return driver.findElement(errorMessage).getText();
    }
}
