package seleniuMe;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static seleniuMe.ExampleZero.driver;

public class Way2Automation {

    @BeforeClass
    public static void openPlayground() {

        System.setProperty("webdriver.gecko.driver", "I:\\gecko\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("http://way2automation.com/way2auto_jquery/index.php");
        login();

    }

    private static void register()
    {
        driver.findElement(By.name("name")).sendKeys("name");
        driver.findElement(By.name("phone")).sendKeys("545");
        driver.findElement(By.name("email")).sendKeys("k@g.c");
        driver.findElement(By.name("city")).sendKeys("A");
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/fieldset[6]/input")).sendKeys("k");
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/fieldset[7]/input")).sendKeys("p");
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/div/div[2]/input")).click();
    }

    private static void login()
    {
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/div/div[1]/p/a")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/fieldset[1]/input"))
                .sendKeys("k");
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/fieldset[2]/input"))
                .sendKeys("p");
        driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/div/div[2]/input")).click();
    }

    @Test
    public void dragBox()
    {
        driver.findElement(By.xpath("//a[@href='draggable.php']/figure")).click();
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        WebElement draggableBox = driver.findElement(By.id("draggable"));

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(draggableBox, 100, 20);
        Action drag = builder.build();
        drag.perform();
    }

    @Test
    public void checkTabs()
    {
        driver.findElement(By.xpath("//a[@href='tabs.php']/figure")).click();
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        WebElement tab1 = driver.findElement(By.xpath("/html/body/div/ul/li[1]"));
        WebElement tab2 = driver.findElement(By.xpath("/html/body/div/ul/li[2]"));
        WebElement tab3 = driver.findElement(By.xpath("/html/body/div/ul/li[3]"));

        tab2.click();
        tab3.click();
        tab1.click();
    }

    @Test
    public void pickDate()
    {
        driver.findElement(By.xpath("//a[@href='datepicker.php']/figure")).click();
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr[4]/td[2]/a")).click();
        assertEquals(datePicker.getAttribute("value"), "06/18/2018");
    }

    @Test
    public void useSlider()
    {
        driver.findElement(By.xpath("//a[@href='slider.php']/figure")).click();
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));



    }

}
