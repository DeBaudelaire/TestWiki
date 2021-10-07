package lib.ui;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {

    protected static String
            folderByNameTPL,
            articleByTitleTPL,
            iosElementToDelete,
            removeFromSavedButton;

    public static String getFolderXpathByName(String nameOfFolder) {
        return folderByNameTPL.replace("{folderName}", nameOfFolder);
    }

    public static String getSavedArticleXpathByTitle(String articleTitle) {
        return articleByTitleTPL.replace("{title}", articleTitle);
    }

    public static String getRemoveButtonByTitle(String articleTitle) {
        return removeFromSavedButton.replace("{title}", articleTitle);
    }

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void openFolderByName(String nameOfFolder) {
        String folderNameXpath = getFolderXpathByName(nameOfFolder);
        this.waitForElementAndClick(folderNameXpath, "Cannot find folder by name " + nameOfFolder, 20);
    }

    public void waitForArticleToDisappear(String articleTitle) {
        String articleXpath = getSavedArticleXpathByTitle(articleTitle);
        this.waitForElementNotPresent(articleXpath, "We see deleted article", 10);
    }

    public void waitForArticleToAppearByTitle(String articleTitle) {
        String articleXpath = getSavedArticleXpathByTitle(articleTitle);
        this.waitForElementPresent(articleXpath, "Cannot find article by title " + articleTitle, 10);
    }

    public void swipeByArticleToDelete(String articleTitle) {

        this.waitForArticleToAppearByTitle(articleTitle);
        String articleXpath = getSavedArticleXpathByTitle(articleTitle);

        if ((Platform.getInstance().isIOS()) || (Platform.getInstance().isAndroid())) {
            this.swipeElementToLeft(articleXpath, "Cannot swipe article " + articleTitle);
        } else {
            String removeLocator = getRemoveButtonByTitle(articleTitle);
            this.waitForElementAndClick(removeLocator, "Cannot click button to remove from saved", 10);
        }

            if (Platform.getInstance().isIOS()) {
                this.waitForElementAndClick(iosElementToDelete, "Cannot find saved article", 10);
            }

            if (Platform.getInstance().isMw()) {
                driver.navigate().refresh();
            }

            this.waitForArticleToDisappear(articleTitle);

    }
}