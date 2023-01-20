package TestProject.Tests;


import Framework.BaseTest.BaseTest;
import Framework.ConfigUtils.ConfigUtils;
import Framework.DataProvider.DProvider;
import Framework.Driver.DriverUtils;
import Framework.Logger.CustomLogger;
import TestProject.PageObjectModels.HomePage;
import TestProject.PageObjectModels.LoginPage;
import TestProject.PageObjectModels.SignUpPage;
import TestProject.User.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_1 extends BaseTest {

    HomePage homePage;
    SignUpPage signUpPage;
    LoginPage loginPage;

    @Test(dataProvider ="TestCase_1",dataProviderClass = DProvider.class)
    public void test1(User user) {
        homePage = new HomePage();
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();

        CustomLogger.info("Начинаем тест 1.");
        CustomLogger.info("1.1 Открываем главную страницу.");
        DriverUtils.openPage(ConfigUtils.getURL());
        Assert.assertTrue(homePage.isFormOpened(),"Главная страница не открыта.");

        CustomLogger.info("1.2. Нажимаем кнопку Sign Up.");
        homePage.clickSignUp();
        Assert.assertTrue(signUpPage.isFormOpened(),"Страница регистрации не открыта.");

        CustomLogger.info("1.3. Регистрируем пользователя.");
        signUpPage.signUpUser(user);
        Assert.assertTrue(loginPage.isFormOpened(),"Пользователь не зарегистрирован.");
    }
}