package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

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

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
