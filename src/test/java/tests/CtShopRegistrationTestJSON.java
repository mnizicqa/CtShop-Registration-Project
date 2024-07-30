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
import utils.DataUtilRegistration;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
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

    @Test(dataProviderClass = DataUtilRegistration.class, dataProvider = "dataProviderSuccessfulRegistration")
    public void CtShopSuccessfulRegistration(HashMap<String, String> data) throws Exception {
        CtShopRegistrationPageJSON ctShopRegistrationPageJSON = new CtShopRegistrationPageJSON(driver);
        ctShopRegistrationPageJSON.getToRegisterForm();
        ctShopRegistrationPageJSON.enterFirstName(data.get("First Name"));
        ctShopRegistrationPageJSON.enterLastName(data.get("Last Name"));
        ctShopRegistrationPageJSON.enterEmail(data.get("Email"));
        ctShopRegistrationPageJSON.enterPassword(data.get("Password"));
        ctShopRegistrationPageJSON.clickOnSubscribeCheckbox(data.get("Subscribe Checkbox"));
        ctShopRegistrationPageJSON.clickOnRegisterButton();
        ctShopRegistrationPageJSON.checkRegistrationMessage();

        YopmailPageJSON yopmailPageJSON = new YopmailPageJSON(driver);
        yopmailPageJSON.goToYopmail();

        yopmailPageJSON.enterEmailAddress(data.get("User Name"));
        yopmailPageJSON.switchToIframe();
        yopmailPageJSON.clickOnConfirmationLink();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login_email")));
        ctShopRegistrationPageJSON.enterLoginEmail(data.get("Login Email"));
        ctShopRegistrationPageJSON.enterLoginPassword(data.get("Login Password"));
        ctShopRegistrationPageJSON.clickOnLoginButton();
        ctShopRegistrationPageJSON.checkTitle();
    }

    @Test(dataProviderClass = DataUtilRegistration.class, dataProvider = "dataProviderErrorMessages")
    public void CtShopRegistrationErrorMessages(String data) throws Exception {
        String[] registerInfo = data.split(",");
        CtShopRegistrationPageJSON ctShopRegistrationPageJSON = new CtShopRegistrationPageJSON(driver);
        ctShopRegistrationPageJSON.getToRegisterForm();
        ctShopRegistrationPageJSON.enterFirstName(registerInfo[0]);
        ctShopRegistrationPageJSON.enterLastName(registerInfo[1]);
        ctShopRegistrationPageJSON.enterEmail(registerInfo[2]);
        ctShopRegistrationPageJSON.enterPassword(registerInfo[3]);
        ctShopRegistrationPageJSON.clickOnRegisterButton();
        ctShopRegistrationPageJSON.checkErrorMessageIfEmpty(registerInfo[4]);
    }
}
