package Framework.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CustomLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomLogger.class);
    public static void info(String msg){
        LOGGER.info(msg);
    }
    public static void debug(String msg){
        LOGGER.debug(msg);
    }
    public static void warn(String msg){
        LOGGER.warn(msg);
    }
    public static Logger getLogger(){
        return LOGGER;
    }
}
