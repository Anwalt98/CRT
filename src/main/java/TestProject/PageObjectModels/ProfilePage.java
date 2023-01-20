package TestProject.PageObjectModels;

import Framework.BaseElement.Elements.Text;
import Framework.BaseForm.BaseForm;

public class ProfilePage extends BaseForm implements CommonInterface{
    public ProfilePage() {
        super("//*[@class = 'title' and contains(text(), 'Welcome,')]");
    }
    public static Text title = new Text("//*[@class = 'title' and contains(text(), 'Welcome,')]");

    public String getNameFromTitle(){
      String name = (String) title.getText().subSequence(9,title.getText().length()-1);
      return name;
    }
}