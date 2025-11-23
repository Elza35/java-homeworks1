package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Онлайн пополнение')]")
    private WebElement paymentHeader;

    @FindBy(xpath = "//*[contains(text(), 'Услуги связи')]")
    private WebElement communicationServicesTab;

    @FindBy(xpath = "//*[contains(text(), 'Задолженность')]")
    private WebElement debtTab;

    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement amountInput;

    @FindBy(xpath = "//input[@placeholder='Номер счета на 44']")
    private WebElement accountInput;

    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPaymentHeaderDisplayed() {
        return paymentHeader.isDisplayed();
    }

    public String getPaymentHeaderText() {
        return paymentHeader.getText();
    }

    public void selectCommunicationServices() {
        communicationServicesTab.click();
    }

    public void selectDebt() {
        debtTab.click();
    }

    public void enterPhoneNumber(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void enterAmount(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void enterAccountNumber(String account) {
        accountInput.clear();
        accountInput.sendKeys(account);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public String getPhonePlaceholder() {
        return phoneInput.getAttribute("placeholder");
    }

    public String getAmountPlaceholder() {
        return amountInput.getAttribute("placeholder");
    }

    public String getAccountPlaceholder() {
        return accountInput.getAttribute("placeholder");
    }

    public void acceptCookiesIfPresent() {
        try {
            WebElement acceptCookiesButton = driver.findElement(
                    org.openqa.selenium.By.xpath("//button[contains(text(), 'Принять')]"));
            acceptCookiesButton.click();
        } catch (Exception e) {
            // Куки не найдены
        }
    }
}