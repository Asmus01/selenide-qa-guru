import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;

public class StepsOfGitHub {
    @Test


    @Description("Test of GitHub page")
    @Severity(CRITICAL)
    @Owner("Aslan")
    @Link(name = "GitHub", url = "https://github.com/selenide/selenide")
    @DisplayName("Создание Issue для авторизованного пользователя")
    @Story("Создание Issue")
    @Issue("")
    public void testStaticLabels() {
    }

    @Step("Открываем страницу сайта Github")
    public void openSiteGitHub() {
        open("https://github.com/selenide/selenide");
    }
    @Step("Выбираем ховер-элемент")
    public void selectHover() {
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
    }
    @Step("Проверяем содержимое pop-up")
    public void inspectPopUpElement() {
        $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
        $x("//div").shouldBe(visible);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenShot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
