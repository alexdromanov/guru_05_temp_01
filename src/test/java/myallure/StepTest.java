package myallure;

import org.junit.jupiter.api.Test;

public class StepTest {

    private final static String repName = "alexdromanov/guru_05_temp_01";
    private final static String findValue = "Issues";

    private WebSteps steps = new WebSteps();

    @Test
    public void testSearch() {
        steps.openMainPage();
        steps.searchForRepository(repName);
        steps.goToRepository(repName);
        steps.clickOnIssueTab();
        steps.shouldSeeIssueWithName(findValue);
    }

}
