package TestProject.Tests;


import Framework.BaseTest.BaseTest;
import Framework.ConfigUtils.ConfigUtils;
import Framework.DataProvider.DProvider;
import Framework.Driver.DriverUtils;
import Framework.Logger.CustomLogger;
import TestProject.PageObjectModels.HomePage;
import TestProject.PageObjectModels.LoginPage;
import TestProject.PageObjectModels.ProfilePage;
import TestProject.PageObjectModels.SignUpPage;
import TestProject.User.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_4 extends BaseTest {

    HomePage homePage;
    SignUpPage signUpPage;
    LoginPage loginPage;
    ProfilePage profilePage;

    @Test(dataProvider ="TestCase_4",dataProviderClass = DProvider.class)
    public void test3(User user) {
        homePage = new HomePage();
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();

        CustomLogger.info("Начинаем тест 4.");
        CustomLogger.info("4.1. Открываем главную страницу.");
        DriverUtils.openPage(ConfigUtils.getURL());
        Assert.assertTrue(homePage.isFormOpened(),"Главная страница не открыта.");

        CustomLogger.info("4.2. Нажимаем кнопку Sign Up.");
        homePage.clickSignUp();
        Assert.assertTrue(signUpPage.isFormOpened(),"Страница регистрации не открыта.");

        CustomLogger.info("4.3. Регистрируем пользователя.");
        signUpPage.signUpUser(user);
        Assert.assertTrue(loginPage.isFormOpened());

        CustomLogger.info("4.4. Нажимаем кнопку Login.");
        loginPage.loginUser(user);
        Assert.assertTrue(profilePage.isFormOpened());
        Assert.assertEquals(profilePage.getNameFromTitle(), user.getName(),"Имя пользователя не совпадает с выведенным.");

        CustomLogger.info("4.5. Нажимаем кнопку Login.");
        profilePage.clickLogOut();
        Assert.assertTrue(homePage.isFormOpened(),"Главная страница не открыта.");
    }
}