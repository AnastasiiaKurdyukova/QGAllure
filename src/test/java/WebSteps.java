import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");

    }

    @Step("Ищем репозиторий")
    public void searchForRepoitory(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Переходим по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Кликаем на таб Issues")
    public void openIssueTab() {
        $(By.partialLinkText("Issues")).click();
    }

    @Step("Проверяем, что существует Issue c номером {number}")
    public void shouldSeeIssueWithNumber(int issueNumber) {
        $(withText("#65")).should(Condition.visible);
    }


    @Attachment(value = "Мой любимый скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
