package stepDefinitions;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.Base;

import java.time.Duration;

public class stepDefinition extends Base {
    LandingPage landingPage;

    @Given("^Initialize the browser with chrome driver$")
    public void initialize_the_browser_with_chrome_driver() throws Throwable {

        driver = initializeDriver();

    }

    @Given("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_site(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get(arg1);
    }

    @Given("^Click on Login link in home page to land on sign in page$")
    public void click_on_Login_link_in_home_page_to_land_on_sign_in_page() throws Throwable {
        landingPage = new LandingPage(driver);
        landingPage.login();

    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
    public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys(arg1);
        loginPage.getPass().sendKeys(arg2);
        loginPage.submit();

    }

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
        System.out.println("Successful validation kek.");

    }


    @When("^User enters (.+) and (.+) and logs in$")
    public void userEntersUsernameAndPasswordAndLogsIn(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys(username);
        loginPage.getPass().sendKeys(password);
        loginPage.submit();

    }

    @And("^Close browsers$")
    public void closeBrowsers() {
        driver.quit();
    }

}
