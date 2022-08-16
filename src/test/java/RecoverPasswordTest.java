import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.PasswordRecovery;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import resources.Base;

public class RecoverPasswordTest extends Base {



    @BeforeSuite
    public void start(){
        driver = initializeDriver();
    }


    @Test
    public void forgotPassword(){
        driver.get("https://www.qaclickacademy.com");
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = landingPage.login();
        PasswordRecovery passwordRecovery = loginPage.forgotPassword();
        passwordRecovery.email().sendKeys("Help ME!!!!!!");
        passwordRecovery.submit();
    }



    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }



}
