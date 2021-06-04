package tests.selenide;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.IosBaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

@Tag("selenide_ios")
@DisplayName("Check UI elements in sample ios app (SELENIDE)")
public class BrowserStackIosSelenideTests extends IosBaseTest {

    @Test
    @DisplayName("Check Text element in sample ios app")
    void searchTest() {
        //видео пишется не с самого начала почему-то, чтобы писалось надо sleep(10);
        step("Click on 'Text' button", () ->
                $(MobileBy.AccessibilityId("Text Button")).click());

        String inputValue = "hello@browserstack.com";
        step("Enter the text:" + inputValue, () ->
                $(MobileBy.AccessibilityId("Text Input")).val(inputValue).pressEnter());

        step("Check output field", () ->
                $(MobileBy.AccessibilityId("Text Output")).shouldHave(Condition.text(inputValue)));
    }

    @Test
    @DisplayName("Check Alert element in sample ios app")
    void searchTest1() {
        //видео пишется не с самого начала почему-то, чтобы писалось надо sleep(10); - только для айос проблема
        sleep(10);
        step("Click on 'Alert' button", () ->
                $(MobileBy.AccessibilityId("Alert Button")).click());

        step("Check that 'Alert appears", () ->
                $(MobileBy.AccessibilityId("Alert")).should(Condition.appear));

        step("Close 'Alert", () -> {
            $(MobileBy.AccessibilityId("OK")).click();
            $(MobileBy.AccessibilityId("OK")).should(Condition.disappear);
        });
    }
}