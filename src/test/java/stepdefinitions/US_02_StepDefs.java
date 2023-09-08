package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import pages.AdminManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_02_StepDefs {


    AdminManagementPage adminManagementPage = new AdminManagementPage();
    String eklenenFakeUserName;


    @Then("Kullanici login butonuna tıklar")
    public void kullanici_login_butonuna_tiklar() {
        adminManagementPage.login_gnl.click();

    }

    @And("Kullanici Username girer")
    public void kullaniciUsernameGirer() {
        adminManagementPage.userNameInput_gnl.sendKeys(ConfigReader.getProperty("adminUserName"), Keys.ENTER);

    }

    @And("Kullanici Password girer")
    public void kullaniciPasswordGirer() {
        adminManagementPage.passwordInput_gnl.sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);

    }


    @And("Kullanici Hi yazisinin gorundugunu dogrular")
    public void kullaniciYazisininGorundugunuDogrular() {
        String hiMessage = "Hi";
        Assert.assertTrue(adminManagementPage.hiYazisi_gnl.getText().contains(hiMessage));

    }

    @Then("Kullanici Menu butonuna tiklar")
    public void kullaniciMenuButonunaTiklar() {
        adminManagementPage.menuButton_gnl.click();

    }

    @Then("Kullanici Guest User butonuna tiklar")
    public void kullaniciGuestUserButonunaTiklar() {
        adminManagementPage.guestUserButton_gnl.click();

    }

    @And("Kullanici son basarili kaydin guest user list'te oldugunu dogrular")
    public void kullaniciSonBasariliKaydinGuestUserListTeOldugunuDogrular() {

        String eklenenFakeUserName = US_01_StepDefs.fakeUsername;

        int maxDenemeSayisi = 30;
        int guncelDenemeSayisi = 1;
        boolean sonucBulundu = false;

        while (guncelDenemeSayisi < maxDenemeSayisi && !sonucBulundu) {
            try {
                System.out.println(guncelDenemeSayisi + ". sayfa kontrol ediliyor....");
                boolean tryToFind = Driver.getDriver().findElements(By.xpath("//*[text()='" + eklenenFakeUserName + "']")).isEmpty();
                if (tryToFind) {
                    System.out.println("Guest User, " + guncelDenemeSayisi + ". sayfada bulunamadı...");
                    ReusableMethods.click(adminManagementPage.sagOkButton_gnl);
                    guncelDenemeSayisi++;
                } else {
                    ReusableMethods.bekle(1);
                    WebElement element = Driver.getDriver().findElement(By.xpath("//*[text()='" + eklenenFakeUserName + "']"));
                    System.out.println("Guest User, " + guncelDenemeSayisi + ". sayfada bulundu: " + element.isDisplayed());
                    sonucBulundu = true;
                }
            } catch (TimeoutException e) {
                if (guncelDenemeSayisi == maxDenemeSayisi) {
                    throw new TimeoutException();
                }
            }
        }
    }

    @Then("Kullanici son eklenen Guest user'i siler")
    public void kullaniciSonEklenenGuestUserISiler() {
        eklenenFakeUserName = US_01_StepDefs.fakeUsername;
        By submitLocator = RelativeLocator.with(By.xpath("//*[@class='btn btn-danger']")).toRightOf(By.xpath("//*[text()='" + eklenenFakeUserName + "']"));
        ReusableMethods.click(Driver.getDriver().findElement(submitLocator));

    }


    @And("Kullanici son eklenen Guest user'i silindigini dogrular")
    public void kullaniciSonEklenenGuestUserISilindiginiDogrular() {

        for (int i = 1; i <= 5; i++) {
            WebElement el = Driver.getDriver().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]"));
            for (int j = 1; j <= 5; j++) {
                WebElement el2 = Driver.getDriver().findElement(By.xpath("//table/tbody/tr[" + j + "]/td[4]"));
                System.out.println(i + ". Name: " + el.getText() + ", User Name: " + el2.getText());
            }
        }


        ReusableMethods.visibleWait(adminManagementPage.alertMessage_gnl, 5);
        Assert.assertEquals("Guest User deleted Successful", adminManagementPage.alertMessage_gnl.getText());

    }

    @And("Kullanici Login butonuna tiklar_gnl")
    public void kullaniciLoginButonunaTiklar_gnl() {
        adminManagementPage.loginButton_gnl.click();
    }
}
