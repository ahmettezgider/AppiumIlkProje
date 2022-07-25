package Gun02;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

import static utils.Utils.openApp;

public class Test03Calculator {

    AppiumDriver<?> driver;
    WebDriverWait wait;

    By lNumber0 = By.id("calc_keypad_btn_00");
    By lNumber1 = By.id("calc_keypad_btn_01");
    By lNumber2 = By.id("calc_keypad_btn_02");
    By lNumber3 = By.id("calc_keypad_btn_03");
    By lNumber4 = By.id("calc_keypad_btn_04");
    By lNumber5 = By.id("calc_keypad_btn_05");
    By lNumber6 = By.id("calc_keypad_btn_06");
    By lNumber7 = By.id("calc_keypad_btn_07");
    By lNumber8 = By.id("calc_keypad_btn_08");
    By lNumber9 = By.id("calc_keypad_btn_09");
    By lClear = By.id("calc_keypad_btn_clear");
    By lAdd = By.id("calc_keypad_btn_add");
    By lSub = By.id("calc_keypad_btn_sub");
    By lMul = By.id("calc_keypad_btn_mul");
    By lDiv = By.id("calc_keypad_btn_div");
    By lDot = By.id("calc_keypad_btn_dot");
    By lEqual = By.id("calc_keypad_btn_equal");
    By lPercentage = By.id("calc_keypad_btn_percentage");
    By lScreen = By.id("calc_edt_formula");



    @BeforeTest
    public void beforeTest(){
        driver = openApp(Device.SAMSUNG_A33, App.CALCULATOR);
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void sum1(){
        click(lNumber2);
        click(lSub);
        click(lNumber3);
        click(lEqual);
        System.out.println(getTextOf(lScreen));
        Assert.assertEquals(getTextOf(lScreen).replaceAll("[^0-9-,]",""), "1");

    }


    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getTextOf(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }



    @AfterTest
    public void afterTest(){
        driver.closeApp();
        Driver.stopAppium();
    }
}


/*
        Cep Telefonu hesap makinesinde asagidaki islemleri yapiniz ve sonucu assert ediniz

        1+1 = 2
        123 + 435 = 558
        1,23 + 5,7 = 6,93

        34 - 12 = 22
        12 - 34 = -22

        25 x 35 = 900
        1,2 x 2,1 = 2,52

        10/4 = 2,5
        10/3 = 3.33333333



 */