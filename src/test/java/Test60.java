import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test
    public void loginTest() {
        inboxPage = loginPage.login(LOGIN, PASS);
        Assert.assertTrue(inboxPage.isDisplayed(), "Inbox page is not displayed");
    }

    @Test
    public void logoutTest() {
        inboxPage = loginPage.login(LOGIN, PASS);
        loginPage = inboxPage.logout();
        Assert.assertTrue(loginPage.isDisplayed(), "Login page is not displayed");
    }
}
