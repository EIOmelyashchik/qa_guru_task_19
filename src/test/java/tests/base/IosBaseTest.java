package tests.base;

import com.codeborne.selenide.Configuration;
import drivers.IosDriverProvider;
import org.junit.jupiter.api.BeforeAll;
import tests.base.BaseTest;

import static com.codeborne.selenide.Selenide.open;

public class IosBaseTest extends BaseTest {

    @BeforeAll
    public static void setup() {
        Configuration.browser = IosDriverProvider.class.getName();
    }
}
