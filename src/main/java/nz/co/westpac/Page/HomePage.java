package nz.co.westpac.Page;

import com.google.inject.Inject;
import nz.co.westpac.exception.AutomationException;
import nz.co.westpac.utils.WebDriverUtility;
import nz.co.westpac.utils.WebDriverWaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static nz.co.westpac.configs.TestTimeOuts.NORMAL_WAIT_SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePage {

    @Inject
    private WebDriver webDriver;

    @Inject
    private WebDriverWaitUtility webDriverWaitUtility;

    @Inject
    private WebDriverUtility webDriverUtility;

    private static final By BTN_LOGIN = By.xpath("//button[text()='Login']");

    private static final By BTN_REGISTER= By.xpath("//a[text()='Register']");

    private static final By TXT_USERNAME= By.xpath("//input[@name='login']");

    private static final By TXT_PASSWORD= By.xpath("//input[@name='password']");
    private static final By LNK_LOGOUT= By.xpath("//a[text()='Logout']");
    private static final By IMG_OVERALL= By.xpath("//img[@src='/img/overall.jpg']");
    private static final By LNK_FIRSTMODEL= By.xpath("//tbody/tr[1]/td[3]/a");


    public void clickBtnLogin (){
        webDriverUtility.moveToElement(BTN_LOGIN);
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(BTN_LOGIN), NORMAL_WAIT_SECONDS);
        webDriver.findElement(BTN_LOGIN).click();
    }

    public void clickBtnRegister (){
        webDriverUtility.moveToElement(BTN_REGISTER);
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(BTN_REGISTER), NORMAL_WAIT_SECONDS);
        webDriver.findElement(BTN_REGISTER).click();
    }

    public void setUserName (String userName){

        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(TXT_USERNAME), NORMAL_WAIT_SECONDS);
        webDriver.findElement(TXT_USERNAME).sendKeys(userName);
    }

    public void setPassword (String password){
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(TXT_PASSWORD), NORMAL_WAIT_SECONDS);
        webDriver.findElement(TXT_PASSWORD).sendKeys(password);
    }

    public void clickLogout (){
        webDriverUtility.moveToElement(LNK_LOGOUT);
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(LNK_LOGOUT), NORMAL_WAIT_SECONDS);
        webDriver.findElement(LNK_LOGOUT).click();
    }

    public void validateLogin (){
        try {
            webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(LNK_LOGOUT), NORMAL_WAIT_SECONDS);
            assertThat(webDriver.findElement(LNK_LOGOUT).isDisplayed()).isTrue();
        }
        catch (AutomationException e) {
            throw new AutomationException("could not find the element on page " + e.getMessage());
        }
        }

        public void clickOverallImage () {
            try {
                webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(IMG_OVERALL), NORMAL_WAIT_SECONDS);
                webDriver.findElement(IMG_OVERALL).click();
            } catch (AutomationException e) {
                throw new AutomationException("could not find the element on page " + e.getMessage());
            }
        }

            public void clickFirstModel (){
                try {
                    webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(LNK_FIRSTMODEL), NORMAL_WAIT_SECONDS);
                    webDriver.findElement(LNK_FIRSTMODEL).click();
                }
                catch (AutomationException e) {
                    throw new AutomationException("could not find the element on page " + e.getMessage());
                }
    }

}
