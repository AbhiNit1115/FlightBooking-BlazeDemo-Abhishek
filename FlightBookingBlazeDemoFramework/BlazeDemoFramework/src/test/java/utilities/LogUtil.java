package utilities;

import org.apache.log4j.Logger;
import org.testng.*;

public class LogUtil extends TestListenerAdapter implements ITestListener {

    private static Logger log = Logger.getLogger(ConfigReader.get("logger.file"));

    public static void info(String message){
        log.info(message);
    }

    public static void warn(String message){
        log.warn(message);
    }

    public static void error(String message){
        log.error(message);
    }

    public static void fatal(String message){
        log.fatal(message);
    }

    public static void debug(String message){
        log.debug(message);
    }

}
