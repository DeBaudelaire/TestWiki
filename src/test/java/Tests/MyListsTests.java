package Tests;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for articles")
public class MyListsTests extends CoreTestCase  {

    private static final String
            nameOfFolder = "Learning programming",
            login = "lenorelenore",
            password = "!Nag-8MxSM.seQ9";


    //Ex5: Тест: сохранение двух статей
    //Написать тест, который:
    //1. Сохраняет две статьи в одну папку
    //2. Удаляет одну из статей
    //3. Убеждается, что вторая осталась
    //4. Переходит в неё и убеждается, что title совпадает
    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("Save two articles to my list")
    @Description("We search two articles, add to list, delete one and make sure the remaining title is expected")
    @Step("Starting test testToSaveTwoArticlesToMyList")
    @Severity(value = SeverityLevel.NORMAL)
    public void testToSaveTwoArticlesToMyList() throws InterruptedException {

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
        } else if (Platform.getInstance().isIOS()) {
            ArticlePageObject.addArticlesToMySaved();
        } else if (Platform.getInstance().isMw()) {

            ArticlePageObject.addArticlesToMySaved();

            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
                Auth.clickAuthButton();
                Auth.enterLoginData(login, password);
                Auth.submitForm();

                ArticlePageObject.waitForTitleElement();

            Assert.assertEquals("We are not on the same page after login", articleTitle, ArticlePageObject.getArticleTitle());
        }

        if (Platform.getInstance().isIOS()) {
            ArticlePageObject.closeIOSPopUp();
        }

        ArticlePageObject.closeArticle();

        //вторая статья
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        if ((Platform.getInstance().isIOS()) || (Platform.getInstance().isAndroid())) {
            SearchPageObject.clickByArticleWithSubstring("Java version history");
        } else {
            SearchPageObject.clickByArticleWithSubstring("List of versions of the Java programming language");
        }


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
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        //удаление
        if (Platform.getInstance().isAndroid()){
            MyListsPageObject.openFolderByName(nameOfFolder);
        }

        MyListsPageObject.swipeByArticleToDelete(articleTitle);

        if ((Platform.getInstance().isIOS()) || (Platform.getInstance().isAndroid())) {
            SearchPageObject.waitForElementByTitleAndDescription("Java version history", "List of versions of the Java programming language");
        } else {
            SearchPageObject.waitForElementByTitle("Java version history");
        }
    }
}
