package vildanova.tests;

import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import vildanova.pages.CsvSourcePage;
import vildanova.pages.EnumSourcePage;
import vildanova.pages.MethodSourcePage;

import java.util.stream.Stream;

public class Tests {

    CsvSourcePage csvSourcePage = new CsvSourcePage();
    EnumSourcePage enumSourcePage = new EnumSourcePage();
    MethodSourcePage methodSourcePage = new MethodSourcePage();


    @ResourceLock("CheckStep")
    @CsvSource({
            "ivanovao, 123",
            "simanovaa, 123"
    })
    @ParameterizedTest
    void negativeAuthForGitHubWithCsvSource(String login, String password) {
        csvSourcePage.openPage();

        csvSourcePage.setLoginValue(login)
                .setPasswordValue(password)
                .signIn()
                .checkIncorrectData();
    }

    @EnumSource(MenuItem.class)
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

    static Stream<Arguments> argsProviderFactory() {
        return Stream.of(
                Arguments.of(
                        "ivanovao", 123
                ),
                Arguments.of(
                        "simanovaa", 123
                )
        );
    }
    @ParameterizedTest
    @MethodSource("argsProviderFactory")
    void negativeAuthForGitHubWithMethodSource(String login, int password) {
        {
            csvSourcePage.openPage();

            csvSourcePage.setLoginValue(login);
            methodSourcePage
                    .setPasswordValue(password);
            csvSourcePage.signIn()
                    .checkIncorrectData();
        }
    }
}
