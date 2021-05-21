package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import util.DataProviders;

public class CreateNewActionTests extends TestBase{
    LoginPageHelper loginPage;
    HomePageHelper bpPage;
    ActionsListPageHelper myActionsPage;
    AuthErrorPageHelper authError;
    CreateNewActionHelper createNewAction;


    @BeforeClass
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
    @Test(dataProviderClass = DataProviders.class,dataProvider = "actionsCreating")
    public void createNewAction(String name, String category, String subCategory, String measure, String purchase,
                                String priceLevel1, String priceLevel2, String priceLevel3, String price1,
                                String price2, String price3, String basicPrice, String minimalValue, String maximalValue,
                                String picture, String description){


        bpPage.openCreateNewAction();
        createNewAction
                .waitUntilPageIsLoaded()
                .fillGoodRequisites(name,category,subCategory,measure,purchase)
                .pressForward()
                .fillQuantityRequisites(priceLevel1,price1,priceLevel2,price2,priceLevel3,price3,basicPrice,
                        minimalValue,maximalValue)
                .pressForward()
                .waitPicturesScreenIsLoaded()
                .addPicture(picture)
                .addDescription(description)
                .pressForward();
        bpPage
                .waitUntilPageIsLoaded();
                /*.logOut();
                .openMyActionsPage();
        myActionsPage.waitUntilPageIsLoaded();
        Assert.assertTrue(myActionsPage.actionsListContainsAction(name));*/
        }




}
