package Framework.BaseTest;

import Framework.ConfigUtils.ConfigUtils;
import Framework.Driver.Driver;
import Framework.Logger.CustomLogger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    @BeforeTest
    protected void setUp() {
        CustomLogger.debug("Подтаскиваем конфигурационные данные");
        ConfigUtils.setConfValues();
        CustomLogger.debug("Инициализируем драйвер");
        Driver.getDriver().manage().window().maximize();
    }

    @AfterTest
    protected void tearDown() {
        Driver.deleteDriver();
    }
}
