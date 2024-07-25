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
import utils.DataUtilSuccessfulRegistration;

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

    @Test(dataProviderClass = DataUtilSuccessfulRegistration.class, dataProvider = "dataProviderSuccessfulRegistration")
    public void CtShopRegistration(HashMap<String,String> hashMap) throws Exception {
        CtShopRegistrationPageJSON ctShopRegistrationPageJSON = new CtShopRegistrationPageJSON(driver);
        ctShopRegistrationPageJSON.getToRegisterForm();
        ctShopRegistrationPageJSON.enterFirstName(hashMap.get("First Name"));
        ctShopRegistrationPageJSON.enterLastName(hashMap.get("Last Name"));
        ctShopRegistrationPageJSON.enterEmail(hashMap.get("Email"));
        ctShopRegistrationPageJSON.enterPassword(hashMap.get("Password"));
        ctShopRegistrationPageJSON.clickOnSubscribeCheckbox(hashMap.get("Subscribe Checkbox"));
        ctShopRegistrationPageJSON.clickOnRegisterButton();
        ctShopRegistrationPageJSON.checkRegistrationMessage();

        YopmailPageJSON yopmailPageJSON = new YopmailPageJSON(driver);
        yopmailPageJSON.goToYopmail();
        yopmailPageJSON.enterEmailAddress(hashMap.get("User Name"));
        yopmailPageJSON.switchToIframe();
        yopmailPageJSON.clickOnConfirmationLink();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login_email")));
        ctShopRegistrationPageJSON.enterLoginEmail(hashMap.get("Login Email"));
        ctShopRegistrationPageJSON.enterLoginPassword(hashMap.get("Login Password"));
        ctShopRegistrationPageJSON.clickOnLoginButton();
        ctShopRegistrationPageJSON.checkTitle();
    }
}
