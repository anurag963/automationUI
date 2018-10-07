package testPkg1;

import com.app.driverControls.BaseClass;
import com.app.pageFactory.IndexPage;
import com.app.pageFactory.MyAccountPage;
import com.app.pageFactory.SignInPage;
import org.testng.annotations.Test;

public class SignInTest extends BaseClass {
    IndexPage indexPage= new IndexPage();
    SignInPage signInPage= new SignInPage();
    MyAccountPage myAccountPage= new MyAccountPage();

    @Test
    public void signInTest1(){

        indexPage.clickSignInBtn();
        signInPage.enterUserName(propertiesData.getProperty("username"));
        signInPage.enterPassword(propertiesData.getProperty("password"));
        signInPage.clickOnSignBtn();
        myAccountPage.validateHeaderOFMyAccountPage("MY ACCOUNT");
        System.out.print("tset");
    }
}
