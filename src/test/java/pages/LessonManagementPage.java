package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class LessonManagementPage {
    public LessonManagementPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='controlled-tab-example-tab-lessonsList']")
    public WebElement lessonsHeader;

    @FindBy(xpath = "//*[@id='lessonName']")
    public WebElement lessonName;

    @FindBy(xpath = "//*[@id='compulsory']")
    public WebElement compulsoryRadioButton;

    @FindBy(xpath = "//*[@id='creditScore']")
    public WebElement creditScore;

    @FindBy(xpath = "(//*[text()='Submit'])[2]")
    public WebElement submitButton;

   // @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    //public WebElement lessonCreated;

    @FindBy(xpath = "//*[text()='Lesson Created']")
    public WebElement lessonCreated;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertMessage;

    @FindBy(xpath = "(//thead)[2]//th[1]")
    public WebElement lessonNameTitle;

    @FindBy(xpath = "(//tbody)[2]//td[1]")
    public List<WebElement> lessonList;

    @FindBy(xpath = "((//table)[2]/tbody/tr)[last()]")
    public WebElement lastRow;

    @FindBy(xpath = "//*[text()='Required']")
    public WebElement requiredText;

    @FindBy(xpath = "((//tbody)[2]//tr//td)[last()]")
    public WebElement deleteLesson;

    @FindBy(xpath = "((((//tbody)[2]//tr)[last()])//td)[1]")
    public WebElement lastRowLesson;

    @FindBy(xpath = "((((//tbody)[2]//tr)[last()])//td)[ ")
    public WebElement lastRowCompulsory;

    @FindBy(xpath = "((((//tbody)[2]//tr)[last()])//td)[3]")
    public WebElement lastRowCredit;

    @FindBy(xpath = "(//*[text()='Last'])[2]")
    public WebElement lastPage;

    @FindBy(xpath = "//*[@id='controlled-tab-example-tab-lessonProgram']")
    public WebElement lessonProgram;

    @FindBy(xpath = "(//*[text()='Submit'])[3]")
    public WebElement lessonProgramSubmitButton;

    @FindBy(xpath = "//*[@class=' css-19bb58m']")
    public WebElement selectLesson;

    @FindBy(xpath = "//*[@id='educationTermId']")
    public WebElement educationTerm;

    @FindBy(xpath = "//*[@id='day']")
    public WebElement chooseDay;

    @FindBy(xpath = "//*[@id='startTime']")
    public WebElement startTime;

    @FindBy(xpath = "//*[@id='stopTime']")
    public WebElement stopTime;

    @FindBy(xpath = "//*[text()='Required']")
    public WebElement requiredAlert;

    ////tr[td[text()='History5']]

    //ders ismi history olan satirdaki istedigimiz veri icin
    //td[span[text()='History5']]/../td[3]

    @FindBy(xpath = "//button[@id='controlled-tab-example-tab-lessonProgram']") public WebElement lessonProgramButtonY;
    @FindBy(xpath = "//h5[text()='Lesson Program List']") public WebElement lessonProgramListY;
    @FindBy(xpath = "(//td[span[text()='Cucumber101']]/../td[1])[1]") public WebElement cucumber101Y;
    @FindBy(xpath = "(//td[span[text()='Cucumber101']]/../td[2])[1]") public WebElement cucumber101DayY;
    @FindBy(xpath = "(//td[span[text()='Cucumber101']]/../td[3])[1]") public WebElement cucumber101StartY;
    @FindBy(xpath = "(//td[span[text()='Cucumber101']]/../td[4])[1]") public WebElement cucumber101StopY;
    @FindBy(xpath = "(//tbody[@class='table-group-divider'])[3]//tr//td[1]") public List<WebElement> ListY;
    @FindBy(xpath = "(//a[@class='page-link' and @role='button'])[11]") public WebElement ilerlemeButonuY;
    @FindBy(xpath = "(//div[@class='d-flex justify-content-start ps-5 col'])[3]") public WebElement pageSeiteY;
    @FindBy(xpath = "//h5[text()='Lesson Program Assignment']") public WebElement lpAssignmentY;
    @FindBy(xpath = "//input[@type='checkbox' and @id='lessonProgramId']") public WebElement lpChooseLessonY;
    @FindBy(xpath = "//select[@class='form-select' and @id='teacherId']") public WebElement lpChooseTeacherY;
    @FindBy(xpath = "(//button[text()='Submit'])[4]") public WebElement lpSubmitY;
    @FindBy(xpath = "//div[text()='Lesson added to Teacher']") public WebElement lpSuccesY;
    @FindBy(xpath = "//div[@role='alert' and @class='Toastify__toast-body']") public WebElement errorChooseTeacherY;
    @FindBy(xpath = "//div[@role='alert']") public WebElement errorChooseLessonY;

}
