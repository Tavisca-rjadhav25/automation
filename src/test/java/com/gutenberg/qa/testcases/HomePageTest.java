package com.gutenberg.qa.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
		
		
	}
	
	
	@Test(priority = 1)
	//verify add category button is clickable
	public void verifyAddCategoryButtonIsClickable() {
		hp.clickOnAddCategoryButton();
		
	}
	
	
	@Test(priority = 2)
	//verify category is getting added
	public void verifyCategoryGetAdded() {
		hp.addCategory();
		hp.clickOnCreateCategoryButton();
		Assert.assertTrue(hp.isElementDisplayed(hp.categorySuccessMessage));
	}
	
	@Test(priority = 3)
	//verify category is getting updated
	public void verifyCategoryIsUpdated() {
		hp.updateCategory();
		Assert.assertTrue(hp.getElement(hp.header).contains("GUTENBERG"));
	}
	
	@Test(priority = 4)
	//verify category is getting deleted
	public void verifyCategoryIsDeleted() {
		hp.deleteCategory();
	}
	
	@Test(priority = 5)
	//verify project is getting updated
	public void verifyProjectIsUpdated() throws InterruptedException {
		hp.updateProject();
		Thread.sleep(3000);
		Assert.assertTrue(hp.getElement(hp.header).contains("GUTENBERG"));
	}
	
	@Test(priority = 6)
	//verify project is getting deleted
	public void verifyProjectIsDeleted() {
		hp.deleteProject();
		Assert.assertTrue(hp.isElementDisplayed(hp.projectDeleteMessage));
	}
	
	
	@Test(priority = 7)
	//verify Search Icon Is Clickable
	public void verifySearchIconIsClickable() {
		hp.clickOnSearchIcon();
		
	}
	
	@Test(priority = 8)
	//verify search functionality
	public void verifySearch() {
		hp.enterTextInSearch();
	}
	
	@Test(priority = 9)
	//verify search functionality
	public void verifyClickOnListView() {
		hp.clickListViewIcon();
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Open project')]")).getText().contains("Open project"));
	}
	
	
	
	
	
	
	
	
}
