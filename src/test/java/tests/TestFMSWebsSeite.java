package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.sql.Driver;

public class TestFMSWebsSeite extends TestBase {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Faker fake=new Faker();



    //2) https://www.future-mobility-solutions.com/
    @BeforeMethod
    public void beforeClassMethod(){
        //driver.get("https://www.future-mobility-solutions.com/");
        driver.navigate().to("https://www.future-mobility-solutions.com/");
    }
    @Test
    public void test01_Bewerbung() throws NullPointerException, InterruptedException {

        //driver.get("https://www.future-mobility-solutions.com/");
        driver.findElement(By.xpath("//rs-layer[@id='slider-4-slide-4-layer-24']")).click();//bewerbung web element
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='uc-btn-accept-banner']")).click();//cookie web element
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Berufserfahrene']")).click();//berufserfahrene web element
/*
           try {
               js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
           } catch (Exception NullPointerException) {
               NullPointerException.printStackTrace();
           }

 */

       Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[text()='Weiterlesen'])[14]")).click();//software tester web element
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='ubtn-data ubtn-text '])[1]")).click();//online bewerben


    }
    @Test
    public void test02_Kontakt() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='uc-btn-accept-banner']")).click();//cookie web element
        Thread.sleep(2000);
        WebElement kontakt=driver.findElement(By.xpath("(//*[text()='Kontakt'])[1]"));
        kontakt.click();
        Thread.sleep(2000);
        WebElement name=driver.findElement(By.xpath("//*[@placeholder='Name*']"));
        name.sendKeys(fake.name().fullName());
        Thread.sleep(2000);
        WebElement email=driver.findElement(By.xpath("//*[@placeholder='E-Mail-Adresse*']"));
        email.sendKeys(fake.internet().emailAddress());
        Thread.sleep(2000);
        WebElement telNumber=driver.findElement(By.xpath("//*[@placeholder='Telefonnummer']"));
        telNumber.sendKeys(fake.phoneNumber().cellPhone());
        Thread.sleep(2000);
        WebElement message=driver.findElement(By.xpath("//*[@placeholder='Freitextfeld*']"));
        message.sendKeys("calm down only a trying:)))");
        Thread.sleep(2000);
        WebElement checkbox=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        checkbox.click();
        WebElement question=driver.findElement(By.xpath("//*[@name='random-math-quiz']"));
        question.click();
        question.sendKeys("3");
        WebElement submit=driver.findElement(By.xpath("(//*[@type='submit'])[1]"));
        submit.submit();






    }



}






