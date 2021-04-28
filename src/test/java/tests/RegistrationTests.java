package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.RegistrationPageHelper;

public class RegistrationTests extends TestBase{
    LoginPageHelper loginPage;
    HomePageHelper bpPage;
    ActionsListPageHelper myActionsPage;
    AuthErrorPageHelper authError;
    RegistrationPageHelper registrationPage;

    @BeforeMethod
    public void initTests(){
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        registrationPage = PageFactory.initElements(driver,RegistrationPageHelper.class);
        loginPage.waitUntilHomePageIsLoaded();
        loginPage.openRegistrationPage();
        registrationPage.waitUntilPageIsLoaded();

    }
    @Test
    public void positiveRegistration(){
        String lastName = "lastName";
        String firstName = "firstName";
        String login = "loginTest";
        String password = "password";
        String phone = "0535227766";
        String region = "North";
        String settlement = "Naharya";
        String email = "";
        String iAm = "male";
        String birthDate = "01/01/2000";
        //We need objects (see models-package) for that...

        registrationPage.fillRegistrationForm(lastName,firstName,login,password,password,
                phone,region,settlement);
        registrationPage.continueRegistration();
        //loginPage.waitUntilPageIsLoaded();
    }
}
