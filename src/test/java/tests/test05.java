package tests;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.io.IOException;
import java.sql.Driver;

import static java.awt.SystemColor.window;

public class test05 extends TestBase {
    @Test
    public void testCase01() throws IOException{
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com';
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertFalse(driver.getTitle().isEmpty());
        //4. Scroll down page to bottom
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");

        //5. Verify 'SUBSCRIPTION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Subscription']")).isDisplayed());
        //6. Click on arrow at bottom right side to move upward
        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
    }


}