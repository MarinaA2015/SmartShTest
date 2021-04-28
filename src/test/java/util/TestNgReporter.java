package util;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

public class TestNgReporter implements IReporter {
    public static LogLog4j log4j = new LogLog4j();
    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {
        log4j.info("list: " + list.toString());
        log4j.info("list1: " + list1.toString());
        log4j.info("String s: " + s);
    }
}
