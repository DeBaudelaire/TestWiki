package Tests;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {

    @Test
    public void testCheckSearchArticleInBackground() {

        if (Platform.getInstance().isMw()) {
            return;
        }
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        this.backgroundApp(2);
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    //Ex7*: Поворот экрана
    //Appium устроен так, что может сохранить у себя в памяти поворот экрана, который использовался в предыдущем тесте, и начать новый тест с тем же поворотом. Мы написали тест на поворот экрана, и он может сломаться до того, как положение экрана восстановится. Следовательно, если мы запустим несколько тестов одновременно, последующие тесты будут выполняться в неправильном положении экрана, что может привести к незапланированным проблемам.
    //Как нам сделать так, чтобы после теста на поворот экрана сам экран всегда оказывался в правильном положении, даже если тест упал в тот момент, когда экран был наклонен?

    @Test
    public void testChangeScreenOrientationOnSearchResults() {

        if (Platform.getInstance().isMw()) {
            return;
        }

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String titleBeforeRotation = ArticlePageObject.getArticleTitle();
        this.rotateScreenLandscape();
        String titleAfterRotation = ArticlePageObject.getArticleTitle();
        assertEquals("Article title have been changed after rotation", titleBeforeRotation, titleAfterRotation);
    }
}
