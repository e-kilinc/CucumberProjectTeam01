package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.TeacherManagementPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.JDBCUtils.executeQuery;

public class US_13_StepDefs {
    TeacherManagementPage teacherManagementPage = new TeacherManagementPage();
    private static String fakeUsername;
    private static String fakeSsn;
    private static String fakePhoneNumber;
    private static String fakeEmail;
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Then("Menu butonuna tiklar")
    public void menuButonunaTiklar() {
        ReusableMethods.clickElementByJS(teacherManagementPage.menuY);
    }

    @Then("Teacher Mananement basligina tiklar")
    public void teacherMananementBasliginaTiklar() {
        ReusableMethods.clickElementByJS(teacherManagementPage.teacherManageButtonY);
        ReusableMethods.bekle(2);
    }

    @Then("Add Teacher  basliginin altinda choose Lessons'da ders secer")
    public void addTeacherBasligininAltindaChooseLessonsDaDersSecer() {
        Actions actions = new Actions(Driver.getDriver());
        teacherManagementPage.chooseLessonsY.click();
        ReusableMethods.bekle(2);
        actions.sendKeys("Kunst", Keys.ENTER, Keys.TAB).perform();
    }

    @Then("Zorunlu alanlari doldurur; name {string}, surname {string},birth_place {string},email {string}, phone_number {string},gender {string}, birth_day {string},ssn {string},username {string},password{string}")
    public void zorunluAlanlariDoldururNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernamePassword(String name, String surname, String birth_place, String fakeEmail, String fakePhoneNumber, String gender, String birth_day, String fakeSsn, String fakeUsername, String password) {
        Faker faker = new Faker();
        teacherManagementPage.nameInputY.sendKeys(name);
        teacherManagementPage.surNameInputY.sendKeys(surname);
        teacherManagementPage.birthPlaceInputY.sendKeys(birth_place);
        fakeEmail = faker.internet().emailAddress();
        teacherManagementPage.emailInputY.sendKeys(fakeEmail);
        fakePhoneNumber = faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(1000, 9999);
        teacherManagementPage.phoneNumberInputY.sendKeys(fakePhoneNumber);

        if (gender.equalsIgnoreCase("male")) {
            ReusableMethods.clickElementByJS(teacherManagementPage.maleRadioButtonY);
        } else {
            ReusableMethods.clickElementByJS(teacherManagementPage.femaleRadioButtonY);
        }
        teacherManagementPage.birthDayY.sendKeys(birth_day);
        fakeSsn = faker.idNumber().ssnValid();
        teacherManagementPage.ssnInputY.sendKeys(fakeSsn);
        fakeUsername = faker.name().username();
        teacherManagementPage.userNameInputY.sendKeys(fakeUsername);
        teacherManagementPage.passwordInputY.sendKeys(password);
    }

    @But("Is Advisor alanini bos birakir")
    public void isAdvisorAlaniniBosBirakir() {
        if (teacherManagementPage.isAdvisorY.isSelected()) {
            teacherManagementPage.isAdvisorY.click();
        }
    }

    @When("Sayfadaki Submit butonuna tiklar")
    public void sayfadakiSubmitButonunaTiklar() {
        teacherManagementPage.tmSubmitY.click();
    }

    @And("Teacher saved successfully yazisinin göründügünü dogrular")
    public void teacherSavedSuccessfullyYazisininGöründügünüDogrular() {
        ReusableMethods.waitForVisibility(teacherManagementPage.tmSuccesY, 5);
        ReusableMethods.tumSayfaResmi("teacherSaved");
        assertEquals("Teacher saved successfully", teacherManagementPage.tmSuccesY.getText());
    }

    @And("Sayfadaki Submit alanina gelir, butonuna tiklar")
    public void sayfadakiSubmitAlaninaGelirButonunaTiklar() {
        ReusableMethods.scroll(teacherManagementPage.tmSubmitY);
        ReusableMethods.clickElementByJS(teacherManagementPage.tmSubmitY);
    }

