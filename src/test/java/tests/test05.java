package tests;

import org.junit.Test;
import utilities.TestBase;

import java.sql.Driver;

public class test05 extends TestBase {
    @Test
    public void testCase01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //driver.get("http://automationexercise.com");
        try {
            driver.navigate().to("http://automationexercise.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3. Verify that home page is visible successfully
        //4. Scroll down page to bottom
        //5. Verify 'SUBSCRIPTION' is visible
        //6. Click on arrow at bottom right side to move upward
        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
    }
}