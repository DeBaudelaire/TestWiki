package lib.ui;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject{

     protected  static String
        myListsLink,
        openNavigation;

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    public void openNavigation() {
        if (Platform.getInstance().isMw()) {
            this.waitForElementAndClick(openNavigation, "Cannot find and click open navigation button", 10);
        } else {
            System.out.println("Method openNavigation () does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickMyLists() {
        {
            if (Platform.getInstance().isMw()) {
                this.tryClickElementWithFewAttempts(myListsLink, "Cannot find navigation button to My list", 5);
            } else {
                this.waitForElementAndClick(myListsLink, "Cannot find my lists", 5);
            }
        }
    }
}