    @And("Zorunlu alanlar;name,surname,birth_place,email,phone_number,gender,birth_day,ssn,username,password altinda uyari yazilarinin göründügünü dogrular.")
    public void zorunluAlanlarNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernamePasswordAltindaUyariYazilarininGöründügünüDogrular() {

        ReusableMethods.scroll(teacherManagementPage.nameRequiredY);
        assertEquals("Required",teacherManagementPage.nameRequiredY.getText());
        ReusableMethods.scroll(teacherManagementPage.surnameRequiredY);
        assertEquals("Required",teacherManagementPage.surnameRequiredY.getText());
        ReusableMethods.scroll(teacherManagementPage.birthPlaceRequiredY);
        assertEquals("Required",teacherManagementPage.birthPlaceRequiredY.getText());
        ReusableMethods.scroll(teacherManagementPage.emailRequiredY);
        assertEquals("Required",teacherManagementPage.emailRequiredY.getText());
        ReusableMethods.scroll(teacherManagementPage.phoneRequiredY);
        assertEquals("Required",teacherManagementPage.phoneRequiredY.getText());
        ReusableMethods.scroll(teacherManagementPage.dateBirthRequiredY);
        assertEquals("Required",teacherManagementPage.dateBirthRequiredY.getText());
        ReusableMethods.scroll(teacherManagementPage.ssnRequiredY);
        assertEquals("Required",teacherManagementPage.ssnRequiredY.getText());
        ReusableMethods.scroll(teacherManagementPage.usernameRequiredY);
        assertEquals("Required",teacherManagementPage.usernameRequiredY.getText());
        ReusableMethods.scroll(teacherManagementPage.passRequiredY);
        assertEquals("Enter your password",teacherManagementPage.passRequiredY.getText());
    }

    @And("Is Advisor alanini onaylar")
    public void isAdvisorAlaniniOnaylar() {
        ReusableMethods.scroll(teacherManagementPage.isAdvisorY);
        teacherManagementPage.isAdvisorY.click();
    }

    @And("Zorunlu alanlari gender haric doldurur; name {string}, surname {string},birth_place {string},email {string}, phone_number {string}, birth_day {string},ssn {string},username {string},password{string}")
    public void zorunluAlanlariGenderHaricDoldururNameSurnameBirth_placeEmailPhone_numberBirth_daySsnUsernamePassword(String name, String surname, String birth_place, String fakeEmail, String fakePhoneNumber, String birth_day, String fakeSsn, String fakeUsername, String password) {
        Faker faker = new Faker();
        teacherManagementPage.nameInputY.sendKeys(name);
        teacherManagementPage.surNameInputY.sendKeys(surname);
        teacherManagementPage.birthPlaceInputY.sendKeys(birth_place);
        fakeEmail = faker.internet().emailAddress();
        teacherManagementPage.emailInputY.sendKeys(fakeEmail);
        fakePhoneNumber = faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(1000, 9999);
        teacherManagementPage.phoneNumberInputY.sendKeys(fakePhoneNumber);
        teacherManagementPage.birthDayY.sendKeys(birth_day);
        fakeSsn = faker.idNumber().ssnValid();
        teacherManagementPage.ssnInputY.sendKeys(fakeSsn);
        fakeUsername = faker.name().username();
        teacherManagementPage.userNameInputY.sendKeys(fakeUsername);
        teacherManagementPage.passwordInputY.sendKeys(password);
    }

    @And("Gender icin uyari mesajinin göründügünü dogrular")
    public void genderIcinUyariMesajininGöründügünüDogrular() {
        ReusableMethods.waitForVisibility(teacherManagementPage.errorGenderY,5);
        assertTrue(teacherManagementPage.errorGenderY.getText().contains("You have entered an invalid value. Valid values are: MALE, FEMALE"));
    }

