package Tests;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    @Test
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
    public void testArticleHasTitle() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        //проверка наличия заголовка
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        int amountOfTitles = ArticlePageObject.getAmountOfArticleTitles();
        assertTrue("We cannot find some titles", amountOfTitles > 0);
    }
}
