package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "//img[contains(@src, 'visa')]")
    private WebElement visaIcon;

    @FindBy(xpath = "//img[contains(@src, 'mastercard')]")
    private WebElement mastercardIcon;

    @FindBy(xpath = "//img[contains(@src, 'mir')]")
    private WebElement mirIcon;

    @FindBy(xpath = "//img[contains(@src, 'webpay')]")
    private WebElement webpayIcon;

    @FindBy(xpath = "//input[contains(@placeholder, 'Номер карты')]")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//input[contains(@placeholder, 'Срок действия')]")
    private WebElement expiryDateInput;

    @FindBy(xpath = "//input[contains(@placeholder, 'CVV')]")
    private WebElement cvvInput;

    @FindBy(xpath = "//input[contains(@placeholder, 'Имя держателя')]")
    private WebElement cardHolderInput;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVisaIconDisplayed() {
        try {
            return visaIcon.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isMastercardIconDisplayed() {
        try {
            return mastercardIcon.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isMirIconDisplayed() {
        try {
            return mirIcon.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isWebpayIconDisplayed() {
        try {
            return webpayIcon.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCardNumberFieldDisplayed() {
        try {
            return cardNumberInput.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isExpiryDateFieldDisplayed() {
        try {
            return expiryDateInput.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCvvFieldDisplayed() {
        try {
            return cvvInput.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCardHolderFieldDisplayed() {
        try {
            return cardHolderInput.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getCardNumberPlaceholder() {
        try {
            return cardNumberInput.getAttribute("placeholder");
        } catch (Exception e) {
            return "";
        }
    }

    public String getExpiryDatePlaceholder() {
        try {
            return expiryDateInput.getAttribute("placeholder");
        } catch (Exception e) {
            return "";
        }
    }

    public String getCvvPlaceholder() {
        try {
            return cvvInput.getAttribute("placeholder");
        } catch (Exception e) {
            return "";
        }
    }
}
