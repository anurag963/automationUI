package testPkg1;

import com.app.driverControlsLibrary.BaseClass;
import com.app.pageLibrary.IndexPage;
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
