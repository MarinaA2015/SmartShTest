package util;

import io.appium.java_client.events.api.general.ListensToException;
import org.openqa.selenium.WebDriver;

public class ExceptionListener implements ListensToException {
    public static LogLog4j log4j = new LogLog4j();

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        log4j.info("Exception: " + throwable);
    }
}
