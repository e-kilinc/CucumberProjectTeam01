package stepdefinitions.dbStepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.TeacherManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static utilities.JDBCUtils.executeQuery;


public class D_US_13_Step {
    HomePage homePage=new HomePage();
    TeacherManagementPage teacherManagementPage = new TeacherManagementPage();
    Connection connection;
    Statement statement;
    ResultSet resultSet;


    @Given("kullanici {string} sayfasina giderEEY")
    public void kullaniciSayfasinaGiderEEY(String arg0) {
        Driver.getDriver().get(ConfigReader.getProperty("homePageUrl"));
    }

    @Then("Vice Dean olarak login olurEEY")
    public void viceDeanOlarakLoginOlurEEY() {
        homePage.login1Y.click();
        homePage.usernameY.sendKeys(ConfigReader.getProperty("viceDeanUserName"));
        homePage.passwordY.sendKeys(ConfigReader.getProperty("password"));
        homePage.login2Y.click();
    }

    @Then("Menu butonuna tiklarEEY")
    public void menuButonunaTiklarEEY() {
        ReusableMethods.clickElementByJS(teacherManagementPage.menuY);
    }

    @Then("Teacher Mananement basligina tiklarEEY")
    public void teacherMananementBasliginaTiklarEEY() {
        ReusableMethods.clickElementByJS(teacherManagementPage.teacherManageButtonY);
        ReusableMethods.bekle(2);

    }

    @Then("Add Teacher  basliginin altinda choose Lessons'da ders secerEEY")
    public void addTeacherBasligininAltindaChooseLessonsDaDersSecerEEY() {
        Actions actions = new Actions(Driver.getDriver());
        teacherManagementPage.chooseLessonsY.click();
        ReusableMethods.bekle(2);
        actions.sendKeys("Kunst", Keys.ENTER, Keys.TAB).perform();
    }

    @Then("Zorunlu alanlari doldurur; name {string}, surname {string},birth_place {string},email {string}, phone_number {string},gender {string}, birth_day {string},ssn {string},username {string},password{string}EEY")
    public void zorunluAlanlariDoldururNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernamePasswordEEY(String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String password) {

        teacherManagementPage.nameInputY.sendKeys(name);
        teacherManagementPage.surNameInputY.sendKeys(surname);
        teacherManagementPage.birthPlaceInputY.sendKeys(birth_place);
        teacherManagementPage.emailInputY.sendKeys(email);
        teacherManagementPage.phoneNumberInputY.sendKeys(phone_number);
        if (gender.equalsIgnoreCase("Female")) {
            ReusableMethods.clickElementByJS(teacherManagementPage.maleRadioButtonY);
        } else {
            ReusableMethods.clickElementByJS(teacherManagementPage.femaleRadioButtonY);
        }
        teacherManagementPage.birthDayY.sendKeys(birth_day);
        teacherManagementPage.ssnInputY.sendKeys(ssn);
        teacherManagementPage.userNameInputY.sendKeys(username);
        teacherManagementPage.passwordInputY.sendKeys(password);
    }

    @But("Is Advisor alanini bos birakirEEY")
    public void isAdvisorAlaniniBosBirakirEEY() {
        if (teacherManagementPage.isAdvisorY.isSelected()) {
            teacherManagementPage.isAdvisorY.click();
        }
    }

    @When("Sayfadaki Submit butonuna tiklarEEY")
    public void sayfadakiSubmitButonunaTiklarEEY() {
        teacherManagementPage.tmSubmitY.click();
    }

    @Then("Teacher saved successfully yazisinin göründügünü dogrularEEY")
    public void teacherSavedSuccessfullyYazisininGöründügünüDogrularEEY() {
        ReusableMethods.waitForVisibility(teacherManagementPage.tmSuccesY, 5);
        ReusableMethods.tumSayfaResmi("teacherSaved");
        assertEquals("Teacher saved successfully", teacherManagementPage.tmSuccesY.getText());
    }

    @Given("DataBase baglantisi yapilirDBY")
    public void databaseBaglantisiYapilirDBY() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management", "select_user", "43w5ijfso");
    }

    @When("Teacher username{string} bilgisi ile cagirilirDBY")
    public void teacherUsernameBilgisiIleCagirilirDBY(String username) throws SQLException {
        statement=connection.createStatement();
        String query = "select * from teacher where username = '" + username + "'";
        resultSet=statement.executeQuery(query);
        resultSet.next();
    }

    @Then("Teacher bilgileri dogrulanirDBY: name {string}, surname {string},birth_place {string},email {string}, phone_number {string},gender {string}, birth_day {string},ssn {string},username {string}")
    public void teacherBilgileriDogrulanirDBYNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsername(String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username) throws SQLException {

        String actualName= resultSet.getString("name");
        String actualSurname= resultSet.getString("surname");
        String actualBirthPlace= resultSet.getString("birth_place");
        String actualEmail= resultSet.getString("email");
        String actualPhoneNumber= resultSet.getString("phone_number");
        String actualGender= resultSet.getString("gender");
        String actualBirthDay= resultSet.getString("birth_day");
        String actualSsn= resultSet.getString("ssn");
        String actualUsername= resultSet.getString("username");

        assertEquals(name,actualName);
        assertEquals(surname,actualSurname);
        assertEquals(birth_place,actualBirthPlace);
        assertEquals(email,actualEmail);
        assertEquals(phone_number,actualPhoneNumber);
        assertEquals("1",actualGender);
        assertEquals(birth_day,actualBirthDay);
        assertEquals(ssn,actualSsn);
        assertEquals(username,actualUsername);

    }



}
