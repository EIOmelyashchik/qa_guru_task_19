package drivers;

import com.codeborne.selenide.WebDriverProvider;
import helpers.BrowserstackHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.ProjectData.androidConfig;


public class AndroidDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        return getAndroidDriver();
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", "qa_guru_19");
        capabilities.setCapability("build", "Android");
        capabilities.setCapability("name", "Tests");
        capabilities.setCapability("autoGrantPermissions", "true");

        return capabilities;
    }

    public AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("device", androidConfig.device());
        capabilities.setCapability("os_version", androidConfig.osVersion());
        capabilities.setCapability("app", androidConfig.app());

        return new AndroidDriver(BrowserstackHelper.getBrowserstackUrl(), capabilities);
    }
}