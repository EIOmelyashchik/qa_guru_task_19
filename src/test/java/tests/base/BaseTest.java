package tests.base;

import com.codeborne.selenide.Configuration;
import helpers.AttachHelper;
import helpers.BrowserstackHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachHelper.getSessionId;

public class BaseTest {

    @BeforeAll
    public static void baseSetup() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = getSessionId();

        AttachHelper.screenshotAs("Last screenshot");
        AttachHelper.attachAsText("Browserstack build link", BrowserstackHelper.getBSPublicLink(sessionId));

        closeWebDriver();

        AttachHelper.attachVideo(sessionId);
    }
}
