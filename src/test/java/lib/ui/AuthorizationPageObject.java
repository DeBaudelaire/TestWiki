package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {
    private final static String
        loginButton = "xpath://body/div/div/a[text()='Log in']",
        loginInput = "css:input[name='wpName']",
        passwordInput = "css:input[name='wpPassword']",
        submitButton = "css:#wpLoginAttempt";

    public AuthorizationPageObject (RemoteWebDriver driver) {
        super(driver);
    }

    public void clickAuthButton() throws InterruptedException {
        Thread.sleep(1000);
        this.waitForElementPresent(loginButton,"Cannot find auth button", 20);
        this.waitForElementAndClick(loginButton, "Cannot find and click auth button", 10);
    }

    public void enterLoginData(String login, String password) {
        this.waitForElementAndSendKeys(loginInput,  login, "Cannot find and put a login to the login input", 10);
        this.waitForElementAndSendKeys(passwordInput,  password, "Cannot find and put a password to the password input", 10);
    }

    public void submitForm() {
        this.waitForElementAndClick(submitButton, "Cannot find and click submit auth button", 10);
    }
}
