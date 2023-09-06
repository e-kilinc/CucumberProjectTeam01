package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.LessonManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class US_08_StepDefs {
    HomePage homePage = new HomePage();
    LessonManagementPage lessonManagementPage = new LessonManagementPage();
    Faker faker= new Faker();


    @Given("kullanici {string} sayfasina gider")
    public void kullanici_sayfasina_gider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty("homePageUrl"));
    }

    @Then("Kullanici Login butonuna tiklar")
    public void kullaniciLoginButonunaTiklar() {
        homePage.loginButton.click();
    }

    @Then("Kullanici verilen bilgiler ile login olur")
    public void kullanici_verilen_bilgiler_ile_login_olur(DataTable data) {

        homePage.userNameBox.sendKeys(data.row(1).get(0), Keys.TAB, data.row(1).get(1));
        ReusableMethods.bekle(2);
    }
    @And("Kullanici verileri girdikten sonra login olur")
    public void kullaniciVerileriGirdiktenSonraLoginOlur() {
        ReusableMethods.click(homePage.loginButtonHome);
        ReusableMethods.bekle(5);
    }

    @And("Kullanici Lessons headerina tiklar")
    public void kullaniciLessonsHeaderinaTiklar() {

        ReusableMethods.click(lessonManagementPage.lessonsHeader);
    }

    @And("Kullanici Lesson Name kismini doldurur")
    public void kullaniciLessonNameKisminiDoldurur(DataTable data1) {
        lessonManagementPage.lessonName.sendKeys(data1.row(1).get(0));
    }

    @Then("Kullanici dersin compulsory kismina tiklar")
    public void kullanici_dersin_compulsory_kismina_tiklar() {
        if(!lessonManagementPage.compulsoryRadioButton.isSelected()){
            lessonManagementPage.compulsoryRadioButton.click();
        }
    }

    @And("Kullanici Credit Score bilgilerini girer")
    public void kullaniciCreditScoreBilgileriniGirer(DataTable data2) {

        lessonManagementPage.creditScore.sendKeys(data2.row(1).get(0));
    }

    @And("Kullanici submit butonuna tiklar")
    public void kullaniciSubmitButonunaTiklar() {
        lessonManagementPage.submitButton.click();

    }

    @Then("Kullanici basariyla ders olustugunu dogrular")
    public void kullanici_basariyla_ders_olustugunu_dogrular() {
        ReusableMethods.visibleWait(lessonManagementPage.alertMessage,5);
        ReusableMethods.tumSayfaResmi("lessonManagementPage.alertMessage");
        assertTrue(lessonManagementPage.alertMessage.getText().contains("Lesson Created"));
        //Assert.assertEquals("Lesson Created",lessonManagementPage.lessonCreated.getText());
        //get text ile text bos donuyor.

        //assertTrue(lessonManagementPage.lessonCreated.isDisplayed());
       // String text = Driver.getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
        //System.out.println("text = " +
        //-------------------------------------
//        alert = Driver.getDriver().switchTo().alert();
//        String text = alert.getText();
//        System.out.println("text = " + text);
    }
    @Then("kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {
        Driver.closeDriver();
    }


    @And("Kullanici Lesson Name altinda Required uyarisini gorur")
    public void kullaniciLessonNameAltindaRequiredUyarisiniGorur() {
        assertTrue(lessonManagementPage.requiredText.isDisplayed());
    }

    @And("Kullanici Credit Score altinda Required uyarisini gorur")
    public void kullaniciCreditScoreAltindaRequiredUyarisiniGorur() {
        assertTrue(lessonManagementPage.requiredText.isDisplayed());
    }
}
