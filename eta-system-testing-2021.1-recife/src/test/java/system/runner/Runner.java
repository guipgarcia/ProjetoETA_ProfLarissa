package system.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/system/resources/features",
    glue = "system/step_definitions",
    plugin = "pretty",
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    tags = "@TableSortScenarios"
)
public class Runner {

}