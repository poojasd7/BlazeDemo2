package automationFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.openqa.selenium.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.sfdcsteps.World;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Driver {

    private final Logger LOGGER = LogManager.getLogger(Driver.class);
    static public World world;

    public Driver(World world) throws IOException {
        this.world = world;
    }

    /*
     * Checks to see what OS we are using and uses the appropriate driver
     */

    @Before
    public void startWebDriverOld() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\data\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("chrome.switches", "--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("enable-automation");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-web-security");
        this.world.driver = new ChromeDriver(options);
    }

    public void startWebDriver() throws IOException {
        /*String os = System.getProperty("os.name").toLowerCase();
        String userName = System.getProperty("user.name").toLowerCase();
        String browser = System.getenv("browser");
        */
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("chrome.switches", "--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("enable-automation");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-web-security");
        ////options.addArguments("-incognito");
        String filepath = System.getProperty("user.dir") + File.separator + "Downloads" + File.separator;
        File file = new File(filepath);
        file.mkdir();
        Map<String, Object> preferences = new HashMap<>();
        preferences.put("profile.default_content_settings.popups", 0);
        preferences.put("download.default_directory", filepath);
        options.setExperimentalOption("prefs", preferences);
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.setExperimentalOption("useAutomationExtension", false);
        world.driver = new ChromeDriver(options);
        world.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        LOGGER.info("Start Thread ID:" + Thread.currentThread().getId());
        LOGGER.info("Driver Instance:" + world.driver);
    }
}

