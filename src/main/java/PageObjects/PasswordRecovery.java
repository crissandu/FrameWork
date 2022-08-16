package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordRecovery {

    public WebDriver driver;

    public PasswordRecovery(WebDriver driver) {
        this.driver = driver;
    }

    By email = By.id("user_email");
    By submit = By.xpath("//input[@type='submit']");

    public WebElement email(){
        return driver.findElement(email);
    }

    public WebElement submit() {
        return driver.findElement(submit);
    }









}
