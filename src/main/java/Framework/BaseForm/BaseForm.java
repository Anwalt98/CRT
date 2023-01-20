package Framework.BaseForm;

import Framework.Driver.Driver;
import Framework.Logger.CustomLogger;
import Framework.Utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BaseForm {
  public By uniqueBy;
    public BaseForm(String by){
        uniqueBy = new By.ByXPath(by);
    }

    public boolean isFormOpened(){
        CustomLogger.debug("Проверяем, открыта ли страница.");
        WaitUtils.getWait().until(ExpectedConditions.numberOfElementsToBeMoreThan(uniqueBy,0));
       return !Driver.getDriver().findElements(uniqueBy).isEmpty();
    }
}
