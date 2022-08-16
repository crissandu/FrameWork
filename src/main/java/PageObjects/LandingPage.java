package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By login = By.xpath("//span[.='Login']");
    private final By title = By.xpath("//h2[normalize-space()='Featured Courses']");
    private final By navbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
    private final By header = By.cssSelector("div[class*='video-banner'] h3");



    public LoginPage login(){
        driver.findElement(login).click();
        PageObjects.LoginPage loginPage = new PageObjects.LoginPage(driver);
        return loginPage;

    }

    public WebElement titles(){
        return driver.findElement(title);
    }

    public WebElement navBar(){
        return driver.findElement(navbar);
    }

    public WebElement header(){
        return driver.findElement(header);
    }




}
