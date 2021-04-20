package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"}
		,features = {"Features/DesafioGlobo.feature"}
		,glue= {"steps", "utility"}
)

public class DesafioGlobo {

}