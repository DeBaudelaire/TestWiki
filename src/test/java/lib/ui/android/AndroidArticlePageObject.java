package lib.ui.android;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
        title = "id:view_page_title_text";
        footerElement = "xpath://*[@text='View page in browser']";
        optionsButton = "xpath://android.widget.ImageView[@content-desc='More options']";
        optionsAddTiMyListButton = "xpath://*[@resource-id='org.wikipedia:id/title'][@text='Add to reading list']";
        addToMyListOverlay ="id:org.wikipedia:id/onboarding_button";
        myListNameInput = "id:org.wikipedia:id/text_input";
        myListOkButton = "xpath://*[@text='OK']";
        closeArticleButton = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
