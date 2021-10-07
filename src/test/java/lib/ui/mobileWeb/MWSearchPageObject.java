package lib.ui.mobileWeb;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {

    static {
        searchInitElement = "css:button#searchIcon";
        searchInput = "css:form>input[type='search']";
        searchCancelButton = "css:div>button.cancel";
        searchResultBySubstringTPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        searchResultElement = "css:ul.page-list>li.page-summary";
        searchEmptyResultElement = "css:p.without-results";
        searchResultByTitleSubstringTPL = "xpath://li[contains(@title,'{TITLESUBSTRING}')]";
        searchResultByDescriptionSubstringTPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(), '{DESCRIPTIONSUBSTRING}')]";
    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
