package songster_test;

import org.testng.annotations.Test;
import songster.MainPage;
import songster.base.DriverInit;

public class AppiumTest extends DriverInit {

    @Test
    public void horizontalSwipingTest() throws InterruptedException {

        new MainPage()
                .horizontalSwipe();
    }


    @Test
    public void verticalSwipingToElementTest() throws InterruptedException {

        new MainPage()
                .verticalSwipeToElement()
                .landscapeMode();
    }

    @Test
    public void longPressTest() throws InterruptedException {

        new MainPage()
                .longPress();
    }
}
