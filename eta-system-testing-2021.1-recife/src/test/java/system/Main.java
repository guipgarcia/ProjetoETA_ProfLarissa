package system;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import system.actions.demo_selenium_easy.InputFormDemoAction;
import system.actions.demo_selenium_easy.SeleniumEasyHomeAction;
import system.actions.demo_selenium_easy.TableSortAndSearchDemoAction;
import system.base.DriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Main{
    WebDriver driver;
    WebDriverWait wait;
    @BeforeEach
    public void beforeEach(){
        driver = DriverFactory.getDriver();

    }
    @DisplayName("Preenchendo formulario do Input Form Demo")
    @Test
    public void myFirstTest() throws InterruptedException {
        driver.get("https://demo.seleniumeasy.com/input-form-demo.html");
        // Fields map
        WebElement firstName = driver.findElement(By.xpath("//input[@name = 'first_name']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@name = 'last_name']"));
        WebElement email = driver.findElement(By.xpath("//input[@name = 'email']"));
        WebElement phone = driver.findElement(By.xpath("//input[@name = 'phone']"));
        WebElement endereco = driver.findElement(By.xpath("//input[@name = 'address']"));
        WebElement city = driver.findElement(By.xpath("//input[@name = 'city']"));
        WebElement state = driver.findElement(By.xpath("//select[@name = 'state']"));
        WebElement website = driver.findElement(By.xpath("//input[@name = 'website']"));
        WebElement zipcode = driver.findElement(By.xpath("//input[@name = 'zip']"));
        WebElement dontHaveHost = driver.findElement(By.xpath("//input[@name= 'hosting' and @value = 'no']"));
        WebElement description = driver.findElement(By.xpath("//textarea[@name = 'comment']"));
        WebElement sendButton = driver.findElement(By.xpath("//div[@class = 'form-group']//button[@type = 'submit']"));
        Select selectState = new Select(state);

        // Fill fields
        firstName.sendKeys("Guilherme");
        lastName.sendKeys("Garcia");
        email.sendKeys("guilherme_test@email.com");
        phone.sendKeys("8458886651");
        endereco.sendKeys("My address");
        city.sendKeys("New York");
        selectState.selectByVisibleText("Georgia");
        zipcode.sendKeys("1231");
        website.sendKeys("https://www.google.com");
        dontHaveHost.click();
        description.sendKeys("Form description");
        Thread.sleep(10000);
        sendButton.click();
    }

    @DisplayName("Table search")
    @Test
    public void tableSearch() throws InterruptedException {
        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
        Thread.sleep(5000);
        List<WebElement> printFirstLineValue = driver.findElements(By.cssSelector("table[id='task-table'] tbody tr:first-child td"));
        for(WebElement currentElement : printFirstLineValue){
            System.out.println(currentElement.getText());
        }
    }

    @DisplayName("Listing Elements for Assignee Column")
    @Test
    public void tableSearchForAssignee(){
        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
        WebElement assigneeHeader = driver.findElement(By.cssSelector("table[id='task-table'] th:nth-child(3)"));
        System.out.println(assigneeHeader.getText());
        List<WebElement> assigneeBody = driver.findElements(By.cssSelector("table[id='task-table'] td:nth-child(3)"));
        for(WebElement currentElement : assigneeBody){
            System.out.println(currentElement.getText());
        }
    }

    @DisplayName("Listing elements using filter")
    @Test
    public void listedUsersByFilter() throws InterruptedException {
        driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
        WebElement filterBtn = driver.findElement(By.cssSelector("div[class = 'pull-right'] button"));
        filterBtn.click();
        WebElement userNameFilter = driver.findElement(By.cssSelector("input[placeholder = 'Username']"));
        WebElement firstNameFilter = driver.findElement(By.cssSelector("input[placeholder = 'First Name']"));

        userNameFilter.sendKeys("jacobs");
        firstNameFilter.sendKeys("Daniel");
        Thread.sleep(8000);

        List<WebElement> firstReturnAfterSearch = driver.findElements(By.cssSelector("table[class = 'table'] tbody tr:not([style = 'display: none;']) td"));
        for(WebElement currentElement : firstReturnAfterSearch){
            System.out.println(currentElement.getText());
        }
    }

    @Test
    public void atividade17(){}

    @Test
    public void atividade19() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));


        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginBtn.click();
