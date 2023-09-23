package stepdefinitions.apiStepDefinitions;

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


public class A_US_11_12_Step {
    LessonProgramPostKunstPojoY expectedData;
    Response response;
    ResponseLPostPojoY actualData;
    ResponseLGetPojoY actualData2;
    ResponseDelPojoY actualData3;
    Object lessonIdList;
    int lessonProgramId;
    LessonProgAssignPojo expectedData2;
    ResponseLPAssignPojoY actualData4;

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


    //int userId;
    @Then("Ogretmene ders atamak icin API hazirligi yapilirY")
    public void ogretmeneDersAtamakIcinAPIHazirligiYapilirY() {
        spec.pathParams("first","teachers","second","chooseLesson");
        expectedData2=new LessonProgAssignPojo(Collections.singletonList(""+lessonProgramId+""),"423");
    }

    @Then("Ogretmene post request ile ders atanirY")
    public void ogretmenePostRequestIleDersAtanirY() {
        response=given(spec).body(expectedData2).when().post("{first}/{second}");
        actualData4=response.as(ResponseLPAssignPojoY.class);
    }

    @Then("Ögretmene dersin atandigi dogrulanirY")
    public void ögretmeneDersinAtandigiDogrulanirY() {
        String message="Lesson added to Teacher";
        String httpStatus="CREATED";
        // userId= Integer.parseInt(expectedData.getTeacherId());
        // assertEquals(userId,actualData.getObject().getUserId());
        assertEquals(message,actualData4.getMessage());
        assertEquals(httpStatus,actualData4.getHttpStatus());

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
