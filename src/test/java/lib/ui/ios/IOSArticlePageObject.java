package lib.ui.ios;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {
    static {
        title = "id:Java (programming language)";
        footerElement = "id:View article in browser";
        optionsAddTiMyListButton = "xpath://XCUIElementTypeButton[@name='Save for later']";
        closeArticleButton = "xpath://XCUIElementTypeButton[@name='Back']";
        closePopUp = "xpath://XCUIElementTypeButton[@name='places auth close']";
        goHome = "//XCUIElementTypeButton[@name='Wikipedia, return to Explore']";
        secondTitle = "id:Java version history";
    }

    public IOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
