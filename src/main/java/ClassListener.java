import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;


public class ClassListener implements ITestListener {

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] makeScreen() {
        return ((TakesScreenshot) Driver.getDriver().get()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Information", type = "text/plain")
    private String sendInfo() {
        String message = "";
        message += ("Browser name: " + ((RemoteWebDriver) Driver.getDriver().get()).getCapabilities().getBrowserName() + "; ");
        message += ("Browser version: " + ((RemoteWebDriver) Driver.getDriver().get()).getCapabilities().getVersion() + "; ");
        return message;
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreen();
        sendInfo();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
