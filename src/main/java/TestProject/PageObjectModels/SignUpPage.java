package TestProject.PageObjectModels;

import Framework.BaseElement.Elements.Button;
import Framework.BaseElement.Elements.Input;
import Framework.BaseElement.Elements.Link;
import Framework.BaseElement.Elements.Text;
import Framework.BaseForm.BaseForm;
import TestProject.User.User;

public class SignUpPage extends BaseForm implements CommonInterface{
    public SignUpPage() {
        super("//*[@class = 'title' and contains(text(),'Sign Up')]");
    }
    static Input email = new Input("//*[@name='email']");
    static Input name = new Input("//*[@name='name']");
    static Input password = new Input("//*[@name = 'password']");
    static Button signUp = new Button("//button[contains(text(),'Sign Up')]");
    static Text dangerNotificationText = new Text("//*[contains(text(),'Email address already exists.')]");
    static Link loginLink = new Link("//a[@href='/login'and text()='login page']");
    public static void signUpUser(User user){
            email.sendKeys(user.getEmail());
            name.sendKeys(user.getName());
            password.sendKeys(user.getPassword());
            signUp.click();
    }
    public static boolean isDangerNotificationPresent(){
        return dangerNotificationText.isPresent();
    }
    public static void clickGoToLoginPageLink(){
        loginLink.click();
    }
}
