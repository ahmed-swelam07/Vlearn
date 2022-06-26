package search;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchEnrolledCourse {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver;
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver() ;
	  
	  driver.manage().window().maximize();
	  driver.navigate().to("https://vol.vdev.variiance.com");
	  By LoginBtn = By.xpath("//button[@class='Label-btn1']");
	  new WebDriverWait(driver,Duration.ofSeconds(5))
			  .until(ExpectedConditions.elementToBeClickable(LoginBtn));
	  driver.findElement(LoginBtn).click();
	  By UserName = By.xpath("//input[@id='username']");
	  By Password = By.xpath("//input[@id='password']");
//	  By CourseName = By.linkText("صناعة الأفلام");
	  By ViewCoursBtn = By.linkText("view Course");

	  new WebDriverWait(driver,Duration.ofSeconds(5))
	  .until(ExpectedConditions.presenceOfNestedElementsLocatedBy(Password,UserName));
	  driver.findElement(UserName).sendKeys("bundle2@mozej.com",Keys.TAB);
	  driver.findElement(Password).sendKeys("12345678",Keys.ENTER);
	  driver.navigate().to("https://vol.vdev.variiance.com/AllCourses/1");
	  
	  WebElement CourseName1 = driver.findElement(By.linkText("صناعة الأفلام"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CourseName1);
	  Thread.sleep(500);
	  
	  new WebDriverWait(driver,Duration.ofSeconds(5))
	  .until(ExpectedConditions.elementToBeClickable(CourseName1));
	  driver.findElement((By) CourseName1).click();

	  new WebDriverWait(driver,Duration.ofSeconds(5))
	  .until(ExpectedConditions.elementToBeClickable(ViewCoursBtn));
driver.findElement(ViewCoursBtn).click();
	  
	  
	  
	  
	  
	  

  }
}
