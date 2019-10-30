package shoppingWeb.utilities.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateReportInstance {
    public static ExtentHtmlReporter htmlReport;
    public static ExtentReports extent;

    public static ExtentReports getReportInstance(){
        if (extent == null)
        {
            String timeStamp = new SimpleDateFormat("yy.MM.dd.HH.mm.ss").format(new Date());
            String reportName = "Test-Report-"+timeStamp+".html";
            htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/projExtentReport/reports/" + reportName);

            // attach the report to extent object variable
            extent = new ExtentReports();
            extent.attachReporter(htmlReport);

            extent.setSystemInfo("hostname", "localhost");
            extent.setSystemInfo("environment", "Demo");
            extent.setSystemInfo("user", "aduong");;

            htmlReport.config().setDocumentTitle("shoppingWeb Demo");
            htmlReport.config().setReportName("shoppingWeb Automation Test Report");
            htmlReport.config().setTheme(Theme.DARK);
        }
        return extent;
    }


}
