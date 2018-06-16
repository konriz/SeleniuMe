package seleniuMe;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.*;

public class ExampleZero {

    public static WebDriver driver;

    @BeforeClass
    public static void openPlayground() {

        driver = new FirefoxDriver();
        driver.navigate().to("http://timvroom.com/selenium/playground/");

    }

    @Test
    public void case01()
    {
        String pageTitle = driver.getTitle();
        final WebElement answer1 = driver.findElement(By.id("answer1"));
        answer1.sendKeys(pageTitle);

        assertTrue(answer1.getAttribute("value").equals(pageTitle));
    }

    @Test
    public void case02()
    {
        final WebElement nameField = driver.findElement(By.id("name"));

        nameField.sendKeys("Kilgore Trout");
        assertTrue(nameField.getAttribute("value").equals("Kilgore Trout"));
    }

    @Test
    public void case03()
    {
        final Select occupationBox = new Select(driver.findElement(By.id("occupation")));
        occupationBox.selectByValue("scifiauthor");

        assertTrue(occupationBox.getFirstSelectedOption().getText().equals("Science Fiction Author"));
    }

    @Test
    public void case04()
    {
        List<WebElement> blueBoxes = driver.findElements(By.className("bluebox"));
        final WebElement answer4 = driver.findElement(By.id("answer4"));
        answer4.sendKeys(Integer.toString(blueBoxes.size()));

        assertTrue(answer4.getAttribute("value").equals(Integer.toString(blueBoxes.size())));
    }

    @Test
    public void case05()
    {
        WebElement link = driver.findElement(By.linkText("click me"));
        link.click();
    }

    @Test
    public void case06()
    {
        final WebElement redBox = driver.findElement(By.id("redbox"));
        final WebElement answer6 = driver.findElement(By.id("answer6"));

        answer6.sendKeys(redBox.getAttribute("class"));

        assertTrue(answer6.getAttribute("value").equals(redBox.getAttribute("class")));
    }

    @Test
    public void case07() {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver)
                    .executeScript("ran_this_js_function()");
        }
    }

    @Test
    public void case08() {
        if (driver instanceof JavascriptExecutor) {
            Object jsReturn = ((JavascriptExecutor) driver)
                    .executeScript("got_return_from_js_function()");

            driver.findElement(By.id("answer8")).sendKeys((String) jsReturn);
        }
    }

    @Test
    public void case09()
    {
        driver.findElement(By.name("wrotebook")).click();
    }

    @Test
    public void case10()
    {
        String redboxText = driver.findElement(By.id("redbox")).getText();
        driver.findElement(By.id("answer10")).sendKeys(redboxText);
    }

    @Test
    public void case11()
    {
        final WebElement orangeBox = driver.findElement(By.id("orangebox"));
        int orangeBoxY = orangeBox.getLocation().y;

        final WebElement greenBox = driver.findElement(By.id("greenbox"));
        int greenBoxY = greenBox.getLocation().y;
        String toPass;
        if(orangeBoxY < greenBoxY)
        {
            toPass = "orange";
        }
        else
        {
            toPass = "green";
        }

        driver.findElement(By.id("answer11")).sendKeys(toPass);
    }

    @Test
    public void case12()
    {
        driver.manage().window().setSize(new Dimension(850, 650));
        assertTrue(driver.manage().window().getSize().equals(new Dimension(850, 650)));

    }

    @Test
    public void case13()
    {
        try
        {
            driver.findElement(By.id("ishere"));
            driver.findElement(By.id("answer13")).sendKeys("yes");
        }
        catch (NoSuchElementException e)
        {
            driver.findElement(By.id("answer13")).sendKeys("no");
        }
    }

    @Test
    public void case14()
    {
        try
        {
            driver.findElement(By.id("purplebox"));
            driver.findElement(By.id("answer14")).sendKeys("yes");
        }
        catch (NoSuchElementException e)
        {
            driver.findElement(By.id("answer14")).sendKeys("no");
        }
    }

    @Test
    public void case15()
    {
        driver.findElement(By.linkText("click then wait")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("click after wait")).click();
    }

    @Test
    public void case16()
    {
        driver.switchTo().alert().accept();
    }

    @Test
    public void case17()
    {
        driver.findElement(By.id("submitbutton")).click();
    }


    @AfterClass
    public static void closeFirefox() throws InterruptedException
    {
//        if(driver != null)
//        {
//            driver.close();
//        }
    }

}
