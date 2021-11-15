package com.qa.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	ExtentHtmlReporter HtmlReporter;
	ExtentReports xReport;
	ExtentTest logger;
	
	
	
	
	public void onStart(ITestContext testContext) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+".html";
		
		
		
		HtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		HtmlReporter.config().setDocumentTitle("Test Automation");
		HtmlReporter.config().setReportName("Functional Test automation report");
		HtmlReporter.config().setTheme(Theme.DARK);
		HtmlReporter.config().setAutoCreateRelativePathMedia(true);
		
		xReport = new ExtentReports();
		xReport.attachReporter(HtmlReporter);
		xReport.setSystemInfo("QA name", "Jyothi");
			
		
	}


	

	public void onTestSuccess(ITestResult tr) {
		
		logger = xReport.createTest(tr.getName()); // create an entry into extent report...
		

	}


	public void onTestFailure(ITestResult tr) {
		logger = xReport.createTest(tr.getName());

	}


	public void onTestSkipped(ITestResult tr) {
		logger = xReport.createTest(tr.getName());

	}
	
	public void onFinish(ITestContext testContext) {
		xReport.flush();

	}


}
