package lib.ui.mobileWeb;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {

    static {
        articleByTitleTPL = "xpath://ul[contains(@class,'content-unstyled')]//h3[contains(text(),'{title}')]";
        removeFromSavedButton = "xpath://ul[contains(@class,'content-unstyled')]//h3[contains(text(),'{title}')]/../../a[contains(@class,'watched')]";
    }
    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
