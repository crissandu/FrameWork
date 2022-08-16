package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public class Base {

    // Base class is used to invoke web driver
    public WebDriver driver;
    public Properties prop = new Properties();
    //    String browserName = System.getProperty("browser");
    String browserName = "chrome";

    public WebDriver initializeDriver() {
        //parse the browser (chrome, firefox, IE) from data.properties

        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
            prop.load(fis);
//            String browserName = prop.getProperty("browser");
            if (browserName.contains("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\CRISTIAN SANDU\\Desktop\\Java IntelliJ\\Selenium_Package\\drivers\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                if (browserName.contains("headless")) {
                    options.addArguments("headless");
                }
                driver = new ChromeDriver(options);
            } else if (Objects.equals(browserName, "firefox")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\CRISTIAN SANDU\\Desktop\\Java IntelliJ\\Selenium_Package\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (Objects.equals(browserName, "edge")) {
                System.setProperty("webdriver.edge.driver", "C:\\Users\\CRISTIAN SANDU\\Desktop\\Java IntelliJ\\Selenium_Package\\drivers\\msedgedriver.exe");
                driver = new EdgeDriver();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }


    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }


}
