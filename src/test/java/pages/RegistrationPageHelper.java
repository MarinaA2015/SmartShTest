package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageHelper extends PageBase {
    @FindBy(id = "club.conim.hahamim:id/purchaseBtnNext")
    WebElement saveButton;
    @FindBy(id = "club.conim.hahamim:id/purchaseBtnCancel")
    WebElement cancelButton;
    @FindBy(id = "club.conim.hahamim:id/lastName")
    WebElement lastNameField;
    @FindBy(id = "club.conim.hahamim:id/firstName")
    WebElement firstNameField;
    @FindBy(id = "club.conim.hahamim:id/login")
    WebElement loginField;
    @FindBy(id = "club.conim.hahamim:id/passw2")
    WebElement repeatPasswordField;
    @FindBy(id = "club.conim.hahamim:id/passw")
    WebElement passwordField;
    @FindBy(id = "club.conim.hahamim:id/phone")
    WebElement phoneField;
    @FindBy(id = "club.conim.hahamim:id/usersRegion")
    WebElement regionField;
    @FindBy(id = "club.conim.hahamim:id/usersSettlement")
    WebElement settlementField;
    @FindBy(id = "club.conim.hahamim:id/email")
    WebElement emailField;
    @FindBy(id = "club.conim.hahamim:id/genderItem1")
    WebElement femaleItem;
    @FindBy(id = "club.conim.hahamim:id/genderItem2")
    WebElement maleItem;
    @FindBy(id = "club.conim.hahamim:id/birthDay")
    WebElement birthDay;
    @FindBy(id = "club.conim.hahamim:id/purchaseBtnCancel")
    WebElement getCancelButton;
    @FindBy(id = "club.conim.hahamim:id/purchaseBtnNext")
    WebElement continueButton;



    public RegistrationPageHelper(WebDriver driver) {
        super(driver);
    }

    public  void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(saveButton,15);
        waitUntilElementIsClickable(cancelButton,15);
    }

    public void fillRegistrationForm(String lastName,String firstName, String login, String password,
                             String rPassword, String phone, String region, String settle)
    {
        editField(lastNameField,lastName);
        editField(firstNameField,firstName);
        editField(loginField,login);
        editField(passwordField, password);
        editField(repeatPasswordField,rPassword);
        editField(phoneField, phone);
        editField(regionField, region);
        editField(settlementField,settle);
    }
    public void continueRegistration(){
        continueButton.click();
    }

    public void cancelRegistration(){
        cancelButton.click();
    }



}
