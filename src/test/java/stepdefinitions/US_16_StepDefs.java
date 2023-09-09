package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.ViceDeanManagementPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class US_16_StepDefs {
    ViceDeanManagementPage viceDeanManagementPage = new ViceDeanManagementPage();
    HomePage homePage = new HomePage();
    @And("vdKullanici contactgetall sekmesini acar")
    public void vdkullaniciContactgetallSekmesiniAcar() {
        viceDeanManagementPage.mainMenuContactGettAll.click();
    }

    @And("contact message sayfasinda delete butonu gorumedigini dogrula")
    public void contactMessageSayfasindaDeleteButonuGorumediginiDogrula() {
        assertFalse(viceDeanManagementPage.ContactGettAllPage.getText().contains("delete"));

        for (int i = 0; i < viceDeanManagementPage.ContactGettAllbuttons.size(); i++) {
            assertFalse(viceDeanManagementPage.ContactGettAllbuttons.get(i).getText().contains("delete"));
    }
    }

    @And("get Contact ve {string} {string} {string} {string}  bilgilerini doldur ve gonder")
    public void getContactVeBilgileriniDoldurVeGonder(String yourname, String youremail, String yoursubject, String yourmessage) {
        viceDeanManagementPage.ContactGetContact.click();
        ReusableMethods.bekle(2);
        viceDeanManagementPage.contactMsjName.sendKeys(yourname, Keys.TAB, youremail, Keys.TAB, yoursubject, Keys.TAB, yourmessage, Keys.TAB, Keys.ENTER);

    }

    @Then("get Contact ve {string} {string} {string} {string} bilgileri liste ile gorundugunu dogrular")
    public void getContactVeBilgileriListeIleGorundugunuDogrular(String yourname, String youremail, String yoursubject, String yourmessage) {
        ZoneId abdSaatDilimi = ZoneId.of("America/New_York");
        String datetoday = LocalDate.now(abdSaatDilimi).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<String> list = new ArrayList<>(List.of(yourname, youremail, datetoday, yoursubject, yourmessage));
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i).equalsIgnoreCase(Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[" + (i + 1) + "]")).getText()));
        }
    }
}
