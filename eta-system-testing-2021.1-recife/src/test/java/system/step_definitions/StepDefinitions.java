package system.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import system.actions.demo_selenium_easy.SeleniumEasyHomeAction;
import system.actions.demo_selenium_easy.TableSortAndSearchDemoAction;
import system.base.DriverFactory;

import static system.helpers.Constants.DEFAULT_BROWSER;

public class StepDefinitions {
    public static Scenario scenario;
    private SeleniumEasyHomeAction homeAction = new SeleniumEasyHomeAction();
    private TableSortAndSearchDemoAction tableSortAndSearchDemoAction = new TableSortAndSearchDemoAction();

    @Before
    public void before(Scenario currentScenario){
        scenario = currentScenario;
        System.out.println("Scenario Name - " + scenario.getName());
        System.out.println("Executing scenario on: " + DEFAULT_BROWSER);
        System.out.println(" ############## BEFORE ##############");
    }

    @After
    public void after(){
        System.out.println(" ############## AFTER ##############");
        System.out.println("Scenario Name - " + scenario.getName());
        System.out.println("Status - " + scenario.getStatus());
        DriverFactory.quitDriver();
    }

    // ########### SCENARIO'S STEPS ###########
    @Given("that I access demo selenium easy application")
    public void that_i_access_demo_selenium_easy_application() {
        homeAction.accessApplication();
    }
    @When("I select the {string} and {string}")
    public void i_select_the_and(String menuItem, String submenuItem) {
        homeAction.selectHomeOption(menuItem, submenuItem);
    }
    @When("I change name position")
    public void i_change_name_position() {
        tableSortAndSearchDemoAction.changeNamePosition();
    }
    @Then("The {string} position was changed")
    public void the_position_was_changed(String name) {
        tableSortAndSearchDemoAction.isNameChangePosition(name);
    }
}
