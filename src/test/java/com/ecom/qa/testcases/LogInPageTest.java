package com.ecom.qa.testcases;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.LoginPage;
import com.ecom.qa.pages.ProductBookPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogInPageTest extends TestBase {

    LoginPage logInPage;

    ProductBookPage productBookPage;

    public LogInPageTest(){
        super();
    }

    @BeforeTest
    public void setUp(){
        initialization();
        logInPage = new LoginPage();

    }

    @Test (priority = 1)
    public void loginPageTitleTest(){

        String title = logInPage.validateLoginPageTitle();
        Assert.assertEquals(title, logInPage.loginPageTitle);
    }

    @Test(priority = 2)
    public void logInLogoImageTest(){
        boolean flag = logInPage.validateLogoImg();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void logInTest(){
        productBookPage = logInPage.login("mail", "password");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
