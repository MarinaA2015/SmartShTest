package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import util.LogLog4j;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

abstract public class PageBase {
    //WebDriver driver;
    AppiumDriver driver;
    public static LogLog4j log4j = new LogLog4j();


    public PageBase(WebDriver driver){
        this.driver =  (AppiumDriver) driver;
    }
    //public abstract void waitUntilPageIsLoaded();

    public void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsPresent(By locator, int time) {
        try {
            new WebDriverWait (driver,time).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsInvisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementsArePresent(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilNumberOfElementsToBe(By locator, int quantity,int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.numberOfElementsToBe(locator,quantity));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsInvisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilNumberOfElementsLessThan(By locator, int num,int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.numberOfElementsToBeLessThan(locator,num));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsAbsent(By locator, int time){
        int timeMax = time*1000;
        int timeWait = 0;
        while (driver.findElements(locator).size()!=0 && timeWait<timeMax){
            try {
                Thread.sleep(500);
                timeWait = timeWait + 500;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void waitUntilElementIsVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementsAreVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void frameToBeAvailableAndSwitchToIt(WebElement iframe, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void waitUntilElementsAreVisible(List<WebElement> elementsList, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfAllElements(elementsList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editField(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void rotateScreenLandScape() {
        AppiumDriver appDriver = (AppiumDriver)(driver);
        appDriver.rotate(ScreenOrientation.LANDSCAPE);
    }

    public void rotateScreenPortrait() {
        AppiumDriver appDriver = (AppiumDriver)(driver);
        appDriver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void runBackGround(int time) {
        AppiumDriver appDriver = (AppiumDriver)(driver);
        appDriver.runAppInBackground(Duration.ofSeconds(time));
    }

    public void swipeUp() {
        AppiumDriver appDriver = (AppiumDriver)(driver);
        TouchAction action = new TouchAction(appDriver);
        Dimension size = driver.manage().window().getSize();
        int x = (int)(size.width * 0.5);
        int y1 = (int)(size.height * 0.8);
        int y2 = (int)(size.height * 0.3);
        action.press(PointOption.point(x,y1))
                .waitAction()
                .moveTo(PointOption.point(x,y2))
                .release()
                .perform();
    }
    public void swipeUpToElement(By by, int maxTimes, int implWait){
        driver.manage().timeouts().implicitlyWait(implWait,TimeUnit.SECONDS);
        swipeUpToElement(by, maxTimes);
        driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
    }

    public void swipeUpToElement(By by, int maxTimes){
        int counter = 0;

        while(driver.findElements(by).size()==0 && counter < maxTimes){
            swipeUp();
            counter++;
        }
        driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
    }

    public void returnBack(){
        driver.navigate().back();
    }

}
