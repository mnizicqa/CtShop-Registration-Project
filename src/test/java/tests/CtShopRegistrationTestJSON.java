package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CtShopRegistrationPageJSON;
import pages.YopmailPageJSON;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CtShopRegistrationTestJSON extends BaseTest {

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
        CtShopRegistrationPageJSON ctShopRegistrationPageJSON = new CtShopRegistrationPageJSON(driver);
        ctShopRegistrationPageJSON.getToRegisterForm();
        ctShopRegistrationPageJSON.enterFirstName("Tester007");
        ctShopRegistrationPageJSON.enterLastName("Testerovic");
        ctShopRegistrationPageJSON.enterEmail("tester007@yopmail.com");
        ctShopRegistrationPageJSON.enterPassword("Qatester1309");
        ctShopRegistrationPageJSON.clickOnSubscribeCheckbox("is_subscribed");
        ctShopRegistrationPageJSON.clickOnRegisterButton();
        ctShopRegistrationPageJSON.checkRegistrationMessage();

        YopmailPageJSON yopmailPageJSON = new YopmailPageJSON(driver);
        yopmailPageJSON.goToYopmail();
        yopmailPageJSON.enterEmailAddress("tester007");
        yopmailPageJSON.switchToIframe();
        yopmailPageJSON.clickOnConfirmationLink();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login_email")));
        ctShopRegistrationPageJSON.enterLoginEmail("tester007@yopmail.com");
        ctShopRegistrationPageJSON.enterLoginPassword("Qatester1309");
        ctShopRegistrationPageJSON.clickOnLoginButton();
        ctShopRegistrationPageJSON.checkTitle();
    }
}
