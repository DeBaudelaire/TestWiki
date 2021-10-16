package Tests;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for articles")
public class SearchTests extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Search article")
    @Description("We search article by title")
    @Step("Starting test testSearch")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testSearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    //Ex3: Тест: отмена поиска
    //Написать тест, который:
    //1.Ищет какое-то слово
    //2.Убеждается, что найдено несколько статей
    //3.Отменяет поиск
    //4.Убеждается, что результат поиска пропал

    @Test
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Search article and clear search line")
    @Description("We search article by title, clear searching result and make sure the cancel button is disappear")
    @Step("Starting test testCancelSearch")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testCancelSearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Search article")
    @Description("We search article by title and make sure the search result is not empty")
    @Step("Starting test testAmountOfNotEmptySearch")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testAmountOfNotEmptySearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String searchLine = "Linkin Park discography";
        SearchPageObject.typeSearchLine(searchLine);
        int amountOfSearchResults = SearchPageObject.getAmountOfFoundArticles();
        Assert.assertTrue("We found too few results!", amountOfSearchResults > 0);
    }

    @Test
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Search invalid request")
    @Description("We search invalid request and make sure the search result is empty")
    @Step("Starting test testAmountOfEmptySearch")
    @Severity(value = SeverityLevel.NORMAL)
    public void testAmountOfEmptySearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String searchLine = "kskjtgrjjjhgdsf";
        SearchPageObject.typeSearchLine(searchLine);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }

    @Test
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Search articles by title and description")
    @Description("We search articles and make sure three titles and descriptions are expected")
    @Step("Starting test testByTitleAndDescription")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testByTitleAndDescription() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("the lion king");
        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isIOS())) {
            SearchPageObject.waitForElementByTitleAndDescription("The Lion King", "1994 American animated film");
            SearchPageObject.waitForElementByTitleAndDescription("The Lion King (2019 film)", "Photo-realistic computer-animated film");
            SearchPageObject.waitForElementByTitleAndDescription("The Lion King: The Gift", "2019 soundtrack album by Beyoncé");
        } else {
            SearchPageObject.waitForElementByTitleAndDescription("The Lion King", "1994 film");
            SearchPageObject.waitForElementByTitleAndDescription("The Lion King (2019 film)", "2019 film by Jon Favreau");
            SearchPageObject.waitForElementByTitleAndDescription("The Lion King: The Gift", "2019 soundtrack album by Beyoncé and various artists");
        }
    }
}
