import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class TestBase {
    @BeforeAll
    static void setUp() {

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "99.0");
        Configuration.remote = System.getProperty("browserUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.browserSize = System.getProperty("resolution", "1920x1080");
        ;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // включает в Selenoid подключение к порту VNС и возможность записывать видео
        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVNC", true);
            put("enableVideo", true);
        }});
        Configuration.browserCapabilities = capabilities;
    }

    //передает в Allure-отчет все шаги теста
    @BeforeEach
    void addListenerAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    // прикрепляет к ALLURE-отчету скрины и видео
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
