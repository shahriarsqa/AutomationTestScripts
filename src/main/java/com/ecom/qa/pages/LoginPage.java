package com.ecom.qa.pages;

import com.ecom.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(id = "j_username")
    WebElement emailOrPhone;

    @FindBy(id = "j_password")
    WebElement password;

    @FindBy(css = "label[for = 'rememberme']")
    WebElement checkInBox;

    @FindBy(css = "form[id='loginForm'] button[type='submit']")
    WebElement logInBtn;

    @FindBy(css = "img[alt='Rokomari.com']")
    WebElement logoImg;

    public String loginPageTitle = "Login To Rokomari | Rokomari.com";

     public LoginPage(){
         PageFactory.initElements(driver, this);
     }

     public String validateLoginPageTitle(){

         return driver.getTitle();
     }

     public boolean validateLogoImg(){

         return logoImg.isDisplayed();
     }

     public ProductBookPage login (String ep, String pw){
         emailOrPhone.sendKeys(ep);
         password.sendKeys(pw);
         logInBtn.click();

         return new ProductBookPage();
     }


}
