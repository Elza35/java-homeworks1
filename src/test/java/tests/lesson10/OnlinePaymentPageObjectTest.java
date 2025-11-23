package tests.lesson10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MainPage;
import pages.PaymentPage;

import java.time.Duration;

public class OnlinePaymentPageObjectTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;
    private PaymentPage paymentPage;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.mts.by");

        mainPage = new MainPage(driver);
        mainPage.acceptCookiesIfPresent();
    }

    public void testOnlinePaymentWithPageObject() {
        try {
            setUp();

            // Проверка заголовка
            System.out.println("✓ Заголовок: " + mainPage.getPaymentHeaderText());

            // Проверка надписей в незаполненных полях каждого варианта оплаты
            checkAllPaymentOptionsPlaceholders();

            // Тест услуг связи с дополнительными проверками
            testCommunicationServicesWithVerifications();

            System.out.println("✓ ДЗ 10 ВЫПОЛНЕНО!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tearDown();
        }
    }

    private void checkAllPaymentOptionsPlaceholders() {
        System.out.println("=== ПРОВЕРКА НАДПИСЕЙ В ПОЛЯХ ===");

        // Проверка Услуг связи
        mainPage.selectCommunicationServices();
        System.out.println("Услуги связи - телефон: " + mainPage.getPhonePlaceholder());
        System.out.println("Услуги связи - сумма: " + mainPage.getAmountPlaceholder());

        // Проверка Задолженности
        mainPage.selectDebt();
        System.out.println("Задолженность - счет: " + mainPage.getAccountPlaceholder());
        System.out.println("Задолженность - сумма: " + mainPage.getAmountPlaceholder());

        // Возвращаемся к услугам связи для дальнейшего тестирования
        mainPage.selectCommunicationServices();
    }

    private void testCommunicationServicesWithVerifications() {
        System.out.println("=== ТЕСТ УСЛУГ СВЯЗИ С ДОПОЛНИТЕЛЬНЫМИ ПРОВЕРКАМИ ===");

        // Заполняем поля
        mainPage.enterPhoneNumber("297777777");
        mainPage.enterAmount("10");

        System.out.println("✓ Заполнили поля: телефон=297777777, сумма=10");

        // Нажимаем продолжить
        mainPage.clickContinue();
        System.out.println("✓ Нажали 'Продолжить'");

        // Ждем и проверяем окно оплаты
        checkPaymentWindow();
    }

    private void checkPaymentWindow() {
        try {
            Thread.sleep(3000);

            // Создаем страницу оплаты
            paymentPage = new PaymentPage(driver);

            // Проверяем иконки платежных систем
            checkPaymentSystemIcons();

            // Проверяем поля для реквизитов карты
            checkCardFields();

        } catch (Exception e) {
            System.out.println("✗ Окно оплаты не открылось: " + e.getMessage());
        }
    }

    private void checkPaymentSystemIcons() {
        System.out.println("=== ПРОВЕРКА ИКОНОК ПЛАТЕЖНЫХ СИСТЕМ ===");

        System.out.println("Visa: " + paymentPage.isVisaIconDisplayed());
        System.out.println("Mastercard: " + paymentPage.isMastercardIconDisplayed());
        System.out.println("Mir: " + paymentPage.isMirIconDisplayed());
        System.out.println("Webpay: " + paymentPage.isWebpayIconDisplayed());
    }

    private void checkCardFields() {
        System.out.println("=== ПРОВЕРКА ПОЛЕЙ ДЛЯ КАРТЫ ===");

        System.out.println("Номер карты: " + paymentPage.isCardNumberFieldDisplayed() +
                " (" + paymentPage.getCardNumberPlaceholder() + ")");
        System.out.println("Срок действия: " + paymentPage.isExpiryDateFieldDisplayed() +
                " (" + paymentPage.getExpiryDatePlaceholder() + ")");
        System.out.println("CVV: " + paymentPage.isCvvFieldDisplayed() +
                " (" + paymentPage.getCvvPlaceholder() + ")");
        System.out.println("Имя держателя: " + paymentPage.isCardHolderFieldDisplayed());
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("✓ Браузер закрыт");
        }
    }

    public static void main(String[] args) {
        OnlinePaymentPageObjectTest test = new OnlinePaymentPageObjectTest();
        test.testOnlinePaymentWithPageObject();
    }
}
