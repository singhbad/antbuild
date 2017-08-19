package MyQa;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ValidLogin {
	public static void main(String[] args) throws WebDriverException{
	System.setProperty(
            "webdriver.chrome.driver",
            "C://Badal5//chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait=new WebDriverWait(driver, 20);
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://mail.google.com"); 
	String username="seleniumantjar@gmail.com";
	String password="Ponds123";
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
	driver.findElement(By.id("identifierId")).sendKeys("seleniumantjara@gmail.com");

	String usern=driver.findElement(By.id("identifierId")).getAttribute("value");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='identifierNext']/content/span")));
	driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
	if(usern!=username){
		
	  
		System.out.println("Wrong UserName"); 

		
	
	}
	driver.findElement(By.id("identifierId")).clear();
	driver.findElement(By.id("identifierId")).sendKeys("seleniumantjar@gmail.com");
	//String a="//*[@id='identifierNext']/content";
	String b="//*[@id='identifierNext']/content/span";
	//driver.findElement(By.xpath(a)).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(b)));
	driver.findElement(By.xpath(b)).click();
	driver.findElement(By.name("password")).sendKeys("Ponds1234");
	String passwordwrong=driver.findElement(By.name("password")).getAttribute("value");
	if(passwordwrong!=password){
		System.out.println("Inside password");
		  
		System.out.println("Wrong Password");
	}
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys("Ponds123");
	driver.findElement(By.xpath("//*[@id='passwordNext']/content")).click();
	System.out.println("Logged In succesfully"); 

	driver.close();
	driver.quit();
	}
}

	
