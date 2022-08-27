package githubtests;

import com.codeborne.selenide.Condition;
import config.BaseConfig;
import config.Constant;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.withText;

public class IssueSeklenideTest extends BaseConfig {
    @Description("Проверка что issues существует")
    @Owner("Aleks")
    @Story("Проверить что issues существует")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    @Test
    void checkIssueTest() {
        open("https://github.com");
        $(".header-search-input").sendKeys("allure");
        $(".header-search-input").submit();

        $(By.linkText("allure-framework/allure-java")).click();
        $("#issues-tab").click();
        $(withText(Constant.ISSUE)).should(Condition.exist);

    }
}
