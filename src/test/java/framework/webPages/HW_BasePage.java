package framework.webPages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import stepdefinition.SharedSD;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HW_BasePage {
    // This is the most common wait function used in selenium
    public static WebElement webAction(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }

    public void clickOn(By locator) throws InterruptedException {
        Thread.sleep(1000);
        webAction(locator).click();
    }

    public void setValue(By locator, String value) {
        webAction(locator).sendKeys(value);
    }

    public String getTextFromElement(By locator) {
        return webAction(locator).getText();
    }
    public String getAttribute(By locator, String value){return webAction(locator).getAttribute(value);}

    public boolean isElementDisplayed(By locator) {
        return webAction(locator).isDisplayed();
    }

    public boolean isElementSelected(By locator) {
        return webAction(locator).isSelected();
    }
    public boolean isEnable(By locator) { return webAction(locator).isEnabled();}



    public void selectFromDropdown(By locator, String dropdownText) {
        WebElement month = webAction(locator);
        Select selectMonth = new Select(month);
        //select element by visible text
        selectMonth.selectByVisibleText(dropdownText);
    }

    public void selectFromDropdown(By locator, int index) {
        WebElement month = webAction(locator);
        Select selectMonth = new Select(month);
        //select element by index
        selectMonth.selectByIndex(index);
    }



    public void scrollMethod(int x, int y, By locator) {
        //scroll by x coordinate
        JavascriptExecutor jsScrollBy = (JavascriptExecutor)SharedSD.getDriver();
        jsScrollBy.executeScript("scrollBy(" + x,+ y +");");
        // This will scroll the page till the element is found
        //WebElement timeMachine = DriverWrapper.getDriver().findElement(locator);
        // jsScrollBy.executeScript("arguments[0].scrollIntoView();", timeMachine);
    }
    public void scrollMethod_() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)SharedSD.getDriver();
        js.executeScript("scrollBy(0,500);");
        Thread.sleep(3000);
    }
    public void scrollButtomOfPage() throws InterruptedException {
        JavascriptExecutor je =(JavascriptExecutor) SharedSD.getDriver();
        je.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(5000);
    }
    public void scrollByElement(By locator) throws InterruptedException {
        //WebElement element = getDriver().findElement(By.xpath("//*[@id='result-info-container']/div"));
        ((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", locator);
        Thread.sleep(4000);
    }

    public void dynamicScrolling() throws InterruptedException {
        long lastHeight = (long) ((JavascriptExecutor)SharedSD.getDriver()).executeScript("return document.body.scrollHeight");

        while (true) {
            ((JavascriptExecutor) SharedSD.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(4000);

            long newHeight = (long) ((JavascriptExecutor) SharedSD.getDriver()).executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }
    }

    public void dynamicScrolling_2() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) SharedSD.getDriver();

        long initialHeight = (long)(jse.executeScript("return document.body.scrollHeight"));

        while (true){
            jse.executeScript("window.scrollTo(0,document.body.scrollHeight");
            Thread.sleep(2000);
            long currentHeight = (long) (jse.executeScript("return document.body.scrollHeight"));
            if(initialHeight==currentHeight){
                break;
            }
            initialHeight=currentHeight;
        }
    }

    public void getTestScenerio_text(By locator, String value) throws InterruptedException {
        Select values = new Select(webAction(locator));
        values.selectByVisibleText(value);
        Thread.sleep(2000);
    }

    public void testScenario_index(By locator, int Index) {
        Select months = new Select(webAction(locator));
        months.selectByIndex(Index);
    }

    public void testScenerio_Value(By locator, String value) {
        Select days = new Select(webAction(locator));
        days.selectByValue(value);
    }
    public void  navigation(By locator){
        SharedSD.getDriver().navigate().forward();
        SharedSD.getDriver().navigate().back();
        SharedSD.getDriver().navigate().refresh();
    }



    public void alertHandles(By locator, String value) throws InterruptedException {
        SharedSD.getDriver().switchTo().frame("iframeResult");
        webAction(locator).click();
        SharedSD.getDriver().switchTo().alert().accept();
        webAction(locator).click();
        SharedSD.getDriver().switchTo().alert().dismiss();
        webAction(locator).click();
        SharedSD.getDriver().switchTo().alert().getText();
        SharedSD.getDriver().switchTo().alert().dismiss();
        webAction(locator).click();
        SharedSD.getDriver().switchTo().alert().sendKeys(value);
        SharedSD.getDriver().switchTo().alert().dismiss();
    }


    //CHECK FOR DUPLICATE
    public void checkForDropDownDuplicate(By locator, String MonthsDaysYears) {
        if (MonthsDaysYears == "month") {
            Select months = new Select(webAction(locator));
            List<WebElement> monthsValue = months.getOptions();
            for (int i = 0; i < monthsValue.size(); i++) {
                for (int j = i + 1; j < monthsValue.size(); j++) {
                    if (monthsValue.get(i).equals(monthsValue.get(j))) {
                        Assert.fail("duplicate month:" + monthsValue.get(i));
                    }
                }
            }
        }
        else if(MonthsDaysYears == "years") {
            Select years = new Select(webAction(locator));
            List<WebElement> yearsValue= years.getOptions();
            for(int i = 0; i < yearsValue.size(); i++) {
                for(int j = i + 1; j < yearsValue.size(); i++){
                    if(yearsValue.get(i).equals(yearsValue.get(j))){
                        Assert.fail("duplicate years:" + yearsValue.get(i));
                    }
                }
            }
        }
        else if(MonthsDaysYears=="days"){
            Select days = new Select(webAction(locator));
            List<WebElement> daysValue = days.getOptions();
            for(int i = 0; i < daysValue.size(); i++){
                for(int j = i = 1; j < daysValue.size(); i ++){
                    if(daysValue.get(i).equals(daysValue.get(j))){
                        Assert.fail("duplicate days:"+ daysValue.get(i));
                    }
                }
            }
        }
        else {}

    }


    public boolean dropDownDuplicates (By locator) {
        // CHECK FOR DUPLICATE
        Select select = new Select(webAction(locator));
        List<WebElement> monthValuesList = select.getOptions(); //gets all the dropdown as form of lists
        System.out.println("Num of elements in a dropdown is : " + monthValuesList.size());

        Set<String> monthNames = new HashSet<String>(); // add set list
        for (
                WebElement month : monthValuesList) {
            monthNames.add(month.getText().trim());
        }

        if (monthValuesList.size() == monthNames.size()) {
            System.out.println("duplicate found");
            return true;
        } else {
            System.out.println("no duplicate found");
            return false;
        }
    }


}




