package com.gutenberg.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
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
		pd= new ProjectDetails();
		hp= new HomePage();
		hp.addUsername();
		hp.addPass();
		hp.clickSubmit();
	}
	
	@Test(priority = 1)
	// Verify create project button is clickable
	public void verifyCreateProjectButtonIsClickable() {
		HomePage hp = new HomePage();
		
		hp.clickOnAddProjectButton();
	}

	@Test(priority = 2)
	// Add new site
	public void verifySiteGetAddSuccessfully() {
		
		//add image
		pd.clickOnBrowseButton();
		
		
		// Insert project name
		pd.addpickName();
		
		pd.clickMetaData();
		
		// Insert Meta description
		pd.addMetaDataDescription();

		// scroll page down
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// Insert Meta Tag
		pd.addMetaTags();
		

		// click on Create Project Button
		pd.clickOnCreateButton();

		//Assert.assertTrue(gm.isElementDisplayed(HomePage.successMessage));
	}
	
	
	@Test(priority = 3)
	//To verify cancel button is clickable
	public void verifyCancelButtonIsClickable() throws IOException {
		ProjectDetails pd = new ProjectDetails();
		hp.clickOnAddProjectButton();
		pd.clickOnCancelButton();
	}
	
	/*@Test(priority = 3)
	//To verify browse create is clickable
	public void verifyCreateButtonIsClickable() throws IOException {
		ProjectDetails pd = new ProjectDetails();
		
		pd.clickOnCreateButton();
	}*/
	

}
