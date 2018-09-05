import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

@Listeners(ClassListener.class)
public class Test60 {
    private final String LOGIN = Credentials.creds.getProperty("login");
    private final String PASS = Credentials.creds.getProperty("password");
    private LoginPage loginPage;
    private InboxPage inboxPage;

    @BeforeMethod
    public void beforeMethod() {
        Driver.openLoginPage();
        loginPage = new LoginPage();

    }

    @AfterMethod
    public void afterMethod() {
        Driver.closeDriver();
    }

    @Features("Login Test")
    @Description("Verify if user can log in via Login page")
    @TestCaseId("1")
    @Test
    public void loginTest() {
        inboxPage = loginPage.login(LOGIN, PASS);
        Assert.assertTrue(inboxPage.isDisplayed(), "Inbox page is not displayed");
    }

    @Features("LogOut Test")
    @Description("Verify if user can log out via LogOut link")
    @TestCaseId("2")
    @Test (enabled = false)
    public void logoutTest() {
        inboxPage = loginPage.login(LOGIN, PASS);
        loginPage = inboxPage.logout();
        Assert.assertTrue(loginPage.isDisplayed(), "Login page is not displayed");
    }
}
