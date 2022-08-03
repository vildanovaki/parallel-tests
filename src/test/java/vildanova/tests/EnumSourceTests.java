package vildanova.tests;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import vildanova.pages.EnumSourcePage;

public class EnumSourceTests {

    EnumSourcePage enumSourcePage = new EnumSourcePage();

    @EnumSource(MenuItem.class)
    @Execution(value = ExecutionMode.SAME_THREAD)
    @ParameterizedTest(name = "Check recommendation in menu")
    void checkResultForMenuItems(MenuItem menuItem) {
        enumSourcePage.openPage();
        enumSourcePage.searchMenu(menuItem);
        if (menuItem.getDesc().equals("Новинки")) {
            enumSourcePage.newBookCheck();
        }
        if (menuItem.getDesc().equals("Популярное")) {
            enumSourcePage.bestsellersBook();
        }
        if (menuItem.getDesc().equals("Аудикниги")) {
            enumSourcePage.whatListen();
        } else {
            System.out.println("По данному enum - " + menuItem.getDesc() + "нужно добавить проверку");
        }
    }
}
