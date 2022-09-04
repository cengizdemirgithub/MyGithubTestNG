package tests;

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



    //2) https://www.future-mobility-solutions.com/
    @BeforeMethod
    public void beforeClassMethod(){
        //driver.get("https://www.future-mobility-solutions.com/");
        driver.navigate().to("https://www.future-mobility-solutions.com/");
    }
    @Test
    public void test01_Bewerbung() throws InterruptedException {

        //driver.get("https://www.future-mobility-solutions.com/");
        driver.findElement(By.xpath("//rs-layer[@id='slider-4-slide-4-layer-24']")).click();//bewerbung web element
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='uc-btn-accept-banner']")).click();//cookie web element
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Berufserfahrene']")).click();//berufserfahrene web element

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[text()='Weiterlesen'])[14]")).click();//software tester web element
        driver.findElement(By.xpath("(//*[@class='ubtn-data ubtn-text '])[1]")).click();//online bewerben


    }



}






