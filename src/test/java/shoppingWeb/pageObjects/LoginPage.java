package shoppingWeb.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver ldriver;
    WebDriverWait lwait;
    //Constructor
   public LoginPage(WebDriver rdriver, WebDriverWait rwait)
   {
       ldriver = rdriver;
       lwait = rwait;

       //initialize all elements of the page
       PageFactory.initElements(ldriver,this);
   }
   //find the object which id = username by annotation @FindBy.
    @FindBy(id = "username")
    //cache the object that selenium will not search for next run. It's good for static elements only
    @CacheLookup
   //the found object is txtUsername
    WebElement txtUsername;
    @FindBy (id = "password1")
    @CacheLookup
    WebElement txtPassword;
    @FindBy(id = "Signin")
    @CacheLookup
    WebElement btnSignin;
    //@FindBy(xpath = "//*[@id=\"AMS_Login\"]")
    @FindBy(xpath = "//*[@id=\"AMS_Login\"]")
    @CacheLookup
    WebElement linkLoginRegister;

    public void setUsername(String uname){
        //wait.until(ExpectedConditions.invisibilityOf(txtUsername));
        txtUsername.sendKeys(uname);
    }
    public void setPassword (String pass){
        txtPassword.sendKeys(pass);
    }
    public void clickSignin(){
        btnSignin.click();
    }
    public void clickLoginRegister(){
        lwait.until(ExpectedConditions.elementToBeClickable(linkLoginRegister));
        linkLoginRegister.click();
    }


}
