package songster.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseSetup {

    private final static String url = "http://127.0.0.1:4723/wd/hub";
    private final static DesiredCapabilities dc = new DesiredCapabilities();
    private static AndroidDriver aDriver;

    public AndroidDriver getDriver(){

        return aDriver;
    }

    private void initDriver(){

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_API_30");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability("appPackage", "com.songsterr");
        dc.setCapability("appActivity", "com.songsterr.main.MainActivity");
        dc.setCapability("noReset", true);

        try {
            System.out.println("Init driver with url: " + url);
            aDriver = new AndroidDriver(new URL(url), dc);
        } catch (NullPointerException|MalformedURLException e) {
            throw new RuntimeException("Appium driver could not be initiated" + e);
        }
    }

    @BeforeClass
    public void setUp(){

        initDriver();
    }

    @AfterClass
    public void tearDown(){

        if(aDriver != null){
            aDriver.quit();
        }
    }
}
