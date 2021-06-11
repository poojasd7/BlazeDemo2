package automationFramework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BuildConstructor extends PageActions {

    private final Logger LOGGER = LogManager.getLogger(PageActions.class.getName());
    public Integer EXPLICIT_WAIT_60_SEC = 60;
    private WebDriver driver;

    public BuildConstructor(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement constructdivspan(String differenceInSelector) throws InterruptedException {
        By by = By.xpath("//div/span[contains(text(), '" + differenceInSelector + "')]");
        return driver.findElement(by);
    }

}
