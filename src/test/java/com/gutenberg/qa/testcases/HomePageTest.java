package com.gutenberg.qa.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;


import com.gutenberg.qa.base.base;
import com.gutenberg.qa.pages.HomePage;


public class HomePageTest extends base{
	
	HomePage hp;
	
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeTest
	// Launch browser & load site
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Launch the Gutenberg Website
		driver.get(prop.getProperty("URL"));
		
		hp= new HomePage();
		hp.addUsername();
		hp.addPass();
		hp.clickSubmit();
		//hp.clickOnSendPush();
		
	}
	
	
	@Test(priority = 1)
	//verify add category button is clickable
	public void verifyAddCategoryButtonIsClickable() throws IOException {
		HomePage hp = new HomePage();
		hp.clickOnAddCategoryButton();
	}
	
	@Test(priority = 2)
	//verify category is getting added
	public void verifyCategoryGetAdded() throws IOException {
		HomePage hp = new HomePage();
		hp.addCategory();
		hp.clickOnCreateCategoryButton();
	}
	
	/*@Test(priority = 3)
	//verify cancel button is clickable while adding category
	public void verifyCancelCategoryButtonIsClickable() throws IOException {
		HomePage hp = new HomePage();
		
		hp.clickOnCancelCategoryButton();
	}
	
	@Test(priority = 4)
	//verify create category button is clickable
	public void verifyCreateCategoryButtonIsClickable() throws IOException {
		HomePage hp = new HomePage();
		
		hp.clickOnCreateCategoryButton();
	}*/

}
