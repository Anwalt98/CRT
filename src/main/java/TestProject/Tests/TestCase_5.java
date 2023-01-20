package TestProject.Tests;

import Framework.BaseTest.BaseTest;
import Framework.ConfigUtils.ConfigUtils;
import Framework.DataProvider.DProvider;
import Framework.Driver.Driver;
import Framework.Driver.DriverUtils;
import Framework.Logger.CustomLogger;
import TestProject.PageObjectModels.HomePage;
import TestProject.PageObjectModels.LoginPage;
import TestProject.PageObjectModels.ProfilePage;
import TestProject.PageObjectModels.SignUpPage;
import TestProject.User.User;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase_5 extends BaseTest {

    HomePage homePage;
    SignUpPage signUpPage;
    LoginPage loginPage;
    ProfilePage profilePage;

    @Test(dataProvider ="TestCase_5",dataProviderClass = DProvider.class)
    public void test5(User user){
        homePage = new HomePage();
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();

        CustomLogger.info("Начинаем тест 5.");
        CustomLogger.info("5.1. Открываем главную страницу.");
        DriverUtils.openPage(ConfigUtils.getURL());
        Assert.assertTrue(homePage.isFormOpened(), "Главная страница не открыта.");

        CustomLogger.info("5.2. Нажимаем кнопку Sign Up.");
        homePage.clickSignUp();
        Assert.assertTrue(signUpPage.isFormOpened(), "Страница регистрации не открыта.");

        CustomLogger.info("5.3. Регистрируем пользователя.");
        signUpPage.signUpUser(user);
        Assert.assertTrue(loginPage.isFormOpened());

        CustomLogger.info("5.4. Переходим на страницу Login.");
        homePage.clickLoginLink();
        Assert.assertTrue(loginPage.isFormOpened(), "Login страница не открыта.");

        CustomLogger.info("5.5. Логиним пользователя.");
        loginPage.loginUser(user);
        Assert.assertTrue(profilePage.isFormOpened(), "Страница профиля не открыта.");
        Assert.assertEquals(profilePage.getNameFromTitle(), user.getName(),"Имя пользователя не совпадает с выведенным.");

        CustomLogger.info("5.6. Открываем новую вкладку.");
        DriverUtils.openNewTab(ConfigUtils.getURL());
        Assert.assertTrue(homePage.isFormOpened(), "Главная страница не открыта.");
        homePage.clickProfile();
        Assert.assertEquals(profilePage.getNameFromTitle(), user.getName(),"Имя пользователя не совпадает с выведенным.");

        profilePage.clickLogOut();
        Assert.assertTrue(homePage.isFormOpened(), "Главная страница не открыта.");
    }
}
