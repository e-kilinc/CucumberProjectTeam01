package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.lessonManagement.LessonProgramPostKunstPojoY;
import pojos.lessonManagement.ResponseDelPojoY;
import pojos.lessonManagement.ResponseLGetPojoY;
import pojos.lessonManagement.ResponseLPostPojoY;
import utilities.ObjectMapperUtils;

import static baseUrl.ManagementOnSchoolBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class API_US_10_StepDefs {
    LessonProgramPostKunstPojoY expectedData;
    Response response;
    ResponseLPostPojoY actualData;
    ResponseLGetPojoY actualData2;
    ResponseDelPojoY actualData3;
    Object lessonIdList;
    int lessonProgramId;
    @Given("Ders programina ders eklemek icin API hazirligi yapilir")
    public void dersPrograminaDersEklemekIcinAPIHazirligiYapilir() {
        //Set the Url  ///lessonPrograms/save
        spec.pathParams("first", "lessonPrograms", "second","save");
    }

    @When("Post edilecek ders bilgileri hazirlanir")
    public void postEdilecekDersBilgileriHazirlanir() {
        //Set the expected Data
        String body=" {\n" +
                "  \"day\": \"THURSDAY\",\n" +
                "  \"educationTermId\": \"1\",\n" +
                "  \"lessonIdList\": [\n" +
                "    \"1722\"\n" +
                "  ]\n" +
                ",\n" +
                "  \"startTime\": \"08:03\",\n" +
                "  \"stopTime\": \"09:03\"\n" +
                "}";
        expectedData= ObjectMapperUtils.convertJsonToJava(body, LessonProgramPostKunstPojoY.class);
        lessonIdList=expectedData.getLessonIdList().get(0);
    }

    @And("Ders eklemek icin Post request gönderilir")
    public void dersEklemekIcinPostRequestGönderilir() {
        //Send the request get response
        response= given(spec).body(expectedData).when().post("{first}/{second}");
        actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),ResponseLPostPojoY.class);
    }

    @Then("Ders programi bilgileri dogrulanir")
    public void dersProgramiBilgileriDogrulanir() {
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getDay(),actualData2.getDay());
        assertTrue(actualData2.getStartTime().contains(expectedData.getStartTime()));
        assertTrue(actualData2.getStopTime().contains(expectedData.getStopTime()));
        assertEquals("Cucumber1000",actualData2.getLessonName().get(0).getLessonName());
    }
}
