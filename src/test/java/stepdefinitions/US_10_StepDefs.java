package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.LessonManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;


public class US_10_StepDefs {
    HomePage homePage = new HomePage();
    LessonManagementPage lessonManagementPage = new LessonManagementPage();
    Select select;
    Actions actions;

    @Then("Kullanici Lesson Program headerina tiklar")
    public void kullaniciLessonProgramHeaderinaTiklar() {
        ReusableMethods.click(lessonManagementPage.lessonProgram);
        ReusableMethods.bekle(2);
    }

    @And("Kullanici istedigi dersi secer")
    public void kullaniciIstedigiDersiSecer() {

        //ReusableMethods.scroll(lessonManagementPage.selectLesson);


       actions = new Actions(Driver.getDriver());
       ReusableMethods.click(lessonManagementPage.selectLesson);
       actions.sendKeys(ConfigReader.getProperty("lesson1"),Keys.ENTER).perform();

       // ReusableMethods.clickElementByJS(lessonManagementPage.selectLesson);
        //ReusableMethods.ddmVisibleText(lessonManagementPage.selectLesson, ConfigReader.getProperty("lesson1"));
       //ReusableMethods.bekle(2);

//        ReusableMethods.click(lessonManagementPage.selectLesson);
//        ReusableMethods.bekle(2);
//        lessonManagementPage.selectLesson.sendKeys("Cypress",Keys.ENTER);

//        ReusableMethods.click(lessonManagementPage.selectLesson);
//        ReusableMethods.bekle(5);
//        select = new Select(lessonManagementPage.selectLesson);
//        select.selectByVisibleText("Cypress");
    }

    @And("Kullanici egitim donemini secer")
    public void kullaniciEgitimDoneminiSecer() {
        ReusableMethods.click(lessonManagementPage.educationTerm);
        select = new Select(lessonManagementPage.educationTerm);
        select.selectByIndex(2);
    }

    @And("Kullanici ders gununu secer")
    public void kullaniciDersGununuSecer() {
        ReusableMethods.click(lessonManagementPage.chooseDay);
        select = new Select(lessonManagementPage.chooseDay);
        select.selectByIndex(5);
    }

    @And("Kullanici ders baslama saatini secer")
    public void kullaniciDersBaslamaSaatiniSecer(DataTable data) {
        lessonManagementPage.startTime.sendKeys(data.row(0).get(0));
    }

    @And("Kullanici ders bitis saatini secer")
    public void kullaniciDersBitisSaatiniSecer(DataTable data) {
        lessonManagementPage.stopTime.sendKeys(data.row(0).get(0));
    }

    @And("Kullanici ders programi submit butonuna tiklar")
    public void kullaniciDersProgramiSubmitButonunaTiklar() {
        ReusableMethods.click(lessonManagementPage.lessonProgramSubmitButton);
    }

    @And("Kullanici ders programinin olustugunu dogrular")
    public void kullaniciDersProgramininOlustugunuDogrular() {
        String expectedLessonPlanCreated = "Created Lesson Program";
        ReusableMethods.visibleWait(lessonManagementPage.alertMessage,5);
        ReusableMethods.tumSayfaResmi("Created Lesson Program.alertMessage");
        assertTrue(lessonManagementPage.alertMessage.getText().contains(expectedLessonPlanCreated));


    }

    @And("Kullanici hata mesaji aldigini dogrular")
    public void kullaniciHataMesajiAldiginiDogrular() {
        ReusableMethods.visibleWait(lessonManagementPage.alertMessage,5);
        ReusableMethods.tumSayfaResmi("Hata Resmi");
        assertTrue(lessonManagementPage.alertMessage.isDisplayed());
    }

    @And("Kullanici hata Required yazini gorur")
    public void kullaniciHataRequiredYaziniGorur() {
        ReusableMethods.visibleWait(lessonManagementPage.requiredAlert,5);
        ReusableMethods.tumSayfaResmi("Required");
        assertTrue(lessonManagementPage.requiredAlert.isDisplayed());
    }
}
