package Framework.BaseElement;

import Framework.Driver.Driver;
import Framework.Logger.CustomLogger;
import Framework.Utils.WaitUtils;
import org.openqa.selenium.*;

public abstract class BaseElement{
   protected By by;
    public BaseElement(String by){
        this.by = new By.ByXPath(by);
    }
    public boolean isPresent(){
        CustomLogger.debug("Проверяем наличие локатора " + by.toString());
       return !Driver.getDriver().findElements(by).isEmpty();
    }
    public WebElement getElement(){
        CustomLogger.debug("Получаем WebElement локатора"  + by.toString());
        return Driver.getDriver().findElement(by);
    }
    public void click() {
        CustomLogger.debug("Пытаемся кликнуть на элемент");
        WaitUtils.elementToBeClickable(by);
        moveToElement();
        Driver.getDriver().findElement(by).click();
    }
    public void moveToElement(){
        CustomLogger.debug("Пытаемся скриптом передвинуться к элементу.");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", Driver.getDriver().findElement(by));
    }
    public String getText(){
        CustomLogger.debug("Получаем текст элемента.");
      return  Driver.getDriver().findElement(by).getText();
    }
    public By getBy(){
        return by;
    }
}
