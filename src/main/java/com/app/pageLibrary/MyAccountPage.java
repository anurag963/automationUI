package com.app.pageLibrary;

import com.app.driverControlsLibrary.Grab;
import com.app.driverControlsLibrary.Waits;
import org.testng.Assert;

public class MyAccountPage {

    Waits waits= new Waits();
    Grab grab = new Grab();

    public void validateHeaderOFMyAccountPage(String headerExpected){
        waits.waitUntilElementIsDisplayed("myAccountPage_MyAccountHeader");
        String headerActual= grab.grabText("myAccountPage_MyAccountHeader");
        Assert.assertEquals(headerExpected,headerActual );

    }


}
