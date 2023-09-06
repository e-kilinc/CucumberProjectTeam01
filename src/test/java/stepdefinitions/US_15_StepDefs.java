package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.ViceDeanManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class US_15_StepDefs {
    HomePage homePage = new HomePage();
    ViceDeanManagementPage viceDeanManagmentPage = new ViceDeanManagementPage();
    @Then("kullanici vice dean olarak login olur")
    public void kullanici_vice_dean_olarak_login_olur() {
        homePage.getLogin(ConfigReader.getProperty("viceDeanUserName"), ConfigReader.getProperty("password"));
    }
    @Then("kullanici menuye click yapar")
    public void kullaniciMenuyeClickYapar() {
        ReusableMethods.click(viceDeanManagmentPage.menu);
    }
    @Then("vdkullanici {int} saniye bekler")
    public void vdkullaniciSaniyeBekler(int saniye) {
        ReusableMethods.bekle(saniye);
    }
    @Then("kullanici main menuden {string}sayfasini acar")
    public void kullaniciMainMenudenSayfasiniAcar(String studenmanagement) {
        viceDeanManagmentPage.mainMenuStudentManagement.click();
    }
    @And("kullanici chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, name, surname, birth_place, email, phone_number, gender, birth_day, ssn, username, fathername, mothername, password);
    }
    @And("basarili kayit yapildigini dogrular")
    public void basariliKayitYapildiginiDogrular() {
        ReusableMethods.visibleWait(viceDeanManagmentPage.alertMessage, 3);
        assertTrue(viceDeanManagmentPage.alertMessage.getText().contains("saved Successfully"));
    }
    @And("no {string} ile kayit yapilmadigini dogrular")
    public void kayitYapilmadiginiDogrular(String str) {
        if (str == null) {
            assertTrue(viceDeanManagmentPage.requiredName.isDisplayed());
        }
    }
    @And("no choosechooseteacher ile kayit yapilmadigini dogrular")
    public void noChoosechooseteacherIleKayitYapilmadiginiDogrular(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(null, name, surname, birth_place, email, phone_number, gender, birth_day, ssn, username, fathername, mothername, password);
    }
    @And("kullanici eksik name chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikNameChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, null, surname, birth_place, email, phone_number, gender, birth_day, ssn, username, fathername, mothername, password);
    }
    @And("kullanici eksik surname chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikSurnameChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, name, null, birth_place, email, phone_number, gender, birth_day, ssn, username, fathername, mothername, password);
    }
    @And("kullanici eksik birth_place chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikBirth_placeChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, name, surname, null, email, phone_number, gender, birth_day, ssn, username, fathername, mothername, password);
    }
    @And("kullanici eksik email ile chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikEmailIleChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, name, surname, birth_place, null, phone_number, gender, birth_day, ssn, username, fathername, mothername, password);
    }
    @And("kullanici eksik phoneNumber ile chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikPhoneNumberIleChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, name, surname, birth_place, email, null, gender, birth_day, ssn, username, fathername, mothername, password);
    }
    @And("kullanici eksik gender ile chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikGenderIleChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, name, surname, birth_place, email, phone_number, null, birth_day, ssn, username, fathername, mothername, password);
        ReusableMethods.visibleWait(viceDeanManagmentPage.alertMessage, 3);
    }
    @And("no gender ile kayit yapilmadigini dogrular")
    public void noGenderIleKayitYapilmadiginiDogrular() {
        assertTrue(viceDeanManagmentPage.alertMessage.getText().contains("Valid values are: MALE, FEMALE"));
    }
    @And("kullanici eksik birth_day ile chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikBirth_dayIleChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, name, surname, birth_place, email, phone_number, gender, null, ssn, username, fathername, mothername, password);
    }
    @And("kullanici eksik ssn ile chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikSsnIleChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, name, surname, birth_place, email, phone_number, gender, birth_day, null, username, fathername, mothername, password);
    }
    @And("kullanici eksik username ile chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikUsernameIleChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, name, surname, birth_place, email, phone_number, gender, birth_day, ssn, null, fathername, mothername, password);
    }
    @And("kullanici eksik fathername ile chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikFathernameIleChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, name, surname, birth_place, email, phone_number, gender, birth_day, ssn, username, null, mothername, password);
    }
    @And("kullanici eksik mothername ile chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikMothernameIleChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, name, surname, birth_place, email, phone_number, gender, birth_day, ssn, username, fathername, null, password);
    }
    @And("kullanici eksik password ile chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikPasswordIleChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(chooseteacher, name, surname, birth_place, email, phone_number, gender, birth_day, ssn, username, fathername, mothername, null);
    }
    @And("kullanici eksik chooseteacher ile chooseTeacher {string}, name {string},surname {string}, birth_place {string} , email {string} , phone_number {string},gender{string}, birth_day {string},ssn {string},username {string},fatherName{string} , motherName {string}, password {string} bilgilerini girer")
    public void kullaniciEksikChooseteacherIleChooseTeacherNameSurnameBirth_placeEmailPhone_numberGenderBirth_daySsnUsernameFatherNameMotherNamePasswordBilgileriniGirer(String chooseteacher, String name, String surname, String birth_place, String email, String phone_number, String gender, String birth_day, String ssn, String username, String fathername, String mothername, String password) {
        viceDeanManagmentPage.addStudent(null, name, surname, birth_place, email, phone_number, gender, birth_day, ssn, username, fathername, mothername, password);
    }
    @And("no chooseteacher ile kayit yapilmadigini dogrular")
    public void noChooseteacherIleKayitYapilmadiginiDogrular() {
        ReusableMethods.visibleWait(viceDeanManagmentPage.alertMessage, 3);
        assertTrue(viceDeanManagmentPage.alertMessage.getText().contains("select advisor teacher"));
    }
    @And("kullanici ssn bilgisine - yazmaz")
    public void kullaniciSsnBilgisineYazmaz() {
        ReusableMethods.bekle(3);
        ReusableMethods.click(viceDeanManagmentPage.addStudentSsn);
        viceDeanManagmentPage.addStudentSsn.sendKeys("222556666");
        viceDeanManagmentPage.addStudentSubmit.click();
    }
    @And("kullanici ssn bilgisine {string} girer")
    public void kullaniciSsnBilgisineGirer(String str) {
        ReusableMethods.bekle(2);
        ReusableMethods.click(viceDeanManagmentPage.addStudentSsn);
        viceDeanManagmentPage.addStudentSsn.sendKeys(Keys.CONTROL + "a" + Keys.CONTROL, Keys.DELETE);
        ReusableMethods.bekle(2);
        viceDeanManagmentPage.addStudentSsn.sendKeys(str);
        viceDeanManagmentPage.addStudentSubmit.click();
    }
    @Then("ssn {string} ile kayit yapilmadigini {string} ile dogrular")
    public void ssnIleKayitYapilmadiginiIleDogrular(String str, String msj) {
        ReusableMethods.visibleWait(viceDeanManagmentPage.alertMessage, 3);
        assertTrue(viceDeanManagmentPage.alertMessage.getText().contains(msj));
    }
    @And("kullanici sayfa yeniler")
    public void kullaniciSayfaYeniler() {
        ReusableMethods.bekle(3);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.bekle(3);
    }
    @And("kullanici passworde {string}girer")
    public void kullaniciPasswordeGirer(String str) {
        ReusableMethods.bekle(2);
        viceDeanManagmentPage.addStudentPassword.click();
        viceDeanManagmentPage.addStudentPassword.sendKeys(Keys.CONTROL + "a" + Keys.CONTROL, Keys.DELETE);
        ReusableMethods.bekle(2);
        viceDeanManagmentPage.addStudentPassword.sendKeys(str);
        ReusableMethods.bekle(2);
        viceDeanManagmentPage.addStudentSubmit.click();
    }
    @And("student numberin otomatik geldigini dogrular")
    public void studentNumberinOtomatikGeldiginiDogrular() {
        ReusableMethods.bekle(2);
        ReusableMethods.scroll(viceDeanManagmentPage.listStudentNumber);
        viceDeanManagmentPage.listStudentNumber.isDisplayed();
    }
    @Then("password {string} ile kayit yapildigini {string} ile dogrular")
    public void passwordIleKayitYapildiginiIleDogrular(String str, String msj ) {
        ReusableMethods.visibleWait(viceDeanManagmentPage.alertMessage, 3);
        assertTrue(viceDeanManagmentPage.alertMessage.getText().contains(msj));
    }

    @Given("kullanici ana sayfaya gider")
    public void kullaniciAnaSayfayaGider() {
        homePage.getMainPage();
    }
    //sa as
}