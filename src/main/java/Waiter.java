import java.util.concurrent.TimeUnit;

public class Waiter {

    public static void implicitWait(int waitTime) {
        Driver.getDriver().get().manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }
}
