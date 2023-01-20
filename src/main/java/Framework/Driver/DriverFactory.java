package Framework.Driver;

import Framework.ConfigUtils.ConfigUtils;
import Framework.Logger.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    static WebDriver getWebDriver(){
            switch (ConfigUtils.getBrowser()){
                case ("CHROME") -> {
                    CustomLogger.debug("Конфигурируем Chrome браузер.");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    if (ConfigUtils.getOptions() != null) {
                        options.addArguments(ConfigUtils.getOptions());
                    }
                    if (ConfigUtils.getLanguage() != null) {
                        options.addArguments(ConfigUtils.getLanguage());
                    }
                    return new ChromeDriver(options);
                }

                case ("FIREFOX") -> {
                    CustomLogger.debug("Конфигурируем Firefox браузер.");
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (ConfigUtils.getOptions() != null) {
                        firefoxOptions.addArguments(ConfigUtils.getOptions());
                    }
                    if (ConfigUtils.getLanguage() != null) {
                        firefoxOptions.addArguments(ConfigUtils.getLanguage());
                    }
                   return new FirefoxDriver(firefoxOptions);
                }
                default -> throw new IllegalArgumentException("Wrong browser");
            }
        }
    }
