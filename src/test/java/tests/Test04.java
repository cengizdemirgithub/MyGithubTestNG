package tests;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Random;

//import static jdk.nashorn.internal.runtime.PropertyHashMap.findElement;
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

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.id("days")).click();
        select.selectByVisibleText("5");
        driver.findElement(By.id("days")).click();
        driver.findElement(By.id("months")).click();
        Select select_month = new Select(driver.findElement(By.id("months")));
        driver.findElement(By.id("months")).click();
        select_month.selectByVisibleText("September");
        driver.findElement(By.id("months")).click();
        driver.findElement(By.id("years")).click();
        Select select_years = new Select(driver.findElement(By.id("years")));
        select_years.selectByIndex(5);
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("first_name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("last_name")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.id("country")).click();
        Select select_country = new Select(driver.findElement(By.id("country")));
        select_country.selectByIndex(2);
        driver.findElement(By.id("state")).sendKeys(faker.address().state());
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        driver.findElement(By.id("zipcode")).sendKeys(faker.address().zipCode());
        driver.findElement(By.id("mobile_number")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();





        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountCreated = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();


        //11. Verify ' Logged in as username' at top
        WebElement asLoggedIn = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(asLoggedIn.isDisplayed());

        //12.Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();
        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();
        //14. Verify Address Details and Review Your Order
        WebElement deliveryAdress=driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[2]"));
        WebElement billingyAdress=driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[5]"));
        Assert.assertTrue(deliveryAdress.getText().equals(billingyAdress.getText()));


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
