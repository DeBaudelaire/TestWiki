package lib.ui;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject {

    protected static String
            searchInitElement,
            searchInput,
            searchCancelButton,
            searchResultBySubstringTPL,
            searchResultElement,
            searchEmptyResultElement,
            searchResultByTitleSubstringTPL,
            searchResultByDescriptionSubstringTPL;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

/*     ||                    ||
       || TEMPLATES METHODS  ||
       \/                    \/
 */
    private static String getResultSearchElement(String substring) {
        return searchResultBySubstringTPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchTitle(String title) {
        return searchResultByTitleSubstringTPL.replace("{TITLESUBSTRING}", title);
    }

    private static String getResultSearchDescription(String description) {
        return searchResultByDescriptionSubstringTPL.replace("{DESCRIPTIONSUBSTRING}", description);
    }

/*     /\                    /\
       || TEMPLATES METHODS  ||
       ||                    ||
 */

    public void initSearchInput() {
        this.waitForElementPresent(searchInitElement, "Cannot find search input", 5);
        this.waitForElementAndClick(searchInitElement, "Cannot find and click search init element", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(searchInput, search_line, "Cannot find and type search input", 5);
    }

    public void waitForSearchResult(String substring) {
        String searchResultXpath = getResultSearchElement(substring);
        this.waitForElementPresent(searchResultXpath,"Cannot find search result with substring " + substring, 10);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(searchCancelButton, "Cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(searchCancelButton, "Search cancel button is still present", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(searchCancelButton, "Cannot find and click search cancel button", 5);
    }

    public void clickByArticleWithSubstring(String substring) {
        String searchResultXpath = getResultSearchElement(substring);
        this.waitForElementAndClick(searchResultXpath,"Cannot find and click search result with substring " + substring, 10);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(searchResultElement, "Cannot find anything by the request", 15);
        return this.getAmountOfElements(searchResultElement);
    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(searchEmptyResultElement, "Cannot find empty result element", 15);
    }

    public void assertThereIsNoResultOfSearch() {
         this.assertElementNotPresent(searchResultElement, "We supposed not to find any results", 15);
    }

    public void waitForElementByTitleAndDescription(String title, String description) {
        String searchResultTitleXpath = getResultSearchTitle(title), searchResultDescriptionXpath = getResultSearchDescription(description);

        this.waitForElementPresent(searchResultTitleXpath,"Cannot find search result with title substring: " + title, 10);
        this.waitForElementPresent(searchResultDescriptionXpath,"Cannot find search result with description substring: " + description, 10);
    }

    public void waitForElementByTitle(String title) {
        String searchResultTitleXpath = getResultSearchTitle(title);

        this.waitForElementPresent(searchResultTitleXpath,"Cannot find search result with title substring: " + title, 10);
    }
}
