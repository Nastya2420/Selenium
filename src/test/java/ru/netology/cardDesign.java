package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class cardDesign {
    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTest() throws InterruptedException {
        driver.get("http://localhost:9999");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        inputs.get(0).sendKeys("Ольга Абрамова");
        inputs.get(1).sendKeys("+79569999999");
        driver.findElement(By.className("")).click();
        driver.findElement(By.tagName("")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.tagName("")).getText().trim();
        Assertions.assertEquals(expected,actual);
    }

}
