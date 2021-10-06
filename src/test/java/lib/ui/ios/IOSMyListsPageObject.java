package lib.ui.ios;
import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

 public class IOSMyListsPageObject extends MyListsPageObject {

     static {
         articleByTitleTPL = "xpath://XCUIElementTypeStaticText[@name='{title}']";
         iosElementToDelete = "xpath://XCUIElementTypeButton[@name='swipe action delete']";
     }
     public IOSMyListsPageObject(AppiumDriver driver) {
        super(driver);
     }
}
