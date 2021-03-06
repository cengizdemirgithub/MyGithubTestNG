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

import java.util.Locale;
import java.util.Random;

//import static jdk.nashorn.internal.runtime.PropertyHashMap.findElement;
import static org.bouncycastle.cms.RecipientId.password;

public class Test04 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(driver.getTitle().contains("Automation"));
        Thread.sleep(300);

        //4. Add products to cart
        WebElement product1 = driver.findElement(By.xpath("//*[@data-product-id='1']"));
        product1.click();
        Thread.sleep(300);

        //5. Click 'Cart' button
        WebElement contuniueShopping = driver.findElement(By.xpath("//*[text()='Continue Shopping']"));
        contuniueShopping.click();
        WebElement chart1 = driver.findElement(By.xpath("//*[text()=' Cart']"));
        chart1.click();
        Thread.sleep(300);
        //6. Verify that cart page is displayed
        String cartPage = "https://automationexercise.com/view_cart";
        Assert.assertTrue(driver.getCurrentUrl().equals(cartPage));
        Thread.sleep(300);
        //7. Click Proceed To Checkout
        WebElement checkout = driver.findElement(By.xpath("//*[text()='Proceed To Checkout']"));
        checkout.click();
        Thread.sleep(300);
        //8. Click 'Register / Login' button
        WebElement register = driver.findElement(By.xpath("(//a[@href='/login'])[2]"));
        register.click();
        Thread.sleep(300);

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
        Thread.sleep(300);


        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountCreated = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        Thread.sleep(300);


        //11. Verify ' Logged in as username' at top
        WebElement asLoggedIn = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(asLoggedIn.isDisplayed());
        Thread.sleep(300);

        //12.Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();
        Thread.sleep(300);
        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();
        //14. Verify Address Details and Review Your Order
        WebElement deliveryAdress = driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[2]"));
        WebElement billingyAdress = driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[5]"));
        Assert.assertTrue(deliveryAdress.getText().equals(billingyAdress.getText()));
        Thread.sleep(300);


        //15. Enter description in comment text area and click 'Place Order'
        WebElement comment = driver.findElement(By.xpath("//*[@class='form-control']"));
        comment.sendKeys(faker.expression("comment"));
        driver.findElement(By.xpath("//*[text()='Place Order']")).click();
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement nameOnCard = driver.findElement(By.xpath("//*[@*='name_on_card']"));
        nameOnCard.sendKeys(faker.name().fullName());
        WebElement cardNumber = driver.findElement(By.xpath("//*[@*='card_number']"));
        cardNumber.sendKeys(faker.number().digits(12));
        WebElement cvc = driver.findElement(By.xpath("//*[@*='cvc']"));
        cvc.sendKeys(faker.number().digits(3));
        WebElement expiryDate = driver.findElement(By.xpath("//*[@*='expiry_month']"));
        expiryDate.sendKeys(faker.random().nextInt(1, 12).toString());
        WebElement expiryYear = driver.findElement(By.xpath("//*[@*='expiry_year']"));
        expiryYear.sendKeys(faker.random().nextInt(2000, 2022).toString());


        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("(//*[@*='submit'])[1]")).click();
        Thread.sleep(300);

        //18. Verify success message 'Your order has been placed successfully!'
        String abc = driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']")).getText();
        System.out.println("abc = " + abc);
       WebElement text = driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']"));
       Assert.assertFalse(text.getText().contains("Your order has been placed successfully!"));

       
        
        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        driver.findElement(By.xpath("//*[text()='Download Invoice']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@*='/download_invoice/500']")).isDisplayed());



        //20. Click 'Continue' button
        driver.findElement(By.xpath("//*[text()='Continue']"));
        //21. Click 'Delete Account' button
        WebElement deleteAccount = driver.findElement(By.xpath("//*[text()=' Delete Account']"));
        deleteAccount.click();
        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='HTTP 405 Method Not Allowed']")).isDisplayed());
    }
}
