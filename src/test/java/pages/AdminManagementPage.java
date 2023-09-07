package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminManagementPage {


    public AdminManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='header_link ms-2']")
    public WebElement login_gnl;

    @FindBy(id = "username")
    public WebElement userNameInput_gnl;

    @FindBy(id = "password")
    public WebElement passwordInput_gnl;

    @FindBy(xpath = "//*[@class='fw-semibold btn btn-primary']")
    public WebElement loginButton_gnl;

    @FindBy(xpath = "//*[@class='text-white ']")
    public WebElement hiYazisi_gnl;

    @FindBy(xpath = "(//button)[1]")
    public WebElement menuButton_gnl;

    @FindBy(xpath = "//*[.='Guest User']")
    public WebElement guestUserButton_gnl;

    @FindBy(xpath = "(//td)[4]")
    public WebElement userNameKutusu_gnl;

    @FindBy(xpath = "(//*[@class='page-link'])[4]")
    public WebElement sagOkButton_gnl;

    @FindBy(xpath = "//*[@class='btn btn-danger']")
    public WebElement delete_gnl;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertMessage_gnl;


}
