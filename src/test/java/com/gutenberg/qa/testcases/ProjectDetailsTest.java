package com.gutenberg.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gutenberg.qa.base.base;
import com.gutenberg.qa.pages.HomePage;
import com.gutenberg.qa.pages.ProjectDetails;




public class ProjectDetailsTest extends base{
	
	ProjectDetails pd;
	HomePage hp;
	
	public ProjectDetailsTest() {
		super();
	}
	
	@BeforeTest
	// Launch browser & load site
	public void setup() throws IOException {
		driver = initializeDriver();
		
		 //Launch the Gutenberg Website
		driver.get(prop.getProperty("URL"));
		hp= new HomePage();
		pd= new ProjectDetails();
		hp.addUsername();
		hp.addPass();
		hp.clickSubmit();
	}
	
	@Test(priority = 1)
	// Verify create project button is clickable
	public void verifyCreateProjectButtonIsClickable() {
		hp.clickOnAddProjectButton();
	}

	@Test(priority = 2)
	// Add new category
	public void verifySiteGetAddSuccessfully() {
		
		//add image
		pd.clickOnBrowseButton();
		
		
		// Insert project name
		pd.addpickName();
		
		//pd.selectCategory();
		
		pd.clickMetaData();
		
		// Insert Meta description
		pd.addMetaDataDescription();

		// scroll page down
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Insert Meta Tag
		pd.addMetaTags();
		

		// click on Create Project Button
		pd.clickOnCreateButton();
		
		Assert.assertTrue(hp.getElement(hp.header).contains("GUTENBERG"));
	
	}
	
	
	@Test(priority = 3)
	//To verify cancel button is clickable
	public void verifyCancelButtonIsClickable() {
		hp.clickOnAddProjectButton();
		pd.clickOnCancelButton();
		Assert.assertTrue(hp.getElement(hp.header).contains("GUTENBERG"));
	}
	
	@Test(priority = 4)
	//Add new project without image, meta-description, meta-tags
	public void verifySiteGetAddSuccessfullyWithoutDescription() {
		
		//click on add project button
		hp.clickOnAddProjectButton();
				
		// Insert project name
		pd.addpickName();
				
		
		// scroll page down
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

				
		// click on Create Project Button
		pd.clickOnCreateButton();
		
		Assert.assertTrue(hp.getElement(hp.header).contains("GUTENBERG"));
	}
	
	@Test(priority = 5)
	//To verify back navigation button is clickable
	public void goToHomePage() {
		hp.clickOnAddProjectButton();
		pd.clickOnBackButton();
		Assert.assertTrue(hp.getElement(hp.header).contains("GUTENBERG"));
	}
	
	
}
