package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LessonManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US_09_StepDefs {
    HomePage homePage = new HomePage();
    LessonManagementPage lessonManagementPage = new LessonManagementPage();

    @And("Kullanici ders listesinde son sayfaya gider")
    public void kullaniciDersListesindeSonSayfayaGider() {
        ReusableMethods.click(lessonManagementPage.lastPage);
        ReusableMethods.bekle(5);

    }

    @Then("Kullanici derslerin gorunur oldugunu dogrular")
    public void kullanici_derslerin_gorunur_oldugunu_dogrular() {
         ReusableMethods.visibleWait(lessonManagementPage.lastRowLesson,3);
         ReusableMethods.scroll(lessonManagementPage.lastRowLesson);
         ReusableMethods.webElementResmi(lessonManagementPage.lastRowLesson);
         String lessonName = lessonManagementPage.lastRowLesson.getText();
         assertEquals(ConfigReader.getProperty("lesson2"),lessonName);

        //System.out.println(lessonManagementPage.lastRow.getText());
        //lessonManagementPage.lastRow.forEach(t-> System.out.println(t.getText()));
        //assertTrue(lessonManagementPage.lessonList.toString().contains("Cypress"));
        //System.out.println("lessonManagementPage.lessonList.toString() = " + lessonManagementPage.lessonList.toString());

    }
    @Then("Kullanici derslerin compulsary olup olmadiginin gorunur oldugunu dogrular")
    public void kullanici_derslerin_compulsary_olup_olmadiginin_gorunur_oldugunu_dogrular() {
        ReusableMethods.visibleWait(lessonManagementPage.lastRowCompulsory,3);
        String compulsoryActual = lessonManagementPage.lastRowCompulsory.getText();
        assertEquals("Yes",compulsoryActual);

    }
    @Then("Kullanici derslerin credit scorelerinin gorunur oldugunu dogrular")
    public void kullanici_derslerin_credit_scorelerinin_gorunur_oldugunu_dogrular() {
        ReusableMethods.visibleWait(lessonManagementPage.lastRowCredit,3);
        String creditActual = lessonManagementPage.lastRowCredit.getText();
        assertEquals("3",creditActual);
    }

    @And("Kullanici dersi silme butonuna tiklar")
    public void kullaniciDersiSilmeButonunaTiklar() {
        ReusableMethods.click(lessonManagementPage.deleteLesson);
    }

    @And("Kullanici dersin silindigini dogrular")
    public void kullaniciDersinSilindiginiDogrular() {
        ReusableMethods.visibleWait(lessonManagementPage.alertMessage,3);
        ReusableMethods.tumSayfaResmi("ders basariyla silindi");
        assertTrue(lessonManagementPage.alertMessage.getText().contains("Lesson Deleted"));
    }
}
