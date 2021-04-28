package util;

import io.appium.java_client.events.api.general.ElementEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementListener implements ElementEventListener {
    public static LogLog4j log4j = new LogLog4j();

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        log4j.info("Before click on " + webElement.toString().split("->")[1]);
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        log4j.info("After click on " + webElement.toString().split("->")[1]);
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {
        log4j.info("Before changing the value of " + webElement.toString().split("->")[1]);

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {
        log4j.info("After changing the value of " + webElement.toString().split("->")[1]);
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}
