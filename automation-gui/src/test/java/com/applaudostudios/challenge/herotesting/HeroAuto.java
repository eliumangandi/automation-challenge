package com.applaudostudios.challenge.herotesting;

import com.applaudostudios.challenge.utils.HeroDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

/*
   This class enables to use testng
   @author: Yonatan E Juarez
   @version: 09/29/2021
 */
public class HeroAuto extends HeroDriver {

    @Test(priority=0)
    public void addRemove(){
        heroLocators.goToLink("Add/Remove Elements");
        for (int i = 0; i < 9; i++) {
            Assert.assertEquals(heroLocators.AddItem(), true, "Item Added");
        }
        Assert.assertEquals(heroLocators.DeleteItems(), true, "Items Deleted");
    }

    @Test(priority=5)
    public void contextMenu(){
        heroLocators.goToLink("Context Menu");
        Assert.assertEquals(heroLocators.rightClick(), true, "Close Alert");
    }

    @Test(priority=1)
    public void floatingMenu(){
        heroLocators.goToLink("Floating Menu");
        Assert.assertEquals(heroLocators.checkLinkUrl("Home"),
                                                "https://the-internet.herokuapp.com/floating_menu#home");
        Assert.assertEquals(heroLocators.checkLinkUrl("News"),
                                                "https://the-internet.herokuapp.com/floating_menu#news");
        Assert.assertEquals(heroLocators.checkLinkUrl("Contact"),
                                                "https://the-internet.herokuapp.com/floating_menu#contact");
        Assert.assertEquals(heroLocators.checkLinkUrl("About"),
                                                "https://the-internet.herokuapp.com/floating_menu#about");
    }

    @Test(priority=2)
    public void formAuth(){
        heroLocators.goToLink("Form Authentication");
        Assert.assertEquals(heroLocators.authForm("tomsmithh","SuperSecretPassword!"),
                                                "Your username is invalid!\n×");
        Assert.assertEquals(heroLocators.authForm("tomsmith","SuperSecretPassword"),
                                                "Your password is invalid!\n×");
        Assert.assertEquals(heroLocators.authForm("tomsmith","SuperSecretPassword!"),
                                                "You logged into a secure area!\n×");
    }

    @Test(priority=3)
    public void multipleWindows(){
        heroLocators.goToLink("Multiple Windows");
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(heroLocators.openWindow(), true, "Opening Window");
        }
        Assert.assertEquals(heroLocators.closeWindows(), true, "Closing Windows");
    }

    @Test(priority=4)
    public void horizontalSlider(){
        heroLocators.goToLink("Horizontal Slider");
        Assert.assertEquals(heroLocators.sliderValue(), "4.5");
    }

}