    @And("Choose Lesson icin uyari mesajinin göründügünü dogrular")
    public void chooseLessonIcinUyariMesajininGöründügünüDogrular() {
        ReusableMethods.waitForVisibility(teacherManagementPage.errorChooseLessonY,5);
        assertTrue(teacherManagementPage.errorChooseLessonY.isDisplayed());
    }

    @Then("Zorunlu alanlari ssn haric doldurur; name {string}, surname {string},birth_place {string},email {string}, phone_number {string},gender {string}, birth_day {string},username {string},password{string}")
    public void zorunluAlanlariSsnHaricDoldururNameSurnameBirth_placeEmailPhone_numberGenderBirth_dayUsernamePassword(String name, String surname, String birth_place, String fakeEmail, String fakePhoneNumber, String gender, String birth_day, String fakeUsername, String password) {
        Faker faker = new Faker();
        teacherManagementPage.nameInputY.sendKeys(name);
        teacherManagementPage.surNameInputY.sendKeys(surname);
        teacherManagementPage.birthPlaceInputY.sendKeys(birth_place);
        fakeEmail = faker.internet().emailAddress();
        teacherManagementPage.emailInputY.sendKeys(fakeEmail);
        fakePhoneNumber = faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(1000, 9999);
        teacherManagementPage.phoneNumberInputY.sendKeys(fakePhoneNumber);

        if (gender.equalsIgnoreCase("male")) {
            ReusableMethods.clickElementByJS(teacherManagementPage.maleRadioButtonY);
        } else {
            ReusableMethods.clickElementByJS(teacherManagementPage.femaleRadioButtonY);
        }
        teacherManagementPage.birthDayY.sendKeys(birth_day);
        fakeUsername = faker.name().username();
        teacherManagementPage.userNameInputY.sendKeys(fakeUsername);
        teacherManagementPage.passwordInputY.sendKeys(password);
    }

    @And("SSN alanina gecersizSsn girer")
    public void ssnAlaninaGecersizSsnGirer(DataTable data1) {
        teacherManagementPage.ssnInputY.sendKeys(data1.row(1).get(0));
    }

    @And("SSN hakkinda hata mesajinin göründügünü dogrular")
    public void ssnHakkindaHataMesajininGöründügünüDogrular() {
        ReusableMethods.waitForVisibility(teacherManagementPage.errorSSNgecersizFormY,5);
        assertTrue(teacherManagementPage.errorSSNgecersizFormY.isDisplayed());
    }

