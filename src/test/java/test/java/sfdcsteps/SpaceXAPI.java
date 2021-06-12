package test.java.sfdcsteps;

import com.jayway.restassured.http.Method;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class SpaceXAPI {

    RequestSpecification httpRequest = RestAssured.given();
    Response response;

    @And("user hits the get spaceX to check status code")
    public void userhitsGetSpaceX() throws Throwable {
        String url = "https://api.spacexdata.com/v4/launches/latest";
        RestAssured.given().when().get(url).then().statusCode(200);
        int code= RestAssured.given().when().get(url).getStatusCode();
        Assert.assertTrue("Status is not matching as its:"+code, code==200 );
    }

    @And("user hits the get spaceX to check payload")
    public void userhitsGetSpaceXToCheckPayload() throws Throwable {
        String url = "https://api.spacexdata.com/v4/launches/latest";
        RestAssured.given().when().get(url).jsonPath().get("payloads").equals("[5fe3b57db3467846b324217a]");
//        Assert.assertTrue("payload is not matching as its:"+RestAssured.given().when().get(url).jsonPath().get("payloads"), RestAssured.given().when().get(url).jsonPath().get("payloads").toString().equals("[5fe3b57db3467846b324217a]") );
    }

    @And("user hits the get spaceX to get cores and ships")
    public void userhitsGetSpaceXToGetCoresAndShips() throws Throwable {
        String url = "https://api.spacexdata.com/v4/launches/latest";
        System.out.println(RestAssured.given().when().get(url).jsonPath().get("cores").toString());
        System.out.println(RestAssured.given().when().get(url).jsonPath().get("ships").toString());
    }

}
