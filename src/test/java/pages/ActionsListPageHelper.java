package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActionsListPageHelper extends PageBase{
    @FindBy(id = "club.conim.hahamim:id/sampleImageView")
    List<WebElement> productsImageList;
    @FindBy(xpath = "//*[@resource-id = 'club.conim.hahamim:id/sampleImageView']/..")
    List<WebElement> actionsList;
    @FindBy(xpath = "//*[@resource-id = 'club.conim.hahamim:id/fldName']")
    List<WebElement> nameActionsList;
    @FindBy(xpath = "//*[@resource-id = 'club.conim.hahamim:id/action_bar']/*[@class = 'android.widget.TextView']")
    WebElement searchViewTextField;
    @FindBy(xpath = "//*[@resource-id = 'club.conim.hahamim:id/action_bar']/*[@class = 'android.widget.ImageButton']")
    WebElement cancelToHPButton;

    public ActionsListPageHelper(WebDriver driver) {
        super(driver);
    }

    public ActionsListPageHelper waitUntilPageIsLoaded() {
        log4j.method("ActionsListPageHelper, waitUntilPageIsLoaded()");
        waitUntilElementsAreVisible(productsImageList,10);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitUntilElementsAreVisible(nameActionsList,15);
        return  this;
    }


    public String getSearchViewTextField(){
        return searchViewTextField.getText();
    }

    public ActionsListPageHelper cancelToHomePage(){
        log4j.method("ActionsListPageHelper, cancelToHomePage()");
        waitUntilElementIsClickable(cancelToHPButton,10);
        cancelToHPButton.click();
        return  this;
    }

    public boolean actionsListContainsAction(String name) {
        log4j.method("ActionsListPageHelper, actionsListContainsAction(String name)");
        log4j.info("name = " + name);
        Boolean res = false;
        for (WebElement element : nameActionsList){
            if (element.getText().equals(name.toUpperCase())) res = true;

        }
        return res;
    }

    public ActionsListPageHelper openActionDescription(String name){
        log4j.method("ActionsListPageHelper openActionDescription()");
        log4j.info("name = " + name);
        String locator = "//*[@text='" + name.toUpperCase() + "']/..";
        waitUntilElementIsClickable(By.xpath(locator),10);
        driver.findElement(By.xpath(locator)).click();
        return this;
    }

}
