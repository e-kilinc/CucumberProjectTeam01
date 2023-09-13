package pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Random;

import static utilities.ReusableMethods.bekle;

public class ViceDeanManagementPage {
    public ViceDeanManagementPage() {
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
    public ViceDeanManagementPage addStudent(String chooseTeacher, String name, String surname, String birdPlace, String email, String phoneNumber, String gender, String birthDay, String ssn, String userName, String fatherName, String motherName, String password) {
        Faker faker = new Faker();
        if (chooseTeacher != null) {
            Select select = new Select(addStudentChooseTeacher);
            select.selectByVisibleText(chooseTeacher);
        }
        bekle(2);
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
        bekle(2);
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
        bekle(3);
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
    public ViceDeanManagementPage addLessonNameCreditScore(String lessonname, String creditscore){
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

    @FindBy(xpath = "(//a)[2]")
    public WebElement login;//anasayfada yukarıda olan login
    @FindBy(xpath = "(//*[@class='page-link'])[5]")//>> işareti locati
    public WebElement sonkayitgit;
    @FindBy(xpath = "(//tr//td)[5]")//Edit button==> son satirin locati olmali
    public WebElement editButton;
    @FindBy(xpath = "(//button)[29]")
    public WebElement bSubmitdEdit;
    @FindBy(xpath = "(//select[@id='advisorTeacherId'])[2]")
    public WebElement chooseLessonsEdit;
    @FindBy(xpath = "(//*[@id='name'])[2]")
    public WebElement editTeacherName;
    @FindBy(xpath = "(//*[@id='surname'])[2]")
    public WebElement editTeacherSurname;
    @FindBy(xpath = "(//*[@id='birthPlace'])[2]")
    public WebElement editTeacherBirthplace;
    @FindBy(xpath = "(//*[@id='email'])[2]")
    public WebElement editTeacherEmail;
    @FindBy(xpath = "(//*[@id='phoneNumber'])[2]")
    public WebElement editTeacherPhoneNumber;
    @FindBy(xpath = "(//*[@id='isAdvisorTeacher'])[2]")
    public WebElement editTeacherIsAdvisorTeacher;
    @FindBy(xpath = "(//*[@id='ssn'])[2]")
    public WebElement editTeacherSsn;
    @FindBy(xpath = "(//*[@id='username'])[2]")
    public WebElement editTeacherUsername;
    @FindBy(xpath = "(//*[@id='password'])[2]")
    public WebElement editTeacherPassword;
    @FindBy(xpath = "(//*[@id='birthDay'])[2]")
    public WebElement editTeacherBirthDay;
    @FindBy(xpath = "(//*[@value='FEMALE'])[2]")
    public WebElement editTeacherFemale;
    @FindBy(xpath = "(//*[@value='MALE'])[2]")
    public WebElement editTeacherMale;
    @FindBy(xpath = "(//*[@class='fw-semibold btn btn-primary btn-lg'])[2]")
    public WebElement editTeacherSubmitButton;
    @FindBy(xpath = "(//*[@name='gender'])[1]")
    public WebElement female;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement passsword;

    @FindBy(xpath = "(//button)[3]")
    public WebElement loginButton;//giriş login buttonu
    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement menuButton;
    @FindBy(xpath = "//a[text()='Teacher Management']")
    public WebElement teacherMannagement;
    @FindBy(xpath = "//div[@class=' css-19bb58m']")
    public WebElement selectLesson;

    //Name alanı
    @FindBy(xpath = "//*[@id='name']")
    public WebElement name;

    //Surname alanı
    @FindBy(xpath = "//*[@id='surname']")
    public WebElement surname;
    @FindBy(xpath = "//*[@id='birthPlace']")
    public WebElement birthPlace;
    //Email alanı
    @FindBy(xpath = "//*[@id='email']")
    public WebElement email;
    //Phone alanı
    @FindBy(xpath = "//*[@id='phoneNumber']")
    public WebElement phone;
    //Gender

    @FindBy(xpath = "(//*[@name='gender'])[2]")
    public WebElement male;
    @FindBy(xpath = "//*[@id='birthDay']")
    public WebElement birthday;
    //Ssn alanı
    @FindBy(xpath = "//*[@id='ssn']")
    public WebElement ssn;

    //User Name alanı
    @FindBy(css = "#username")
    private WebElement userName;

    //Password alanını
    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//*[@class='fw-semibold btn btn-primary btn-lg']")
    public WebElement submitButton;















    public static void MethodeditTeacher(){
        ViceDeanManagementPage teacher = new ViceDeanManagementPage();//locator'larimizin oldugu page class'i
        Random random = new Random();
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        if (teacher.chooseLessonsEdit.getText().isEmpty()){
            teacher.chooseLessonsEdit.click();
            String[] dersler = {"English", "Cypress", "Java", "JavaScript", "Selenium", "Fluid", "Lambda", "CSS", "HTML"};
            int rastgeleIndeks = random.nextInt(dersler.length);
            String secilenDers = dersler[rastgeleIndeks];
            actions.sendKeys(secilenDers).perform();
            bekle(2);
            actions.sendKeys(Keys.TAB).perform();
            bekle(2);
        }
        if (teacher.editTeacherName.getText().isEmpty()){
            String newName = faker.name().name();
            teacher.editTeacherName.sendKeys(Keys.CONTROL + "a");
            teacher.editTeacherName.sendKeys(Keys.DELETE);
            if (newName.length() > 8) {
                newName = newName.substring(0, 8);
            }
            teacher.editTeacherName.sendKeys(newName);
        }
        if (teacher.editTeacherSurname.getText().isEmpty()){
            teacher.editTeacherSurname.sendKeys(Keys.CONTROL + "a");
            teacher.editTeacherSurname.sendKeys(Keys.DELETE);
            teacher.editTeacherSurname.sendKeys(faker.name().lastName());
        }
        if (teacher.editTeacherBirthplace.getText().isEmpty()){
            String birthCity = faker.address().city();
            if (birthCity.length() > 8) {
                birthCity = birthCity.substring(0, 8);
            }
            teacher.editTeacherBirthplace.sendKeys(birthCity);
        }
        if (teacher.editTeacherEmail.getText().isEmpty()){
            teacher.editTeacherEmail.sendKeys(Keys.CONTROL + "a");
            teacher.editTeacherEmail.sendKeys(Keys.DELETE);
            teacher.editTeacherEmail.sendKeys(faker.internet().emailAddress());
        }
        if (teacher.editTeacherPhoneNumber.getText().isEmpty()){
            int first = 100 + random.nextInt(900);
            int second = 100 + random.nextInt(900);
            int third = 1000 + random.nextInt(9000);
            String randomPhoneNumber = String.format("%03d-%03d-%04d", first, second, third);
            teacher.editTeacherPhoneNumber.sendKeys(randomPhoneNumber);
        }
        if (!teacher.editTeacherMale.isSelected() && !teacher.female.isSelected()){
            int randomclickNumber = random.nextInt(2);
            if (randomclickNumber == 0){
                teacher.editTeacherMale.click();
            }else {
                teacher.editTeacherFemale.click();
            }
        }
        if (teacher.editTeacherMale.isSelected()){
            teacher.editTeacherFemale.click();
        }
        if (teacher.editTeacherFemale.isSelected()){
            teacher.editTeacherMale.click();
        }
        if (teacher.editTeacherBirthDay.getText().isEmpty()){
            int year = faker.number().numberBetween(1950, 2000);
            int month = faker.number().numberBetween(1, 13);
            int day = faker.number().numberBetween(1, 30);
            String formattedBirthdate = String.format("%02d%02d%04d", day, month, year);
            teacher.editTeacherBirthDay.sendKeys(formattedBirthdate);
        }
        if (teacher.editTeacherSsn.getText().isEmpty()){
            int first = random.nextInt(1000);
            int second = random.nextInt(100);
            int third = random.nextInt(10000);
            String randomSsnNumber = String.format("%03d-%02d-%04d", first, second, third);
            teacher.editTeacherSsn.sendKeys(randomSsnNumber);
        }
        if (teacher.editTeacherUsername.getText().isEmpty()){
            String randomUsername = faker.name().username();
            if (randomUsername.length() > 8) {
                randomUsername = randomUsername.substring(0, 8);
            }
            teacher.editTeacherUsername.sendKeys(Keys.CONTROL + "a");
            teacher.editTeacherUsername.sendKeys(Keys.DELETE);
            teacher.editTeacherUsername.sendKeys(randomUsername);
        }
        if (teacher.editTeacherPassword.getText().isEmpty()){
            String fakerPassword = faker.regexify("[A-Z][a-z]{5}[A-Z][0-9]{2}");
            teacher.editTeacherPassword.sendKeys(Keys.CONTROL + "a");
            teacher.editTeacherPassword.sendKeys(Keys.DELETE);
            teacher.editTeacherPassword.sendKeys(fakerPassword);
        }
        teacher.editTeacherSubmitButton.click();
    }
    public ViceDeanManagementPage teacheradd(String nameValue, String surnameValue, String birthPlaceValue,
                                             String eMailValue,
                                             String phoneNumberValue, String genderValue, String birthDayValue,
                                             String ssnValue, String userNameValue, String passwordValue) {
        if (nameValue != null) {
            name.sendKeys(nameValue);
        }
        if (surnameValue != null) {
            surname.sendKeys(surnameValue);
        }
        if (birthPlaceValue != null) {
            birthPlace.sendKeys(birthPlaceValue);
        }
        if (eMailValue != null) {
            email.sendKeys(eMailValue);
        }
        if (phoneNumberValue != null) {
            phone.sendKeys(phoneNumberValue);
        }
        if (genderValue != null) {
            if (genderValue.equalsIgnoreCase("FEMALE")) {
                ReusableMethods.click(female);
            } else if (genderValue.equalsIgnoreCase("MALE")) {
                ReusableMethods.click(male);
            }
        }
        if (birthDayValue != null) {
            birthday.sendKeys(birthDayValue);
        }
        if (ssnValue != null) {
            ssn.sendKeys(ssnValue);
        }
        if (userNameValue != ".") {
            userName.sendKeys(userNameValue);
        }
        if (passwordValue != null) {
            password.sendKeys(passwordValue);
        }
        return this;
    }
}
