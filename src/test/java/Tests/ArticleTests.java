package Tests;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for articles")
public class ArticleTests extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("Swipe article to the footer")
    @Description("We open 'Java Object-oriented programming language' article and make sure the title is expected")
    @Step("Starting test testSwipeArticle")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSwipeArticle() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();
    }

    //Ex6: Тест: assert title
    //Написать тест, который открывает статью и убеждается, что у нее есть элемент title. Важно: тест не должен дожидаться появления title, проверка должна производиться сразу. Если title не найден - тест падает с ошибкой. Метод можно назвать assertElementPresent.
    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("Compare article title with expected one")
    @Description("We open an article and swipe it to the footer")
    @Step("Starting test testArticleHasTitle")
    @Severity(value = SeverityLevel.MINOR)
    public void testArticleHasTitle() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        //проверка наличия заголовка
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        int amountOfTitles = ArticlePageObject.getAmountOfArticleTitles();
        ArticlePageObject.takeScreenshot("article_page");
        Assert.assertTrue("We cannot find some titles", amountOfTitles > 0);
    }
}
