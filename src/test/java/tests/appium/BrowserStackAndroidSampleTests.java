package tests.appium;

import helpers.BrowserstackHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static config.ProjectData.androidConfig;
import static config.ProjectData.browserStackConfig;

@Tag("appium_android")
@DisplayName("Successful search in wikipedia android app (SELENIDE)")
public class BrowserStackAndroidSampleTests {
    private  AndroidDriver<AndroidElement> driver;

    @BeforeEach
    void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", browserStackConfig.bsLogin());
        caps.setCapability("browserstack.key", browserStackConfig.bsPassword());

        // Set URL of the application under test
        caps.setCapability("app", androidConfig.app());

        // Specify device and os_version for testing
        caps.setCapability("device", androidConfig.device());
        caps.setCapability("os_version", androidConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "Appium");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        driver = new AndroidDriver<>(
                BrowserstackHelper.getBrowserstackUrl(), caps);
    }

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() throws InterruptedException {
        // Test case for the BrowserStack sample Android app.
        // If you have uploaded your app, update the test case here.
        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);
        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        assert (allProductsName.size() > 0);
    }


    @AfterEach
    void tearDown() {
        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}
