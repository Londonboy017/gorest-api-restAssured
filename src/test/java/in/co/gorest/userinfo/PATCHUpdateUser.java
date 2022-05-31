package in.co.gorest.userinfo;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PATCHUpdateUser extends TestBase {

    @Test
    public void updateUserInfo() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Jasony");
        /*userPojo.setStatus("active");
        userPojo.setGender("male");*/
        userPojo.setEmail("jason" + getRandomValue() + "@gmail.com");

        Response response = given()
               .header("Content-type", "application/json")
                .header("Authorization", "Bearer 914c0f670f001278363480f4134d14f5dbf7d901652c1212fe3ce872e9e07d7b")
                .and()
                .body(userPojo)
                .when()
                .patch("/3967")
                .then()
                .extract().response();
      response.then().statusCode(200);
        response.prettyPrint();
    }
}
