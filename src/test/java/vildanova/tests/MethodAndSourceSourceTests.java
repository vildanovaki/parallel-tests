package vildanova.tests;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import vildanova.pages.CsvSourcePage;
import vildanova.pages.MethodSourcePage;

import java.util.stream.Stream;


public class MethodAndSourceSourceTests {

    MethodSourcePage methodSourcePage = new MethodSourcePage();
    CsvSourcePage csvSourcePage = new CsvSourcePage();

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

    @Execution(value = ExecutionMode.SAME_THREAD)
    @ParameterizedTest
    @MethodSource("argsProviderFactory")
    void negativeAuthForGitHubWithMethodSource(String login, int password) {
        {
            methodSourcePage.openPage();

            methodSourcePage.setLoginValue(login)
                    .setPasswordValue(password)
                    .signIn()
                    .checkIncorrectData();
        }
    }

    @CsvSource({
            "ivanovao, 123",
            "simanovaa, 123"
    })
    @Execution(value = ExecutionMode.SAME_THREAD)
    @ParameterizedTest
    void negativeAuthForGitHubWithCsvSource(String login, String password) {
        csvSourcePage.openPage();

        csvSourcePage.setLoginValue(login)
                .setPasswordValue(password)
                .signIn()
                .checkIncorrectData();
    }
}
