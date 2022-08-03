package vildanova.tests;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import vildanova.pages.CsvSourcePage;


public class CsvSourceTests {

    CsvSourcePage csvSourcePage = new CsvSourcePage();

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
