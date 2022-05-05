import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.lang.annotation.*;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LabelsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;
    private Object SeverityLavel;

    @Test
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Просмотр созданных задач в репозитории")
    @DisplayName("Мой любимый тест")
    @Link(value = "Тестинг", url = "https://github.com")
    public void testAnnotated() {
    }

    @Test
    public void testCode() {
        Allure.label("owner", "eroshenkoam");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.feature("Задачи в репозитории");
        Allure.story("Просмотр созданных задач в репозитории");
        Allure.link("Тестинг", "https://github.com");
    }


    @Documented
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Простматр созданных задач в репозитории")
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IssueShow {

    }
}
