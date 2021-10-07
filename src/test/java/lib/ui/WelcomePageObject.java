package lib.ui;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject {

    private static final String
        stepLearnMoreLink = "id:Learn more about Wikipedia",
        stepNewWaysToExploreText = "id:New ways to explore",
        stepAddOrEditPreferredLangLink = "id:Add or edit preferred languages",
        stepLearnMoreAboutDataCollectedLink = "id:Learn more about data collected",
        nextLink = "id:Next",
        getStartedButton = "id:Get started",
        skipButton = "id:Skip";

    public WelcomePageObject(RemoteWebDriver driver) {
        super(driver );
    }

    public void waitForLearnMoreLink() {
        this.waitForElementPresent(stepLearnMoreLink, "Cannot find 'Learn more about Wikipedia' link", 10);
    }

    public void clickNextButton() {
        this.waitForElementAndClick(nextLink, "Cannot find and click Next link", 10);
    }

    public void waitForNewWaysToExploreText() {
        this.waitForElementPresent(stepNewWaysToExploreText, "Cannot find 'New ways to explore'", 10);
    }

    public void waitForAddOrEditPreferredLangText() {
        this.waitForElementPresent(stepAddOrEditPreferredLangLink, "Cannot find 'Add or edit preferred languages' link", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText() {
        this.waitForElementPresent(stepLearnMoreAboutDataCollectedLink, "Cannot find 'Learn more about data collected' link", 10);
    }

    public void clickGetStartedButton() {
        this.waitForElementAndClick(getStartedButton, "Cannot find and click 'Get started' button", 10);
    }

    public void clickSkip() {
        waitForElementAndClick(skipButton, "Cannot find and click skip button", 10);
    }
}
