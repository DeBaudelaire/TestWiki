package lib.ui.ios;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListsPageObject extends MyListsPageObject {

     static {
         articleByTitleTPL = "xpath://XCUIElementTypeStaticText[@name='{title}']";
         iosElementToDelete = "xpath://XCUIElementTypeButton[@name='swipe action delete']";
     }
     public IOSMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
     }
}
