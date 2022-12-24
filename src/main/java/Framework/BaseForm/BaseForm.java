package Framework.BaseForm;

import Framework.DriverUtils.Driver;
import org.openqa.selenium.By;

public abstract class BaseForm {


    public abstract boolean isPageOpened();

    public static void openPage(String url){
        Driver.getDriver().get(url);
    }

}
