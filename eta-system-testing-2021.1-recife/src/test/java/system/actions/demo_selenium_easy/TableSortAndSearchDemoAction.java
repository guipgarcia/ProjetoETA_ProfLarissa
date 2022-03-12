package system.actions.demo_selenium_easy;

import org.junit.jupiter.api.Assertions;
import system.pages.demo_selenium_easy.TableSortAndSearchDemoPage;

public class TableSortAndSearchDemoAction extends TableSortAndSearchDemoPage {
    private String nameBeforeClick, nameAfterClick;

    private String getTableSortName(){
        return firstName.getText();
    }

    public void changeNamePosition(){
        nameBeforeClick = getTableSortName();
        nameField.click();
        nameAfterClick = getTableSortName();
    }

    public void isNameChangePosition(String nameToCompare){
        Assertions.assertNotEquals(nameBeforeClick, nameAfterClick, "Names are not the same!");
        Assertions.assertEquals(nameAfterClick, nameToCompare , "Name changed position");
    }
}
