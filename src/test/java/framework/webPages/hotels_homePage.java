package framework.webPages;

import cucumber.api.java.ca.I;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepdefinition.SharedSD;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class hotels_homePage extends HW_BasePage {

    private By SearchButton = By.xpath("//*[@id='qf-0q-destination']");
    private By clickDropDown = By.xpath("//*[@id='qf-0q-compact-occupancy']");
    private By moreOptions = By.xpath("//*[@id='qf-0q-compact-occupancy']/option[3]");
    private By RoomsDropDown = By.xpath("//*[@id='qf-0q-rooms']");
    private By clickSearch = By.xpath("//button[@class='cta cta-strong']");
    private By locationDropDown = By.xpath("//tbody[@class='autosuggest-recommended']/child::tr/td/div[2]");
    private By hilton = By.xpath("//li[@class='hotel sold-out pinned-unavailable']//div[@class='description resp-module']");
    private By selectFiveStars = By.xpath("//input[@id='f-star-rating-5']");
    private By selectFourStars = By.xpath("//input[@id='f-star-rating-4']");
    private By selectThreeStars = By.xpath("//input[@id='f-star-rating-3']");
    private By adult = By.xpath("//div[@class='widget-query-adults']");
    private By children = By.xpath("//div[@class='widget-query-children']");
    private By ListOfHotels = By.xpath("//*[@id='listings']/child::ol/child::li");
    private By ListsOfHotelsMiles = By.xpath("//div[@class='details resp-module']/div/div/ul/li");
    private By Scroll = By.xpath("//div[@class='info unavailable-info']");
    private By miles = By.xpath("//div[@class='details resp-module']/div/div/ul/li");
    private By checkrightPage = By.xpath("//span[@class='sprite sprite-flags sprite-flags-usa']");
    private By roomsDesplayed = By.xpath("//div[contains(@class, 'widget-query-room-options')]");
    private By roomNum = By.xpath("//div[contains(@class, 'widget-query-room-options')]");
    //Today deal
    private By todayDeal = By.xpath("//h2[@class='header-text']");
    private By dealPrice = By.xpath("//ins[contains(text(),'$103')]");

    public boolean isLogoDisplayed() {
        return isElementDisplayed(checkrightPage);
    }

    //Sprint-1

    public boolean Sprint_1( int number_of_room_dropdown) throws InterruptedException {

        boolean result = false;
        clickOn(SearchButton);
        Thread.sleep(2000);
        List<WebElement> loctionLists = SharedSD.getDriver().findElements(locationDropDown);
        for(WebElement location : loctionLists) {
            String innerhtml = location.getAttribute("innerHTML");

            if (innerhtml.contentEquals("New York, New York, United States of America")) {
                location.click();
            }
        }
        clickOn(clickSearch);
        clickOn(clickDropDown);
        Thread.sleep(2000);
        clickOn(moreOptions);
        Thread.sleep(2000);
        List<WebElement> roomNumbers = SharedSD.getDriver().findElements(roomNum);
        for (WebElement r : roomNumbers) {
            String rText = r.getText();

            WebElement firstDropDown = SharedSD.getDriver().findElement(RoomsDropDown);
            Select options = new Select(firstDropDown);
            List<WebElement> valuesUnderoptions = options.getOptions();
             if(valuesUnderoptions.size()== number_of_room_dropdown)
                        result = true;
                    }

        return result;
    }


    //Sprint-2

    public boolean hotels_2(String stars) throws InterruptedException {

        boolean result = false;
        String name;

        clickOn(SearchButton);
        Thread.sleep(2000);
        List<WebElement> loctionLists = SharedSD.getDriver().findElements(locationDropDown);
        for(WebElement location : loctionLists) {
            String innerhtml = location.getAttribute("innerHTML");

            if (innerhtml.contentEquals("New York, New York, United States of America")) {
                location.click();
            }
        }
        clickOn(clickSearch);
        dynamicScrolling();

        if (stars.equals("5-star")) {
            clickOn(selectFiveStars);
            dynamicScrolling();
            List<WebElement> lists = SharedSD.getDriver().findElements(ListOfHotels);
            for (WebElement list : lists) {
                name = list.getAttribute("data-title");
                if (name.contains("5-stars")) {
                    result = true;
                }
            }

        } else if (stars.equals("4-star")) {
            clickOn(selectFourStars);
            dynamicScrolling();
            List<WebElement> lists = SharedSD.getDriver().findElements(ListOfHotels);
            for (WebElement list : lists) {
                name = list.getAttribute("data-title");
                if (name.contains("4-stars") || name.contains("4.5-stars")) {
                    result = true;
                }
            }

        } else if (stars.equals("3-star")) {
            clickOn(selectThreeStars);
           dynamicScrolling();
            List<WebElement> lists = SharedSD.getDriver().findElements(ListOfHotels);
            for (WebElement list : lists) {
                name = list.getAttribute("data-title");
                if (name.contains("3-stars") || name.contains("3.5-stars")) {
                    result = true;
                }

            }
        }
        return result;
    }


    //Sprint-3

    public boolean hotels_3(int distance) throws InterruptedException {
        boolean result = false;

        clickOn(SearchButton);
        Thread.sleep(2000);
        List<WebElement> loctionLists = SharedSD.getDriver().findElements(locationDropDown);
        for(WebElement location : loctionLists) {
            String innerhtml = location.getAttribute("innerHTML");

            if (innerhtml.contentEquals("New York, New York, United States of America")) {
                location.click();
            }
        }
        clickOn(clickSearch);
        dynamicScrolling();

        List<WebElement> milesLists = SharedSD.getDriver().findElements(ListsOfHotelsMiles);
        String[] strings = new String[milesLists.size()];
        Double[] douStrings = new Double[strings.length];
        int [] intString = new int[douStrings.length];
        for (int i = 0; i < milesLists.size(); i++) {
            strings[i] = milesLists.get(i).getAttribute("property-landmarks");
            strings[i] = strings[i].replaceAll("[^0-9.]", "");
            douStrings[i] = Double.parseDouble(strings[i]);
            intString [i] = (int) Math.floor(douStrings[i]);

            if (intString[i] < distance) {
             }
                result = true;
            }
        return result;
        }

        public boolean hotels_3_hilton(int distance) throws InterruptedException {
            boolean result = false;
            clickOn(SearchButton);
            Thread.sleep(2000);
            List<WebElement> loctionLists = SharedSD.getDriver().findElements(locationDropDown);
            for(WebElement location : loctionLists) {
                String innerhtml = location.getAttribute("innerHTML");

                if (innerhtml.contentEquals("New York, New York, United States of America")) {
                    location.click();
                }
            }
            dynamicScrolling();
            String holtonDistance = getTextFromElement(hilton);
            holtonDistance = holtonDistance.replaceAll("[^0-9.]", "");
            int intRadius =Integer.parseInt(holtonDistance);
            if(intRadius < distance){
                result = true;
            }
             return result;
        }



    //Sprint-4

    public boolean hotels_4(int deal) throws InterruptedException {
        boolean result = false;
        String bestDeal;
        clickOn(SearchButton);
        Thread.sleep(2000);
        List<WebElement> loctionLists = SharedSD.getDriver().findElements(locationDropDown);
        for(WebElement location : loctionLists) {
            String innerhtml = location.getAttribute("innerHTML");

            if (innerhtml.contentEquals("New York, New York, United States of America")) {
                location.click();
            }
        }
        clickOn(clickSearch);
        dynamicScrolling();
        try {
            isElementDisplayed(todayDeal);
            String str = getTextFromElement(dealPrice);
            bestDeal = str;
        } catch (NoSuchElementException e) {
            throw new RuntimeException("There isn't any spacial deal for today");
        }

        bestDeal = bestDeal.substring(1);
        int Intstr = Integer.parseInt(bestDeal);
        if (Intstr < 200) {
            result = true;
        } else
            result = false;


        return result;
    }

}




//    List<WebElement> listsHotelsForMiles = SharedSD.getDriver().findElements(ListsOfHotelsMiles);
//    List<Integer> intMiles = new ArrayList<>();
//        for (WebElement options : listsHotelsForMiles){
//        String innerhtlmForHilton = options.getAttribute("New York Hilton Midtown");
//        String milesPerHotels = options.getAttribute("property-landmarks");
//        milesPerHotels = milesPerHotels.replaceAll("[^0-9.]", "");
//        intMiles.add(Integer.parseInt(milesPerHotels));
//        if(intMiles < distance){
//
//        }


