package stepdefinitions.apiStepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.lessonManagement.*;
import utilities.ObjectMapperUtils;

import java.util.Collections;
import java.util.List;

import static baseUrl.ManagementOnSchoolBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class A_US_11_Step {
    LessonProgramPostKunstPojoY expectedData;
    Response response;
    ResponseLPostPojoY actualData;
    ResponseLGetPojoY actualData2;
    ResponseDelPojoY actualData3;
    Object lessonIdList;
    int lessonProgramId;

    @Given("Ders programina ders eklemek icin API hazirligi yapilirY")
    public void dersPrograminaDersEklemekIcinAPIHazirligiYapilirY() {
        //Set the Url  ///lessonPrograms/save
        spec.pathParams("first", "lessonPrograms", "second","save");
    }

    @When("Post edilecek ders bilgileri hazirlanirY")
    public void postEdilecekDersBilgileriHazirlanirY() {
        //Set the expected Data
        String body=" {\n" +
                "  \"day\": \"MONDAY\",\n" +
                "  \"educationTermId\": \"1\",\n" +
                "  \"lessonIdList\": [\n" +
                "    \"417\"\n" +
                "  ]\n" +
                ",\n" +
                "  \"startTime\": \"08:00\",\n" +
                "  \"stopTime\": \"09:00\"\n" +
                "}";
       expectedData= ObjectMapperUtils.convertJsonToJava(body, LessonProgramPostKunstPojoY.class);
       lessonIdList=expectedData.getLessonIdList().get(0);
    }

    @Then("Ders eklemek icin Post request gönderilirY")
    public void dersEklemekIcinPostRequestGönderilirY() {
        //Send the request get response
       response= given(spec).body(expectedData).when().post("{first}/{second}");
       actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),ResponseLPostPojoY.class);
    }

    @When("Olusturulan ders programinin ID numarasi alinirY")
    public void olusturulanDersProgramininIDNumarasiAlinirY() {
        spec.pathParams("first", "lessonPrograms", "second","getAll");
        response=given(spec).when().get("{first}/{second}");
        JsonPath jsonPath=response.jsonPath();
        List<Integer> lessonProgramIdList=jsonPath.getList("findAll{it.lessonName[0].lessonId=="+lessonIdList+"}.lessonProgramId");
        lessonProgramId=lessonProgramIdList.get(0);
    }

    @When("Get request ile olusturulmus ders programi bilgisine ulasilirY")
    public void getRequestIleOlusturulmusDersProgramiBilgisineUlasilirY() {
        //Send the Request get response
        spec.pathParams("first", "lessonPrograms", "second","getById", "third",""+lessonProgramId+"");
        response=given(spec).when().get("{first}/{second}/{third}");
        actualData2=ObjectMapperUtils.convertJsonToJava(response.asString(),ResponseLGetPojoY.class);
    }

    @Then("Ders Programinin bilgileri dogrulanirY")
    public void dersProgramininBilgileriDogrulanirY() {
        //Do assertion
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getDay(),actualData2.getDay());
        assertTrue(actualData2.getStartTime().contains(expectedData.getStartTime()));
        assertTrue(actualData2.getStopTime().contains(expectedData.getStopTime()));
        assertEquals("Kunst",actualData2.getLessonName().get(0).getLessonName());
    }

    @When("Delete request ile ders programi silinirY")
    public void deleteRequestIleDersProgramiSilinirY() {
        //Send the request get response
        spec.pathParams("first", "lessonPrograms", "second","delete", "third",""+lessonProgramId+"");
        response=given(spec).when().delete("{first}/{second}/{third}");
        actualData3=ObjectMapperUtils.convertJsonToJava(response.asString(),ResponseDelPojoY.class);
    }

    @Then("ders programinin silindigi dogrulanirY")
    public void dersProgramininSilindigiDogrulanirY() {
        //Do Assertion
        String message="Lesson Program Deleted";
        String httpStatus="OK";
        assertEquals(message,actualData3.getMessage());
        assertEquals(httpStatus,actualData3.getHttpStatus());
    }
}
