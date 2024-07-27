package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CtShopRegistrationPageJSON extends BasePage {

    public CtShopRegistrationPageJSON(WebDriver driver) {
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

    @FindBy(css = "#registerBtn")
    WebElement registerButton;

    @FindBy(css = "#registration-message")
    List<WebElement> registrationMessage;

    @FindBy(css = "#login_email")
    WebElement loginEmailField;

    @FindBy(css = "#login_password")
    WebElement loginPasswordField;

    @FindBy(css = "#loginBtn")
    WebElement loginButton;

    @FindBy(css = "h1")
    WebElement title;

    @FindBy(css = ".error-message")
    List<WebElement> errorMessage;

    public void getToRegisterForm() throws Exception {
        assertTrueDisplayed(logo, "Logo displayed!");
        click(profileLink, "Profile link!");
        click(emailLoginButton, "Email login button!");
        click(createAccountLink, "Create account link!");
    }

    public void enterFirstName(String firstName) throws Exception {
        typeText(firstNameField, firstName, "First name field!");
    }

    public void enterLastName(String lastName) throws Exception {
        typeText(lastNameField, lastName, "Last name field!");
    }

    public void enterEmail(String email) throws Exception {
        typeText(emailField, email, "Email field!");
    }

    public void enterPassword(String password) throws Exception {
        typeText(passwordField, password, "Password field!");
    }

    public void clickOnSubscribeCheckbox(String subscribeCheckbox) throws Exception {
        click(driver.findElement(By.xpath("//input[@name='" + subscribeCheckbox + "']")), "Subscribe checkbox!");
    }

    public void clickOnRegisterButton() throws Exception {
        click(registerButton, "Register button!");
    }

    public void checkRegistrationMessage() {
        Assert.assertTrue(registrationMessage.get(0).getText().contains("Hvala na registraciji."));
    }

    public void enterLoginEmail(String loginEmail) throws Exception {
        typeText(loginEmailField, loginEmail, "Login email!");
    }

    public void enterLoginPassword(String loginPassword) throws Exception {
        typeText(loginPasswordField, loginPassword, "Login password!");
    }

    public void clickOnLoginButton() throws Exception {
        click(loginButton, "Login button!");
    }

    public void checkTitle() {
        assertEQ(title.getText(), "Moj nalog", "Title!");
    }

    public void checkErrorMessageIfEmpty(String errorMessageIfEmpty) {
        assertEQ(errorMessage.get(0).getText(), errorMessageIfEmpty, "First name, last name, email, password have not been entered!");
    }
}