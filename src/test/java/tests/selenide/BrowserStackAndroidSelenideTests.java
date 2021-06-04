package tests.selenide;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.AndroidBaseTest;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;


@Tag("selenide_android")
@DisplayName("Successful search in wikipedia android app (SELENIDE)")
public class BrowserStackAndroidSelenideTests extends AndroidBaseTest {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        String searchValue = "BrowserStack";
        step("Search in Wikipedia: " + searchValue, () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val(searchValue);
        });
        step("Verify that search results appear", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));


        String expectedSubtitle = "Software company based in India";
        step("Verify texts of first search result", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(Condition.text(searchValue));
            $(MobileBy.id("org.wikipedia.alpha:id/page_list_item_description"))
                    .shouldHave(Condition.text(expectedSubtitle));
        });

        step("Click on the first search result", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container")).click());

        step("Verify title and subtitle on opened page ", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_page_title_text"))
                    .shouldHave(Condition.text(searchValue));
            $(MobileBy.id("org.wikipedia.alpha:id/view_page_subtitle_text"))
                    .shouldHave(Condition.text(expectedSubtitle));
        });
    }
}