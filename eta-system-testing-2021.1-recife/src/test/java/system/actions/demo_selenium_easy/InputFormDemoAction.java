package system.actions.demo_selenium_easy;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.Select;
import system.pages.demo_selenium_easy.InputFormDemoPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputFormDemoAction extends InputFormDemoPage {

    public void fillFormFieldsWithMockedValues(){
        Select selectState = new Select(state);
        firstName.sendKeys("Guilherme");
        lastName.sendKeys("Garcia");
        email.sendKeys("guilherme_test@email.com");
        phone.sendKeys("8458886651");
        address.sendKeys("My address");
        city.sendKeys("New York");
        selectState.selectByVisibleText("Georgia");
        zipcode.sendKeys("1231");
        website.sendKeys("https://www.google.com");
        dontHaveHost.click();
        description.sendKeys("Form description");
    }

    public void validateFilledFormWithMockedValues(){
        Assertions.assertAll("Verifying all fields",
                () -> assertEquals("Guilherme", firstName.getText(), "First name was filled correctly"),
                () -> assertEquals("Garcia", lastName.getText(), "Last name was filled correctly"),
                () -> assertEquals("guilherme_test@email.com", email.getText(), "Email was filled correctly"),
                () -> assertEquals("8458886651", phone.getText(), "Phone was filled correctly"),
                () -> assertEquals("New York", city.getText(), "City "));
    }

    public void clickSendButton(){
        sendButton.click();
    }
}
