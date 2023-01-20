package Framework.Utils;

import Framework.Driver.Driver;
import Framework.Logger.CustomLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertUtils {

    public static void acceptConfirm(){
        CustomLogger.info("Принимаем конферм.");
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    public static void inputPromtAlertName(String name){
        CustomLogger.info("Вводим строку в promt aлерт.");
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys(name);
    }
    public static void acceptAlert(){
        CustomLogger.info("Принимаем первый алерт.");
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    public static boolean isAlertOpened(){
        try{
            Driver.getDriver().switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException noAlertPresentException){
            return false;
        }
    }
    public static String getAlertText(){
        return WaitUtils.getWait().until(ExpectedConditions.alertIsPresent()).getText();
    }
}
