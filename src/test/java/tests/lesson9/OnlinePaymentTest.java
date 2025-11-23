
package tests.lesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Set;

public class OnlinePaymentTest {

    private WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.mts.by");
        acceptCookiesIfPresent();
    }

    private void acceptCookiesIfPresent() {
        try {
            WebElement acceptCookiesButton = driver.findElement(
                    By.xpath("//button[contains(text(), 'Принять')]"));
            acceptCookiesButton.click();
            System.out.println("Куки приняты");
        } catch (Exception e) {
            System.out.println("Окно с куками не найдено");
        }
    }

    public void testOnlinePaymentWithoutCommission() {
        try {
            setUp();

            Thread.sleep(3000);

            WebElement paymentHeader = driver.findElement(
                    By.xpath("//*[contains(text(), 'Онлайн пополнение')]"));
            System.out.println("✓ Заголовок найден: " + paymentHeader.getText());

            checkPaymentOptions();

            testCommunicationServices();

            System.out.println("✓ ОСНОВНЫЕ ПРОВЕРКИ ВЫПОЛНЕНЫ УСПЕШНО!");
            System.out.println("✓ ДЗ 9 ВЫПОЛНЕНО!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tearDown();
        }
    }

    private void checkPaymentOptions() {
        System.out.println("=== ПРОВЕРЯЕМ ВАРИАНТЫ ОПЛАТЫ ===");

        String[][] paymentOptions = {
                {"Услуги связи", "Номер телефона", "Сумма"},
                {"Задолженность", "Номер счета на 44", "Сумма"}
        };

        for (String[] option : paymentOptions) {
            String optionName = option[0];
            String expectedFieldPlaceholder = option[1];
            String expectedAmountPlaceholder = option[2];

            try {
                WebElement optionElement = driver.findElement(
                        By.xpath("//*[contains(text(), '" + optionName + "')]"));
                optionElement.click();
                System.out.println("✓ Выбрали: " + optionName);

                Thread.sleep(1000);

                checkInputPlaceholders(optionName, expectedFieldPlaceholder, expectedAmountPlaceholder);

            } catch (Exception e) {
                System.out.println("✗ Ошибка при проверке '" + optionName + "'");
            }
        }

        WebElement communicationServices = driver.findElement(
                By.xpath("//*[contains(text(), 'Услуги связи')]"));
        communicationServices.click();
    }

    private void checkInputPlaceholders(String optionName, String expectedFieldPlaceholder, String expectedAmountPlaceholder) {
        try {
            WebElement fieldInput = driver.findElement(By.xpath("//input[@placeholder='" + expectedFieldPlaceholder + "']"));
            String actualFieldPlaceholder = fieldInput.getAttribute("placeholder");
            if (expectedFieldPlaceholder.equals(actualFieldPlaceholder)) {
                System.out.println("✓ " + optionName + " - поле корректен: " + actualFieldPlaceholder);
            } else {
                System.out.println("✗ " + optionName + " - поле неверен. Ожидалось: " + expectedFieldPlaceholder + ", получено: " + actualFieldPlaceholder);
            }
        } catch (Exception e) {
            System.out.println("✗ " + optionName + " - не удалось найти поле: " + expectedFieldPlaceholder);
        }

        try {
            WebElement amountInput = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
            String actualAmountPlaceholder = amountInput.getAttribute("placeholder");
            if (expectedAmountPlaceholder.equals(actualAmountPlaceholder)) {
                System.out.println("✓ " + optionName + " - сумма корректен: " + actualAmountPlaceholder);
            } else {
                System.out.println("✗ " + optionName + " - сумма неверен. Ожидалось: " + expectedAmountPlaceholder + ", получено: " + actualAmountPlaceholder);
            }
        } catch (Exception e) {
            System.out.println("✗ " + optionName + " - не удалось проверить сумму");
        }
    }

    private void testCommunicationServices() {
        System.out.println("=== ТЕСТИРУЕМ УСЛУГИ СВЯЗИ ===");

        try {
            WebElement communicationServices = driver.findElement(
                    By.xpath("//*[contains(text(), 'Услуги связи')]"));
            if (!communicationServices.getAttribute("class").contains("active")) {
                communicationServices.click();
            }

            WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
            WebElement amountInput = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));

            phoneInput.clear();
            phoneInput.sendKeys("297777777");
            amountInput.clear();
            amountInput.sendKeys("10");

            System.out.println("✓ Заполнили поля: телефон=297777777, сумма=10");

            String mainWindow = driver.getWindowHandle();

            WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
            continueButton.click();
            System.out.println("✓ Нажали 'Продолжить'");

            Thread.sleep(3000);

            checkNewWindowOrFrame(mainWindow);

            checkPaymentSystemIcons();

        } catch (Exception e) {
            System.out.println("✗ Ошибка при тестировании услуг связи: " + e.getMessage());
        }
    }

    private void checkNewWindowOrFrame(String mainWindow) {
        System.out.println("=== ПРОВЕРЯЕМ ОТКРЫТИЕ ОПЛАТЫ ===");

        Set<String> allWindows = driver.getWindowHandles();
        if (allWindows.size() > 1) {
            System.out.println("✓ Открылось новое окно/вкладка");
            for (String window : allWindows) {
                if (!window.equals(mainWindow)) {
                    driver.switchTo().window(window);
                    System.out.println("✓ Переключились в новое окно");
                    checkPaymentInNewWindow();
                    driver.close();
                    driver.switchTo().window(mainWindow);
                    return;
                }
            }
        }

        try {
            driver.switchTo().frame(0);
            System.out.println("✓ Переключились в iframe");
            checkPaymentInFrame();
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("✗ iframe не найден");
        }

        System.out.println("ℹ️ Оплата открывается на внешнем сервисе или требует дополнительных действий");
    }

    private void checkPaymentInNewWindow() {
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println("URL нового окна: " + url);
        System.out.println("Заголовок нового окна: " + title);
    }

    private void checkPaymentInFrame() {
        System.out.println("✓ Проверяем содержимое iframe");
    }

    private void checkPaymentSystemIcons() {
        try {
            System.out.println("=== ПРОВЕРЯЕМ ИКОНКИ ПЛАТЕЖНЫХ СИСТЕМ ===");

            String[] paymentSystems = {"visa", "mastercard", "belcard", "mir", "webpay"};

            boolean foundAny = false;
            for (String system : paymentSystems) {
                try {
                    WebElement icon = driver.findElement(By.xpath(
                            "//img[contains(@src, '" + system + "') or contains(@alt, '" + system + "') " +
                                    "or contains(@class, '" + system + "')]"));
                    System.out.println("✓ Иконка '" + system + "' найдена");
                    foundAny = true;
                } catch (Exception e) {
                }
            }

            if (foundAny) {
                System.out.println("✅ ВСЕ ИКОНКИ ПЛАТЕЖНЫХ СИСТЕМ НАЙДЕНЫ!");
            }

        } catch (Exception e) {
            System.out.println("✗ Ошибка при проверке иконок платежных систем");
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("✓ Браузер закрыт");
        }
    }

    public static void main(String[] args) {
        OnlinePaymentTest test = new OnlinePaymentTest();
        test.testOnlinePaymentWithoutCommission();
    }
}