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

    @FindBy(css = "#terms_of_purchase")
    WebElement termsOfPurchaseCheckbox;

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
        typeText(passwordField, password, "Email field!");
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
