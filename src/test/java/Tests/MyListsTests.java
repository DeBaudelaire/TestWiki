package Tests;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase  {

    private static final String
            nameOfFolder = "Learning programming";


    //Ex5: Тест: сохранение двух статей
    //Написать тест, который:
    //1. Сохраняет две статьи в одну папку
    //2. Удаляет одну из статей
    //3. Убеждается, что вторая осталась
    //4. Переходит в неё и убеждается, что title совпадает
    @Test
    public void testToSaveTwoArticlesToMyList() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String articleTitle = ArticlePageObject.getArticleTitle();

        //добавление в новый список закладок
        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToNewList(nameOfFolder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        if (Platform.getInstance().isIOS()) {
            ArticlePageObject.closeIOSPopUp();
        }

        ArticlePageObject.closeArticle();

        //вторая статья
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Java version history");

        //добавление в существующий список
        if (Platform.getInstance().isIOS()) {
            ArticlePageObject.waitForSecondTitleElement();
        } else if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.waitForTitleElement();
        }

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(nameOfFolder);
        } else {
        ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject.closeArticle();

        //закладки
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        //удаление
        if (Platform.getInstance().isAndroid()){
            MyListsPageObject.openFolderByName(nameOfFolder);
        }

        MyListsPageObject.swipeByArticleToDelete(articleTitle);

        SearchPageObject.waitForElementByTitleAndDescription("Java version history", "List of versions of the Java programming language");

    }
}
