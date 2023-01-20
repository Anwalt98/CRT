package Framework.Utils;

import Framework.ConfigUtils.ConfigUtils;
import Framework.Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private static WebDriverWait wait =  new WebDriverWait(Driver.getDriver(), ConfigUtils.getWait());
    public static WebDriverWait getWait() {
       return wait;
    }
    public static void waitTextToBePresent(WebElement element, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }
    public static void frameToBeAvailableAndSwitchToIt(By by){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }
    public static void elementToBeClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void invisibilityOfElementLocated(By by){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}
