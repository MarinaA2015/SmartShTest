package util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener {
    public static LogLog4j log4j = new LogLog4j();
    @Override
    public void onTestStart(ITestResult iTestResult) {
        log4j.startTestCase(iTestResult.getName());
        //log4j.info("Methods: "+iTestResult.getMethod().toString());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log4j.info("SUCCESS");
        log4j.endTestCase();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log4j.info("!!! FAILURE !!!");
        log4j.endTestCase();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log4j.info("!!! SKIPPED !!!");
        log4j.endTestCase();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log4j.info("!!! FAILURE + WAS NOT FULLY IMPLEMENTED !!!");
        log4j.endTestCase();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log4j.info("");
        log4j.info("*********************************************************************************");
        log4j.info("*********************************************************************************");
        log4j.info("  PROJECT NAME: " + iTestContext.getName());
        log4j.info("*********************************************************************************");
        log4j.info("*********************************************************************************");
        log4j.info("");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
