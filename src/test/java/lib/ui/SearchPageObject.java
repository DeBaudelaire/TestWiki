package lib.ui;
import io.qameta.allure.Step;
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

    @Step("Initializing the search field")
    public void initSearchInput() {
        this.waitForElementPresent(searchInitElement, "Cannot find search input", 5);
        this.waitForElementAndClick(searchInitElement, "Cannot find and click search init element", 5);
    }

    @Step("Typing '{search_line}' to the search line")
    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(searchInput, search_line, "Cannot find and type search input", 5);
    }

    @Step("Waiting for search result")
    public void waitForSearchResult(String substring) {
        String searchResultXpath = getResultSearchElement(substring);
        this.waitForElementPresent(searchResultXpath,"Cannot find search result with substring " + substring, 10);
    }

    @Step("Waiting for button to cancel search result")
    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(searchCancelButton, "Cannot find search cancel button", 5);
    }

    @Step("Waiting for search cancel button to disappear")
    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(searchCancelButton, "Search cancel button is still present", 5);
    }

    @Step("Clicking button to cancel search result")
    public void clickCancelSearch() {
        this.waitForElementAndClick(searchCancelButton, "Cannot find and click search cancel button", 5);
    }

    @Step("Waiting for search result and select an article by substring in article title")
    public void clickByArticleWithSubstring(String substring) {
        String searchResultXpath = getResultSearchElement(substring);
        this.waitForElementAndClick(searchResultXpath,"Cannot find and click search result with substring " + substring, 10);
    }

    @Step("Getting amount of found articles")
    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(searchResultElement, "Cannot find anything by the request", 15);
        return this.getAmountOfElements(searchResultElement);
    }

    @Step("Waiting for empty result label")
    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(searchEmptyResultElement, "Cannot find empty result element", 15);
    }

    @Step("Making sure there are no results for the search")
    public void assertThereIsNoResultOfSearch() {
         this.assertElementNotPresent(searchResultElement, "We supposed not to find any results", 15);
    }

    @Step("Waiting for title and description of article")
    public void waitForElementByTitleAndDescription(String title, String description) {
        String searchResultTitleXpath = getResultSearchTitle(title), searchResultDescriptionXpath = getResultSearchDescription(description);

        this.waitForElementPresent(searchResultTitleXpath,"Cannot find search result with title substring: " + title, 10);
        this.waitForElementPresent(searchResultDescriptionXpath,"Cannot find search result with description substring: " + description, 10);
    }

    @Step("Waiting for title of article")
    public void waitForElementByTitle(String title) {
        String searchResultTitleXpath = getResultSearchTitle(title);

        this.waitForElementPresent(searchResultTitleXpath,"Cannot find search result with title substring: " + title, 10);
    }
}
