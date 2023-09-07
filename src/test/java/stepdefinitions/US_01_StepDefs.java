package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US_01_StepDefs {


    HomePage homePage = new HomePage();
    Faker faker = new Faker();
    public static String fakeUsername;
    private static String fakeSsn;
    private static String fakePhoneNumber;

    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Given("Kullanici anasayfaya gider")
    public void kullaniciAnasayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("homePageUrl"));
    }

    @Then("Kullanici register linkine tiklar")
    public void kullaniciRegisterLinkineTiklar() {
        homePage.registerLink_gnl.click();
    }

    @And("Kullanici Name {string}, surname {string} girer")
    public void kullaniciNameSurnameGirer(String name, String surname) {
        homePage.name_gnl.sendKeys(name);
        homePage.surname_gnl.sendKeys(surname);

    }

    @And("Kullanici birth place {string}, phone {string}, gender {string}, Date Of Birth {string}, ssn {string} girer")
    public void kullaniciBirthPlacePhoneGenderDateOfBirthSsnGirer(String birthPlace, String phone, String gender, String birthDay, String ssn) {
        homePage.birthPlace_gnl.sendKeys(birthPlace);
        fakePhoneNumber = faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(1000, 9999);
        homePage.phoneNumber_gnl.sendKeys(fakePhoneNumber);

        if (gender.equalsIgnoreCase("male")) {
            ReusableMethods.click(homePage.male_gnl);
        } else {
            ReusableMethods.click(homePage.female_gnl);
        }

        homePage.birthDay_gnl.sendKeys(birthDay);

        fakeSsn = faker.idNumber().ssnValid();
        homePage.ssn_gnl.sendKeys(fakeSsn);
    }


    @And("Kullanici username {string} ve password {string} girer")
    public void kullaniciUsernameVePasswordGirer(String userName, String password) {
        fakeUsername = faker.name().username();
        homePage.username_gnl.sendKeys(fakeUsername);
        System.out.println("Eklenen fake username: " + fakeUsername);
        homePage.password_gnl.sendKeys(password);
        ReusableMethods.bekle(1);

    }

    @And("Kullanici register butonuna tiklar")
    public void kullaniciRegisterButonunaTiklar() {
        homePage.registerButton_gnl.submit();
//        ReusableMethods.bekle(6);
    }

    @And("Kullanici cikan mesajin Guest User registered icerdigini dogrular")
    public void kullaniciCikanMesajinIcerdiginiDogrular() {

        ReusableMethods.visibleWait(homePage.alertMessage_gnl, 5);
        assertTrue(homePage.alertMessage_gnl.getText().contains("Guest User registered"));

    }

    @And("Kullanıcı çıkan Required mesajlarını doğrular")
    public void kullaniciCikanRequiredMesajlariniDogrular() {


        String expectedRequiredMessage = "Required";
        scrollIntoViewJS(homePage.requiredName_gnl);
        assertEquals(expectedRequiredMessage, homePage.requiredName_gnl.getText());

        scrollIntoViewJS(homePage.requiredSurname_gnl);
        assertEquals(expectedRequiredMessage, homePage.requiredSurname_gnl.getText());

        scrollIntoViewJS(homePage.requiredPlace_gnl);
        assertEquals(expectedRequiredMessage, homePage.requiredPlace_gnl.getText());

        scrollIntoViewJS(homePage.requiredPhone_gnl);
        assertEquals(expectedRequiredMessage, homePage.requiredPhone_gnl.getText());

        scrollIntoViewJS(homePage.requiredGender_gnl);
        assertEquals(expectedRequiredMessage, homePage.requiredGender_gnl.getText());

        scrollIntoViewJS(homePage.requiredDate_gnl);
        assertEquals(expectedRequiredMessage, homePage.requiredDate_gnl.getText());

        scrollIntoViewJS(homePage.requiredSsn_gnl);
        assertEquals(expectedRequiredMessage, homePage.requiredSsn_gnl.getText());

        scrollIntoViewJS(homePage.requiredUserName_gnl);
        assertEquals(expectedRequiredMessage, homePage.requiredUserName_gnl.getText());

        scrollIntoViewJS(homePage.requiredPassword_gnl);
        assertEquals(expectedRequiredMessage, homePage.requiredPassword_gnl.getText());

    }


}
