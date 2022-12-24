package TestProject.PageObjectModels;

import Framework.BaseElement.Button;
import Framework.BaseElement.Text;
import Framework.BaseForm.BaseForm;

public class DemoQAMainPage extends BaseForm {
        Text mainPageBanner = new Text("//*[@class ='home-body']");
        Button alertsFrameWindowsbutton = new Button("//*[contains(text(),'Alerts')]/ancestor::*[contains(@class,'card mt-4 top-card')]");


    @Override
    public boolean isPageOpened() {
        return mainPageBanner.isPresent();
    }

    public void openAlerts(){
        alertsFrameWindowsbutton.click();
    }
}
