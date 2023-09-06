package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

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

}