package lib.ui.android;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static {
        folderByNameTPL = "xpath://*[@text='{folderName}'";
        articleByTitleTPL = "xpath://*[@text='{title}']";
    }

    public AndroidMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
