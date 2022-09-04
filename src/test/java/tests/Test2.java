package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.sql.DriverManager;

public class Test2 extends TestBase {
    //Page Object Model
    //Class Work
    //PositiveTest
    //1 ) Bir Class olustur : PositiveTest
    //2) Bir test method olustur positiveLoginTest()
    //https://www.hotelmycamp.com/ adresine git
    //login butonuna bas
    //test data username: manager ,
    //test data password : Manager1!
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
    @Test
    public void TC001() {
        driver.get("https://www.hotelmycamp.com/");
        WebElement loginButton = driver.findElement(By.xpath("//*[text()='Log in']"));
        loginButton.click();
        WebElement userName = driver.findElement(By.id("UserName"));
        userName.sendKeys("manager");
        WebElement Password = driver.findElement(By.id("Password"));
        Password.sendKeys("Manager1!");
        WebElement loginSubmit = driver.findElement(By.id("btnSubmit"));
        loginSubmit.click();
        Assert.assertTrue(driver.getTitle().contains("Admin"));

    }
}
