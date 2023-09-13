package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.Authentication.generateToken;

public class ManagementOnSchoolBaseUrl {

        public static RequestSpecification spec;
        public static void setup() {
            spec = new RequestSpecBuilder()
                    .setBaseUri("https://managementonschools.com/app")
                    .addHeader("Authorization", generateToken())
                    .setContentType(ContentType.JSON)
                    .build();
        }

}
