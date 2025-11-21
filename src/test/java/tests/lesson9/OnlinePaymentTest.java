package tests.lesson9;

import config.lesson9.TestConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.lesson9.MainPage;

public class OnlinePaymentTest extends TestConfig {

    @Test(priority = 1)
    public void testBlockTitle() {
        MainPage mainPage = new MainPage(driver, wait);

        String actualTitle = mainPage.getBlockTitle();

        Assert.assertTrue(actualTitle.contains("пополнение"),
                "Заголовок не содержит нужный текст. Получен: " + actualTitle);
    }

    @Test(priority = 2)
    public void testPaymentSystemLogos() {
        MainPage mainPage = new MainPage(driver, wait);

        int logosCount = mainPage.getPaymentSystemLogosCount();
        Assert.assertTrue(logosCount > 0, "Логотипы платежных систем не найдены");

        boolean allLogosDisplayed = mainPage.arePaymentSystemLogosDisplayed();
        Assert.assertTrue(allLogosDisplayed, "Не все логотипы платежных систем отображаются");
    }

    @Test(priority = 3)
    public void testDetailsLink() {
        MainPage mainPage = new MainPage(driver, wait);

        String originalUrl = driver.getCurrentUrl();
        mainPage.clickDetailsLink();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String newUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(newUrl, originalUrl,
                "Ссылка 'Подробнее о сервисе' не работает");

        driver.navigate().back();
    }

    @Test(priority = 4)
    public void testContinueButtonWithValidData() {
        MainPage mainPage = new MainPage(driver, wait);

        mainPage.enterPhoneNumber("297777777");
        mainPage.enterAmount("10");

        boolean isButtonEnabled = mainPage.isContinueButtonEnabled();
        Assert.assertTrue(isButtonEnabled,
                "Кнопка 'Продолжить' не активна при корректных данных");

        try {
            mainPage.clickContinueButton();
            System.out.println("Кнопка 'Продолжить' работает корректно");
        } catch (Exception e) {
            Assert.fail("Кнопка 'Продолжить' не работает: " + e.getMessage());
        }
    }
}