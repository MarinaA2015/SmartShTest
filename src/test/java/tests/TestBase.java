package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.events.api.Listener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
import org.testng.annotations.*;
import pages.*;
import util.ElementListener;
import util.ExceptionListener;
import util.LogLog4j;
import org.testng.annotations.Listeners;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Listeners(util.TestNgListener.class)

public class TestBase {
    public /*static*/ AppiumDriver driver;
    public static final String LOGIN_BP = "aron";
    public static final String PASSWORD_BP = "123";
    public static LogLog4j log4j = new LogLog4j();

    DesiredCapabilities capabilities;

    @BeforeClass(alwaysRun = true)
    public void startUp() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        //capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("platformVersion", "8.1.0");
        //capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("appPackage", "club.conim.hahamim");
        capabilities.setCapability("appActivity",".activities.MainActivity");
        capabilities.setCapability("automationName","Uiautomator2");
        capabilities.setCapability("app",
                "C:/Marina/TelRan/Auto/Practice/SmartShopping/SmartShTest/apk/konim-hahamim-v0.9.apk");

        //--- Adding listenersfor appium-----
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        List<Listener> listeners = new ArrayList<>();
        listeners.add(new ElementListener());
        listeners.add(new ExceptionListener());
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, listeners);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
