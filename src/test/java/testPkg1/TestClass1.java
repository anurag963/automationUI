package testPkg1;

import com.app.driverControlsLibrary.BaseClass;
import com.app.pageLibrary.IndexPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestClass1{

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public  void beforeClass(){
        htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.setAppendExisting(true);
    }

    @Test
    public void test1(){
        test = extent.createTest("MyFirstTest1", "Test Description1");
        System.out.println("Test1 ");
        test.log(Status.INFO, "test 1");
    }

    @Test
    public void test2(){

        test = extent.createTest("MyFirstTest2", "Test Description2");
        System.out.println("Test2 ");
        test.log(Status.INFO, "test 2");
        Assert.assertEquals("Gooooogle", "a");

    }

    @AfterClass
    public  void afterClass(){
        extent.flush();

    }

}
