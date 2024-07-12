package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CtShopRegistrationPage extends BasePage {

    public CtShopRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".logo a")
    WebElement logo;

    @FindBy(css = ".first .modal-link")
    WebElement profileLink;

    @FindBy(css = ".text-button.email-and-password")
    WebElement emailLoginButton;

    @FindBy(css = "#create-account-new")
    WebElement createAccountLink;

    @FindBy(css = "#firstname")
    WebElement firstNameField;

    @FindBy(css = "#lastname")
    WebElement lastNameField;

    @FindBy(css = "#email")
    WebElement emailField;

    @FindBy(css = "#password")
    WebElement passwordField;

    @FindBy(css = "#is_subscribed")
    WebElement subscribeCheckbox;

    @FindBy(css = "#registerBtn")
    WebElement registerButton;

    @FindBy(css = "#registration-message")
    List<WebElement> registrationMessage;

    @FindBy(css = "#login_email")
    WebElement loginEmail;

    @FindBy(css = "#login_password")
    WebElement loginPassword;

    @FindBy(css = "#loginBtn")
    WebElement loginButton;

    @FindBy(css = "h1")
    WebElement title;

    public void checkIfLogoIsDisplayed() {
        assertTrueDisplayed(logo, "Logo displayed!");
    }

    public void clickOnProfileLink() throws Exception {
        click(profileLink, "Profile link!");
    }

    public void clickOnEmailLoginButton() throws Exception {
        click(emailLoginButton, "Email login button!");
    }

    public void clickOnCreateAccountLink() throws Exception {
        click(createAccountLink, "Create account link!");
    }

    public void enterFirstName() throws Exception {
        typeText(firstNameField, "Tester", "First name field!");
    }

    public void enterLastName() throws Exception {
        typeText(lastNameField, "Testerovic", "Last name field!");
    }

    public void enterEmail() throws Exception {
        typeText(emailField, "tester15@yopmail.com", "Email field!");
    }

    public void enterPassword() throws Exception {
        typeText(passwordField, "Qatester1309", "Email field!");
    }

    public void clickOnSubscribeCheckbox() throws Exception {
        click(subscribeCheckbox, "Subscribe checkbox!");
    }

    public void clickOnRegisterButton() throws Exception {
        click(registerButton, "Register button!");
    }

    public void checkRegistrationMessage() {
        Assert.assertTrue(registrationMessage.get(0).getText().contains("Hvala na registraciji."));
    }

    public void enterLoginEmail() throws Exception {
        typeText(loginEmail, "tester15@yopmail.com", "Login email!");
    }

    public void enterLoginPassword() throws Exception {
        typeText(loginPassword, "Qatester1309", "Login password!");
    }

    public void clickOnLoginButton() throws Exception {
        click(loginButton, "Login button!");
    }

    public void checkTitle() {
        assertEQ(title.getText(), "Moj nalog", "Title!");
    }

}
