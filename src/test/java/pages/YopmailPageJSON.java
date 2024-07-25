package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YopmailPageJSON extends BasePage{

    public YopmailPageJSON(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#login")
    WebElement loginField;

    @FindBy(css = "#ifmail")
    WebElement iFrame;

    @FindBy(css ="h1+p+p a")
    WebElement confirmationLink;

    public void goToYopmail() {
        driver.get("https://yopmail.com/");
    }

    public void enterEmailAddress(String userName) throws Exception {
        typeText(loginField, userName, "Username entered!");
        typeText(loginField, Keys.ENTER, "Login");
    }

    public void switchToIframe() {
        driver.switchTo().frame(iFrame);
    }

    public void clickOnConfirmationLink() throws Exception {
        click(confirmationLink, "Confirmation link!");
    }
}
