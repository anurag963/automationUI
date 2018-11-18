package testPkg1;

import com.app.driverControlsLibrary.BaseClass;
import com.app.pageLibrary.IndexPage;
import com.app.pageLibrary.MyAccountPage;
import com.app.pageLibrary.SignInPage;
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
