package vildanova.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CsvSourcePage {

    private SelenideElement passwordField = $("#password");

    private static SelenideElement
            loginField = $("#login_field"),
            signInButton = $("[value='Sign in']"),
            container = $("#js-flash-container");

    public void openPage() {
        open("https://github.com/login");
    }

    public CsvSourcePage setLoginValue(String login) {
        loginField.setValue(login);
        return this;
    }

    public CsvSourcePage setPasswordValue(String password) {
        passwordField.setValue(password);
        return this;
    }

    public CsvSourcePage signIn() {
        signInButton.click();
        return this;
    }

    public void checkIncorrectData() {
        container.shouldHave(Condition.text("Incorrect username or password."));
    }
}
