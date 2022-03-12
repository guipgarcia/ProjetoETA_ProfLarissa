package system.pages.demo_selenium_easy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import system.base.BasePage;

public class InputFormDemoPage extends BasePage {
    @FindBy(xpath = "//input[@name = 'first_name']")
    protected WebElement firstName;

    @FindBy(xpath = "//input[@name = 'last_name']")
    protected WebElement lastName;

    @FindBy(xpath = "//input[@name = 'email']" )
    protected WebElement email;

    @FindBy(xpath = "//input[@name = 'phone']")
    protected WebElement phone;

    @FindBy(xpath = "//input[@name = 'address']")
    protected WebElement address;

    @FindBy(xpath = "//input[@name = 'city']")
    protected WebElement city;

    @FindBy(xpath = "//select[@name = 'state']")
    protected WebElement state;

    @FindBy(xpath = "//input[@name = 'website']")
    protected WebElement website;

    @FindBy(xpath = "//input[@name = 'zip']")
    protected WebElement zipcode;

    @FindBy(xpath = "//input[@name= 'hosting' and @value = 'no']")
    protected WebElement dontHaveHost;

    @FindBy(xpath = "//textarea[@name = 'comment']")
    protected WebElement description;

    @FindBy(xpath = "//div[@class = 'form-group']//button[@type = 'submit']")
    protected WebElement sendButton;


}
