package pageobjets;

import automationFramework.BuildConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utils.Log;

import java.io.IOException;

public class BlazeDemoHome extends BuildConstructor {

    private final Logger LOGGER = LogManager.getLogger(BlazeDemoHome.class.getName());
    private WebDriver driver;
    Log logObj = new Log();

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement btnFindFlights;

    @FindBy(xpath = "//select[@name='fromPort']")
    public WebElement departureDrp;

    @FindBy(xpath = "//select[@name='toPort']")
    public WebElement destinationDrp;

    @FindBy(xpath = "//input[@name='inputName']")
    public WebElement inputName;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement address;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement state;

    @FindBy(xpath = "//input[@name='zipCode']")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@name='creditCardNumber']")
    public WebElement creditCardNumber;

    @FindBy(xpath = "//input[@name='nameOnCard']")
    public WebElement nameOnCard;

    @FindBy(xpath = "//input[@value='Purchase Flight']")
    public WebElement purchaseFlightBtn;

    public BlazeDemoHome(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String navigateToURL(String url) throws InterruptedException {
        LOGGER.info("Navigating to URL");
        logObj.startTestCase();
        String title = navigateToURL(url);
        LOGGER.info("The Blaze Demo Title is: " + title);
        return title;
    }

    public void bookTheFlight(String departure, String destination, String flightNumber) throws InterruptedException {
        LOGGER.info("Booking a Flight");
        Assert.assertTrue("Destination and Departure cities are same", !departure.equalsIgnoreCase(destination));
        Select departureElement = new Select(departureDrp);
        departureElement.selectByVisibleText(departure);
        Select destinationElement = new Select(destinationDrp);
        destinationElement.selectByVisibleText(destination);
        clickWebElement(btnFindFlights);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td/input)[" + flightNumber + "]")));

    }

    public void fillTheDetails() throws InterruptedException {
        LOGGER.info("Booking a Flight");
        fillTextByCharacter(inputName, "Pooja");
        fillTextByCharacter(address, "ravet,chinchwad");
        fillTextByCharacter(city, "pune");
        fillTextByCharacter(state, "maharashtra");
        fillTextByCharacter(zipCode, "412101");
        fillTextByCharacter(creditCardNumber, "123456789");
        fillTextByCharacter(nameOnCard, "Pooja D");
        clickWebElement(purchaseFlightBtn);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Thank you for your purchase today!']/..//tr/td[text()='Id']/following-sibling::td")));
    }


}
