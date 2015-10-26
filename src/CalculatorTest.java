import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class CalculatorTest {
	private static WebDriver driver;
	private static Actions action;
	private static WebDriverWait wait;

	
	@BeforeClass
	public static void classSetup(){
		
	}
	
	@Before
	public void setUp() throws Exception{
	
       
		System.setProperty("webdriver.chrome.driver", "chrome//chromedriver");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 5);
		driver.get("http://web2.0calc.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
	@Test
	public void calTest () throws Exception{
		
	//Multiplication
		WebElement multiplication = driver.findElement(By.id("input"));
		multiplication.sendKeys("423*525");
		action.sendKeys(driver.findElement(By.id("BtnCalc")),Keys.ENTER).build().perform();
		String result = driver.findElement(By.xpath("//input[@value='']")).getText();
		Assert.assertEquals(result, 222075, 222075);
		
		action.sendKeys(driver.findElement(By.xpath("//button[@id='BtnClear']")),Keys.ENTER).build().perform();

//		//Division
		WebElement division = driver.findElement(By.id("input"));
		division.sendKeys("4000/200");
		action.sendKeys(driver.findElement(By.id("BtnCalc")),Keys.ENTER).build().perform();
		String secondResult = driver.findElement(By.xpath("//input[@value='']")).getText();
		Assert.assertEquals(secondResult, 20, 20);
		action.sendKeys(driver.findElement(By.xpath("//button[@id='BtnClear']")),Keys.ENTER).build().perform();
//	
//		//Subtraction
		WebElement subtraction = driver.findElement(By.id("input"));
		subtraction.sendKeys("-23094823 -234823 ");
		action.sendKeys(driver.findElement(By.id("BtnCalc")),Keys.ENTER).build().perform();
		String thirdResult =  driver.findElement(By.xpath("//input[@value='']")).getText();
		Assert.assertEquals(thirdResult, 23329646, 23329646);
		action.sendKeys(driver.findElement(By.xpath("//button[@id='BtnClear']")),Keys.ENTER).build().perform();
//	
//	
//		//Addition
		WebElement addition = driver.findElement(By.id("input"));
		addition.sendKeys("-234234+345345");
		action.sendKeys(driver.findElement(By.id("BtnCalc")),Keys.ENTER).build().perform();
		String fourthString = driver.findElement(By.xpath("//input[@value='']")).getText();
		Assert.assertEquals(fourthString, 111111, 111111);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id= 'BtnClear']")));
		action.sendKeys(driver.findElement(By.xpath("//button[@id = 'BtnClear']")), Keys.ENTER).build().perform();
		
}
	@After 
	public void cleanUp () throws Exception{
		driver.close();
	}

}
