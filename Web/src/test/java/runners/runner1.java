package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilsweb.Driver;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepdefs"}
)
public class runner1 extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("ortam")
    public void beforeTest(@Optional("pc") String ortam){
        if(ortam.equalsIgnoreCase("mobil"))
            Driver.getMobilDriver();
        else
            Driver.getDriver();
    }
}
