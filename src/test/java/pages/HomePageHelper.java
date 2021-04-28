package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHelper extends PageBase{
    @FindBy(id = "club.conim.hahamim:id/cabModerMembers")
    WebElement myActionsMenu;
    @FindBy(id = "club.conim.hahamim:id/cabmBtnCreateAction")
    WebElement createActionsMenu;
    @FindBy(xpath = "//*[@resource-id = 'club.conim.hahamim:id/action_bar']/*[@class = 'android.widget.ImageButton']")
    WebElement logOutButton;
    @FindBy(id = "club.conim.hahamim:id/cabModerPurchases")
    WebElement newsActionsOption;

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public HomePageHelper waitUntilPageIsLoaded() {
        log4j.method("HomePageHelper, waitUntilPageIsLoaded()");
        waitUntilElementIsClickable(myActionsMenu,15);

        return this;
    }

    public String getCreateActionsName(){
        waitUntilElementIsClickable(createActionsMenu,15);
        return createActionsMenu.getText();
    }

    public String getMyActionsName(){
        return myActionsMenu.getText();
    }

    public HomePageHelper openMyActionsPage(){
        log4j.method("HomePageHelper, openMyActionsPage()");
        myActionsMenu.click();
        return this;
    }

    public HomePageHelper logOut(){
        log4j.method("HomePageHelper, logOut()");
        waitUntilElementIsClickable(logOutButton,10);
        logOutButton.click();
        return this;
    }

    public HomePageHelper openCreateNewAction() {
        log4j.method("HomePageHelper, openCreateNewAction()");
        waitUntilElementIsClickable(createActionsMenu,10);
        createActionsMenu.click();
        return this;
    }
    public HomePageHelper openNewActionsPage(){
        log4j.method("HomePageHelper, openNewActionsPage()");
        waitUntilElementIsClickable(newsActionsOption,10);
        newsActionsOption.click();
        return  this;
    }
}
