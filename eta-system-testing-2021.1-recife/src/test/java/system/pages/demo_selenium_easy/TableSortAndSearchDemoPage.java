package system.pages.demo_selenium_easy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import system.base.BasePage;

public class TableSortAndSearchDemoPage extends BasePage {

    @FindBy(xpath = "//table[@id = 'example']//tbody/tr[1]/td[@class = 'sorting_1']")
    protected WebElement firstName;

    @FindBy(xpath = "//table[@id = 'example']//th[text() = 'Name']")
    protected WebElement nameField;
}
