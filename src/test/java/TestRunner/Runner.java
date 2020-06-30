package TestRunner;

import com.cucumber.listener.ExtentProperties;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;	
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features/ValidacionBusqueda.feature",glue={"Auto.PruebaTecnica"},
	//tags = {"@foo"},
	plugin = { "com.cucumber.listener.ExtentCucumberFormatter:C:\\reporte\\ValidacionBusqueda.html"},	
	tags = { "~@ignore" }
)				
public class Runner {

	private static TestNGCucumberRunner testRunner;

    @BeforeClass
    public void setUP() {   
        testRunner = new TestNGCucumberRunner(Runner.class);
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("output/" + this.hashCode() + "-report.html");
        
    }

    @Test(description="Tests",dataProvider="features")
    public void setUpClass(CucumberFeatureWrapper cFeature) {
        testRunner.runCucumber(cFeature.getCucumberFeature());
    }

    @DataProvider(name="features")
    public Object[][] getFeatures() {
        return testRunner.provideFeatures();
    }

    @AfterClass
    public static void teardown() {
        testRunner.finish();
    }
}
