package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreatingContactPerson {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();

        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Контрагенты']"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//a/span[text()='Контактные лица']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pull-left btn-group icons-holder']")));
        driver.findElement(By.xpath("//div[@class='pull-left btn-group icons-holder']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/input[@name='crm_contact[lastName]']")));
        driver.findElement(By.xpath("//div/input[@name='crm_contact[lastName]']")).sendKeys("Aбраменко");
        driver.findElement(By.xpath("//div/input[@name='crm_contact[firstName]']")).sendKeys("Ольга");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='«Все организации»']")));
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='crm_contact[jobTitle]']")));
        driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']")).sendKeys("Тестировщик");
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
    }
}
