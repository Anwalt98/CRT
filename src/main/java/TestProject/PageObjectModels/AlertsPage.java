package TestProject.PageObjectModels;

import Framework.BaseElement.Button;
import Framework.BaseElement.Text;
import Framework.BaseForm.BaseForm;
import Framework.DriverUtils.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class AlertsPage extends BaseForm {
    Button menuButton = new Button("//*[contains(text(),'Alerts')]/ancestor::*[@class='btn btn-light ']");
    Button allertButton = new Button("//*[@id ='alertButton']");
    Text alertsLabel = new Text("//*[contains(text(),'Alerts')]/ancestor::div[contains(@class,'playgound-header')]");
    public void clickMenuItemButton(){
        menuButton.click();
    }

    public String getAlertText(){
        Alert alert = Driver.getDriver().switchTo().alert();
        return alert.getText();
    }
    public void clickAlertButton(){
        allertButton.click();
    }
    public void acceptAlert(){
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    public boolean isAlertOpened(){
        try{
            Driver.getDriver().switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException noAlertPresentException){
            return false;
        }
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public boolean isAlertsFragmentOpened(){
      return  allertButton.isPresent();
    }
}