package shoppingWeb.pageObjects;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import shoppingWeb.utilities.ReadConfig;
import shoppingWeb.utilities.report.CreateReportInstance;

import java.util.HashMap;
import java.util.Map;


public class BaseTest {
  ReadConfig readconfig = new ReadConfig();
   public static WebDriver driver;
   public static WebDriverWait wait;
   public static Logger logger;
   public static ExtentReports reporter;
   public static ExtentTest test;

   public String baseURL =  readconfig.getURL();
   public String username = readconfig.getUsername();
   public String password = readconfig.getPassword();

   @Parameters ("browser")
   @BeforeClass
   public void setUp(String br) throws InterruptedException {
       logger = LogManager.getLogger(BaseTest.class);
       reporter = CreateReportInstance.getReportInstance();

       if (br.equals("chrome")) {
           System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
           //Create prefs map to store all preferences
           Map<String, Object> prefs = new HashMap<String, Object>();
           //Put this into prefs map to switch off browser notification
           prefs.put("profile.default_content_setting_values.notifications", 1);
           //Create chrome options to set this prefs
           ChromeOptions options = new ChromeOptions();
           options.setExperimentalOption("prefs", prefs);
           //options.addArguments("--disable-notifications");
           //Help webdriver specifies chrome web driver's location

           driver = new ChromeDriver(options);
           driver.get(baseURL);
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           wait = new WebDriverWait(driver, 100);
           wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"pp_full_res\"]/iframe")));
           try{
               driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"pp_full_res\"]/iframe")));
               driver.findElement(By.xpath("//*[@id=\"no-thanks\"]/a")).click();
               driver.switchTo().parentFrame();
           } catch (Exception e){
               System.out.print(e.getMessage());
           }

       } else if (br.equals("firefox")) {
           System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
           FirefoxOptions options = new FirefoxOptions();
           options.addPreference("dom.webnotifications.enabled", false);
           driver = new FirefoxDriver(options)  ;
           driver.get(baseURL);
           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           wait = new WebDriverWait(driver, 20);

       } else if (br.equals("ie")) {
           System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
           InternetExplorerOptions options = new InternetExplorerOptions();
           DesiredCapabilities cap = new DesiredCapabilities();
           cap.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR,false);
           options.merge(cap);

           driver = new InternetExplorerDriver(options);
           driver.get(baseURL);
           wait = new WebDriverWait(driver, 20);


       }

   }
   @AfterClass
    public void tearDown(){
    driver.quit();
   }


}
