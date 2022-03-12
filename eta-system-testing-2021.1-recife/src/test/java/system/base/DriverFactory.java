package system.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import system.helpers.Constants;

public class DriverFactory {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
        protected  synchronized WebDriver initialValue(){ return selectDriverType();}
    };

    public static WebDriver getDriver(){return threadDriver.get();}

    public static void quitDriver(){
        WebDriver localDriver = getDriver();
        if(localDriver != null){
            localDriver.quit();
            localDriver = null;
        }
        if(threadDriver != null){
            threadDriver.remove();
        }
    }

    public static WebDriver selectDriverType() {
        WebDriver driver = null;
        switch (Constants.DEFAULT_BROWSER){
        case "chrome":
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            options.addArguments("--incognito");
            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(capabilities);
            driver = new ChromeDriver(options);
            break;
        }
        return driver;
    }
}
