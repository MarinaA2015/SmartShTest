package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
    @Test(dataProviderClass = DataProviders.class,dataProvider = "actionsCreating")
    public void createNewAction(String name, String category, String subCategory, String measure, String purchase,
                                String priceLevel1, String priceLevel2, String priceLevel3, String price1,
                                String price2, String price3, String basicPrice, String minimalValue, String maximalValue){
        /*String name = "avocado666";
        String category = "Food";
        String subCategory = "Delicacies";
        String measure = "kg";
        String purchase = "Vegetables";
        String priceLevel1 = "5";
        String priceLevel2 = "10";
        String priceLevel3 = "20";
        String price1 = "30";
        String price2 = "25";
        String price3 = "20";
        String basicPrice = "35";
        String minimalValue = "1";
        String maximalValue = "50";*/

        bpPage.openCreateNewAction();
        createNewAction
                .waitUntilPageIsLoaded()
                .fillGoodRequisites(name,category,subCategory,measure,purchase)
                .pressForward()
                .fillQuantityRequisites(priceLevel1,price1,priceLevel2,price2,priceLevel3,price3,basicPrice,
                        minimalValue,maximalValue)
                .pressForward()
                .waitPicturesScreenIsLoaded()
                .addPicture()
                .pressForward();
        bpPage
                .waitUntilPageIsLoaded()
                .openMyActionsPage();
        myActionsPage.waitUntilPageIsLoaded();
        Assert.assertTrue(myActionsPage.actionsListContainsAction(name));
        }



}
