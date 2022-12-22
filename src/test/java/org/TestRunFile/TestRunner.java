package org.TestRunFile;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = { "src/test/java/org/RestAPIAutomationFeatureFiles" },
				 glue = {"org.RestAPIAutomationStepDefs"},
				 plugin = { "pretty","html:target/cucumber-html-report","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
				 monochrome = true
				)
public class TestRunner {
	
	  private TestNGCucumberRunner testngCucumberRunner;
	  
	  @BeforeClass(alwaysRun = true) public void setUpClass() {
	  testngCucumberRunner=new TestNGCucumberRunner(this.getClass()); }
	  
	  @Test(groups = "cucumber", description = "Runs cucumber feature",
	  dataProvider = "features") public void feature(PickleWrapper pickle,
	  FeatureWrapper cucumberFeature) {
	  testngCucumberRunner.runScenario(pickle.getPickle()); }
	  
	  @DataProvider public Object[][] features() { return
	  testngCucumberRunner.provideScenarios(); }
	  
	  @AfterClass(alwaysRun = true) public void tearDownClass() throws Exception {
	  testngCucumberRunner.finish(); }
	 
}