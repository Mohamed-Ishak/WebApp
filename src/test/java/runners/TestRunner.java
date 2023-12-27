package runners;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;


@CucumberOptions(features="src/test/java/features",glue = "stepDefinitions"/*,tags="@test"*/,plugin = {"html:target/cucumber.html"})
public class TestRunner extends TestBase{

}
