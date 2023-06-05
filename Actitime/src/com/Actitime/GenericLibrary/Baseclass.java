package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.LoginPage;

public class Baseclass {
	FileLibrary fl = new FileLibrary();
	public static WebDriver dr;
	@BeforeSuite
	public void databaseconnection()
	{
		Reporter.log("database connected", true);
	}
	@BeforeClass
	public void LaunchBrowser() throws IOException
	{
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String actitimeurl = fl.readdatafrompropertyFile("url");
		dr.get(actitimeurl);
		Reporter.log("Browser Launched", true);
	}
	@BeforeMethod
	public void Login() throws IOException
	{
//		dr.findElement(By.id("username")).sendKeys("admin");
//		dr.findElement(By.name("pwd")).sendKeys("manager");
//		dr.findElement(By.xpath("//div[.='Login ']")).click();
		
		LoginPage lp= new LoginPage(dr);
		String un = fl.readdatafrompropertyFile("username");
		String pw = fl.readdatafrompropertyFile("password");
		lp.getUntbx().sendKeys(un);
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		Reporter.log("Logged in to Actitime", true);
	}
	@AfterMethod
	public void Logout()
	{
//		dr.findElement(By.id("logoutLink")).click();
		HomePage hp= new HomePage(dr);
		hp.getLgoutlink().click();
		Reporter.log("Logged out successfully", true);
	}
	@AfterClass
	public void CloseBrowser()
	{
		dr.close();
		Reporter.log("Browser Closed", true);
	}
	@AfterSuite
	public void databasedisconnection() 
	{
		Reporter.log("Database disconnected",true);
	}
}












