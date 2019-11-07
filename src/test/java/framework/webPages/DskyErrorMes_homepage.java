package framework.webPages;

import org.openqa.selenium.By;



public class DskyErrorMes_homepage extends HW_BasePage {
    private By DerkSkyApi = By.linkText("Dark Sky API");
    private By SignUp = By.cssSelector("header.header:nth-child(1) div.header-container div.wrap.container-fluid div.header div.header-links nav.nav ul.links li:nth-child(5) > a.button.filled");
    private By Register = By.xpath("//button[contains(text(),'Register')]");
    private By emailAddress = By.name("email");




    public void clickOnDarkSky() throws InterruptedException {
        clickOn(DerkSkyApi);
    }
    public void clickOnSignUpButton() throws InterruptedException {
        clickOn(SignUp);
    }
    public void clickOnRegister() throws InterruptedException {
        clickOn(Register);
    }
    public String getErrorMessage(){ return getAttribute(emailAddress,"validationMessage");}






}
