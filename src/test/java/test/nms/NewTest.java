package test.nms;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

@Test
public class NewTest {
	
	private WebDriver driver;
	
	@Test(priority=1)
  public void testCase1() {
	  //driver.get("http://172.19.81.202:9090/nms");
	  
	  String title = driver.getTitle();
	  Assert.assertTrue(title.contains("NMS | Dashboard"));
	  Reporter.log("Title is present");
	 	  
  }
  @Test(priority=2)
  public void testCase2(){
	  //driver.get("http://172.19.81.202:9090/");
		  
	  driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li/a/span/b")).click();
	  Reporter.log("click on login button successful");
	  String name = driver.findElement(By.xpath("/html/body/div/div[1]/a")).getText();
	  Assert.assertTrue(name.contains("NMS Portal"));
	  Reporter.log("Test pass");
  }
  @Test(priority=3)
  public void testCase3(){
	  
	  driver.findElement(By.name("username")).sendKeys("Rajath Sharma");
	  Reporter.log("Username entered successfuly");
	  
	  driver.findElement(By.name("password")).sendKeys("admin");
	  Reporter.log("Password entered successfully");
	  
	  driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div[2]/button")).click();
	  Reporter.log("Sign in successfull !!!!");
  }
  @Test(priority=4)
  public void testCase4(){
	  
	 String username = driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[2]/a/span")).getText();
	 Assert.assertTrue(username.contains("Rajath Sharma"));
	 Reporter.log("test pass");
	  
  }
  @Test(priority=5)
  public void testCase5(){
	  
	  driver.findElement(By.xpath("/html/body/div[1]/aside[1]/section/ul/li[7]/a/span")).click();
	  Reporter.log("click on Add Device button successfull");
	  String addDevice = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div[3]/div/div/div/h3")).getText();
	  Assert.assertTrue(addDevice.contains("Add Network Device"));
	  Reporter.log("test pass");
  }
  @Test(priority=6)
  public void testCase6(){
	  driver.findElement(By.xpath("/html/body/div[1]/aside[1]/section/ul/li[8]/a")).click();
	  Reporter.log("click on view device button successful");
	  String viewDevice = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div[4]/div/div/div[1]/h3")).getText();
	  Assert.assertTrue(viewDevice.contains("Network Devices"));
	  Reporter.log("test pass");
	  
  }
  @Test(priority=7)
  public void testCase7(){
	  driver.findElement(By.xpath("/html/body/div[1]/aside[1]/section/ul/li[11]/a/span")).click();
	  Reporter.log("click on Alarms button is successful");
	  //String alarms = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div[5]/div[1]/div/div[2]/div/div[3]/div[1]")).getText();
	  //Assert.assertTrue(alarms.contains("Critical"));
	  //Reporter.log("test pass");
  }
  @Test(priority=8)
  public void testCase8(){
	  driver.findElement(By.xpath("/html/body/div[1]/aside[1]/section/ul/li[8]/a/span")).click();
	  Reporter.log("click on view devices is successful");
	  
	  driver.findElement(By.xpath("/html/body/div[1]/aside[1]/section/ul/li[4]/a/span")).click();
	  Reporter.log("Click on Dashboard button successfull");
	  
	  String dashboard = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[1]/h1")).getText();
	  Assert.assertTrue(dashboard.contains("Dashboard"));
	  Reporter.log("test pass");
	  
	  
  }
  @Test(priority=9)
  public void testCase9(){
	  
	  String dName = "10.22.1.53";
	  
	  driver.findElement(By.xpath("/html/body/div[1]/aside[1]/section/ul/li[7]/a/span")).click();
	  Reporter.log("click on Add Device button successfull");
	  
	  String addDevice = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div[3]/div/div/div/h3")).getText();
	  Assert.assertTrue(addDevice.contains("Add Network Device"));
	  Reporter.log("Add Network Device text present");
	  
	  driver.findElement(By.name("devicename")).sendKeys(dName);
	  Reporter.log("Device name entered successfully");
	  
	  driver.findElement(By.name("ipaddress")).sendKeys("10.22.1.53");
	  Reporter.log("IP address entered successfully");
	  
	  driver.findElement(By.name("portnumber")).sendKeys("8080");
	  Reporter.log("Port entered successfully");
	  
	  driver.findElement(By.name("devicetype")).sendKeys("Cisco Router");
	  Reporter.log("Device type entered successfully");
	  
	  driver.findElement(By.name("reachable"));
	  Reporter.log("Reachable true entered successfully");
	  
	  driver.findElement(By.name("protocol")).sendKeys("SMTP");;
	  Reporter.log("Protocol entered successfully");
	  
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div[3]/div/div/form/div[2]/button")).click();
	  Reporter.log("Added new device successfully !!!!");
	  
	  driver.findElement(By.xpath("/html/body/div[1]/aside[1]/section/ul/li[8]/a")).click();
	  Reporter.log("click on view device button successful");
	  
	  String viewDevice = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div[4]/div/div/div[1]/h3")).getText();
	  Assert.assertTrue(viewDevice.contains("Network Devices"));
	  Reporter.log("text present");
	  
	  WebElement htmltable=driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div[4]/div/div/div[2]/div/div[2]/div/table/tbody"));
	  List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
	  
	  boolean flag = false;
	  for(int rnum=0;rnum<rows.size();rnum++)
	  {
		  String deviceName = rows.get(rnum).findElements(By.tagName("td")).get(0).getText();
		  System.out.println(deviceName + " --" + dName);
		  if(dName.equals(deviceName))
		  {
			  //System.out.println(dName + "=" +deviceName +"\n Test pass");
			  flag = true;
			  break;
		  }
		  else
		  {
			  System.out.println("Test fail");
		  }
		 
	  }
		  
	  if(!flag){
		  driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div[4]/div/div/div[2]/div/div[3]/div[2]/div/ul/li[4]/a")).click();
		  Reporter.log("Click on next button successful");
		  
		  List<WebElement> rows1 = htmltable.findElements(By.tagName("tr"));
		  for(int rnum1=0;rnum1<rows1.size();rnum1++){
			  
			  String deviceName1 = rows1.get(rnum1).findElements(By.tagName("td")).get(0).getText();
			  System.out.println(deviceName1 + " --" + dName);
			  if(dName.equals(deviceName1))
			  {
				  //System.out.println(dName + "=" +deviceName1 + "\n Test pass");
				  flag =true;
				  break;
			  }
			  else
			  {
				  System.out.println("Test fail");
			  }
		  }
	  }
	  
	  if(!flag){
		  Assert.fail("Test case failed ");
	  }
	  
	  
  }
  
  @Test(priority=10)
  public void testCase10(){
	  	  
	  driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[2]/a")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[2]/ul/li/ul/li[2]/a")).click();
	  Reporter.log("Logout successfull");
	
	  
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	// Launch website
      driver.navigate().to("http://172.19.81.202:9090/nms");
      driver.manage().window().maximize();
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
