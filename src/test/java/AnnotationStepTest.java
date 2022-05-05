import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AnnotationStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    @DisplayName("Успешный тест")
    public void testGithubIssue() {
      SelenideLogger.addListener("allure", new AllureSelenide());
      WebSteps steps = new WebSteps();

      steps.openMainPage();
      steps.searchForRepoitory(REPOSITORY);
      steps.clickOnRepositoryLink(REPOSITORY);
      steps.openIssueTab();
      steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
