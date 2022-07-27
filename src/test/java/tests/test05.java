package tests;

import org.junit.Test;
import utilities.TestBase;

import java.sql.Driver;

public class test05 extends TestBase {
    @Test
    public void testCase01() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'



        //foo(null);
        try {
            driver.get("http://automationexercise.com");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!");
            if(obj == null) {
                // Do something
            } else {
                // Do something else
            }

        }


        //3. Verify that home page is visible successfully
        //4. Scroll down page to bottom
        //5. Verify 'SUBSCRIPTION' is visible
        //6. Click on arrow at bottom right side to move upward
        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
    }
    public <driver> void doSomething(driver obj) {
        if(obj == null) {
            // Do something
        } else {
            // Do something else
        }
    }
}