package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\java\\features",
				 glue = "stepdefinitions",
				 monochrome = false,
				 dryRun = false,
				 plugin = {"pretty",
						 "json:test-output/CucumberReport/report.json",
						 "html:test-output/CucumberReport/report.html",
						   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class BookHotel {

}
