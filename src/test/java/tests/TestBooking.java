package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TestBooking {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        // driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void testAddBooking() {
        driver.get("http://hotel-test.equalexperts.io/");
        driver.findElement(By.id("firstname")).sendKeys("One");
        driver.findElement(By.id("lastname")).sendKeys("Automation");
        driver.findElement(By.id("totalprice")).sendKeys("93.50");

        // Select from drop down list
        WebElement depositDropDown = driver.findElement(By.id("depositpaid"));
        Select depositPaid = new Select(depositDropDown);
        depositPaid.selectByVisibleText("false");

        driver.findElement(By.id("checkin")).sendKeys("2019-09-18");
        driver.findElement(By.id("checkout")).sendKeys("2019-09-21");
        // driver.findElement(By.xpath("//div[@id='form']/div[@class='row']//input[@value=' Save ']")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-out'])[1]/following::input[6]")).click();
        // driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testDeleteBooking() {
        driver.get("http://hotel-test.equalexperts.io/");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Check-out'])[1]/following::input[1]")).click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
