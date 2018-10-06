package testPkg1;

import com.app.driverControls.BaseClass;
import com.app.driverControls.SetValue;
import com.app.pageFactory.IndexPage;
import org.testng.annotations.Test;

public class TestClass1 extends BaseClass{

    @Test
    public void test1(){
        IndexPage indexPage= new IndexPage();
        System.out.print("tset");
        indexPage.clickSignInBtn();
        System.out.print("tset");
    }



}
