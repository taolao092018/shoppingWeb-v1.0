package shoppingWeb.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import shoppingWeb.pageObjects.BaseTest;
import shoppingWeb.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseTest {
    @Test
    public void signinTest()
    {
        test = reporter.createTest("sign-inTest");
        logger.info("URL is opened");
        LoginPage lp = new LoginPage(driver,wait);
        logger.info("Login/Register menu is clicked - to open Login page");
        lp.clickLoginRegister();
        logger.info("Username is set");
        lp.setUsername(username);
        logger.info("Password is set");
        lp.setPassword(password);
        logger.info("Sign-in button is clicked");
        lp.clickSignin();

        if (driver.getTitle().equals("Australia's Cheapest Online Pharmacy - My Account"))
        {
            logger.info("Sign-in test passed");
            Assert.assertTrue(true);
        }
        else
        {
            logger.error("Sign-in test failed");
            Assert.assertFalse(false);
        }
    };
}
