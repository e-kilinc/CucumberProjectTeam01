package pages;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class HomePage {
        Faker faker = new Faker();
        private static String fakeUsername;
        private static String fakeSsn;
        private static String fakePhoneNumber;
        public static String guestUserName;
        public HomePage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }
        @FindBy(xpath = "//a[@href='/register']")
        private WebElement register;
        @FindBy(xpath = "//*[@id='name']")
        public WebElement name;
        @FindBy(id = "surname")
        private WebElement surname;
        @FindBy(id = "birthPlace")
        private WebElement birthPlace;
        @FindBy(id = "phoneNumber")
        private WebElement phoneNumber;
        @FindBy(xpath = "//input[@name='gender' and @value='FEMALE']")
        public WebElement femaleGender;
        @FindBy(xpath = "//input[@name='gender' and @value='MALE']")
        public WebElement maleGender;
        @FindBy(id = "birthDay")
        public WebElement birthDay;
        @FindBy(id = "ssn")
        public WebElement ssn;
        @FindBy(id = "username")
        private WebElement userName;
        @FindBy(id = "password")
        private WebElement passWord;
        @FindBy(xpath = "//*[@class='fw-semibold btn btn-primary']")
        private WebElement registerButton;
        @FindBy(xpath = "//*[@class='header_link ms-2']")
        private WebElement login;
        @FindBy(xpath = "//div[@role='alert']")
        public WebElement alertMessage;
        @FindBy(xpath = "//*[text()='One uppercase character']")
        private WebElement oneUppercaseCharacter;
        @FindBy(xpath = "//*[text()='One lowercase character']")
        private WebElement oneLowercaseCharacter;
        @FindBy(xpath = "//*[text()='One number']")
        private WebElement oneNumber;
        @FindBy(xpath = "//*[text()='At least 8 characters']")
        private WebElement atLeast8Characters;
        @FindBy(xpath = "//form[1]/div[1]/div[@class='invalid-feedback']")
        private WebElement requiredName;
        @FindBy(xpath = "//form[1]/div[2]/div[@class='invalid-feedback']")
        private WebElement requiredSurame;
        @FindBy(xpath = "//form[1]/div[3]/div[@class='invalid-feedback']")
        private WebElement requiredBirthPlace;
        @FindBy(xpath = "//div[10]/div[@class='invalid-feedback']")
        private WebElement requiredUserName;
        @FindBy(xpath = "//*[text()='Please enter valid phone number']")
        public WebElement invalidPhoneNumber;
        @FindBy(xpath = "//*[text()='Please enter valid SSN number']")
        public WebElement invalidSsn;
        @FindBy(xpath = "//*[text()='geçmiş bir tarih olmalı']")
        public WebElement invaliDateOfBirth;
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement login_tlg;

    @FindBy(id = "id=username")
    public WebElement user_name_tlg;


    @FindBy(id = "id=password")
    public WebElement password_tlg;


    @FindBy(xpath = "//div[button='Login']")
    public WebElement nested_login_tlg;


    @FindBy(xpath = "//button[@aria-controls='offcanvasNavbar-expand-false']")
    public WebElement menu_tlg;


    @FindBy(xpath = "//*[.='Meet Management']")
    public WebElement menu_meet_management_tlg;



    @FindBy(xpath = "//*[@class='fa fa-lock']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userNameBox;

    @FindBy(xpath = "(//*[@type='button'])[3]")
    public WebElement loginButtonHome;

    public HomePage registerClick() {
            register.click();
            return this;
        }
        public HomePage getMainPage() {
            Driver.getDriver().get(ConfigReader.getProperty("homePageUrl"));
            return this;
        }
        public HomePage getLogin(String username, String password) {
            login.click();
            userName.sendKeys(username);
            passWord.sendKeys(password);
            registerButton.click();
            return this;
        }
        public HomePage registerButton() {
            ReusableMethods.click(registerButton);
            return this;
        }
        public HomePage registerUser(String nameValue, String surnameValue, String birthPlaceValue,
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
            if (phoneNumberValue != null) {
                phoneNumber.sendKeys(phoneNumberValue);
            }
            if (genderValue != null) {
                if (genderValue.equalsIgnoreCase("FEMALE")) {
                    ReusableMethods.click(femaleGender);
                } else if (genderValue.equalsIgnoreCase("MALE")) {
                    ReusableMethods.click(maleGender);
                }
            }
            if (birthDayValue != null) {
                birthDay.sendKeys(birthDayValue);
            }
            if (ssnValue != null) {
                ssn.sendKeys(ssnValue);
            }
            if (userNameValue != ".") {
                userName.sendKeys(userNameValue);
                guestUserName = userNameValue;
            }
            if (passwordValue != null) {
                passWord.sendKeys(passwordValue);
            }
            return this;
        }
        public String getRequiredName() {
            ReusableMethods.visibleWait(requiredName, 2);
            return requiredName.getText();
        }
        public String getRequiredSurame() {
            ReusableMethods.visibleWait(requiredSurame, 2);
            return requiredSurame.getText();
        }
        public String getRequiredBirthPlace() {
            ReusableMethods.visibleWait(requiredBirthPlace, 2);
            return requiredBirthPlace.getText();
        }
        public String getRequiredUserName() {
            ReusableMethods.visibleWait(requiredUserName, 2);
            return requiredUserName.getText();
        }
        public String getOneUppercaseCharacter() {
            return oneUppercaseCharacter.getText();
        }
        public String getOneLowercaseCharacter() {
            return oneLowercaseCharacter.getText();
        }
        public String getOneNumber() {
            return oneNumber.getText();
        }
        public String getAtLeast8Characters() {
            return atLeast8Characters.getText();
        }
    }





