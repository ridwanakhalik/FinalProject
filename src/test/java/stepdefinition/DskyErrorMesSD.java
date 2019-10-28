package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DskyErrorMes_homepage;
import framework.webPages.HW_BasePage;
import org.testng.Assert;

public class DskyErrorMesSD {
    private DskyErrorMes_homepage homepage = new DskyErrorMes_homepage();


    @Given("^I am on darksky.net$")
    public void IAmOnDarkShy() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - Broadway, New York, NY", "Invalid Home Page");
    }


    @When("^I click on Dark Sky API$")
    public void DarkSkyAPI(){ homepage.clickOnDarkSky();

    }

    @And("^I click on the SignUp button$")
    public void SignUp(){ homepage.clickOnSignUpButton();

    }

    @And("^I click on Register button$")
    public void RegisterButton(){ homepage.clickOnRegister();

    }

    @Then("^I verify error message \"please fill out this field\"$")
    public void VerifyErrorMessage(){
        String  expected = "Please fill out this field.";
        String displayedMessage = homepage.getErrorMessage();
        Assert.assertEquals(displayedMessage,expected, "There's something wrong");

    }
}
