package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.webPages.CurrentTemp_homepage;
import org.testng.Assert;

public class CurrentTempSD {
    private CurrentTemp_homepage homepage = new CurrentTemp_homepage();


    @Given("^I am on darksky$")
    public void IAmOnDarkShy() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");
    }

    @Then("^I verify current temp is not greater or less than temps from daily timeline$")
    public void verifyCurrentTempBoundary() {
      Assert.assertTrue(homepage.VerifyCurrentTempBoundaryRange());

    }

}
