package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    By email = By.id("user_email");
    By pass = By.id("user_password");
    By submit = By.xpath("//input[@name='commit']");
    By forgotPassword = By.cssSelector(".link-below-button");


    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPass() {
        return driver.findElement(pass);
    }

    public WebElement submit(){
        return driver.findElement(submit);
    }

    public PasswordRecovery forgotPassword(){
        driver.findElement(forgotPassword).click();
        PasswordRecovery passwordRecovery = new PasswordRecovery(driver);
        return passwordRecovery;
    }

}
