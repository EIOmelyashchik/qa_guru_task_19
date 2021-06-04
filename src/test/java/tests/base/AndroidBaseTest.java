package tests.base;

import com.codeborne.selenide.Configuration;
import drivers.AndroidDriverProvider;
import org.junit.jupiter.api.BeforeAll;

public class AndroidBaseTest extends BaseTest {

    @BeforeAll
    public static void setup() {
        Configuration.browser = AndroidDriverProvider.class.getName();
    }
}
