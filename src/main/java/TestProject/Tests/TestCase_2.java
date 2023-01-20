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

public class TestCase_2 extends BaseTest {

    HomePage homePage;
    SignUpPage signUpPage;
    LoginPage loginPage;

    // Этот тест будет падать, поскольку последняя проверка проверяет
    // был ли зарегистрирован пользователь без email или пароля,
    // которые являются обязательными полями.
    @Test(dataProvider = "TestCase_2", dataProviderClass = DProvider.class)
    public void test2(User user) {
        homePage = new HomePage();
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();

        CustomLogger.info("Начинаем тест 2.");
        CustomLogger.info("2.1 Открываем главную страницу.");
        DriverUtils.openPage(ConfigUtils.getURL());
        Assert.assertTrue(homePage.isFormOpened(), "Главная страница не открыта.");

        CustomLogger.info("2.2 Нажимаем кнопку Sign Up.");
        homePage.clickSignUp();
        Assert.assertTrue(signUpPage.isFormOpened(), "Страница регистрации не открыта.");

        CustomLogger.info("2.3 Регистрируем пользователя.");
        signUpPage.signUpUser(user);
        Assert.assertFalse(loginPage.isFormOpened(),"Пользователь с email:" + user.getEmail() +" и паролем: " + user.getPassword() + " был зарегестрирован.");
    }
}