/*
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = 'Products']"));
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_badge"));*/
        try {
            WebElement shoppingCartBadger = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void atividade20(){
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));


        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement logoutSideBar = driver.findElement(By.cssSelector("#logout_sidebar_link"));
        try{
            logoutSideBar.click();
        }catch(Exception e){
            WebElement burgerBtn = driver.findElement(By.id("react-burger-menu-btn"));
            burgerBtn.click();
            logoutSideBar.click();
        }
    }

    @Test
    public void atividade21(){
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));


        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement shoppingCartLink = driver.findElement(By.cssSelector(".shopping_cart_link"));
        Assert.assertTrue(shoppingCartLink.isDisplayed());
    }

    @ParameterizedTest
    @CsvSource({"standard_user, secret_sauce"})
    public void atividade22(String user, String pass){
        wait = new WebDriverWait(driver, 30);
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));


        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_badge")));
            driver.findElement(By.cssSelector(".shopping_cart_badge"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void atividade23(){
        wait = new WebDriverWait(driver, 30);
        driver.get("http://demo.seleniumeasy.com/ajax-form-submit-demo.html");
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        WebElement name = driver.findElement(By.id("title"));
        WebElement comment = driver.findElement(By.id("description"));
        WebElement submitBtn = driver.findElement(By.id("btn-submit"));

        name.sendKeys("standard_user");
        comment.sendKeys("secret_sauce");
        submitBtn.click();

        WebElement submitedForm = driver.findElement(By.id("submit-control"));
        wait.until(ExpectedConditions.textToBePresentInElement(submitedForm,"Form submited Successfully!"));
    }

    @Test
    public void atividade24(){
        driver.get("https://demo.seleniumeasy.com/input-form-demo.html");
        // Fields map
        final WebElement firstName = driver.findElement(By.xpath("//input[@name = 'first_name']"));
        final WebElement lastName = driver.findElement(By.xpath("//input[@name = 'last_name']"));
        WebElement email = driver.findElement(By.xpath("//input[@name = 'email']"));
        WebElement phone = driver.findElement(By.xpath("//input[@name = 'phone']"));
        WebElement endereco = driver.findElement(By.xpath("//input[@name = 'address']"));
        WebElement city = driver.findElement(By.xpath("//input[@name = 'city']"));
        WebElement state = driver.findElement(By.xpath("//select[@name = 'state']"));
        WebElement website = driver.findElement(By.xpath("//input[@name = 'website']"));
        WebElement zipcode = driver.findElement(By.xpath("//input[@name = 'zip']"));
        WebElement dontHaveHost = driver.findElement(By.xpath("//input[@name= 'hosting' and @value = 'no']"));
        WebElement description = driver.findElement(By.xpath("//textarea[@name = 'comment']"));
        WebElement sendButton = driver.findElement(By.xpath("//div[@class = 'form-group']//button[@type = 'submit']"));
        Select selectState = new Select(state);

        // Fill fields
        firstName.sendKeys("Guilherme");
        lastName.sendKeys("Garcia");
        email.sendKeys("guilherme_test@email.com");
        phone.sendKeys("8458886651");
        endereco.sendKeys("My address");
        city.sendKeys("New York");
        selectState.selectByVisibleText("Georgia");
        zipcode.sendKeys("1231");
        website.sendKeys("https://www.google.com");
        dontHaveHost.click();
        description.sendKeys("Form description");

        Assertions.assertAll("Verifying all fields",
                () -> assertEquals("Guilherme", firstName.getText(), "First name was filled correctly"),
                () -> assertEquals("Garcia", lastName.getText(), "Last name was filled correctly"),
                () -> assertEquals("guilherme_test@email.com", email.getText(), "Email was filled correctly"),
                () -> assertEquals("8458886651", phone.getText(), "Phone was filled correctly"),
                () -> assertEquals("New York", city.getText(), "City "));
        sendButton.click();
    }

    @Test
    public void atividade24WithPageObject(){
        SeleniumEasyHomeAction homeAction = new SeleniumEasyHomeAction();
        InputFormDemoAction inputFormDemoAction = new InputFormDemoAction();
        homeAction.accessApplication();
        homeAction.selectHomeOption("Input Forms", "Input Form Submit");
        inputFormDemoAction.fillFormFieldsWithMockedValues();
        inputFormDemoAction.validateFilledFormWithMockedValues();
        inputFormDemoAction.clickSendButton();
    }

    @DisplayName("Click on name filter and verify if names change position")
    @ParameterizedTest
    @CsvSource({"Y. Berry"})
    public void atividade27(String name){
       /* driver.get("https://demo.seleniumeasy.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try{
            WebElement closeLightBox = driver.findElement(By.id("at-cv-lightbox-close"));
            closeLightBox.click();
        }catch(Exception e){
            System.out.println("Light Box not found");
        }

        WebElement selectTable = driver.findElement(By.xpath("//li[@class ='dropdown']/a[contains(text() , 'Table')]"));
        selectTable.click();

        WebElement selectTableSubmenuOption = driver.findElement(By.xpath("//ul[@class = 'nav navbar-nav']//a[text() = 'Table Sort & Search']"));
        selectTableSubmenuOption.click();

        String namePath = "//table[@id = 'example']//tbody/tr[1]/td[@class = 'sorting_1']";
        String nameBeforeClick = driver.findElement(By.xpath(namePath)).getText();

        WebElement nameField = driver.findElement(By.xpath("//table[@id = 'example']//th[text() = 'Name']"));
        nameField.click();

        String nameAfterClick = driver.findElement(By.xpath(namePath)).getText();

        Assertions.assertNotEquals(nameBeforeClick, nameAfterClick, "Names are not the same!");
        Assertions.assertEquals(nameAfterClick, name , "Name changed position");*/
        SeleniumEasyHomeAction homeAction = new SeleniumEasyHomeAction();
        TableSortAndSearchDemoAction tableSortAndSearchDemoAction = new TableSortAndSearchDemoAction();

        homeAction.accessApplication();
        homeAction.selectHomeOption("Table", "Table Sort & Search");
        tableSortAndSearchDemoAction.changeNamePosition();
        tableSortAndSearchDemoAction.isNameChangePosition(name);
    }

    @ParameterizedTest
    @CsvSource({"Y. Berry"})
    void atividade27WithPageObject(String name){
        SeleniumEasyHomeAction homeAction = new SeleniumEasyHomeAction();
        TableSortAndSearchDemoAction tableSortAndSearchDemoAction = new TableSortAndSearchDemoAction();

        homeAction.accessApplication();
        homeAction.selectHomeOption("Table", "Table Sort & Search");
        tableSortAndSearchDemoAction.changeNamePosition();
        tableSortAndSearchDemoAction.isNameChangePosition(name);
    }

    @Test
    public void testeeee(){
        driver.get("https://www.americanas.com.br/");
        WebElement busca = driver.findElement(By.name("conteudo"));
        busca.click();
        busca.sendKeys("cama");
        WebElement btnBusca = driver.findElement(By.xpath("//form[@action = '/busca']//button"));
        btnBusca.click();
        WebElement header = driver.findElement(By.xpath("//h1[@class = 'full-grid__Title-sc-19t7jwc-3 jstCvu']"));
        System.out.println(header.getText());
        Assertions.assertTrue(header.getText().contains("cama"));
    }

    @AfterEach
    public void afterEach(){
        DriverFactory.quitDriver();
    }
}
