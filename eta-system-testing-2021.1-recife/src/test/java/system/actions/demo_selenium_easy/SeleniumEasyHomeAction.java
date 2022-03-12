package system.actions.demo_selenium_easy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import system.pages.demo_selenium_easy.SeleniumEasyHomePage;

import static system.helpers.VariaveisGlobais.SELENIUM_EASY_URL;

public class SeleniumEasyHomeAction extends SeleniumEasyHomePage {
    private WebElement dinamicElement;
    public void accessApplication(){
        driver.get(SELENIUM_EASY_URL);
        try{
            WebElement closeLightBox = driver.findElement(By.id("at-cv-lightbox-close"));
            closeLightBox.click();
            System.out.println("Light Box exists and it was closed");
        }catch(Exception e){
            System.out.println("Light Box not found");
        }
    }

    public void selectHomeOption(String menuItem, String submenuItem){
        selectHomeMenu(menuItem);
        dinamicElement = getSubmenuItemMap(submenuItem);
        dinamicElement.click();
    }

    private void selectHomeMenu(String menuItem){
       dinamicElement = getMenuItemMap(menuItem);
       dinamicElement.click();
    }
}
