package nz.co.westpac.Page;

import com.google.inject.Inject;
import nz.co.westpac.exception.AutomationException;
import nz.co.westpac.utils.WebDriverUtility;
import nz.co.westpac.utils.WebDriverWaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static nz.co.westpac.configs.TestTimeOuts.NORMAL_WAIT_SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

public class ModelPage {

    @Inject
    private WebDriver webDriver;

    @Inject
    private WebDriverWaitUtility webDriverWaitUtility;

    @Inject
    private WebDriverUtility webDriverUtility;

    static final Logger LOGGER = LoggerFactory.getLogger(ModelPage.class);

    private static final By TXT_AREA_COMMENT= By.xpath("//textarea[@id='comment']");


    private static final By BTN_VOTE= By.xpath("//button[text()='Vote!']");

    private static final By LBL_COMMENT= By.xpath("//tbody/tr[1]/td[7]/div/p");

    private static final By LBL_VOTE_COUNT= By.xpath("//tbody/tr[1]/td[5]");


    public void clickBtnVote (){
        webDriverUtility.moveToElement(BTN_VOTE);
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(BTN_VOTE), NORMAL_WAIT_SECONDS);
        webDriver.findElement(BTN_VOTE).click();
    }

    public void setComment (String comment){
        webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(TXT_AREA_COMMENT), NORMAL_WAIT_SECONDS);
        webDriver.findElement(TXT_AREA_COMMENT).sendKeys(comment);
    }



        public void validateComment (String comment) {
            try {
                webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(LBL_COMMENT), NORMAL_WAIT_SECONDS);
                assertThat(webDriver.findElement(LBL_COMMENT).getText()).isEqualTo(comment);
                LOGGER.info("comment validated successfully");
            } catch (AutomationException e) {
                throw new AutomationException("could not find the element on page " + e.getMessage());
            }
        }

        public int getVoteCount (){
            int returnValue=0;
            try {
                webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(LBL_VOTE_COUNT), NORMAL_WAIT_SECONDS);
                returnValue=Integer.parseInt(webDriver.findElement(LBL_VOTE_COUNT).getText());
                LOGGER.info("Vote count read successfully");
            }
            catch (AutomationException e) {
                throw new AutomationException("could not find the element on page " + e.getMessage());
            }
            return returnValue;
         }


    public void validateVoteCount (int voteCount){

        try {
            webDriverWaitUtility.waitUntil(ExpectedConditions.elementToBeClickable(LBL_VOTE_COUNT), NORMAL_WAIT_SECONDS);
            assertThat(Integer.parseInt(webDriver.findElement(LBL_VOTE_COUNT).getText())).isEqualTo(voteCount);
            LOGGER.info("vote count validated successfully");
        }
        catch (AutomationException e) {
            throw new AutomationException("could not find the element on page " + e.getMessage());
        }

    }


}
