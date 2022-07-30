package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilsweb.Driver;

import java.util.Map;

import static utilsweb.Locators.*;

public class StepDefs {
    WebDriver driver;
    WebDriverWait wait;
    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
    }
    @Given("user on homepage")
    public void userOnHomepage() {
        driver.get(url);
    }

    @When("user fill the logoin form as follows")
    public void userFillTheLogoinFormAsFollows(DataTable table) {
        Map<String, String> map = table.asMap();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginUsername)).sendKeys(map.get("username"));
        driver.findElement(lLoginPassword).sendKeys(map.get("password"));
    }

    @And("user clicks submit button")
    public void userClicksSubmitButton() {
        driver.findElement(lLoginSubmitButton).click();
    }

    @Then("login should be successfull")
    public void loginShouldBeSuccessfull() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lWelcome));
    }


    @And("driver close")
    public void driverClose() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
