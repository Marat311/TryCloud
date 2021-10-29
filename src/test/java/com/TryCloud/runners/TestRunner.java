package com.TryCloud.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", //alternatively "classpath:features"
        glue = "com/TryCloud/step_definitions",
        plugin = {"html:target/cucumber.html",
                "rerun:target/rerun.txt",
                "json:target/cucumber.json",
                "me.jvt.cucumber.report.PrettyReports:target"
        },   dryRun = false
      //  , tags="@smoke"
)

public class TestRunner {
}
