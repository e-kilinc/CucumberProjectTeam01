package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.lessonManagement.LessonDeletePojo;
import pojos.lessonManagement.LessonGetPojo;

import java.util.List;

import static baseUrl.ManagementOnSchoolBaseUrl.spec;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class API_US_09_StepDefs {
    Response response;
    LessonGetPojo actualData;
    LessonDeletePojo actualData2;
    JsonPath jsonPath;
    List<Integer> lessonIdList;
    static int lessonId;

    @Given("Ders ismi ile get request yapilir")
    public void dersIsmiIleGetRequestYapilir() {
        spec.pathParams("first","lessons","second","getLessonByName")
                .queryParams("lessonName","Cucumber999");
        response = given(spec).get("{first}/{second}");
    }

    @Then("Gelen Ders bilgileri dogrulanir: lessonId={string},lessonName={string},creditScore={string},compulsory={string},message={string}")
    public void gelenDersBilgileriDogrulanirLessonIdLessonNameCreditScoreCompulsoryMessage(String lessonId, String lessonName, String creditScore, String compulsory, String message) {
        actualData = response.as(LessonGetPojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(lessonId,actualData.getObject().getLessonId()+"");
        assertEquals(lessonName,actualData.getObject().getLessonName());
        assertEquals(creditScore,actualData.getObject().getCreditScore()+"");
        //assertTrue(compulsory,actualData.getObject().isCompulsory());
        assertEquals(message,actualData.getMessage());


    }

    @Given("Dersi silmek icin lessonName bilgisi hazirlanir")
    public void dersiSilmekIcinLessonNameBilgisiHazirlanir() {
        spec.pathParams("first","lessons","second","getAll");
        response = given(spec).get("{first}/{second}");
        jsonPath=response.jsonPath();
        lessonIdList = jsonPath.getList("findAll{it.lessonName=='Cucumber1000'}.lessonId");
        lessonId=lessonIdList.get(0);


    }

    @When("Ders silmek icin delete request gonderilir")
    public void dersSilmekIcinDeleteRequestGonderilir() {
        spec.pathParams("first", "lessons", "second","delete","third",lessonId);
        response = given(spec).when().delete("{first}/{second}/{third}");
        actualData2 = response.as(LessonDeletePojo.class);
    }

    @Then("Dersin silindigi dogrulanir")
    public void dersinSilindigiDogrulanir() {
        String message = "Lesson Deleted";
        String httpStatus = "OK";
        assertEquals(message, actualData2.getMessage());
        assertEquals(httpStatus, actualData2.getHttpStatus());
    }


}
