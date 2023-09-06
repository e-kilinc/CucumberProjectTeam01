package stepdefinitions;


import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;



public class US_20_StepDefs {

    HomePage homePage = new HomePage();

    @Given("Kullanici homePage  sayfasina gider.")
    public void kullanici_home_page_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("homePageUrl"));

    }
    @When("Kullanici Login butonuna tiklar.")
    public void kullanici_login_butonuna_tiklar() {
            homePage.login_tlg.click();
    }
    @When("Kullanici kullanici {string} ve password {string} bilgilerini girer.")
    public void kullanici_kullanici_ve_password_bilgilerini_girer(String string, String string2) {

        homePage.user_name_tlg.sendKeys(string);
        homePage.password_tlg.sendKeys(string2);
        homePage.nested_login_tlg.click();

    }
    @When("Kullanici Menu butonuna tiklar.")
    public void kullanici_menu_butonuna_tiklar() {
        homePage.menu_tlg.click();
    }
    @When("Kullanici acilan pencerede Meet Management butonuna tiklar.")
    public void kullanici_acilan_pencerede_butonuna_tiklar() {
        homePage.menu_meet_management_tlg.click();
    }
    @When("Kullanici Meet List bolumunde Date, Start Time,Stop Time ve Desciraption nin oldugunu dogrular")
    public void kullanici_meet_list_bolumunde_date_start_time_stop_time_ve_desciraption_nin_oldugunu_dogrular() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Edit butonuna tiklar.")
    public void kullanici_edit_butonuna_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Chose Student kismindan Team01 Student secer.")
    public void kullanici_chose_student_kismindan_team01_student_secer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Date of Meet bolumunde degisiklik yapar")
    public void kullanici_date_of_meet_bolumunde_degisiklik_yapar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Submit butonuna tiklar.")
    public void kullanici_submit_butonuna_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Meet Updated Succesfully yazisinin gorundugunu dogrular.")
    public void kullanici_meet_updated_succesfully_yazisinin_gorundugunu_dogrular() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Exit butonuna tiklar.")
    public void kullanici_exit_butonuna_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Delete butonuna tiklar")
    public void kullanici_delete_butonuna_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Kullanici Meet deleted succesfully yazisinin gorundugunu dogrular")
    public void kullanici_meet_deleted_succesfully_yazisinin_gorundugunu_dogrular() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




}
