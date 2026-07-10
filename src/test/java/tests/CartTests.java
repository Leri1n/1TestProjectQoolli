package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTests extends BaseTest {


    // Тест 1: Добавление одного товара в корзину
    @Test(description = "Добавление Backpack в корзину")
    public void addItemToCartTest() {
        // Логин
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        // Создаем страницу товаров
        InventoryPage inventory = new InventoryPage(driver, wait);
        // Добавляем товар в корзину
        inventory.addBackpackToCart();
        // Открываем корзину
        inventory.openCart();
        // Проверяем счетчик корзины после открытия корзины
        Assert.assertEquals(inventory.getCartBadge(), "1");
    }

    // Тест 2: Проверка товара в корзине
    @Test(description = "Проверка, что добавленный Backpack отображается в корзине")
    public void checkItemInCartTest() {
        // Логин
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        // Создаем страницу товаров
        InventoryPage inventory = new InventoryPage(driver, wait);
        // Добавляем товар в корзину
        inventory.addBackpackToCart();
        // Переходим в корзину
        inventory.openCart();
        // Создаем страницу корзины
        CartPage cartPage = new CartPage(driver, wait);
        // Проверяем есть ли рюкзак в корзине
        Assert.assertTrue(cartPage.isBackpackDisplayed(), "Рюкзак не обнаружился на странице корзины!");
    }

    // Тест 3: Удаление товара из корзины
    @Test(description = "Удаление Bike Light из корзины")
    public void removeItemFromCartTest() {
        // Логин
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        // Создаем страницу товаров
        InventoryPage inventory = new InventoryPage(driver, wait);
        // Добавляем товар в корзину
        inventory.addBikeLightToCart();
        // Переходим в корзину
        inventory.openCart();
        // Создаем страницу корзины
        CartPage cartPage = new CartPage(driver, wait);
        // Удаляем Bike Light
        cartPage.removeBikeLight();
        // Проверка, что товар удалён
        Assert.assertFalse(cartPage.isBikeLightPresent(), "Bike Light всё еще отображается в корзине после удаления!");
    }

    // Тест 4: Добавление двух товаров в корзину
    @Test(description = "Добавление Backpack и Bike Light в корзину")
    public void addItemsToCartTest() {
        // Логин
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        // Создаем страницу товаров
        InventoryPage inventory = new InventoryPage(driver, wait);
        // Добавляем Backpack в корзину
        inventory.addBackpackToCart();
        // Добавляем Bike Light в корзину
        inventory.addBikeLightToCart();
        // Открываем корзину
        inventory.openCart();
        CartPage cartPage = new CartPage(driver, wait);
        Assert.assertTrue(cartPage.isBackpackDisplayed(), "Backpack не отображается в корзине!");
        Assert.assertTrue(cartPage.isBikeLightDisplayed(), "Bike Light не отображается в корзине!");
    }


    // Тест 5: Попытка перейти к Checkout с пустой корзиной
    @Test(description = "Переход к Checkout с пустой корзиной")
    public void checkoutWithEmptyCartTest() {
        // Логин
        new LoginPage(driver, wait).login("standard_user", "secret_sauce");
        // Создаем страницу товаров
        InventoryPage inventory = new InventoryPage(driver, wait);
        // Переходим в корзину
        inventory.openCart();
        // Создаем страницу корзины
        CartPage cartPage = new CartPage(driver, wait);
        // Нажимаем Checkout
        cartPage.checkout();
        // Проверяем что попали на страницу checkout
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("checkout-step-one"), "Система ошибочно позволила перейти к Checkout с пустой корзиной!");
    }

}
