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

public class TestCase_3 extends BaseTest {

    HomePage homePage;
    SignUpPage signUpPage;
    LoginPage loginPage;

    @Test(dataProvider ="TestCase_3",dataProviderClass = DProvider.class)
    public void test3(User user) {
        homePage = new HomePage();
        signUpPage = new SignUpPage();
        loginPage = new LoginPage();

        CustomLogger.info("Начинаем тест 3.");
        CustomLogger.info("3.1. Открываем главную страницу.");
        DriverUtils.openPage(ConfigUtils.getURL());
        Assert.assertTrue(homePage.isFormOpened(),"Главная страница не открыта.");

        CustomLogger.info("3.2. Нажимаем кнопку Sign Up.");
        homePage.clickSignUp();
        Assert.assertTrue(signUpPage.isFormOpened(),"Страница регистрации не открыта.");

        CustomLogger.info("3.3. Регистрируем пользователя.");
        signUpPage.signUpUser(user);
        Assert.assertTrue(loginPage.isFormOpened());

        CustomLogger.info("3.4. Нажимаем кнопку Sign Up.");
        loginPage.clickSignUp();
        Assert.assertTrue(signUpPage.isFormOpened(),"Страница регистрации не открыта.");

        CustomLogger.info("3.5. Повторно регистрируем пользователя.");
        signUpPage.signUpUser(user);
        Assert.assertTrue(signUpPage.isDangerNotificationPresent(), "Не появилось предупреждение о попытке повторной регистрации email.");

        CustomLogger.info("3.6. Переходим по ссылке.");
        signUpPage.clickGoToLoginPageLink();
        Assert.assertTrue(loginPage.isFormOpened(),"Не был совершен переход по ссылке.");
    }
}