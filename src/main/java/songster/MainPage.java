package songster;

import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import songster.base.DriverInit;

import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.*;

public class MainPage extends DriverInit {

    @AndroidFindBy(id = "com.songsterr:id/song_list")
    private WebElement songList;

    public MainPage(){

        PageFactory.initElements(new AppiumFieldDecorator(aDriver), this);
    }

    public void horizontalSwipe() throws InterruptedException {

        Dimension dimension = songList.getSize();
        int verticalSwipePoint = songList.getSize().getHeight() / 2;

        double startPointSwipe = dimension.getWidth() * 0.9;
        int horizontalStartPointSwipe = (int) startPointSwipe;

        double endPointSwipe = dimension.getWidth() * 0.1;
        int horizontalEndPointSwipe = (int) endPointSwipe;

        new TouchAction(aDriver)
                .press(point(horizontalStartPointSwipe, verticalSwipePoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(point(horizontalEndPointSwipe, verticalSwipePoint))
                .release()
                .perform();

        Thread.sleep(5000);
    }

    public MainPage verticalSwipeToElement() throws InterruptedException {

        Dimension dimension = aDriver.manage().window().getSize();

        while(aDriver.findElements(By.xpath("//*[@text='Everlong']")).size() == 0){

            double startPointSwipe = dimension.getHeight() * 0.5;
            int verticalStartPointSwipe = (int) startPointSwipe;

            double endPointSwipe = dimension.getHeight() * 0.2;
            int verticalEndPointSwipe = (int) endPointSwipe;

            new TouchAction(aDriver)
                    .press(point(0, verticalStartPointSwipe))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(point(0, verticalEndPointSwipe))
                    .release()
                    .perform();

            Thread.sleep(3000);
        }

        return this;
    }

    public MainPage landscapeMode() throws InterruptedException {

        aDriver.rotate(ScreenOrientation.LANDSCAPE);
        ScreenOrientation screenOrientation = aDriver.getOrientation();
        System.out.println(screenOrientation);
        Assert.assertEquals("landscape", screenOrientation.value());

        Thread.sleep(3000);

        return this;
    }

    public MainPage longPress() throws InterruptedException {

        new TouchAction(aDriver)
                .longPress(LongPressOptions.longPressOptions()
                .withPosition(point(972, 1554))
                .withDuration(Duration.ofSeconds(2)))
                .moveTo(point(75, 325))
                .release()
                .perform();

        Thread.sleep(3000);

        return this;
    }

    public MainPage getResolution(){

        Dimension dimension = aDriver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        return this;
    }
}
