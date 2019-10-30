package shoppingWeb.utilities.report;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import shoppingWeb.pageObjects.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenshot extends BaseTest {
    CaptureScreenshot(){

    }
    public String captureScreenshot(String testname) throws  IOException{
        String dateformat = new SimpleDateFormat("yy.MM.dd.HH.mm.ss").format(new Date());
        //create object variable of TakeScreenshot class
        TakesScreenshot ts = ((TakesScreenshot) driver);
        //create File object variable which holds the screen shot reference
        File source = ts.getScreenshotAs(OutputType.FILE);
        //store the screen shot path in path variable.
        String  path= System.getProperty("user.dir") + "/projExtentReport/screenshots/"+testname+dateformat+".png";
        //create another File object variable which points(refer) to the above stored path variable
        File dest = new File(path);
        //use FileUtils class method to save the screen shot at desired path
        FileUtils.copyFile(source, dest);
        return path;
    }
}
