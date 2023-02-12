package Gun01;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test1 {

    @Test
    public void test1() throws MalformedURLException {

        // Desired capability
        // hangi cihaz ve hangi uygulamaya baglanilacak
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid", "RZCT40MN7MY");
        capabilities.setCapability("appium:version", "12");
        capabilities.setCapability("appium:deviceName", "Samgung A33");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appium:appPackage", "io.appium.android.apis");
        capabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");

        // RemoteWebDriver -> WebDriver -> AppiumDriver --> (AndroidDriver, iOSDriver)

        AppiumDriver<MobileElement> driver;

        // appium 4723 portundan calisiyor olmali
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();

        driver.closeApp();

    }

}

/*
    driver, dest.
    driver, cihaz, app

    RemoteWebDriver
    WebDriver
                        appium-java-client
                        7.x.x   8.x.x
    AppiumDriver        50      5
        AndroidDriver   5       50
        IOSDriver       5       50


 */