package tests.appium;

import helpers.BrowserstackHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.ProjectData.browserStackConfig;
import static config.ProjectData.iosConfig;

@Tag("appium_ios")
@DisplayName("Check UI elements in sample ios app (APPIUM)")
public class BrowserStackIosSampleTests {
    private IOSDriver<IOSElement> driver;

    @BeforeEach
    void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", browserStackConfig.bsLogin());
        caps.setCapability("browserstack.key", browserStackConfig.bsPassword());

        // Set URL of the application under test
        caps.setCapability("app", iosConfig.app());

        // Specify device and os_version for testing
        caps.setCapability("device", iosConfig.device());
        caps.setCapability("os_version", iosConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java iOS");
        caps.setCapability("name", "Appium");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        driver = new IOSDriver<>(
                BrowserstackHelper.getBrowserstackUrl(), caps);
    }

    @Test
    @DisplayName("Check UI elements in sample ios app")
    void searchTest() throws InterruptedException {
        // Test case for the BrowserStack sample iOS app.
        // If you have uploaded your app, update the test case here.
        IOSElement textButton = (IOSElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Button")));
        textButton.click();
        IOSElement textInput = (IOSElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
        textInput.sendKeys("hello@browserstack.com");
        textInput.sendKeys(Keys.RETURN);
        Thread.sleep(5000);
        IOSElement textOutput = (IOSElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Output")));
        if (textOutput != null && textOutput.getText().equals("hello@browserstack.com"))
            assert (true);
        else
            assert (false);
    }

    @AfterEach
    void tearDown() {
        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}