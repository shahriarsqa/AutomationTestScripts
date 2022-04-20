package com.ecom.qa.base;

import com.ecom.qa.utill.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/ecom/qa/config/config.properties");
            prop.load(ip);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void initialization(){
        String browser = prop.getProperty("browser");
        if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();

        }
        else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        else if(browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }

        else if(browser.equals("htmlunit")) {
            driver = new HtmlUnitDriver();

        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }
}
