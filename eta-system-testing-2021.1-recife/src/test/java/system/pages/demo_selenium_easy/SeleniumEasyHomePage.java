package system.pages.demo_selenium_easy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import system.base.BasePage;

public class SeleniumEasyHomePage extends BasePage {
    private String basePath;

    @FindBy(xpath = "//li[@class ='dropdown']/a[contains(text() , 'Table')]")
    protected WebElement tableMenu;

    @FindBy(xpath = "//ul[@class = 'nav navbar-nav']//a[text() = 'Table Sort & Search']")
    protected WebElement tableSortAndSerachOption;

    @FindBy(id = "")
    protected WebElement elementById;

    // ############ DINAMIC ELEMENT ############
    protected WebElement getMenuItemMap(String menuItem){
        basePath = "//li[@class ='dropdown']/a[contains(text() , '"+menuItem+"')]";
        return getWebElementByXpath(basePath);
    }

    protected WebElement getSubmenuItemMap(String submenuItem){
        basePath = "//ul[@class = 'nav navbar-nav']//a[text() = '"+submenuItem+"']";
        return getWebElementByXpath(basePath);
    }

    private WebElement getWebElementByXpath(String basePath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(basePath)));
        return driver.findElement(By.xpath(basePath));
    }
}
