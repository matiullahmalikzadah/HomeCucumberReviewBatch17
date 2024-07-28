package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        // features we used to provide the path of all the feature files
        features = "src/test/resources/features",
        //glue is where we find implementation of the gherkin steps
        //we provide the path of package where we defined all the step def
        glue = "steps",
        dryRun = false,
        tags = "@test13",
        //for generating the report
        //pretty is responsible for printing the step and step definition in the console
        //in your framework, all reports should be generated under target folder
        //we will generate html report in target folder
        plugin = {"pretty", "html:target/mati .html", "json:target/cucumber.json",
        "rerun:target/field.txt"}
        //rerun plugin will create failed.tx under target for all failed tc
)

public class runnerClass {
    // it will be empty

}
