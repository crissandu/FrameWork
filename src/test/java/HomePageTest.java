import PageObjects.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Base;

public class HomePageTest extends Base {
    public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
    WebDriver driver;
    LandingPage landingPage;


    @BeforeTest
    public void start(){
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @Test
    public void basePageNavigation(){
        driver.get(prop.getProperty("url"));
        landingPage = new LandingPage(driver);
        log.info("Driver navigated to home page");
        Assert.assertEquals(landingPage.titles().getText(), "FEATURED COURSES");
        log.info("Successfully validated Title");


    }

    @Test
    public void validateHeader(){
        landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.header().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
        driver.findElement(By.id("assa")).click();


    }




    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[2][2];
        data[0][0] ="bc@sc.com";
        data[0][1] ="Password1234";

        data[1][0] = "daf@fad.com";
        data[1][1] = "Password5678";

        return data;
    }
}
