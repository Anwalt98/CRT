package Framework.BaseTest;

import Framework.ConfigUtils.ConfigUtils;
import Framework.DriverUtils.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    @BeforeTest
    protected void setUp() {
        ConfigUtils.setConfValues();
        Driver.getDriver().manage().window().maximize();
    }

    @AfterTest
    protected void tearDown() {
        Driver.deleteDriver();
    }
}
