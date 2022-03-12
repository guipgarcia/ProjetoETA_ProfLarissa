package system.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage(){
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 35);
        PageFactory.initElements(driver, this);
    }
}
