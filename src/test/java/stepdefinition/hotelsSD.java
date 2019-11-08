package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.hotels_homePage;
import org.testng.Assert;

public class hotelsSD {
    hotels_homePage homePage = new hotels_homePage();
    @Given("^I am on hotelsCom home Page$")
    public void IAmOnHotelsMainPage(){
       Assert.assertTrue(homePage.isLogoDisplayed(), "Invalid Home Page");
    }

    //sprint-1

    @When("^I select(.+)from room dropdown$")
    public void selectRoomDropdown(int select_rooms) throws InterruptedException {
      homePage.Sprint_1(select_rooms);
    }

    @Then("^I verify (.+) is displayed$")
    public void numberOfRoomDropdown(int number_of_room_dropdown) throws InterruptedException {
        boolean result_ =homePage.Sprint_1(number_of_room_dropdown);
        Assert.assertTrue(result_);

    }

    //sprint-2

    @When("^I select property class (.+)$")
    public void selectPropertyStars(String stars) throws InterruptedException {
       homePage.hotels_2(stars);
    }
    @Then("^I verify system displays only (.+) hotels on search result$")
    public void verifySystemDisplayedOnlySreachStars(String stars) throws InterruptedException {
       Assert.assertTrue(homePage.hotels_2(stars));
    }

    //sprint-3

    @Then("^I verify system displays all hotels within 10 miles radius of airport$")
    public void verifyHotelsWithIn_10_miles() throws InterruptedException {
        homePage.hotels_3(10);
        Assert.assertTrue(homePage.hotels_3(10));

    }

    @And("^I verify Hilton Hotel is within radius$")
    public void verifyHiltonWithInRadius() throws InterruptedException {
      homePage.hotels_3_hilton(10);
      Assert.assertTrue(homePage.hotels_3_hilton(10));
    }

    //sprint-4
    @Then("^I verify todays deal is less than 200$")
    public void verifyTodaysDeal() throws InterruptedException {
      homePage.hotels_4(200);
      Assert.assertTrue(homePage.hotels_4(200));
    }


}
