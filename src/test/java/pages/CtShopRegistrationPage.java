package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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

    @FindBy(css = ".error-message")
    List<WebElement> errorMessage;

    @FindBy(css = "#terms_of_purchase")
    WebElement termsOfPurchaseCheckbox;

    public void getToRegisterForm() throws Exception {
        assertTrueDisplayed(logo, "Logo displayed!");
        click(profileLink, "Profile link!");
        click(emailLoginButton, "Email login button!");
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

    public void checkErrorMessageIfFirstNameEmpty() {
        assertEQ(errorMessage.get(0).getText(), "Niste uneli ime!", "First name empty!");
    }

    public void checkErrorMessageIfLastNameEmpty() {
        assertEQ(errorMessage.get(0).getText(), "Niste uneli prezime!", "Last name empty!");
    }

    public void checkErrorMessageIfEmailEmpty() {
        assertEQ(errorMessage.get(0).getText(), "Niste uneli email!", "Email empty!");
    }

    public void checkErrorMessageIfPasswordEmpty() {
        assertEQ(errorMessage.get(0).getText(), "Niste uneli šifru!", "Password empty!");
    }

    public void clickOnTermsOfPurchaseCheckbox() throws Exception {
        click(termsOfPurchaseCheckbox, "Terms of purchase checkbox!");
    }

    public void checkErrorMessageIfTermsOfPurchaseCheckboxNotSelected() {
        assertEQ(errorMessage.get(0).getText(), "Molimo vas da prihvatite Uslove kupovine kako biste nastavili sa registracijom.", "Terms of purchase checkbox not selected!");
    }

    public void checkAllErrorMessages() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorMessage.get(0).getText(), "Niste uneli ime!");
        softAssert.assertEquals(errorMessage.get(1).getText(), "Niste uneli prezime!");
        softAssert.assertEquals(errorMessage.get(2).getText(), "Niste uneli email!");
        softAssert.assertEquals(errorMessage.get(3).getText(), "Niste uneli šifru!");
        softAssert.assertEquals(errorMessage.get(4).getText(), "Molimo vas da prihvatite Uslove kupovine kako biste nastavili sa registracijom.");
        softAssert.assertAll();
    }
}
