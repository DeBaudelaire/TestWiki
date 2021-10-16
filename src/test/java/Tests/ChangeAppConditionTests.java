package Tests;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for articles")
public class ChangeAppConditionTests extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("Check search article in background")
    @Description("We search article and make sure the title is expected in background")
    @Step("Starting test testCheckSearchArticleInBackground")
    @Severity(value = SeverityLevel.MINOR)
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
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("Check article title after change screen orientation")
    @Description("We search article, change screen orientation and make sure the title is expected")
    @Step("Starting test testChangeScreenOrientationOnSearchResults")
    @Severity(value = SeverityLevel.NORMAL)
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
        Assert.assertEquals("Article title have been changed after rotation", titleBeforeRotation, titleAfterRotation);
    }
}
