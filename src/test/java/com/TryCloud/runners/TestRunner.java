package com.TryCloud.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", //alternatively "classpath:features"
        glue = "com/TryCloud/step_definitions",
        plugin = {"html:target/cucumber.html",
                "json:target/cucumber.json", //this will generate json report
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target" //this is for detailed html report
        },
        dryRun = false
      //  , tags="@smoke"
)

public class TestRunner {
}
