package tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Random;

import static org.bouncycastle.cms.RecipientId.password;

public class Test04 extends TestBase {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(driver.getTitle().contains("Automation"));

        //4. Add products to cart
        WebElement product1 = driver.findElement(By.xpath("//*[@data-product-id='1']"));
        product1.click();

        //5. Click 'Cart' button
        WebElement contuniueShopping = driver.findElement(By.xpath("//*[text()='Continue Shopping']"));
        contuniueShopping.click();
        WebElement chart1 = driver.findElement(By.xpath("//*[text()=' Cart']"));
        chart1.click();
        //6. Verify that cart page is displayed
        String cartPage = "https://automationexercise.com/view_cart";
        Assert.assertTrue(driver.getCurrentUrl().equals(cartPage));
        //7. Click Proceed To Checkout
        WebElement checkout = driver.findElement(By.xpath("//*[text()='Proceed To Checkout']"));
        checkout.click();
        //8. Click 'Register / Login' button
        WebElement register = driver.findElement(By.xpath("(//a[@href='/login'])[2]"));
        register.click();

        //9. Fill all details in Signup and create account
        Faker faker = new Faker();
        // WebElement eMail=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
        //  eMail.sendKeys(faker.internet().emailAddress());
        // WebElement password=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
        //  password.sendKeys(faker.internet().password());
        WebElement name = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        name.sendKeys(faker.name().fullName());
        WebElement eMail2 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        eMail2.sendKeys(faker.internet().emailAddress());
        WebElement signUpTest = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        signUpTest.sendKeys(Keys.ENTER);
        WebElement gender = driver.findElement(By.id("id_gender1"));
        gender.click();
        WebElement gender2 = driver.findElement(By.id("id_gender2"));
        gender2.click();
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(faker.internet().password());
        Select select = new Select(driver.findElement(By.id("days")));
        Random random = new Random();

        select.selectByVisibleText(random.ints().toString());
        driver.findElement(By.id("days")).click();


        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button

        //11. Verify ' Logged in as username' at top
        //12.Click 'Cart' button
        //13. Click 'Proceed To Checkout' button
        //14. Verify Address Details and Review Your Order
        //15. Enter description in comment text area and click 'Place Order'
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //17. Click 'Pay and Confirm Order' button
        //18. Verify success message 'Your order has been placed successfully!'
        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        //20. Click 'Continue' button
        //21. Click 'Delete Account' button
        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
