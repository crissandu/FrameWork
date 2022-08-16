import PageObjects.LandingPage;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import resources.Base;

public class ValidateNavigationBar extends Base {
    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeSuite
    public void start(){
        driver = initializeDriver();
        log.info("Driver is initialized");
    }


    @Test
    public void navBarTest(){
        // Asserting navigation bar is displayed
        driver.get("https://qaclickacademy.com");
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.navBar().isDisplayed());
        log.info("Navigation bar validated.");

    }



    @AfterTest
    public void quit(){
        driver.quit();
    }


}
