import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import resources.Base;

public class ExtentReporterDemo extends Base {

    @BeforeSuite
    public void start(){
        driver = initializeDriver();
    }

    @Test
    public void initialDemo(){
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());

    }

    @AfterSuite
    public void close(){
        driver.close();
    }


}
