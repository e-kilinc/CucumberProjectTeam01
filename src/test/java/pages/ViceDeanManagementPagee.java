package pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class ViceDeanManagementPagee {
    public ViceDeanManagementPagee() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//nav//button)[1]")
    public WebElement menu;
    //acılır menuden student management
    @FindBy(xpath = "//a[text()='Student Management']")
    public WebElement mainMenuStudentManagement;
    //Add Student sayfası addStudent
    @FindBy(xpath = "//select[@id='advisorTeacherId']")
    private WebElement addStudentChooseTeacher;
    @FindBy(xpath = "//input[@id='name']")
    public WebElement addStudentName;
    @FindBy(xpath = "//input[@id='surname']")
    public WebElement addStudentSurName;
    @FindBy(xpath = "//input[@id='birthPlace']")
    public WebElement addStudentBirdPlace;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement addStudentEmail;
    @FindBy(xpath = "//input[@id='phoneNumber']")
    private WebElement addStudentPhoneNumber;
    @FindBy(xpath = "//input[@value='FEMALE']")
    private WebElement addStudentFemale;
    @FindBy(xpath = "//input[@value='MALE']")
    private WebElement addStudentMale;
    @FindBy(xpath = "//input[@id='birthDay']")
    private WebElement addStudentBirdday;
    @FindBy(xpath = "//*[@id='ssn']")
    public WebElement addStudentSsn;
    @FindBy(xpath = "//*[@id='username']")
    private WebElement addStudentUsername;
    @FindBy(xpath = "//*[@id='fatherName']")
    private WebElement addStudentFatherName;
    @FindBy(xpath = "//*[@id='motherName']")
    private WebElement addStudentmotherName;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement addStudentPassword;
    @FindBy(xpath = "//*[@class='fw-semibold btn btn-primary btn-lg']")
    public WebElement addStudentSubmit;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertMessage;
    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement requiredName;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    public WebElement addStudentLogout;
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    public WebElement addStudentYes;
    @FindBy(xpath = "(//tbody//tr/td//span)[1]")
    public WebElement listStudentNumber;
    public ViceDeanManagementPagee addStudent(String chooseTeacher, String name, String surname, String birdPlace, String email, String phoneNumber, String gender, String birthDay, String ssn, String userName, String fatherName, String motherName, String password) {
        Faker faker = new Faker();
        if (chooseTeacher != null) {
            Select select = new Select(addStudentChooseTeacher);
            select.selectByVisibleText(chooseTeacher);
        }
        ReusableMethods.bekle(2);
        if (name != null) {
            addStudentName.sendKeys(name);
        }
        if (surname != null) {
            addStudentSurName.sendKeys(surname);
        }
        if (birdPlace != null) {
            addStudentBirdPlace.sendKeys(birdPlace);
        }
        if (email != null) {
            email = faker.internet().emailAddress();
            addStudentEmail.sendKeys(email);
        }
        if (phoneNumber != null) {
            phoneNumber = faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(100, 999) + " " + faker.number().numberBetween(1000, 9999);
            addStudentPhoneNumber.sendKeys(phoneNumber);
        }
        if (gender != null) {
            if (gender.equalsIgnoreCase("male")) {
                addStudentMale.click();
            } else if (gender.equalsIgnoreCase("famale")) {
                addStudentFemale.click();
            }
        }
        if (birthDay != null) {
            addStudentBirdday.sendKeys(birthDay);
        }
        if (ssn != null) {
            addStudentSsn.sendKeys(faker.idNumber().ssnValid());
        }
        ReusableMethods.bekle(2);
        if (userName != null) {
            userName = faker.name().username();
            addStudentUsername.sendKeys(userName);
        }
        if (fatherName != null) {
            addStudentFatherName.sendKeys(fatherName);
        }
        if (motherName != null) {
            addStudentmotherName.sendKeys(motherName);
        }
        if (password != null) {
            addStudentPassword.sendKeys(password);
        }
        ReusableMethods.bekle(3);
        addStudentSubmit.click();
        return this;
    }
    @FindBy(xpath = "//*[@id='controlled-tab-example-tab-lessonsList']")
    public WebElement lessons;
    @FindBy(xpath = "//*[@id='lessonName']")
    public WebElement lessonName;
    @FindBy(xpath = "//*[@id='compulsory']")
    public WebElement compulsory;
    @FindBy(xpath = "//*[@id='creditScore']")
    public WebElement creditScore;
    @FindBy(xpath = "(//*[text()='Required'])[1]")
    public WebElement lessonNameRequiredYazisi;
    @FindBy(xpath = "(//*[text()='Required'])[2]")
    public WebElement creditScoreRequiredYazisi;
    @FindBy(xpath = "(//*[text()='Submit'])[2]")
    public WebElement submitButonu;
    @FindBy(xpath = "(//*[text()='»'])[2]")
    public WebElement sayfaSonuImleci;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")
    public WebElement lessonCreatedAlert;
    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> dersListesi;
    @FindBy(xpath = "(//*[text()='›'])[2]")
    public WebElement birSonrakiSayfaButonu;
    public ViceDeanManagementPagee addLessonNameCreditScore(String lessonname,String creditscore){
        if (lessonname!=""){
            lessonName.sendKeys(lessonname);
        }
        if (lessonname!="") {
            creditScore.sendKeys(creditscore);
        }
        ReusableMethods.click(submitButonu);
        return this;
    }
    //contact message sayfası
    @FindBy(xpath = "//a[text()='Contact Get All']")
    public WebElement mainMenuContactGettAll;
    @FindBy(xpath = "//*[@id='root']")
    public WebElement ContactGettAllPage;
    @FindBy(xpath = "//*[@role='button']")
    public List<WebElement> ContactGettAllbuttons;
    @FindBy(xpath = "//*[text()='Contact']")
    public WebElement ContactGetContact;
    @FindBy(xpath = "//*[@id='name']")
    public WebElement contactMsjName;
    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> msjListFirstRow;
}