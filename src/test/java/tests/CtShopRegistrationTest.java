package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CtShopRegistrationPage;
import pages.YopmailPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CtShopRegistrationTest extends BaseTest {

    @BeforeMethod
    @Parameters({"browser", "wait", "env"})
    public void setup(String browser, String wait, String env) throws Exception {
       init(browser, wait);
       openApp(env);
    }

    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit) {
        if(quit.equalsIgnoreCase("yes")) {
            quit();
        }
    }

    @Test
    public void CtShopRegistration() throws Exception {
        CtShopRegistrationPage ctShopRegistrationPage = new CtShopRegistrationPage(driver);
        ctShopRegistrationPage.checkIfLogoIsDisplayed();
        ctShopRegistrationPage.clickOnProfileLink();
        ctShopRegistrationPage.clickOnEmailLoginButton();
        ctShopRegistrationPage.clickOnCreateAccountLink();
        ctShopRegistrationPage.enterFirstName();
        ctShopRegistrationPage.enterLastName();
        ctShopRegistrationPage.enterEmail();
        ctShopRegistrationPage.enterPassword();
        ctShopRegistrationPage.clickOnSubscribeCheckbox();
        ctShopRegistrationPage.clickOnRegisterButton();
        ctShopRegistrationPage.checkRegistrationMessage();

        YopmailPage yopmailPage = new YopmailPage(driver);
        yopmailPage.goToYopmail();
        yopmailPage.enterEmailAddress();
        yopmailPage.switchToIframe();
        yopmailPage.clickOnConfirmationLink();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login_email")));
        ctShopRegistrationPage.enterLoginEmail();
        ctShopRegistrationPage.enterLoginPassword();
        ctShopRegistrationPage.clickOnLoginButton();
        ctShopRegistrationPage.checkTitle();
    }
}
