package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.twoHoursIncremented_homepage;
import org.testng.Assert;

public class twoHoursIncrementedSD {

    private twoHoursIncremented_homepage homepage = new twoHoursIncremented_homepage();

    @Given("^I am on DShome page$")
    public void iAmOnDSHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");
    }
    @Then("^I verify timeline is displayed with two hours incremented$")
    public void iVerifyTimelineIsDisplayedWithTwoHoursIncremented() throws Throwable {
        Assert.assertTrue(homepage.TwoHoursIncremented());

    }
}
