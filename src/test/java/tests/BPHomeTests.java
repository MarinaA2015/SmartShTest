package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

@Listeners(util.TestNgListener.class)

public class BPHomeTests extends TestBase{
    LoginPageHelper loginPage;
    HomePageHelper bpPage;
    ActionsListPageHelper myActionsPage;
    AuthErrorPageHelper authError;
    CreateNewActionHelper createNewAction;
    //RegistrationPageHelper registrationPage;

    @BeforeMethod
    public void initTests(){
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        bpPage = PageFactory.initElements(driver, HomePageHelper.class);
        myActionsPage = PageFactory.initElements(driver, ActionsListPageHelper.class);
        authError = PageFactory.initElements(driver, AuthErrorPageHelper.class);
        createNewAction = PageFactory.initElements(driver, CreateNewActionHelper.class);

        loginPage.waitUntilHomePageIsLoaded();
        loginPage.comeIn(LOGIN_BP,PASSWORD_BP);
        bpPage.waitUntilPageIsLoaded();
    }

    @Test
    public void myActionsOptionTest(){
        Assert.assertEquals("MY ACTIONS",bpPage.getMyActionsName());

        bpPage.logOut();
    }
    @Test
    public void myActionsPageVerification(){
        log4j.info("Enter to the application as a business partner and verify that title of " +
                "the page is 'Club of smart shopping'");
        bpPage.openMyActionsPage();
        myActionsPage.waitUntilPageIsLoaded();
        String title = myActionsPage.getSearchViewTextField();
        myActionsPage.cancelToHomePage();
        bpPage.waitUntilPageIsLoaded();
        bpPage.logOut();
        String failureMessage = "The title of the page is not " + title;
        Assert.assertEquals("Club of smart shopping",title,failureMessage);
    }
    @Test
    public void createNewActionOptionTest(){
        Assert.assertEquals("CREATE ACTION",bpPage.getCreateActionsName());
        bpPage.logOut();
    }
    @Test
    public void createNewActionPageVerification(){
        bpPage.openCreateNewAction();
        createNewAction.waitUntilPageIsLoaded();
        String pageTitle = createNewAction.getPageTitle();
        Assert.assertEquals("Create new action",pageTitle);
        createNewAction.backToHomePage();
        bpPage.waitUntilPageIsLoaded();
        bpPage.logOut();
    }
}