    @And("SSN alanini siler")
    public void ssnAlaniniSiler() {
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.clickElementByJS(teacherManagementPage.ssnInputY);
        ReusableMethods.bekle(2);
        actions.moveToElement(teacherManagementPage.ssnInputY).sendKeys(Keys.CONTROL, "a").build().perform();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.CONTROL,"x").build().perform();
        ReusableMethods.bekle(2);
    }

    @And("SSN alanina OnkarakterSSN girer")
    public void ssnAlaninaOnkarakterSSNGirer(DataTable data2) {
        teacherManagementPage.ssnInputY.sendKeys(data2.row(1).get(0));
    }

    @And("Min. {string} yazisinin göründügünü dogrular")
    public void minYazisininGöründügünüDogrular(String str) {
        ReusableMethods.bekle(3);
        str="Minimum 11 character (XXX-XX-XXXX)";
        ReusableMethods.scroll(teacherManagementPage.minOnBirKarakterYazisiY);
        assertTrue(teacherManagementPage.minOnBirKarakterYazisiY.isDisplayed());
    }

    @And("SSN alanina OnBirkarakterHarfSayiSSn girer")
    public void ssnAlaninaOnBirkarakterHarfSayiSSnGirer(DataTable data3) {
        teacherManagementPage.ssnInputY.sendKeys(data3.row(1).get(0));
    }

    @Then("Zorunlu alanlari password haric doldurur; name {string}, surname {string},birth_place {string},email {string}, phone_number {string},gender {string}, birth_day {string},ssn {string},username {string}")
    public void zorunluAlanlariPasswordHaricDoldururNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsername(String name, String surname, String birth_place, String fakeEmail, String fakePhoneNumber, String gender, String birth_day, String fakeSsn, String fakeUsername) {
        Faker faker = new Faker();
        teacherManagementPage.nameInputY.sendKeys(name);
        teacherManagementPage.surNameInputY.sendKeys(surname);
        teacherManagementPage.birthPlaceInputY.sendKeys(birth_place);
        fakeEmail = faker.internet().emailAddress();
        teacherManagementPage.emailInputY.sendKeys(fakeEmail);
        fakePhoneNumber = faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(1000, 9999);
        teacherManagementPage.phoneNumberInputY.sendKeys(fakePhoneNumber);

        if (gender.equalsIgnoreCase("male")) {
            ReusableMethods.clickElementByJS(teacherManagementPage.maleRadioButtonY);
        } else {
            ReusableMethods.clickElementByJS(teacherManagementPage.femaleRadioButtonY);
        }
        teacherManagementPage.birthDayY.sendKeys(birth_day);
        fakeSsn = faker.idNumber().ssnValid();
        teacherManagementPage.ssnInputY.sendKeys(fakeSsn);
        fakeUsername = faker.name().username();
        teacherManagementPage.userNameInputY.sendKeys(fakeUsername);
    }

    @And("Password alanina sekiz karakterden az veri girer")
    public void passwordAlaninaSekizKarakterdenAzVeriGirer(DataTable data4) {
        teacherManagementPage.passwordInputY.sendKeys(data4.row(1).get(0));
        ReusableMethods.bekle(2);
    }

    @And("Password hakkinda hata mesajinin göründügünü dogrular")
    public void passwordHakkindaHataMesajininGöründügünüDogrular() {
        assertTrue(teacherManagementPage.atLeast8YazisiY.isDisplayed());
        ReusableMethods.webElementResmi(teacherManagementPage.atLeast8YazisiY);
    }

    @And("Password alanina sekiz adet rakam girer")
    public void passwordAlaninaSekizAdetRakamGirer(DataTable data5) {
        teacherManagementPage.passwordInputY.sendKeys(data5.row(1).get(0));
        ReusableMethods.bekle(2);
    }

    @And("One lowercase uyarisinin göründügünü dogrular")
    public void oneLowercaseUyarisininGöründügünüDogrular() {
        assertTrue(teacherManagementPage.oneLowerCaseYazisiY.isDisplayed());
        ReusableMethods.webElementResmi(teacherManagementPage.oneLowerCaseYazisiY);
    }

    @And("Password alanina sekiz karakterden ve bir kücük harf girer")
    public void passwordAlaninaSekizKarakterdenVeBirKücükHarfGirer(DataTable data6) {
        teacherManagementPage.passwordInputY.sendKeys(data6.row(1).get(0));
        ReusableMethods.bekle(2);
    }

    @And("One uppercase uyarisinin göründügünü dogrular")
    public void oneUppercaseUyarisininGöründügünüDogrular() {
        assertTrue(teacherManagementPage.oneUpperCaseYazisiY.isDisplayed());
        ReusableMethods.webElementResmi(teacherManagementPage.oneUpperCaseYazisiY);
    }

    @And("Password alanina sekiz adet büyük ve kücük harf girer")
    public void passwordAlaninaSekizAdetBüyükVeKücükHarfGirer(DataTable data7) {
        teacherManagementPage.passwordInputY.sendKeys(data7.row(1).get(0));
        ReusableMethods.bekle(2);
    }

    @And("One number uyarisinin göründügünü dogrular")
    public void oneNumberUyarisininGöründügünüDogrular() {
        assertTrue(teacherManagementPage.oneNumberYazisiY.isDisplayed());
        ReusableMethods.webElementResmi(teacherManagementPage.oneNumberYazisiY);
    }


}
