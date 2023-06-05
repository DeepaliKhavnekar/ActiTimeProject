package com.Actitime.Testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.TaskPage;

public class CreateCustomer extends Baseclass {

	@Test
	public void createcustomer() throws EncryptedDocumentException, IOException {
		HomePage hp= new HomePage(dr);
		hp.getTasktab().click();
		TaskPage tp= new TaskPage(dr);
		tp.getAddnew().click();
		tp.getNewcust().click();
		FileLibrary fl=new FileLibrary();
		String customer = fl.readdatafromExcel("Sheet1", 4, 1);
		tp.getCustname().sendKeys(customer);
		 String descrip = fl.readdatafromExcel("Sheet1", 4, 2);
		tp.getCustdesc().sendKeys(descrip);
		tp.getCreatebtn().click();
		String expectedresult = customer;
		String actualresult = dr.findElement(By.xpath("//div[.='"+customer+"']")).getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(actualresult, expectedresult);
		
		
	}
}
