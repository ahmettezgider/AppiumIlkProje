package Gun01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

public class Test4 {
    By lContinue = By.id("com.android.permissioncontroller:id/continue_button");
    By lOkButton = By.id("android:id/button1");
    By lAccessibility = By.xpath("//android.widget.TextView[@content-desc='Accessibility']");

    AppiumDriver<MobileElement> driver;
    @BeforeTest
    public void beforeTest(){
        Driver.runAppium();

        driver = Driver.getDriver(Device.SAMSUNG_A33, App.APIDEMO);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
        Driver.stopAppium();
    }

    @Test
    public void test1(){
        driver.findElement(lContinue).click();
        driver.findElement(lOkButton).click();
        driver.findElement(lAccessibility).click();

    }

    @Test
    public void test2(){
        click(lContinue);
        click(lOkButton);
        click(lAccessibility);
    }

    void click(By locator){
        Driver.getDriver().findElement(locator).click();
    }
}
