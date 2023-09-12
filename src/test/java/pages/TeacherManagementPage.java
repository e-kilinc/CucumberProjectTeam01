package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TeacherManagementPage {
    public TeacherManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Menu']") public WebElement menuY;
    @FindBy(xpath = "//a[text()='Teacher Management']") public WebElement teacherManageButtonY;
    @FindBy(xpath = "//*[@class=' css-13cymwt-control']") public  WebElement chooseLessonsY;
    @FindBy(xpath = "//input[@id='name']") public WebElement nameInputY;
    @FindBy(xpath = "//input[@id='surname']") public WebElement surNameInputY;
    @FindBy(xpath = "//input[@id='birthPlace']") public WebElement birthPlaceInputY;
    @FindBy(xpath = "//input[@id='phoneNumber']") public WebElement phoneNumberInputY;
    @FindBy(xpath = "//input[@id='email']") public WebElement emailInputY;
    @FindBy(xpath = "//input[@value='FEMALE']") public WebElement maleRadioButtonY;
    @FindBy(xpath = "//input[@value='MALE']") public WebElement femaleRadioButtonY;
    @FindBy(xpath = "//input[@id='birthDay']") public WebElement birthDayY;
    @FindBy(xpath = "//input[@id='ssn']") public WebElement ssnInputY;
    @FindBy(xpath = "//input[@id='username']") public WebElement userNameInputY;
    @FindBy(xpath = "//input[@id='password']") public WebElement passwordInputY;
    @FindBy(xpath = "//input[@id='isAdvisorTeacher']") public WebElement isAdvisorY;
    @FindBy(xpath = "//button[text()='Submit']") public WebElement tmSubmitY;
    @FindBy(xpath = "//div[text()='Teacher saved successfully']") public WebElement tmSuccesY;
    @FindBy(xpath = "(//div[text()='Required'])[1]") public WebElement nameRequiredY;
    @FindBy(xpath = "(//div[text()='Required'])[2]") public WebElement surnameRequiredY;
    @FindBy(xpath = "(//div[text()='Required'])[3]") public WebElement birthPlaceRequiredY;
    @FindBy(xpath = "(//div[text()='Required'])[4]") public WebElement emailRequiredY;
    @FindBy(xpath = "(//div[text()='Required'])[5]") public WebElement phoneRequiredY;
    @FindBy(xpath = "(//div[text()='Required'])[6]") public WebElement dateBirthRequiredY;
    @FindBy(xpath = "(//div[text()='Required'])[7]") public WebElement ssnRequiredY;
    @FindBy(xpath = "(//div[text()='Required'])[8]") public WebElement usernameRequiredY;
    @FindBy(xpath = "//div[text()='Enter your password']") public WebElement passRequiredY;
    @FindBy(xpath = "//div[@role='alert' and @class='Toastify__toast-body']") public WebElement errorChooseLessonY;
    @FindBy(xpath = "//div[@role='alert']") public WebElement errorGenderY;
    @FindBy(xpath = "//div[@role='alert']") public WebElement errorSSNgecersizFormY;
    @FindBy(xpath = "//div[text()='Minimum 11 character (XXX-XX-XXXX)']") public WebElement minOnBirKarakterYazisiY;
    @FindBy(xpath = "//div[text()='At least 8 characters']") public WebElement atLeast8YazisiY;
    @FindBy(xpath = "//div[text()='One lowercase character']") public WebElement oneLowerCaseYazisiY;
    @FindBy(xpath = "//div[text()='One uppercase character']") public WebElement oneUpperCaseYazisiY;
    @FindBy(xpath = "//div[text()='One number']") public WebElement oneNumberYazisiY;
}
