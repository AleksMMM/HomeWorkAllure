package githubtests;

import config.Constant;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    TestSteps st = new TestSteps();

    @Test
    @Description("Check issue by steps")
    @Owner("Aleks")
    @Story("What issue is exist?")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    public void testAnnotatedSteps() {
        st.openMainPage();
        st.searchRepository(Constant.REPO);
        st.clickOnRepositoryLink(Constant.REPO);
        st.checkShouldSeeIssueWithNumber(Constant.ISSUE);
        st.takeScreenshot();
    }
}
