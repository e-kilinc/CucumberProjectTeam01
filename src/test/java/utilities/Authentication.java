package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class Authentication {

    public static String generateToken(){
        String body = "  {\n" +
                "  \"password\": \"AdminTeam01\",\n" +
                "  \"username\": \"adminteam01\"\n" +
                "}";

     Response response = given().body(body).contentType(ContentType.JSON).when().post("https://managementonschools.com/app/auth/login");
     return response.jsonPath().getString("token");

    }
}
