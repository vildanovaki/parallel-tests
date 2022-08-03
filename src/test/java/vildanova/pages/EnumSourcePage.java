package vildanova.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import vildanova.tests.MenuItem;

import static com.codeborne.selenide.Selenide.*;

public class EnumSourcePage {

    private ElementsCollection menu = $$(".LowerMenu-module__item");

    private SelenideElement
            newBook = $(".book_ratings"),
            bestsellers = $(".book_ratings"),
            listenBook = $(".new-container");

    public void openPage() {
        open("https://www.litres.ru/");
    }

    public void searchMenu(MenuItem menuItem) {
        menu.find(Condition.text(menuItem.getDesc())).click();
    }

    public void newBookCheck() {
        newBook.shouldHave(Condition.text("Новинки книг"));
    }

    public void bestsellersBook() {
        bestsellers.shouldHave(Condition.text("Книжные бестселлеры"));
    }

    public void whatListen() {
        listenBook.shouldHave(Condition.text("Что послушать?"));
    }
}
