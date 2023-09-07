package stepdefinitions;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LessonManagementPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class US_11_StepDefs {
    HomePage homePage=new HomePage();
    LessonManagementPage lessonManagementPage=new LessonManagementPage();
    @Then("Vice Dean olarak login olur")
    public void vice_dean_olarak_login_olur() {
        homePage.login1Y.click();
        homePage.usernameY.sendKeys(ConfigReader.getProperty("viceDeanUserName"));
        homePage.passwordY.sendKeys(ConfigReader.getProperty("password"));
        homePage.login2Y.click();
    }
    @Then("Lesson Program basligina tiklar")
    public void lesson_program_basligina_tiklar() {
        lessonManagementPage.lessonProgramButtonY.click();
        ReusableMethods.scroll(lessonManagementPage.lessonProgramListY);


    }

    @But("kullanici {int} saniye bekler")
    public void kullaniciSaniyeBekler(int sayi) {
        try {
            Thread.sleep(sayi*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Lesson Program List de ders programinin göründügünü dogrular {string},{string},{string},{string}")
    public void lesson_program_list_de_ders_programinin_göründügünü_dogrular(String Lesson, String Day, String Start_Time, String Stop_Time) {

        List<String> dersSütunu = new ArrayList<>();
        for (WebElement ders : lessonManagementPage.ListY) {
            dersSütunu.add(ders.getText());
        }

        String sayfaSayisi=lessonManagementPage.pageSeiteY.getText();
        String[] pages=sayfaSayisi.split(" of ");
        Integer page= Integer.valueOf(pages[1]);

        for (int i = 0; i <=page; i++) {
            for (String veri : dersSütunu) {
                if (veri.contains("Cucumber101")) {
                    ReusableMethods.scroll(lessonManagementPage.cucumber101Y);
                    assertTrue(lessonManagementPage.cucumber101Y.getText().contains("Cucumber101"));
                    assertTrue(lessonManagementPage.cucumber101DayY.getText().contains("FRIDAY"));
                    assertTrue(lessonManagementPage.cucumber101DayY.getText().contains("00:11:00"));
                    assertTrue(lessonManagementPage.cucumber101DayY.getText().contains("10:51:00"));

                    ReusableMethods.scroll(lessonManagementPage.cucumber101Y);
                    assertTrue(lessonManagementPage.cucumber101Y.isDisplayed());
                    assertTrue(lessonManagementPage.cucumber101DayY.isDisplayed());
                    assertTrue(lessonManagementPage.cucumber101StartY.isDisplayed());
                    assertTrue(lessonManagementPage.cucumber101StopY.isDisplayed());

                } else {
                    ReusableMethods.clickElementByJS(lessonManagementPage.ilerlemeButonuY);
                }
            }
        }


    }

}
