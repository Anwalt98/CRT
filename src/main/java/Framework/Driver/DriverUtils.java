package Framework.Driver;

import Framework.ConfigUtils.ConfigUtils;
import Framework.Logger.CustomLogger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class DriverUtils {
    public static void openPage(String url){
        CustomLogger.info("Открываем главную страницу.");
        Driver.getDriver().get(url);
    }
    public static void switchToNextTab(){
        CustomLogger.info("Переключаем драйвер на новую вкладку.");
        String mwh = Driver.getDriver().getWindowHandle();
        Set s = Driver.getDriver().getWindowHandles();
        for (Object tab : s){
            String current = tab.toString();
            if (current != mwh){
                Driver.getDriver().switchTo().window(current);
            }
        }
    }
    public static String getActiveElementText(){
      return Driver.getDriver().switchTo().activeElement().getText();
    }
    public static void closeAndSwitchToPreviousTab(){
        CustomLogger.info("Закрываем вкладку и переносим драйвер на новую вкладку.");
        Set handles = Driver.getDriver().getWindowHandles();
        String current =  Driver.getDriver().getWindowHandle();
        handles.remove(current);
        String tabToGo = (String) handles.stream().findFirst().get();
        Driver.getDriver().close();
        Driver.getDriver().switchTo().window(tabToGo);
    }

    public static String getCurrentURL(){
        CustomLogger.info("Получаем текущий URL");
        new WebDriverWait(Driver.getDriver(), ConfigUtils.getWait()).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return Driver.getDriver().getCurrentUrl();
    }

    public static String getCurrentTab(){
        CustomLogger.info("Получаем текущую вкладку.");
        return Driver.getDriver().getWindowHandle();
    }
    public static void switchTo(String frame){
        Driver.getDriver().switchTo().frame(frame);
    }
    public static void switchToDefaultContent(){
        Driver.getDriver().switchTo().defaultContent();
    }

    public static void openNewTab(String URL){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('"+ URL +"','_blank');");
        switchToNextTab();
    }
    public static void simulateBrowserRestart(String URL){
        Set<Cookie> cookies = Driver.getDriver().manage().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getExpiry() == null) {
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
                Driver.getDriver().manage().deleteCookie(cookie);
            }
        }

        Driver.getDriver().get(URL);
    }
}
