package githubtests;

import com.codeborne.selenide.Condition;
import config.BaseConfig;
import config.Constant;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static config.Constant.ISSUE;
import static config.Constant.REPO;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueLambdaTest extends BaseConfig {

    @Test
    @Description("Check issue by lambda")
    @Owner("Aleks")
    @Story("What issue is exist?")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    void checkIssueTest() {
        step("Open main page", () -> {

            open("https://github.com");
        });
        step("Search reposytory " + REPO, () -> {
            $(".header-search-input").sendKeys(REPO);
            $(".header-search-input").submit();
        });
        step("Click by link of repository -" + REPO, () -> {
            $(linkText(REPO)).click();
        });
        step("Click by issue", () -> {
            $("#issues-tab").click();
        });
        step("Check that element " + ISSUE + " is exist on page", () -> {
            $(withText(ISSUE)).should(Condition.exist);
        });

    }

}
