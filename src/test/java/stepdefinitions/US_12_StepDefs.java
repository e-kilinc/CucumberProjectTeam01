package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LessonManagementPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US_12_StepDefs {
    LessonManagementPage lessonManagementPage=new LessonManagementPage();
    @When("Lesson Program Assignment bölümüne gelir")
    public void lesson_program_assignment_bölümüne_gelir() {
        ReusableMethods.scroll(lessonManagementPage.lpAssignmentY);
    }

    @Then("Choose Lesson altindaki kutucuga tiklar")
    public void choose_lesson_altindaki_kutucuga_tiklar() {
        ReusableMethods.clickElementByJS(lessonManagementPage.lpChooseLessonY);

    }

    @Then("Choose Teacher alaninda bir ögretmen secer")
    public void choose_teacher_alaninda_bir_ögretmen_secer() {
        ReusableMethods.clickElementByJS(lessonManagementPage.lpChooseTeacherY);
        ReusableMethods.ddmVisibleText(lessonManagementPage.lpChooseTeacherY, ConfigReader.getProperty("teacherUsernameY"));
        ReusableMethods.bekle(2);
    }

    @Then("Submit butonuna tiklar")
    public void submit_butonuna_tiklar() {
        //lessonManagementPage.lpSubmitY.click();
        ReusableMethods.clickElementByJS(lessonManagementPage.lpSubmitY);
    }

    @Then("Dersin atandigini dogrular")
    public void dersin_atandigini_dogrular() {
        ReusableMethods.tumSayfaResmi("Ders atama");
        assertEquals("Lesson added to Teacher",lessonManagementPage.lpSuccesY.getText());
    }

    @And("Teacher secilmedigi icin uyari mesajinin görünüdügünü dogrular")
    public void teacherSecilmedigiIcinUyariMesajininGörünüdügünüDogrular() {
        ReusableMethods.waitForVisibility(lessonManagementPage.errorChooseTeacherY,5);
        assertTrue(lessonManagementPage.errorChooseTeacherY.isDisplayed());

    }

    @And("Lesson Secilmedigi icin uyari mesajinin göründügünü dogrular")
    public void lessonSecilmedigiIcinUyariMesajininGöründügünüDogrular() {

        ReusableMethods.waitForVisibility(lessonManagementPage.errorChooseLessonY,5);
        assertTrue(lessonManagementPage.errorChooseLessonY.isDisplayed());
    }
}
