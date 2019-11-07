package framework.webPages;

import org.openqa.selenium.By;

public class CTempDisplayed_homepage extends HW_BasePage {
    private By icon = By.xpath("//span[contains(text(),'Today')]");
    private By LowestTodaysTimeLine = By.xpath("//*[@id='week']/a[1]/span[2]/span[1]");
    private By HigestTodaysTimeLine = By.xpath("//*[@id='week']/a[1]/span[2]/span[3]");
    private By MinTemp = By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]");
    private By MaxTemp = By.xpath("//*[@id='week']/div[2]/div[1]/div[2]/div[1]/span[3]/span[1]");
//body[@class='forecast']/div[@id='week']/a[1]/span[3]


    public void ExtendTodaysTempIcon() throws InterruptedException { clickOn(icon);}
    public String getLowestTodaysFromTimeLine(){ return getTextFromElement(LowestTodaysTimeLine);}
    public String getHigestTodaysFromTimeLine (){ return getTextFromElement(HigestTodaysTimeLine);}
    public String getMinTemp (){return getTextFromElement(MinTemp);}
    public String getMaxTemp (){ return getTextFromElement(MaxTemp);}




}
