import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void canCreateContact() {
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(958, 680));
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("first name");
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys("last name");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("address test");
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).sendKeys("phone test 123");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("email@example.com");
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        driver.findElement(By.linkText("home page")).click();
        driver.findElement(By.linkText("Logout")).click();
    }
}
