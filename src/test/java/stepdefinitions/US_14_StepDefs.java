package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.ViceDeanManagementPage;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.bekle;

public class US_14_StepDefs {
    ViceDeanManagementPage teacher = new ViceDeanManagementPage();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();
    @Then("Kullanici Login yazisina tiklar")
    public void kullaniciLoginYazisinaTiklar() {
        teacher.login.click();

    }

    @And("Teacher List bolumunde daha once olusturulan kayitlarin Name Surname bilgisinin gorulebildigi dogrulanir")
    public void teacherListBolumundeDahaOnceOlusturulanKayitlarinNameSurnameBilgisininGorulebildigiDogrulanir() {
    }
    @Then("Vice Dean listenin sag alt kosesindeki {string} butonuna tiklar")
    public void viceDeanListeninSagAltKosesindekiButonunaTiklar(String arg0) {
        teacher.sonkayitgit.click();
    }
    @And("Olusturulan ogretmenin {string} bilgisinin goruldugunu dogrular")
    public void olusturulanOgretmeninBilgisininGoruldugunuDogrular(String arg0) {
    }
    @And("Olusturulan ogretmen satirinda Edit butonuna tiklar")
    public void olusturulanOgretmenSatirindaEditButonunaTiklar() {
        teacher.editButton.click();
    }
    @And("Ogretmen bilgilerini gunceller")
    public void ogretmenBilgileriniGunceller() {
        teacher.MethodeditTeacher();
    }
    @And("Vice Dean Submit Butonuna Tiklar")
    public void viceDeanSubmitButonunaTiklar() {
        teacher.bSubmitdEdit.click();
    }
    @And("Basarili guncellemeyi dogrular")
    public void basariliGuncellemeyiDogrular() {
        teacher.bSubmitdEdit.click();
    }

    @Then("Kullanici User Name alanina {string} password alanina {string} degerini girip giris yapar")
    public void kullaniciUserNameAlaninaPasswordAlaninaDegeriniGiripGirisYapar(String arg0, String arg1) {
        teacher.username.clear();
        teacher.username.sendKeys("AdminTeam09Vic");
        teacher.passsword.clear();
        teacher.passsword.sendKeys("AdminTeam09Vic");
        teacher.loginButton.click();
        bekle(3);
    }

    @Then("Kullanici Menu tiklar")
    public void kullaniciMenuTiklar() {
        teacher.menuButton.click();
        bekle(3);
    }

    @Then("Kullanici Teacher Management yazisina tiklar")
    public void kullaniciTeacherManagementYazisinaTiklar() {
        teacher.teacherMannagement.click();
        bekle(1);
    }

    @Then("Kullanici Choose Lessons'dan herhangi bir ders secer")
    public void kullaniciChooseLessonsDanHerhangiBirDersSecer() {
        teacher.name.sendKeys(Keys.SHIFT, Keys.TAB);
        actions.click(teacher.selectLesson).perform();
        actions.sendKeys(Keys.ENTER).perform();
        bekle(1);
    }

    @Then("kullanici Add Teacher formu doldurur")
    public void kullaniciAddTeacherFormuDoldurur() {
        teacher.teacheradd(faker.name().name(),
                faker.name().lastName(),
                faker.address().city(),
                faker.internet().emailAddress(),
                faker.regexify("[0-9]{3}-[0-9]{3}-[0-9]{4}"),
                faker.demographic().sex(),
                "15.06.2015",
                faker.regexify("[0-9]{3}-[0-9]{2}-[0-9]{4}"),
                faker.name().username(),
                faker.regexify("[A-Z][a-z]{1}[0-9]{6}"));
        bekle(3);
    }

    @Then("Kullanici submit butonu tiklar")
    public void kullaniciSubmitButonuTiklar() {
        bekle(1);
        teacher.submitButton.click();
    }

    @Then("Kullanici {string} yazisinin gorunurlugunu dogrular")
    public void kullaniciYazisininGorunurlugunuDogrular(String str) {
        Assert.assertEquals(str,teacher.alertMessage.getText());
    }
}
