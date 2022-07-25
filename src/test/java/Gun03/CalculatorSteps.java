
package Gun03;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;


import java.util.List;

public class CalculatorSteps {

    AppiumDriver<?> driver;
    WebDriverWait wait;
    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 20);
    }


    By lButtonAdd = By.id("calc_keypad_btn_add");
    By lButtonEqual = By.id("calc_keypad_btn_equal");
    By lScreen = By.id("calc_edt_formula");



    @Given("user on start page")
    public void userOnStartPage() {
        //driver = openApp(Device.SAMSUNG_A33, App.CALCULATOR);
        //wait = new WebDriverWait(driver, 20);
        driver.resetApp();
    }

    @When("user sum the following numbers")
    public void userSumTheFollowingNumbers(DataTable table) {
        List<Integer> list = table.asList(Integer.class);
        int max = list.size();
        int i=1;

        for (Integer num : list) {
            click(num);
            if (i++ != max)
                click(lButtonAdd);
        }
        click(lButtonEqual);
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int result) {
        Assert.assertTrue(driver.findElement(lScreen).getText().contains(result+""));
    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void click(int num){
        if (num>=0 && num <=9)
            click(By.xpath("//android.widget.Button[@content-desc='" + num + "']"));
    }
}
