package ducnv.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestContentHomePage {
    //    https://thinkpro.vn/laptop
    // http://localhost:3000/......
//    https://live.techpanda.org/
    WebDriver driver;

    @BeforeMethod
    public void beforeBefore() {
        driver.manage().deleteAllCookies();
        driver.get("http://localhost:4200/login");
    }

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[1]/div[1]/mat-card[1]/form[1]/mat-form-field[1]/div[1]/div[1]/div[3]/input[1]")).sendKeys("ducnv123");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[1]/div[1]/mat-card[1]/form[1]/mat-form-field[2]/div[1]/div[1]/div[3]/input[1]")).sendKeys("123123");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-login[1]/div[1]/div[1]/div[1]/div[1]/mat-card[1]/form[1]/div[1]/button[1]")).click();
    }

    @Test()
    public void testTitle() {
        String titleHomaPage = driver.getTitle();
        Assert.assertEquals(titleHomaPage, "ThinkPro | Laptop, máy tính xách tay giá tốt nhất Việt Nam");
    }

    @Test
    public void testNameHomeWithNameDetail() {
        String nameHomePage = driver.findElement(By.xpath("//body/main[@id='main']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/h3[1]/a[1]")).getText().trim();
        driver.findElement(By.xpath("//body/main[@id='main']/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/h3[1]/a[1]")).click();
        String nameDetail = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h1[1]")).getText().trim();
        System.out.println(nameHomePage);
        System.out.println(nameDetail);
        Assert.assertEquals(nameDetail, nameHomePage);
    }


    @Test(dataProvider = "dataPrice")
    public void testPrice(String id1, String id2) {
        String nameHomePage = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-user-dashboard[1]/div[1]/div[1]/div[1]/div[2]/app-load-quiz[1]/div[1]/div[1]/div[1]/div["+id1+"]/mat-card[1]/mat-card-header[1]/div[2]/mat-card-title[1]")).getText();
        driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[" + id2 + "]/div[1]/div[1]/div[3]/h3[1]/a[1]")).click();
        String nameDetail = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/strong[1]")).getText();
        Assert.assertEquals(nameDetail, nameHomePage);
        driver.manage().deleteAllCookies();
        driver.navigate().back();
    }

    @DataProvider(name = "dataPrice")
    public Object[][] dataPrice() {
        return new Object[][]{
//                {"1", "1"},
//                {"2", "2"},
//                {"3", "3"},
//                {"4", "4"},
                {"5", "5"},
        };
    }

//    @AfterTest
//    public void afterTest() {
//        driver.close();
//    }


}
