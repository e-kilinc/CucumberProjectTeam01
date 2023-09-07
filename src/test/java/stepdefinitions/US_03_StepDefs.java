package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class US_03_StepDefs {


    HomePage homePage = new HomePage();
    Faker faker = new Faker();
    private static String fakeEmail;
    private String message;

    @Then("Contact butonuna tiklar")
    public void contact_butonuna_tiklar() {

        ReusableMethods.click(homePage.contact_gnl);

    }

    @And("Kullanici {string}, e-mail ve {string} bolumlerini girer")
    public void kullaniciVeBolumleriniGirer(String name,String subject) {
        homePage.contactName_gnl.sendKeys(name);
        fakeEmail = faker.internet().emailAddress();
        homePage.contactMail_gnl.sendKeys(fakeEmail);
        homePage.contactSubject_gnl.sendKeys(subject);

    }

    @And("Kullanici Mail adresinin {string} ve {string} karakterlerini icerdigini dogrular")
    public void mailAdresiVeKarakterleriniIcerir(String atSymbol, String dotSymbol) {
        if (homePage.contactMail_gnl.getText().contains(atSymbol) && homePage.contactMail_gnl.getText().contains(dotSymbol)) {
            message = "Geçerli e-mail adresi";
        } else {
            message = "Geçersiz e-mail adresi";
        }

    }


    @And("Kullanici {string} yazar")
    public void kullaniciYazar(String mesaj) {

        homePage.contactMessage_gnl.sendKeys(ConfigReader.getProperty(mesaj));
    }


    @Then("Kullanici Send Message butonuna tiklar")
    public void kullaniciSendMessageButonunaTiklar() {
        ReusableMethods.click(homePage.contactSendMessageButton_gnl);

    }


    @And("Kullanici {string} mesajinin gorundugunu dogrular")
    public void kullaniciMesajininGorundugunuDogrular(String expectedMessage) {
        ReusableMethods.visibleWait(homePage.alertMessage_gnl, 10);
        Assert.assertTrue(homePage.alertMessage_gnl.getText().contains(expectedMessage));

        ReusableMethods.bekle(5);

    }


    @And("Kullanici name bolumune 4 karakterden daha az olan {string} girer")
    public void kullaniciNameBolumuneKarakterdenDahaAzOlanGirer(String name) {
        homePage.contactName_gnl.sendKeys(name);

    }

    @And("Kullanici Mail adresi bolumune @ ve . karakterlerini iceren mail girer")
    public void kullaniciMailAdresiBolumuneVeKarakterleriniIcerenGirer() {
        homePage.contactMail_gnl.sendKeys(fakeEmail);

    }

    @Then("Kullanici  Subject bolumune 4 karakterli {string} girer")
    public void kullaniciBolumuneKarakterliKonuGirer(String str) {
        homePage.contactSubject_gnl.sendKeys(str);

    }


    @And("Kullanici name bolumune 4 karakterli {string} girer")
    public void kullaniciNameBolumuneKarakterliGirer(String str) {
        homePage.contactName_gnl.sendKeys(str);

    }


    @And("Kullanici mesaj bolumune 3 karakterli {string} yazar")
    public void kullaniciMesajBolumuneKarakterliYazar(String str) {
        homePage.contactMessage_gnl.sendKeys(str);

    }

    @Then("Kullanici Subject bolumune 4 karakterden az {string} konusunu girer")
    public void kullaniciSubjectBolumuneKarakterdenAzGirer(String str) {
        homePage.contactSubject_gnl.sendKeys(str);

    }
}
