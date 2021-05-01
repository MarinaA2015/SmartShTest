package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.Random;

public class BuildAcceptanceTest_1 extends TestBase{
    LoginPageHelper loginPage;
    HomePageHelper homePageBP;
    HomePageHelper homePageMember;
    AuthErrorPageHelper authError;
    ActionsListPageHelper newActionsList;
    ActionDescriptionHelper actionDescription;
    CreateNewActionHelper createNewAction;
    ActionsListPageHelper myActionsPage;

    @BeforeMethod
    public void initTests(){

        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        homePageBP = PageFactory.initElements(driver, HomePageHelper.class);
        homePageMember = PageFactory.initElements(driver, HomePageHelper.class);
        authError = PageFactory.initElements(driver, AuthErrorPageHelper.class);
        newActionsList = PageFactory.initElements(driver, ActionsListPageHelper.class);
        actionDescription = PageFactory.initElements(driver, ActionDescriptionHelper.class);
        myActionsPage = PageFactory.initElements(driver, ActionsListPageHelper.class);
        createNewAction = PageFactory.initElements(driver, CreateNewActionHelper.class);

        loginPage.waitUntilHomePageIsLoaded();

    }

    @Test
    public void acceptanceTest1(){
        //----- action creating --------
        Random gen = new Random();
        String nameAction = "молоко" + gen.nextInt(1000);
        String category = "Продукты";
        String subCategory = "Напитки";
        String measure = "литр";
        String purchase = "Молочка";
        String priceLevel1 = "5";
        String priceLevel2 = "10";
        String priceLevel3 = "20";
        String price1 = "30";
        String price2 = "25";
        String price3 = "20";
        String basicPrice = "35";
        String minimalValue = "";
        String maximalValue = "";

        // ---- ordering by two members
        String loginMember1 = "may";
        String passwordMember1 = "123";
        String loginMember2 = "rina";
        String passwordMember2 = "123";
        String numberProduct1 = "5";
        String numberProduct2 = "8";
        String picture = "milk.png";
        String commonInfo1 = "30,00 ₪ x 5,00  литр = 150,00 ₪, Levi May ";
        String commonInfo2 = "30,00 ₪ x 8,00  литр = 240,00 ₪, Rina Kohan ";

        log4j.step("Business Partner: Login and create new action (" + nameAction + ")");
        loginPage.comeIn(LOGIN_BP,PASSWORD_BP);
        homePageBP.waitUntilPageIsLoaded();
        homePageBP.openCreateNewAction();
        createNewAction
                .waitUntilPageIsLoaded()
                .fillGoodRequisites(nameAction,category,subCategory,measure,purchase)
                .pressForward()
                .fillQuantityRequisites(priceLevel1,price1,priceLevel2,price2,priceLevel3,price3,basicPrice,
                        minimalValue,maximalValue)
                .pressForward()
                .waitPicturesScreenIsLoaded()
                .addPicture(picture)
                .pressForward();

        log4j.step(LOGIN_BP + " (Business Partner): Verify the created action in 'My Actions' by name (" + nameAction + ")");

        homePageBP
                .waitUntilPageIsLoaded()
                .openMyActionsPage();
        myActionsPage.waitUntilPageIsLoaded();
        Assert.assertTrue(myActionsPage.actionsListContainsAction(nameAction));
        myActionsPage.cancelToHomePage();
        homePageBP
                .waitUntilPageIsLoaded()
                .logOut();

        log4j.step(loginMember1 + " (Club Member1): Login and order product (" + numberProduct1 + "( for the new action ("
                + nameAction + ")");
        loginPage
                .waitUntilPageIsLoaded()
                .comeIn(loginMember1,passwordMember1);
        homePageMember
                .waitUntilPageIsLoaded()
                .openNewActionsPage();
        newActionsList
                .waitUntilPageIsLoaded()
                .openActionDescription(nameAction);
        actionDescription
                .waitUntilPageIsLoaded()
                .orderProductForClubMember(numberProduct1);
        homePageMember
                .waitUntilPageIsLoaded()
                .logOut();

        log4j.step(loginMember2+ " (Club Member2): Login and order product (" + numberProduct2 + "( for the new action ("
                + nameAction + ")");
        loginPage.waitUntilPageIsLoaded();
        loginPage.comeIn(loginMember2,passwordMember2);
        homePageMember
                .waitUntilPageIsLoaded()
                .openNewActionsPage();
        newActionsList
                .waitUntilPageIsLoaded()
                .openActionDescription(nameAction);
        actionDescription
                .waitUntilPageIsLoaded()
                .orderProductForClubMember(numberProduct2);
        homePageMember
                .waitUntilPageIsLoaded()
                .logOut();

        log4j.info(LOGIN_BP + " (Business Partner): Login and verify orders in 'My Actions' for action (" + nameAction + ")");
        log4j.info("    For Member1 - '" + commonInfo1 + "'" );
        log4j.info("    For Member2 - '" + commonInfo2 + "'" );
        loginPage
                .waitUntilPageIsLoaded()
                .comeIn(LOGIN_BP,PASSWORD_BP);
        homePageBP
                .waitUntilPageIsLoaded()
                .openMyActionsPage();
        myActionsPage
                .waitUntilPageIsLoaded()
                .openActionDescription(nameAction);
        actionDescription
                .waitUntilPageIsLoaded();

        Assert.assertTrue(actionDescription.verifyOrderForBP(commonInfo1));
        Assert.assertTrue(actionDescription.verifyOrderForBP(commonInfo2));
    }

}
