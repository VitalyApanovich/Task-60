import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class InboxPage extends Page{
    private final static String TITLE = "Входящие - Почта Mail.Ru";
    @FindBy(id = "PH_logoutLink")
    private WebElement logoutLink;

    InboxPage() {
        super(TITLE);
        PageFactory.initElements(driver, this);
    }

    LoginPage logout() {
        getLogoutLink().click();
        return new LoginPage();
    }

    WebElement getLogoutLink() {
        return logoutLink;
    }

}
