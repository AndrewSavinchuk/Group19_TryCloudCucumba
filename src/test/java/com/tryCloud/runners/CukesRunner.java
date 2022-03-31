package com.tryCloud.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.txt" //,"pretty"
                },
        features = "src/test/resources/features",
        glue = "com/tryCloud/step_definitions",
        dryRun = false,
        tags = "@Regression",
        publish = true

)


public class CukesRunner {
}
