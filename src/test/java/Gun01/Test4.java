package Gun01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

public class Test4 {
    @Test
    public void test1(){
        Driver.runAppium();

        AppiumDriver<MobileElement> driver = Driver.getDriver(Device.SAMSUNG_A33, App.APIDEMO);

        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();

        Driver.stopAppium();
    }
}
