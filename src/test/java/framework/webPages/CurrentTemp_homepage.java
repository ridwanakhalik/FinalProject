package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CurrentTemp_homepage extends HW_BasePage {
    private By CurrentTempLocator = By.xpath("//*[@id='title']/span[1]/span[2]/span[2]/span[1]/span[2]");
    private By TempInTimeLineLocator = By.xpath("//div[@id='timeline']/div/div[4]/child::span");


    public boolean VerifyCurrentTempBoundaryRange() {
        String CT = SharedSD.getDriver().findElement(CurrentTempLocator).getText(); //get current value
        String[] currentTemp = CT.split("°"); //exclude degree°
        int temp = Integer.parseInt(currentTemp[0].replaceAll("˚","")); // convert webElement to Int
        boolean result = false; //Assertion varible


        List<WebElement> TempsInTimeLine = SharedSD.getDriver().findElements(TempInTimeLineLocator); // Get all the displayed temperature in a list
        int[] ListTempFromTimeLine = new int[TempsInTimeLine.size()]; // declare a int variable "ListTempFromTimeLine"for webElements, for the comparison with current temp
        for (int i = 0; i < TempsInTimeLine.size(); i++) { //add all webElements to "ListTempFromTimeLine" array by the for loop
            String value = TempsInTimeLine.get(i).getText(); // Convert "ListTempFromTimeLine" to String again to get all the texts
            value = (value.substring(0, 2)); // using subString to ignore the degree°
            ListTempFromTimeLine[i] = (Integer.parseInt(value)); // Convert "ListTempFromTimeLine" String to Int again
        }
            Arrays.sort(ListTempFromTimeLine);
         int Max =ListTempFromTimeLine[0];
         int Min =ListTempFromTimeLine[ListTempFromTimeLine.length-1];
        System.out.println("Minimum = " + Max);
        System.out.println("Maximum = " + Min);

        // Assertion
        if(temp<Min || temp>Max){
            result = true;
        } else{
            result = false;
        }

        return result;
        }

    }






