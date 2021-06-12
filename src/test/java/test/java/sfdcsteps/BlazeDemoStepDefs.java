package test.java.sfdcsteps;

import automationFramework.Driver;
import automationFramework.PageActions;
import com.jayway.restassured.http.Method;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjets.BlazeDemoHome;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BlazeDemoStepDefs extends PageActions {
    private final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(BlazeDemoStepDefs.class.getName());
    private World world;
    Driver driverObj;
    BlazeDemoHome blazeDemoHome;

    public BlazeDemoStepDefs(World world) throws IOException {
        super(world.driver);
        this.world = world;
        blazeDemoHome = new BlazeDemoHome(world.driver);
    }

    @Given("^user navigates to the BlazeDemo URL$")
    public void blazeDemoIsLoaded() throws Throwable {
        String url = "http://www.blazedemo.com";
        Assert.assertTrue("BlazeDemo page has not opened up!", blazeDemoHome.navigateToURL(url).contains("Travel The World"));
    }


    @And("user books the flight")
    public void userBooksTheFlight() throws Throwable {
        blazeDemoHome.bookTheFlight("Paris", "Rome", "1");
    }

    @And("user fills the details")
    public void userFillsTheDetails() throws Throwable {
        blazeDemoHome.fillTheDetails();
    }


    @And("user validates confirmation Id")
    public void userVerifiesConfirmationId() throws Throwable {
        world.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement confirmationElement = world.driver.findElement(By.xpath("//h1[text()='Thank you for your purchase today!']/..//tr/td[text()='Id']/following-sibling::td"));
        Assert.assertTrue("Confirmation Id is not printed!" , confirmationElement.isDisplayed());
        String confirmationIdText = confirmationElement.getText();
        LOGGER.info("Confirmation ID:"+confirmationIdText);
    }

}
