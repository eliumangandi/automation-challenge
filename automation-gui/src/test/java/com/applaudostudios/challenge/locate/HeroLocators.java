package com.applaudostudios.challenge.locate;

import com.applaudostudios.challenge.utils.HeroActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
   This class enables to use selenium
   @author: Yonatan E Juarez
   @version: 09/29/2021
 */
public class HeroLocators extends HeroActions {

    public HeroLocators(WebDriver driver) {
        super(driver);
    }

    public void goToLink(String linkName){
        this.clickOnLink("//a[text()='"+linkName+"']");
    }

    public boolean AddItem(){
        this.clickOnLink("//button[text()='Add Element']");
        return true;
    }

    public boolean DeleteItems(){
        List<WebElement> items = driver.findElements(By.xpath("//button[text()='Delete']"));
        if(items.size()==0){
            return false;
        }
        for (WebElement element:items) {
            element.click();
        }
        return true;
    }

    public boolean rightClick(){
        WebElement element = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        this.rightClickOnElement(element);
        driver.switchTo().alert().accept();
        return true;
    }

    public String checkLinkUrl(String linkText){
        this.clickOnLink("//a[text()='"+linkText+"']");
        return driver.getCurrentUrl();
    }

    public String authForm(String user, String pass){
        WebElement userName = driver.findElement(By.id("username"));
        WebElement userPass = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.className("radius"));

        this.typeText(userName,user);
        this.typeText(userPass,pass);
        submitBtn.click();

        WebElement message = driver.findElement(By.id("flash"));

        return message.getText();
    }

    public boolean openWindow(){
        this.clickOnLink("//a[text()='Click Here']");
        return true;
    }

    public boolean closeWindows(){
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        if(windows.size() == 1){
            return false;
        }
        Iterator<String> i = windows.iterator();
        i.next();
        while (i.hasNext()){
            String actual = i.next();
            driver.switchTo().window(actual);
            driver.close();
        }
        driver.switchTo().window(mainWindow);
        return true;
    }

    public String sliderValue(){
        WebElement element = driver.findElement(By.xpath("//*[@type='range']"));
        this.dragSlider(element);
        System.out.println();
        return element.getAttribute("value");
    }

}
