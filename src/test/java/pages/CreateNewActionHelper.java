package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateNewActionHelper extends PageBase{
    @FindBy(id = "club.conim.hahamim:id/productName")
    WebElement goodName;
    @FindBy(id = "club.conim.hahamim:id/textinput_placeholder")
    WebElement goodNameInput;
    @FindBy(id = "club.conim.hahamim:id/autoCompleteGoodsCategory")
    WebElement goodCategory;
    @FindBy(id = "club.conim.hahamim:id/autoCompleteGoodsSubcategory")
    WebElement goodSubCategory;
    @FindBy(id = "club.conim.hahamim:id/autoCompleteMeasureUnit")
    WebElement measureUnit;
    @FindBy(id = "club.conim.hahamim:id/autoCompletePurchase")
    WebElement choosePurchase;
    @FindBy(id = "club.conim.hahamim:id/btnForward")
    WebElement buttonForward;
    @FindBy(id = "club.conim.hahamim:id/btnBackToFirstPage")
    WebElement buttonBackward;
    @FindBy(className = "android.widget.TextView")
    WebElement pageTitle;
    @FindBy(id = "club.conim.hahamim:id/priceLevel1Qty")
    WebElement priceLevel1Field;
    @FindBy(id = "club.conim.hahamim:id/priceLevel2Qty")
    WebElement priceLevel2Field;
    @FindBy(id = "club.conim.hahamim:id/priceLevel3Qty")
    WebElement priceLevel3Field;
    @FindBy(id = "club.conim.hahamim:id/priceLevel1Price")
    WebElement price1Field;
    @FindBy(id = "club.conim.hahamim:id/priceLevel2Price")
    WebElement price2Field;
    @FindBy(id = "club.conim.hahamim:id/priceLevel3Price")
    WebElement price3Field;
    @FindBy(id = "club.conim.hahamim:id/priceLevelBasicPrice")
    WebElement basicPriceField;
    @FindBy(id = "club.conim.hahamim:id/productPhoto")
    WebElement cartPicture;
    @FindBy(id = "android:id/text1")
    WebElement openGalleryOption;
    @FindBy(id = "com.google.android.documentsui:id/thumbnail")
    List<WebElement> picturesList;
    @FindBy(xpath = "//*[@class = 'android.widget.RelativeLayout']")
    List<WebElement> fullPicturesList;
    @FindBy(id = "club.conim.hahamim:id/btn_uploadPhoto")
    WebElement upLoadButton;
    @FindBy(id = "club.conim.hahamim:id/minimalVolume")
    WebElement minimalVolumeField;
    @FindBy(id = "club.conim.hahamim:id/maximalVolume")
    WebElement maximalVolumeField;
    @FindBy(id = "club.conim.hahamim:id/editTextDetailInfo")
    WebElement descriptionField;

    public CreateNewActionHelper(WebDriver driver) {
        super(driver);
    }


    public CreateNewActionHelper waitUntilPageIsLoaded() {
        log4j.method("CreateNewActionHelper, waitUntilPageIsLoaded()");
        waitUntilElementIsClickable(goodName,10);
        waitUntilElementIsClickable(goodCategory,10);
        return this;
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public CreateNewActionHelper backToHomePage() {
        buttonBackward.click();
        return this;
    }

    public CreateNewActionHelper fillGoodRequisites(String name,String category, String subCategory,
                                   String measure, String purchase) {
        log4j.method("CreateNewActionHelper, fillGoodRequisites()");
        log4j.info("name = " + name);
        log4j.info("category = " + category);
        log4j.info("subCategory = " + subCategory);
        log4j.info("measure = " + measure);
        log4j.info("purchase = " + purchase);
        this.waitUntilPageIsLoaded();
        this.editField(goodName, name);
        this.editField(goodCategory,category);
        this.editField(goodSubCategory,subCategory);
        this.editField(measureUnit,measure);
        this.editField(choosePurchase,purchase);
        driver.navigate().back();
        return this;
    }

    public CreateNewActionHelper pressForward(){
        log4j.method("CreateNewActionHelper, pressForward()");
        waitUntilElementIsClickable(buttonForward,5);
        buttonForward.click();
        return this;
    }
    public CreateNewActionHelper waitUntilQuantityRequisitesIsLoaded(){
        waitUntilElementIsClickable(price1Field,5);
        waitUntilElementIsClickable(price2Field,5);
        waitUntilElementIsClickable(price3Field,5);
        return this;
    }

    public CreateNewActionHelper fillQuantityRequisites(String priceLevel1, String price1, String priceLevel2,
                                       String price2, String priceLevel3, String price3, String basicPrice,
                                                        String minimalVolume, String maximalVolume)
    {   log4j.method("CreateNewActionHelper, fillQuantityRequisites()");
        log4j.info("priceLevel1 = " + priceLevel1);
        log4j.info("price1 = " + price1);
        log4j.info("priceLevel2 = " + priceLevel2);
        log4j.info("price2 = " + price2);
        log4j.info("priceLevel3 = " + priceLevel3);
        log4j.info("price3 = " + price3);
        log4j.info("basicPrice = " + basicPrice);
        log4j.info("minimalVolume = " + minimalVolume);
        log4j.info("maximalVolume = " + maximalVolume);
        log4j.info("");
        this.waitUntilQuantityRequisitesIsLoaded();
        this.editField(priceLevel1Field,priceLevel1);
        this.editField(price1Field,price1);
        this.editField(priceLevel2Field,priceLevel2);
        this.editField(price2Field,price2);
        this.editField(priceLevel3Field,priceLevel3);
        this.editField(price3Field,price3);
        this.editField(basicPriceField,basicPrice);
        this.editField(minimalVolumeField, minimalVolume);
        this.editField(maximalVolumeField, maximalVolume);
        driver.navigate().back();
        return this;
    }

    public CreateNewActionHelper waitPicturesScreenIsLoaded() {
        log4j.method("CreateNewActionHelper, waitPicturesScreenIsLoaded()");
        waitUntilElementIsClickable(cartPicture,10);
        return this;
    }
    public CreateNewActionHelper addPicture(String pictureName){
        log4j.method("CreateNewActionHelper, addPicture()");
        waitPicturesScreenIsLoaded();
        cartPicture.click();
        waitUntilElementIsClickable(openGalleryOption,5);
        openGalleryOption.click();
        waitUntilElementsArePresent(By.id("android:id/title"),10);
        log4j.debug("Pictures on the page: " + driver.findElements(By.id("android:id/title")).size());
        String pictureLayoutLocator = getPictureLayoutLocator(pictureName);
        this.swipeUpToElement(By.xpath(pictureLayoutLocator),25,1);
        waitUntilElementIsClickable(By.xpath(pictureLayoutLocator),10);
        log4j.debug("Pictures on the page after waiting: " + driver.findElements(By.id("android:id/title")).size());
        driver.findElement(By.xpath(pictureLayoutLocator)).click();
        waitPicturesScreenIsLoaded();
        upLoadButton.click();
        waitUntilElementIsAbsent(By.id("club.conim.hahamim:id/btn_uploadPhoto"),25);
        return this;
    }

    private String getPictureLayoutLocator(String pictureName) {
        return "//*[@text='" + pictureName + "']/../..";
    }

    public CreateNewActionHelper addDescription(String description) {
        waitUntilElementIsClickable(descriptionField,5);
        editField(descriptionField,description);
        this.returnBack();
        return this;
    }
}
