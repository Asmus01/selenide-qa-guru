import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class TestBase {
    @BeforeAll
    static void setUp() {

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "99.0");
        Configuration.remote = System.getProperty("browserUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.browserSize = "1920x1080";

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
//            put("enableVNC", true);
//            put("enableVideo", true);
//        }});
//        Configuration.browserCapabilities = capabilities;
    }
}
