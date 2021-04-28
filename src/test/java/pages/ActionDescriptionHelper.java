package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ActionDescriptionHelper extends PageBase{
    @FindBy(id = "club.conim.hahamim:id/backButton")
    WebElement backwardButton;
    @FindBy(id = "club.conim.hahamim:id/fldActionProductName")
    WebElement productName;
    @FindBy(id = "club.conim.hahamim:id/partnersActivityOrderButton")
    WebElement orderButton;
    @FindBy(id = "club.conim.hahamim:id/fldInputQuantity")
    WebElement orderQuantityField;
    @FindBy(id = "club.conim.hahamim:id/btnAccept")
    WebElement toCartButton;
    @FindBy(id = "club.conim.hahamim:id/textCommonInfo")
    List<WebElement> commonInfoOrdersList;

    public ActionDescriptionHelper(WebDriver driver) {
        super(driver);
    }

    public ActionDescriptionHelper waitUntilPageIsLoaded(){
        log4j.method("ActionDescriptionHelper waitUntilPageIsLoaded()");
        waitUntilElementIsClickable(backwardButton,10);
        return this;
    }

    public String getProductName(){
        return productName.getText();
    }

    public ActionDescriptionHelper turnToActionsList(){
        backwardButton.click();
        return this;
    }

    public ActionDescriptionHelper orderProductForClubMember(String number){
        log4j.method("ActionDescriptionHelper orderProductForClubMember()");
        log4j.info("number = " + number);
        waitUntilElementIsClickable(orderButton,10);
        orderButton.click();
        waitUntilElementIsClickable(orderQuantityField,10);
        this.editField(orderQuantityField,number);
        driver.navigate().back();
        waitUntilElementIsClickable(toCartButton,10);
        toCartButton.click();
        return this;
    }


    public boolean verifyOrderForBP(String commonInfoOrder){
        log4j.method("ActionDescriptionHelper, verifyOrderForBP()");
        log4j.info("commonInfoOrder = " + commonInfoOrder);
        waitUntilElementIsClickable(orderButton,10);
        orderButton.click();
        waitUntilElementsAreVisible(commonInfoOrdersList,10);
        Boolean res = false;
        for (WebElement element : commonInfoOrdersList){
            if (element.getText().equals(commonInfoOrder)) res = true;
        }
        driver.navigate().back();
        waitUntilPageIsLoaded();
        return res;
    }

}
