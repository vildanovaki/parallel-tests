package vildanova.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MethodSourcePage {

    private SelenideElement
            loginField = $("#login_field"),
            passwordField = $("#password"),
            signInButton = $("[value='Sign in']"),
            container = $("#js-flash-container");

    public void openPage() {
        open("https://github.com/login");
    }

    public MethodSourcePage setLoginValue(String login) {
        loginField.setValue(login);
        return this;
    }

    public MethodSourcePage setPasswordValue(int password) {
        passwordField.setValue(String.valueOf(password));
        return this;
    }

    public MethodSourcePage signIn() {
        signInButton.click();
        return this;
    }

    public void checkIncorrectData() {
        container.shouldHave(Condition.text("Incorrect username or password."));
    }
}
