package TestProject.PageObjectModels;

import Framework.BaseElement.Elements.Link;

public interface CommonInterface {
    Link signUp = new Link("//a[@href='/signup']");
    Link homeLink = new Link("//a[@href='/']");
    Link loginLink = new Link("//a[@href='/login']");
    Link logOut = new Link("//a[@href='/logout']");
    Link profile = new Link("//a[@href='/profile']");

    default void clickSignUp(){
        signUp.click();
    }
    default void clickHomeLink(){
        homeLink.click();
    }
    default void clickLoginLink(){
        loginLink.click();
    }
    default void clickLogOut(){
        logOut.click();
    }
    default void clickProfile(){
        profile.click();
    }
}
