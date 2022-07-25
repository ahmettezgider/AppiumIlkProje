package Gun03;

import io.cucumber.java.BeforeAll;
import utils.App;
import utils.Device;
import utils.Driver;

import static utils.Utils.openApp;

public class Hooks {

    @BeforeAll
    public static void beforeAll(){
        if(Driver.getDriver() == null)
            openApp(Device.SAMSUNG_A33, App.CALCULATOR);
    }
}
