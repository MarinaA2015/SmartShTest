package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.TestBase;

public class LoginPageHelper extends PageBase {
    @FindBy(id = "club.conim.hahamim:id/fldLogin")
    WebElement loginField;
    @FindBy(id = "club.conim.hahamim:id/fldEditPassword")
    WebElement passwordField;
    @FindBy(id = "club.conim.hahamim:id/fldRememberMeCheck")
    WebElement rememberMeBox;
    @FindBy(id = "club.conim.hahamim:id/linkComeIn")
    WebElement comeInOption;
    @FindBy(id = "club.conim.hahamim:id/linkRegisterMe")
    WebElement registrationOption;


    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    public LoginPageHelper waitUntilPageIsLoaded() {

        waitUntilElementIsClickable(comeInOption,20);
        return this;
    }

    public String getLoginFieldValue(){
         System.out.println("login field value: " + loginField.getText());
        return loginField.getText();
     }
     public String getPasswordFieldValue(){
        return passwordField.getText();
     }
     public String getTextRememberMeBox(){
        return rememberMeBox.getText();
     }
     public String getTextComeIn(){
        return comeInOption.getText();
     }
     public String getTextRegistration(){
        return registrationOption.getText();
     }
     public LoginPageHelper waitUntilHomePageIsLoaded(){
        waitUntilElementIsClickable(registrationOption,20);
        waitUntilElementIsClickable(comeInOption,20);
        return this;
     }
     public LoginPageHelper openRegistrationPage(){
        registrationOption.click();
        return  this;
     }

    public LoginPageHelper comeIn(String login, String password) {
        log4j.method("LoginPageHelper, comeIn()");
        log4j.info("login = " + login);
        log4j.info("password = " + password);
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        comeInOption.click();
        return this;
    }
}
