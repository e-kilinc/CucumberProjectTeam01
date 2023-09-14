package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.lessonManagement.LessonProgAssignPojo;
import pojos.lessonManagement.ResponseLPAssignPojoY;

import java.util.Collections;

import static baseUrl.ManagementOnSchoolBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class A_US_12_Step {
    LessonProgAssignPojo expectedData;
    Response response;
    ResponseLPAssignPojoY actualData;
    Object userId;
    @Then("Ogretmene ders atamak icin API hazirligi yapilirY")
    public void ogretmeneDersAtamakIcinAPIHazirligiYapilirY() {
        spec.pathParams("first","teachers","second","chooseLesson");
        expectedData=new LessonProgAssignPojo(Collections.singletonList("417"),"380");
    }

    @Then("Ogretmene post request ile ders atanirY")
    public void ogretmenePostRequestIleDersAtanirY() {
        response=given(spec).body(expectedData).when().post("{first}/{second}");
        actualData=response.as(ResponseLPAssignPojoY.class);
    }

    @Then("Ögretmene dersin atandigi dogrulanirY")
    public void ögretmeneDersinAtandigiDogrulanirY() {
        String message="Lesson added to Teacher";
        String httpStatus="CREATED";
//        userId=expectedData.getTeacherId();
//        assertEquals(userId,actualData.getObject().getUserId());
        assertEquals(message,actualData.getMessage());
        assertEquals(httpStatus,actualData.getHttpStatus());


    }
    /*
    {
    "object": {
        "userId": 367,
        "username": "rosann.becker",
        "name": "Yase",
        "surname": "Eri",
        "birthDay": "1990-01-01",
        "ssn": "278-11-8934",
        "birthPlace": "Can",
        "phoneNumber": "620 797 4729",
        "gender": "FEMALE",
        "email": "fran.ortiz@gmail.com",
        "advisorTeacher": false
    },
    "message": "Lesson added to Teacher",
    "httpStatus": "CREATED"
}
     */


}
