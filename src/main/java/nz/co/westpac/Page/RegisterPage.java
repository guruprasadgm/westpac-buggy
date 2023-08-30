package nz.co.westpac.Page;

import com.google.inject.Inject;
import nz.co.westpac.exception.AutomationException;
import nz.co.westpac.utils.WebDriverProvider;
import nz.co.westpac.utils.WebDriverUtility;
import nz.co.westpac.utils.WebDriverWaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static nz.co.westpac.configs.TestTimeOuts.NORMAL_WAIT_SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

public class RegisterPage {

    @Inject
    private WebDriver webDriver;

    @Inject
    private WebDriverWaitUtility webDriverWaitUtility;

    @Inject
    private WebDriverUtility webDriverUtility;

    static final Logger LOGGER = LoggerFactory.getLogger(RegisterPage.class);

    private static final By LNK_REGISTER= By.xpath("//a[text()='Register']");

    private static final By TXT_USERNAME= By.xpath("//input[@id='username']");
    private static final By TXT_FIRSTNAME= By.xpath("//input[@id='firstName']");
    private static final By TXT_LASTNAME= By.xpath("//input[@id='lastName']");
    private static final By TXT_PASSWORD= By.xpath("//input[@id='password']");
    private static final By TXT_CONFIRMPWD= By.xpath("//input[@id='confirmPassword']");

    private static final By BTN_REGISTER= By.xpath("//button[text()='Register']");

    private static final By LBL_SUCCESS_MESSAGE= By.xpath("//div[contains(text(),'Registration is successful')]");

    private static final By LBL_BUGGY_RATING= By.xpath("//a[text()='Buggy Rating']");

    public void clickLnkRegister (){
        webDriverUtility.moveToElement(LNK_REGISTER);
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(LNK_REGISTER), NORMAL_WAIT_SECONDS);
        webDriver.findElement(LNK_REGISTER).click();
    }

    public void setUserName (String userName){
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(TXT_USERNAME), NORMAL_WAIT_SECONDS);
        webDriver.findElement(TXT_USERNAME).sendKeys(userName);
    }

    public void setFirstName (String firstName){
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(TXT_FIRSTNAME), NORMAL_WAIT_SECONDS);
        webDriver.findElement(TXT_FIRSTNAME).sendKeys(firstName);
    }

    public void setLastName (String lastName){
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(TXT_LASTNAME), NORMAL_WAIT_SECONDS);
        webDriver.findElement(TXT_LASTNAME).sendKeys(lastName);
    }

    public void setPassword (String password){
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(TXT_PASSWORD), NORMAL_WAIT_SECONDS);
        webDriver.findElement(TXT_PASSWORD).sendKeys(password);
    }

    public void setConfirmPassword (String password){
        try {
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(TXT_CONFIRMPWD), NORMAL_WAIT_SECONDS);
        webDriver.findElement(TXT_CONFIRMPWD).sendKeys(password);
        }
            catch (AutomationException e) {
            throw new AutomationException("could not find the element on page " + e.getMessage());
        }
    }

    public void clickBtnRegister (){
        try {
        webDriverUtility.moveToElement(BTN_REGISTER);
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(BTN_REGISTER), NORMAL_WAIT_SECONDS);
        webDriver.findElement(BTN_REGISTER).click();
        }
        catch (AutomationException e) {
            throw new AutomationException("could not find the element on page " + e.getMessage());
        }
    }

    public void validateRegistrationSuccess (){
        try {
            webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(LBL_SUCCESS_MESSAGE), NORMAL_WAIT_SECONDS);
            assertThat(webDriver.findElement(LBL_SUCCESS_MESSAGE).isDisplayed()).isTrue();
            LOGGER.info("registration validated successfully");
        }
        catch (AutomationException e) {
            throw new AutomationException("could not find the element on page " + e.getMessage());
        }
    }

    public void clickBuggyRating (){
        try {
            webDriverUtility.moveToElement(LBL_BUGGY_RATING);
            webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(LBL_BUGGY_RATING), NORMAL_WAIT_SECONDS);
            webDriver.findElement(LBL_BUGGY_RATING).click();
        }
        catch (AutomationException e) {
            throw new AutomationException("could not find the element on page " + e.getMessage());
        }
    }

}
