package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.sql.Driver;

public class Test01 extends TestBase {

    //WebDriver driver=new ChromeDriver();
    //1) Bir class oluşturun: YoutubeAssertions

    //2) http://automationexercise.com adresine gidin
    @BeforeClass
    public void beforeClassMethod(){
        driver.get("http://automationexercise.com");
    }
    @Test
    public void test01() {

        driver.get("http://automationexercise.com");

    }

    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin

    //○ titleTest => Sayfa başlığının “Automation” oldugunu test edin
    @Test
    public void titleTest() {
        driver.get("http://automationexercise.com");
        String title = driver.getTitle();
        System.out.println("title = " + title);
        Assert.assertTrue(title.contains("Automation"));

    }

    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void imageTest() {
        driver.get("http://automationexercise.com");
        WebElement image = driver.findElement(By.xpath("//*[@*='/static/images/home/logo.png']"));
        Assert.assertTrue(image.isDisplayed());
    }
    //○ Signup  'in erisilebilir oldugunu test edin (isEnabled())
   @Test
    public void signUpTest(){
       WebElement signup= driver.findElement(By.xpath("//*[@*='/login']"));
       Assert.assertTrue(signup.isEnabled());

   }
    

    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
}
