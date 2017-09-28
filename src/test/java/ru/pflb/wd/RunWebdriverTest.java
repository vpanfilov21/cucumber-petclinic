package ru.pflb.wd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        tags = "@all",
        features = "src/test/resources/add",
        plugin = "json:target/cucumber-report.json")
public class RunWebdriverTest {
}
