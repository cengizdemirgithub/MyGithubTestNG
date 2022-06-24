package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test03 extends TestBase {
    //1 ) Bir Class olustur : NegativeTest
    //2) Bir test method olustur NegativeLoginTest()
    //https://www.hotelmycamp.com/ adresine git
    //login butonuna bas
    //test data username: manager1 ,
    //test data password : manager1!
    //Degerleri girildiginde sayfaya girilemedigini test et
    @Test
    public void negativeTest001(){
        driver.get("https://www.hotelmycamp.com/ ");
        WebElement loginButton=driver.findElement(By.xpath("//*[text()='Log in']"));
        loginButton.click();
    }
}
