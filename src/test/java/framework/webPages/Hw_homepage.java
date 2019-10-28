package framework.webPages;

import org.openqa.selenium.By;


public class Hw_homepage extends BasePage {
//    @FindBy(how= How.XPATH,using = "//*[@id='u_0_9']/div[6]/a")
//    private WebElement field_createNewAccount;
    private By firstNameTextField = By.id("firstName");
    private By lastNameTextField = By.id("lastName");
    private By mobileNumberTextField = By.id("mobileNumber");
    private By newPasswordTextField = By.id("newPwd");
    private By errorMessage = By.xpath("//div[@id='fullname_field']//following-sibling::div[@class='mbm _a4y']//i[1]");
    private By femaleGender = By.id("u_0_9");
    private By maleGender = By.id("u_0_a");
    private By birthdayMonthButton = By.id("month");
    private By birthdayDayButton = By.id("day");
    private By birthdayYearButton = By.id("year");
    private By signUpButton = By.xpath("//*[@id='u_3_u']");



    public void enterFirstName(String firstName) { setValue(firstNameTextField, firstName); }
    public void enterLastName (String lastName){ setValue(lastNameTextField, lastName);}
    public void enterMobileNumber(String mobNum){setValue(mobileNumberTextField,mobNum);}
    public void enterNewPassword(String NPass){setValue(newPasswordTextField,NPass);}
    public String getErrorMessage(){ return getTextFromElement(errorMessage);}
    public boolean isGenderFemaleSelected() {
        return isElementSelected(femaleGender);
    }
    public void clickOnFemaleGender() {
        clickOn(femaleGender);
    }
    public boolean isGenderMaleSelected() {
        return isElementSelected(maleGender);
    }
    public void clickOnMaleGender() {
        clickOn(maleGender);
    }
    public void clickOnBirthdayMonthButton() {clickOn(birthdayMonthButton);}
    public void clickOnBirthdayDayButton() {clickOn(birthdayDayButton);}
    public void clickOnBirthdayYearButton() {clickOn(birthdayYearButton);}
    public void clickOnSignUoButton(){clickOn(signUpButton);}






}
