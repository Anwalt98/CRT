package Framework.BaseElement.Elements;

import Framework.BaseElement.BaseElement;
import Framework.Driver.Driver;
import Framework.Logger.CustomLogger;

public class Input extends BaseElement {

    public Input(String xPath) {
        super(xPath);
    }
    public void sendKeys(String keys){
        CustomLogger.debug("Отправляем значение в веб элемент.");
        Driver.getDriver().findElement(by).sendKeys(keys);
    }
}
