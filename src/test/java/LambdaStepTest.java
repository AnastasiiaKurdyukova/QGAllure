import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 65;

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка заголовка "+ ISSUE_NUMBER +" записи (лямбда)")
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Кликаем на  Issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });
        step("Проверяем, что существует Issue c номером" + ISSUE_NUMBER, () -> {
            $("#issue_" + ISSUE_NUMBER + "_link").shouldBe(text("Test issue"));
        });



    }
}
