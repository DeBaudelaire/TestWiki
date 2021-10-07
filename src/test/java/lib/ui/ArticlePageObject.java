package lib.ui;
import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            title,
            footerElement,
            optionsButton,
            optionsAddTiMyListButton,
            optionsRemoveFromMyListButton,
            addToMyListOverlay,
            myListNameInput,
            myListOkButton,
            closeArticleButton,
            closePopUp,
            goHome,
            secondTitle;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(title, "Cannot find first article title", 15);
    }

    public WebElement waitForSecondTitleElement() {
        return this.waitForElementPresent(secondTitle, "Cannot find second article title", 15);
    }

    public String  getArticleTitle() {
        WebElement titleElement = waitForTitleElement();

        if (Platform.getInstance().isAndroid()) {
            return titleElement.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return titleElement.getAttribute("name");
        } else {
            return titleElement.getText();
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(footerElement, "Cannot find the end of article", 40);
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementAppear(footerElement, "Cannot find the end of article", 40);
        } else {
            scrollWebPageTillElementNotVisible(footerElement, "Cannot find the end of article", 40);
        }
    }

    public void addArticleToNewList(String nameOfFolder) {
        this.waitForElementAndClick(optionsButton, "Cannot find button to open article options", 5);
        this.waitForElementAndClick(optionsAddTiMyListButton, "Cannot find option to add article to reading list", 5);
        this.waitForElementAndClick(addToMyListOverlay, "Cannot find 'Got it' button", 10);
        this.waitForElementAndClear(myListNameInput, "Cannot find input to set name of article's folder", 15);
        //название списка закладок

        this.waitForElementAndSendKeys(myListNameInput, nameOfFolder, "Cannot put text into articles folder input",  5);
        this.waitForElementAndClick(myListOkButton, "Cannot press OK button", 5);
    }

    public void addArticleToMyList(String nameOfFolder) {
        this.waitForElementAndClick(optionsButton, "Cannot find button to open article options", 5);
        this.waitForElementAndClick(optionsAddTiMyListButton, "Cannot find option to add article to reading list", 5);
        this.waitForElementAndClick("xpath://*[@text='" + nameOfFolder + "']", "Cannot find 'Learning programming' list", 5);

    }

    public void closeArticle() {
        if ((Platform.getInstance().isIOS()) || (Platform.getInstance().isAndroid())) {
            this.waitForElementAndClick(closeArticleButton, "Cannot find X button to close article", 5);
        } else {
         }
    }

    public void closeIOSPopUp() {
        this.waitForElementAndClick(closePopUp, "Cannot find X button to close pop-up", 10);
    }

    public int getAmountOfArticleTitles() {
        this.waitForElementPresent(title, "Cannot find any titles", 20);
        return this.getAmountOfElements(title);
    }

    public void addArticlesToMySaved() {
        if (Platform.getInstance().isMw()) {
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(optionsAddTiMyListButton, "Cannot find option to add article to reading list", 10);
    }

    public void removeArticleFromSavedIfItAdded() {
        if (isElementPresent(optionsRemoveFromMyListButton)) {
            this.waitForElementAndClick(optionsRemoveFromMyListButton, "Cannot click button to remove an article from saved", 10);
            this.waitForElementPresent(optionsRemoveFromMyListButton, "Cannot find button to add an article to saved list after removing it from this list before", 10);
        }
    }
}
