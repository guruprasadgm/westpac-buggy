package nz.co.westpac.test;

import nz.co.westpac.Page.HomePage;
import nz.co.westpac.Page.ModelPage;
import nz.co.westpac.Page.RegisterPage;
import nz.co.westpac.initialiser.TestInitialiser;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import javax.inject.Inject;

public class BuggyAppTest extends TestBase{

    @Inject
    private TestInitialiser testInitialiser;

    @Inject
    private HomePage homePage;
    @Inject
    private RegisterPage registerPage;
    @Inject
    private ModelPage modelPage;

    @Test
    public void loginTest()
    {
        testInitialiser.init();
        login("testUserName");
        homePage.validateLogin();
    }


    @Test
    public void registrationTest()
    {
        testInitialiser.init();
        String randomUserName=RandomStringUtils.random(6, true, false);
        register(randomUserName);
        registerPage.validateRegistrationSuccess();

    }

    @Test
    public void OverallCommentAndVoteTest()
    {
        String comment=RandomStringUtils.random(6, true, false);;
        int voteCount=0;
        String randomUserName=RandomStringUtils.random(6, true, false);

        testInitialiser.init();

       //Register new user
        register(randomUserName);
        registerPage.validateRegistrationSuccess();

        //login with new generated user
        login(randomUserName);
        homePage.validateLogin();

        //navigate to overall page
        registerPage.clickBuggyRating();
        homePage.clickOverallImage();

        //read vote count and click on first model item
        voteCount=modelPage.getVoteCount();
        homePage.clickFirstModel();

        //set comment and vote
        modelPage.setComment(comment);
        modelPage.clickBtnVote();

        //navigate back to overall page
        registerPage.clickBuggyRating();
        homePage.clickOverallImage();

        // validate vote count and comment
        modelPage.validateComment(comment);
        modelPage.validateVoteCount(voteCount+1);
    }


    public void login(String userName){
        homePage.setUserName(userName);
        homePage.setPassword("Tester@123");
        homePage.clickBtnLogin();
    }

    public void register(String userName){
        registerPage.clickLnkRegister();
        registerPage.setUserName(userName);
        registerPage.setFirstName("firstname");
        registerPage.setLastName("lastname");
        registerPage.setPassword("Tester@123");
        registerPage.setConfirmPassword("Tester@123");
        registerPage.clickBtnRegister();
    }
}
