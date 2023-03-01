package songster.base;

import io.appium.java_client.android.AndroidDriver;

public class DriverInit extends BaseSetup{

    protected AndroidDriver aDriver;

    protected DriverInit(){

        this.aDriver = super.getDriver();
    }
}
