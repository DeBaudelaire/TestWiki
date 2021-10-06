package lib.ui;
import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject{

     protected  static String
        myListsLink;

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists() {
        this.waitForElementAndClick(myListsLink, "Cannot find my lists", 5);
    }
}
