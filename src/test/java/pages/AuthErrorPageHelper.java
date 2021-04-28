package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthErrorPageHelper extends PageBase{
    @FindBy(id = "android:id/button1")
    WebElement okButton;
    @FindBy(id = "club.conim.hahamim:id/alertTitle")
    WebElement alertTitle;
    @FindBy(id = "android:id/message")
    WebElement errorMessage;


    public AuthErrorPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsVisible(alertTitle,20);
        waitUntilElementIsClickable(okButton,25);
    }

    public String getAlertTitle(){
        return alertTitle.getText();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public void clickOK(){
        okButton.click();
    }

}
