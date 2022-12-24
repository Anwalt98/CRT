package Framework.BaseElement;

import Framework.DriverUtils.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public abstract class BaseElement{
    By by;

    public BaseElement(String by){
        this.by = new By.ByXPath(by);
    }
    public boolean isPresent(){
       return !Driver.getDriver().findElements(by).isEmpty();
    }
    public void click() {
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", Driver.getDriver().findElement(by));
    }
    public By getBy(){
        return by;
    }
}
