package system.pages.americanas;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import system.base.BasePage;

public class CestaPage extends BasePage {
    @FindBy(name = "LineQuantity")
    protected WebElement quantidade;

    @FindBy(xpath = "//*[@id = 'summaryComponent']//li[1]//span")
    protected WebElement precoProduto;
}
