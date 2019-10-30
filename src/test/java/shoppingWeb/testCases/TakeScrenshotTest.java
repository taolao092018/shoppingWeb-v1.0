package shoppingWeb.testCases;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

        import org.openqa.selenium.TakesScreenshot;

        import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TakeScrenshotTest {


@Test (dataProvider = "login-data")
    public void testDataProvider(String username, String pass) throws IOException {

        WebDriver driver ;
        System.setProperty("webdriver.chrome.driver", "C:\\Anh\\Automation\\projWebDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        //goto url

        driver.get("https://www.chemistwarehouse.com.au/login");

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password1")).sendKeys(pass);
        driver.findElement(By.id("Signin")).click();


        //Call take screenshot function

        this.takeSnapShot(driver, System.getProperty("user.dir")+"\\projExtentReport\\screenshots\\abc.png") ;
        driver.close();
    }

    @DataProvider (name="login-data")
    /*public Object[][] dataProviderMethod(){

       {"anna123@gmail.com", "12345"},
        return new Object[][] {
                {"anna123@gmail.com",new Object [][] {"12345678", "abc"}},
        }
    }*/

    /**

     * This function will take screenshot

     * @param webdriver

     * @param fileWithPath

     * @throws Exception

     */

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws IOException{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }

}