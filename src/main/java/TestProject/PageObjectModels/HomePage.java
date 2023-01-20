package TestProject.PageObjectModels;

import Framework.BaseElement.Elements.Link;
import Framework.BaseForm.BaseForm;

public class HomePage extends BaseForm implements CommonInterface {
    public HomePage() {
        super("//*[@class = 'title' and contains(text(),'Test home page')]");
    }
}
