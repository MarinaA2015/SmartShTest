package util;


import org.apache.log4j.Logger;

public class LogLog4j {

// Initialize Log4j log s

    private static Logger Log = Logger.getLogger(util.LogLog4j.class.getName());

    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

    public static void startTestCase(String sTestCaseName) {

        Log.info("");
        Log.info("");
        Log.info("********************************************************************************");
        Log.info("    Test Case: " + sTestCaseName );
        Log.info("********************************************************************************");


    }

    //This is to print log for the ending of the test case

    public static void endTestCase() {

        Log.info("*******************************************************************************" );
        Log.info("***************         " + "      -E---N---D-"  + "          ****************");
        Log.info("*******************************************************************************" );
        Log.info("");
        Log.info("");

    }

    public static void step( String text) {
        Log.info("");
        Log.info("##########################################################################" );
        Log.info("    " + text + "      " );
        Log.info("##########################################################################" );
        Log.info("");
        Log.info("");
    }

    public static void method( String text) {
        Log.info("");
        Log.info("======> Method started: '" + text + "'" );
        Log.info("");
    }

    public static void endTestCase2(){
        Log.info("****************************************************************************" );
        Log.info("-----Test case was finished------");
        Log.info("****************************************************************************" );
    }

    // Need to create these methods, so that they can be called

    public static void info(String message) {

        Log.info(message);

    }
    public static void verify(String message) {

        Log.info("Verify: " + message);

    }

    public static void warn(String message) {

        Log.warn(message);

    }

    public static void error(String message) {

        Log.error(message);

    }

    public static void fatal(String message) {

        Log.fatal(message);

    }

    public static void debug(String message) {
        Log.info("");
        Log.info("============= DEBUG =================");
        Log.info(message);
        Log.info("============= DEBUG =================");
        Log.info("");
        //Log.debug(message);

    }


}
