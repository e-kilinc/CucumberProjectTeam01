package stepdefinitions.apiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.teacherManagement.*;

import java.util.Collections;
import java.util.List;

import static baseUrl.ManagementOnSchoolBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class A_US_13_Step {
    static TeacherPostPojoY expectedData;
    Response response;
    ResponseTeacherPostPojoY actualData;
    JsonPath jsonPath;
    List<Integer> userIdList;
    ResponseTeachDelPojoY actualData2;
    ResponseGetTeacherByIdPojoY actualData3;
    static int userId;

    @Given("Teacher olusturmak icin Post request hazirligi yapilirY")
    public void teacherOlusturmakIcinPostRequestHazirligiYapilirY() {
  //Set the URL
        spec.pathParams("first","teachers", "second","save");
    }

    @And("Gönderilecek Teacher bilgileri hazirlanirY")
    public void gönderilecekTeacherBilgileriHazirlanirY() {
        //Set the expectedData
        expectedData=new TeacherPostPojoY("1990-01-05","Can","elyjah.hersh@feerock.com","FEMALE",false, Collections.singletonList("417"), "Aline","05012123Ka","156-666-5896","123-52-7456","Linder","Alinder");
    }

    @When("Teacher olusturmak icin Post request gönderilirY")
    public void teacherOlusturmakIcinPostRequestGönderilirY() {
       // Send the request and get the response
       response= given(spec).body(expectedData).when().post("{first}/{second}");
       actualData=response.as(ResponseTeacherPostPojoY.class);
    }

    @Then("Teacher bilgileri dogrulanirY")
    public void teacherBilgileriDogrulanirY() {
       String message="Teacher saved successfully";
       String httpStatus="CREATED";
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getBirthDay(),actualData.getObject().getBirthDay());
        assertEquals(expectedData.getBirthPlace(),actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getEmail(),actualData.getObject().getEmail());
        assertEquals(expectedData.getGender(),actualData.getObject().getGender());
        assertEquals(expectedData.getIsAdvisorTeacher(),actualData.getObject().isAdvisorTeacher());
        assertEquals(expectedData.getName(),actualData.getObject().getName());
        assertEquals(expectedData.getPhoneNumber(),actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getSsn(),actualData.getObject().getSsn());
        assertEquals(expectedData.getSurname(),actualData.getObject().getSurname());
        assertEquals(expectedData.getUsername(),actualData.getObject().getUsername());
        assertEquals(message,actualData.getMessage());
        assertEquals(httpStatus,actualData.getHttpStatus());
    }

    @Given("Teacher userId bilgisi alinirY")
    public void teacherUserIdBilgisiAlinirY() {
        spec.pathParams("first","teachers","second", "getAll");
        response=given(spec).get("{first}/{second}");
        jsonPath=response.jsonPath();
        userIdList=jsonPath.getList("findAll{it.email=='elyjah.hersh@feerock.com'}.userId");
        System.out.println("userIdList = " + userIdList);
        userId=userIdList.get(0);
    }
    @When("Get request ile olusturulmus Teacher bilgisine ulasilirY")
    public void getRequestIleOlusturulmusTeacherBilgisineUlasilirY() {
        spec.pathParams("first", "teachers", "second","getSavedTeacherById","third",userId);
        response=given(spec).when().get("{first}/{second}/{third}");
        actualData3=response.as(ResponseGetTeacherByIdPojoY.class);
    }

    @Then("Teacher bilgileri dogrulanirGet_APIY: name {string}, surname {string},birth_place {string},email {string}, phone_number {string},gender {string}, birth_day {string},ssn {string},username {string}")
    public void teacherBilgileriDogrulanirGet_APIYNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsername(String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username) {
        String message="Teacher successfully found";
        String httpStatus="OK";
        assertEquals(birth_day,actualData3.getObject().getBirthDay());
        assertEquals(birth_place,actualData3.getObject().getBirthPlace());
        assertEquals(email,actualData3.getObject().getEmail());
        assertEquals(gender,actualData3.getObject().getGender());
        assertEquals(name,actualData3.getObject().getName());
        assertEquals(phone_number,actualData3.getObject().getPhoneNumber());
        assertEquals(ssn,actualData3.getObject().getSsn());
        assertEquals(surname,actualData3.getObject().getSurname());
        assertEquals(username,actualData3.getObject().getUsername());
        assertEquals(message,actualData3.getMessage());
        assertEquals(httpStatus,actualData3.getHttpStatus());
    }


    @And("Teacher silinirY")
    public void teacherSilinirY() {
        spec.pathParams("first", "teachers", "second","delete","third",userId);
        response=given(spec).when().delete("{first}/{second}/{third}");
        actualData2=response.as(ResponseTeachDelPojoY.class);
    }

    @Then("Teacher kaydinin silindigi dogrulanirY")
    public void teacherKaydininSilindigiDogrulanirY() {
        String message="Teacher Deleted";
        String httpStatus="OK";
        assertEquals(message,actualData2.getMessage());
        assertEquals(httpStatus,actualData2.getHttpStatus());
    }

}
