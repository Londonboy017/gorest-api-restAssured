package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class POSTCreateUser extends TestBase {

    @Test
    public void crateUserInfo() {

        List<String> userdata = new ArrayList<>();
        UserPojo userPojo =new UserPojo();
        userPojo.setName("Jason");
        userPojo.setGender("Male");
        userPojo.setStatus("Active");
        userPojo.setEmail("jason"+getRandomValue()+"@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer c426452f777927f6e49219f45652a5fd08178e3f873af217a5b982a6fdd15dac")
                .body(userPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
