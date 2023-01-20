package TestProject.PageObjectModels;

import Framework.BaseElement.Elements.Button;
import Framework.BaseElement.Elements.Checkbox;
import Framework.BaseElement.Elements.Input;
import Framework.BaseForm.BaseForm;
import TestProject.User.User;

public class LoginPage extends BaseForm implements CommonInterface {
    public LoginPage() {
        super("//*[@class = 'title' and contains(text(),'Login')]");
    }

    Input email = new Input("//*[@name='email']");
    Input password = new Input("//*[@name = 'password']");
    Checkbox rememberMe = new Checkbox("//*[@class='checkbox']");
    Button login = new Button("//button[text()='Login']");

    public void loginUser(User user){
        email.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
        login.click();
    }
    public void clickCheckbox(){
        rememberMe.click();
    }
}