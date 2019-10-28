package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class twoHoursIncremented_homepage {
    private By TimeLine = By.xpath("//div[@id='timeline']//div[@class='hours']");

    public boolean TwoHoursIncremented() {
        List<WebElement> hoursTimeLine = SharedSD.getDriver().findElements(TimeLine);
        ArrayList<String> hours = new ArrayList<>();
        int[] ListTempFromTimeLine = new int[hoursTimeLine.size()];
            for(int j= 0; j<hoursTimeLine.size(); j++) {
                String value = hoursTimeLine.get(j).getText();
                value = value.replaceAll("[^-9.]", "");
                hours.add(value);
            }

        Calendar timeNow = Calendar.getInstance();
        timeNow.add(Calendar.HOUR, 2);
        int timesNumber = timeNow.get(Calendar.HOUR);
        String sHours = String.valueOf(timesNumber);
        SimpleDateFormat sdf_ = new SimpleDateFormat("hh");
        String currentHour = sdf_.format(timeNow.getTime());

        ArrayList<String> timeList = new ArrayList<>();
        timeList.add("Now");
        timeList.add(currentHour);
        for (int i = 1; i < 11; i++) {
            timeNow.add(Calendar.HOUR, 2);
            timesNumber = timeNow.get(Calendar.HOUR);
            sHours = String.valueOf(timesNumber);
            timeList.add(sHours);
        }

        //Assert
        boolean result = false;
                for(int a =0; a<hours.size();a++){
                    for(int b=0; b<timeList.size();b++) {
                        if (!(hours.get(a) == timeList.get(b)))
                            result = true;
                        else {
                            result = false;
                        }
                    }
                }
                return result;
                    }
                }


