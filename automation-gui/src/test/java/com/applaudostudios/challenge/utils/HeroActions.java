package com.applaudostudios.challenge.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
   This class enables to use selenium
   @author: Yonatan E Juarez
   @version: 09/29/2021
 */
public class HeroActions {

    public WebDriver driver;

    public HeroActions(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLink(String visibleText){
        WebElement element = driver.findElement(By.xpath(visibleText));
        element.click();
    }

    public void rightClickOnElement(WebElement element){
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
    }

    public void typeText(WebElement element, String keys){
        element.sendKeys(keys);
    }

    public void dragSlider(WebElement element){
        Actions action = new Actions(driver);
        action.dragAndDropBy(element,50,0).perform();
    }

}
