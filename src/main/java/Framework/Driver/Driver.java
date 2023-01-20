package Framework.Driver;
import org.openqa.selenium.WebDriver;


public class Driver {

   private static WebDriver driver;
    private Driver(){
}
    public static WebDriver getDriver(){
        if (driver == null) {
          driver = DriverFactory.getWebDriver();
            }
         return driver;
    }

    public static void deleteDriver(){
        Driver.getDriver().quit();
        driver = null;
    }
}
