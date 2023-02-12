package Gun01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

import java.text.MessageFormat;
import java.time.Duration;

public class Test6 {
    By lContinue = By.id("com.android.permissioncontroller:id/continue_button");
    By lOkButton = By.id("android:id/button1");
    String textXpath = "//*[@text=\"{0}\"]";


    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeTest
    public void beforeTest(){
        Driver.runAppium();
        driver = Driver.getDriver(Device.SAMSUNG_A33, App.APIDEMO);
        wait = new WebDriverWait(driver, 10);
        click(lContinue);
        click(lOkButton);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
        Driver.stopAppium();
    }

    @Test
    public void test1(){
        click(xpathOfText("Views"));
        waitForVisibility(xpathOfText("Auto Complete"));
        swipeV(.6, .3);
        swipeV(.3, .6);

    }

    @Test
    public void test2(){
        click(xpathOfText("Views"));
        waitForVisibility(xpathOfText("Auto Complete"));
        swipeUntil(xpathOfText("WebView"), .6, .4);
        click(xpathOfText("WebView"));
        driver.navigate().back();
        swipeUntil(xpathOfText("Animation"), .4, .7);
    }
    void click(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    void waitForVisibility(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    By xpathOfText(String...text){
        return By.xpath(MessageFormat.format(textXpath, text));
    }

    public void swipeV(double startPoint, double stopPoint){
        int w = driver.manage().window().getSize().width;
        int h = driver.manage().window().getSize().height;

        new TouchAction<>(driver)
                .press(PointOption.point(w/2, (int)(h*startPoint)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(w/2, (int)(h*stopPoint)))
                .release()
                .perform();

    }

    public void swipeUntil(By locator, double start, double end){
        while (driver.findElements(locator).size()<=0)
            swipeV(start, end);
    }
}
