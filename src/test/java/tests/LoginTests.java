package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthErrorPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;
import util.DataProviders;


public class LoginTests extends TestBase{
    LoginPageHelper loginPage;
    HomePageHelper bpPage;
    AuthErrorPageHelper authError;

    @BeforeMethod
    public void initTests(){

        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        bpPage = PageFactory.initElements(driver, HomePageHelper.class);
        authError = PageFactory.initElements(driver, AuthErrorPageHelper.class);

        loginPage.waitUntilHomePageIsLoaded();

    }

    @Test
    public void loginFieldIsEmptyTest(){
        log4j.info("Log working test");
        System.out.println("tttt");
        Assert.assertEquals("", loginPage.getLoginFieldValue());
    }

    @Test
    public void passwordFieldIsEmptyTest(){
        System.out.println("Password value:" + loginPage.getPasswordFieldValue());
        Assert.assertEquals("", loginPage.getPasswordFieldValue());
    }

    @Test
    public void rememberMeExistsTest(){
        Assert.assertEquals("Remember me", loginPage.getTextRememberMeBox());
    }

    @Test
    public void comeInOptionExists(){
        Assert.assertEquals("Come in",loginPage.getTextComeIn());
    }

    @Test
    public void registrationOptionExists(){
        Assert.assertEquals("Registration",loginPage.getTextRegistration());
    }

    @Test
    public void loginAsBPPositive(){
        loginPage.comeIn(LOGIN_BP,PASSWORD_BP);
        bpPage.waitUntilPageIsLoaded();
        Assert.assertEquals("CREATE ACTION", bpPage.getCreateActionsName());

        bpPage.logOut();
    }

    @Test
    public void loginNegativeLoginEmpty(){
        loginPage.comeIn("",PASSWORD_BP);
        authError.waitUntilPageIsLoaded();
        Assert.assertEquals("Authentification server error",authError.getErrorMessage());

        authError.clickOK();
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "dataProviderFirst")
    public void loginNegativeLoginPasswordIncorrect(String login, String password){
        loginPage.comeIn(login,password);
        authError.waitUntilPageIsLoaded();
        Assert.assertEquals("Authentification server error",authError.getErrorMessage());

        authError.clickOK();
    }

}
