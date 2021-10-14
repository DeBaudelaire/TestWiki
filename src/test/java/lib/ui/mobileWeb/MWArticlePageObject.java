package lib.ui.mobileWeb;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        title = "css:#content h1";
        footerElement = "css:footer";
        optionsAddTiMyListButton = "css:#page-actions li #ca-watch.mw-ui-icon-wikimedia-star-base20";
        optionsRemoveFromMyListButton = "css:#page-actions li #ca-watch.mw-ui-icon-wikimedia-unStar-progressive";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
