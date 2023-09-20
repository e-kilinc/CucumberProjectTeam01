package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.lessonManagement.LessonError1Pojo;
import pojos.lessonManagement.LessonPostPojo;
import pojos.lessonManagement.LessonResponsePojo;

import static baseUrl.ManagementOnSchoolBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class API_US_08_StepDefs {

    LessonPostPojo expectedData;
    Response response;
    LessonResponsePojo actualData;
    LessonError1Pojo actualData1;

    @Given("Ders eklemek icin post request hazirligi yapilir")
    public void dersEklemekIcinPostRequestHazirligiYapilir() {
        //set the url
        spec.pathParams("first", "lessons", "second", "save");

    }

    @And("Gonderilecek ders bilgileri hazirlanir")
    public void gonderilecekDersBilgileriHazirlanir() {
        //set the expected data
        expectedData = new LessonPostPojo("true", "3", "Cucumber999");
    }

    @When("Ders eklemek icin post request gonderilir")
    public void dersEklemekIcinPostRequestGonderilir() {
        //send the request and get the response
        response = given(spec).body(expectedData).when().post("{first}/{second}");
        actualData = response.as(LessonResponsePojo.class);
    }

    @Then("Ders bilgileri dogrulanir")
    public void dersBilgileriDogrulanir() {
        //Do assertion
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getLessonName(),actualData.getObject().getLessonName());
        assertEquals(3,actualData.getObject().getCreditScore());
        //assertTrue(expectedData.getCompulsory(),actualData.getObject().isCompulsory());
        assertEquals("Lesson Created", actualData.getMessage());
        assertEquals("OK",actualData.getHttpStatus());



        /*
{
    "object": {
        "lessonId": 1312,
        "lessonName": "Cucumber999",
        "creditScore": 3,
        "compulsory": true
    },
    "message": "Lesson Created",
    "httpStatus": "OK"
}
         */

    }

    @And("Gonderilecek ders bilgileri compulsory secilmeden hazirlanir")
    public void gonderilecekDersBilgileriCompulsorySecilmedenHazirlanir() {
        //set the expected data
        expectedData = new LessonPostPojo("", "3", "Cucumber999");
    }

    @And("Gonderilecek ders ismi secilmeden hazirlanir")
    public void gonderilecekDersIsmiSecilmedenHazirlanir() {
        //set the expected data
        expectedData = new LessonPostPojo("true", "3", "");
    }

    @Then("Ders olusturulamadigi bilgisi dogrulanir")
    public void dersOlusturulamadigiBilgisiDogrulanir() {
        //Do assertion
        assertEquals(400, response.statusCode());

    }


    @When("Ders eklemek icin dersismi olmadan post request gonderilir")
    public void dersEklemekIcinDersismiOlmadanPostRequestGonderilir() {
        response = given(spec).body(expectedData).when().post("{first}/{second}");
        actualData1 = response.as(LessonError1Pojo.class);
    }

    @And("Gonderilecek credit score secilmeden hazirlanir")
    public void gonderilecekCreditScoreSecilmedenHazirlanir() {
        //set the expected data
        expectedData = new LessonPostPojo("true", "", "Cucumber999");
    }

    @When("Ders eklemek icin credit score olmadan post request gonderilir")
    public void dersEklemekIcinCreditScoreOlmadanPostRequestGonderilir() {
        response = given(spec).body(expectedData).when().post("{first}/{second}");
        actualData1 = response.as(LessonError1Pojo.class);
    }
}
