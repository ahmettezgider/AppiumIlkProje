package utils;

public enum Device {

    PIXEL2("emulator-5554",
            "11",
            "Pixel2",
            "Android"),
    SAMSUNG_A33(
            "RZCT40MN7MY",
            "12",
            "My Phone",
            "ANdroid");

    public String udid;
    public String version;
    public String deviceName;
    public String platformName;

    Device(String udid, String version, String deviceName, String platformName) {
        this.udid = udid;
        this.version = version;
        this.deviceName = deviceName;
        this.platformName = platformName;
    }
    }
