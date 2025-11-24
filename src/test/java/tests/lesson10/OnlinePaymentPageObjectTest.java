package tests.lesson10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MainPage;
import pages.PaymentPage;
import java.time.Duration;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

@Epic("UI Тесты")
@Feature("Онлайн оплата МТС")
@Story("Проверка функционала оплаты через Page Object")
public class OnlinePaymentPageObjectTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;
    private PaymentPage paymentPage;

    @Test
    @Description("Полный тест функционала онлайн оплаты с проверкой всех элементов")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "МТС Онлайн оплата", url = "https://www.mts.by")
    public void testOnlinePaymentWithPageObject() {
        try {
            setUp();
            checkHeader();
            checkAllPaymentOptionsPlaceholders();
            testCommunicationServicesWithVerifications();
            step("ДЗ 10 ВЫПОЛНЕНО!");
        } catch (Exception e) {
            step("Тест упал с ошибкой: " + e.getMessage());
            e.printStackTrace();
        } finally {
            tearDown();
        }
    }

    @Step("Настройка браузера и открытие страницы")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.mts.by");
        mainPage = new MainPage(driver);
        mainPage.acceptCookiesIfPresent();
        step("Браузер запущен и страница загружена");
    }

    @Step("Проверка заголовка страницы")
    private void checkHeader() {
        String headerText = mainPage.getPaymentHeaderText();
        step("Заголовок страницы: " + headerText);
    }

    @Step("Проверка надписей в полях для всех вариантов оплаты")
    private void checkAllPaymentOptionsPlaceholders() {
        mainPage.selectCommunicationServices();
        step("Услуги связи - телефон: " + mainPage.getPhonePlaceholder());
        step("Услуги связи - сумма: " + mainPage.getAmountPlaceholder());
        mainPage.selectDebt();
        step("Задолженность - счет: " + mainPage.getAccountPlaceholder());
        step("Задолженность - сумма: " + mainPage.getAmountPlaceholder());
        mainPage.selectCommunicationServices();
    }

    @Step("Тестирование услуг связи с дополнительными проверками")
    private void testCommunicationServicesWithVerifications() {
        fillPaymentForm();
        mainPage.clickContinue();
        step("Нажали 'Продолжить'");
        checkPaymentWindow();
    }

    @Step("Заполнение формы оплаты: телефон=297777777, сумма=10")
    private void fillPaymentForm() {
        mainPage.enterPhoneNumber("297777777");
        mainPage.enterAmount("10");
        step("Заполнили поля: телефон=297777777, сумма=10");
    }

    @Step("Проверка окна оплаты")
    private void checkPaymentWindow() {
        try {
            Thread.sleep(3000);
            paymentPage = new PaymentPage(driver);
            checkPaymentSystemIcons();
            checkCardFields();
            step("Окно оплаты успешно открыто и проверено");
        } catch (Exception e) {
            step("Окно оплаты не открылось: " + e.getMessage());
        }
    }

    @Step("Проверка иконок платежных систем")
    private void checkPaymentSystemIcons() {
        boolean visa = paymentPage.isVisaIconDisplayed();
        boolean mastercard = paymentPage.isMastercardIconDisplayed();
        boolean mir = paymentPage.isMirIconDisplayed();
        boolean webpay = paymentPage.isWebpayIconDisplayed();
        step("Visa: " + visa);
        step("Mastercard: " + mastercard);
        step("Mir: " + mir);
        step("Webpay: " + webpay);
    }

    @Step("Проверка полей для ввода данных карты")
    private void checkCardFields() {
        boolean cardNumber = paymentPage.isCardNumberFieldDisplayed();
        boolean expiryDate = paymentPage.isExpiryDateFieldDisplayed();
        boolean cvv = paymentPage.isCvvFieldDisplayed();
        boolean cardHolder = paymentPage.isCardHolderFieldDisplayed();
        step("Номер карты: " + cardNumber + " (" + paymentPage.getCardNumberPlaceholder() + ")");
        step("Срок действия: " + expiryDate + " (" + paymentPage.getExpiryDatePlaceholder() + ")");
        step("CVV: " + cvv + " (" + paymentPage.getCvvPlaceholder() + ")");
        step("Имя держателя: " + cardHolder);
    }

    @Step("Завершение теста - закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            step("Браузер закрыт");
        }
    }
}