package utils;

public enum App {

    APIDEMO("io.appium.android.apis","ApiDemos", ""),
    CALCULATOR("com.sec.android.app.popupcalculator","Calculator", "")
    ;

    public String appPackage;
    public String appActivity;
    public String apk;


    App(String appPackage, String appActivity, String apk) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        this.apk = apk;
    }


}
