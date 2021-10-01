package com.applaudostudios.challenge.utils;

import com.applaudostudios.challenge.locate.HeroLocators;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/*
   This class enables to use testng and selenium
   @author: Yonatan E Juarez
   @version: 09/29/2021
 */
public class HeroDriver {


    public static final String URL_WEB = "https://the-internet.herokuapp.com/";
    public WebDriver driver;
    public HeroLocators heroLocators;



    @BeforeClass
    public void initDriver(){
        driver = WebDriverManager.chromedriver().create();

        driver.get(URL_WEB);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        heroLocators = new HeroLocators(driver);

    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }

    @BeforeMethod
    public void goHome(){
     driver.navigate().to(URL_WEB);
    }


}
