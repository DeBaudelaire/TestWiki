package lib.ui.android;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        searchInitElement = "xpath://*[contains(@text,'Search Wikipedia')]";
                searchInput = "xpath://*[contains(@text,'Search…')]";
                searchCancelButton = "id:search_close_btn";
                searchResultBySubstringTPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(text(), '{SUBSTRING}')]";
                searchResultElement = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_container']";
                searchEmptyResultElement = "xpath://*[@text='No results found']";
                searchResultByTitleSubstringTPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='{TITLESUBSTRING}']";
                searchResultByDescriptionSubstringTPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{DESCRIPTIONSUBSTRING}']";
        }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
