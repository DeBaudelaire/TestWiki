package lib.ui.ios;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        searchInitElement = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        searchInput = "xpath://XCUIElementTypeSearchField";
        searchCancelButton = "id:Close";
        searchResultBySubstringTPL = "xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}']";
        searchResultElement = "xpath://XCUIElementTypeLink";
        searchEmptyResultElement = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        searchResultByTitleSubstringTPL = "xpath://XCUIElementTypeStaticText[@name='{TITLESUBSTRING}']";
        searchResultByDescriptionSubstringTPL = "xpath://XCUIElementTypeStaticText[@name='{DESCRIPTIONSUBSTRING}']";
    }

    public IOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
