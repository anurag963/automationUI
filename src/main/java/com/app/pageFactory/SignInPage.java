package com.app.pageFactory;

import com.app.driverControls.Click;
import com.app.driverControls.SetValue;
import com.app.driverControls.Waits;

public class SignInPage {

    SetValue setValue= new SetValue();
    Waits waits= new Waits();
    Click click=new Click();

    public void enterUserName(String userName){
        waits.waitUntilElementIsDisplayed("signInPage_EmailTxtBxLogIn");
        setValue.setValueUSingSendKey("signInPage_EmailTxtBxLogIn", userName);
    }

    public void enterPassword(String password){
        waits.waitUntilElementIsDisplayed("signInPage_PasswordTxtBxLogIn");
        setValue.setValueUSingSendKey("signInPage_PasswordTxtBxLogIn", password);
    }

    public void clickOnSignBtn(){
        waits.waitUntilElementIsDisplayed("signInPage_SignInButton");
        click.clickElement("signInPage_SignInButton");
    }




}
