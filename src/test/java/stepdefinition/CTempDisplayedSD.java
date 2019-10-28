package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.CTempDisplayed_homepage;
import framework.webPages.HW_BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class CTempDisplayedSD {

    CTempDisplayed_homepage homepage = new CTempDisplayed_homepage();

    @Given("^I am on Darksky Home Page$")
    public void IAmOnDarkSkyHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");
    }

    @When("^I expand todays timeline$")
    public void DarkSkyAPI() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)SharedSD.getDriver();
        js.executeScript("scrollBy(0,800);");
        //Thread.sleep(1000);
        homepage.ExtendTodaysTempIcon();
        Thread.sleep(2000);
        homepage.getLowestTodaysFromTimeLine();
        homepage.getHigestTodaysFromTimeLine();
        homepage.getMinTemp();
        homepage.getMaxTemp();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void VerifyErrorMessage() {
        Assert.assertEquals(homepage.getLowestTodaysFromTimeLine(), homepage.getMinTemp());
        Assert.assertEquals(homepage.getHigestTodaysFromTimeLine(),homepage.getMinTemp());
    }
}