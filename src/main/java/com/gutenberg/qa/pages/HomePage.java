package com.gutenberg.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gutenberg.qa.base.base;
import com.gutenberg.qa.utils.Utils;

public class HomePage extends base {
	
	By username = By.id("userNameInput");
	By pass = By.id("passwordInput");
	By submit = By.id("submitButton");
	By sendpush = By.xpath("//button[contains(text(),'Send Me a Push ')]");
	By addproject = By.xpath("//button[contains(text(),'Add project')]");
	By addcategory = By.xpath("//button[contains(text(),'Add category')]");
	By categoryname = By.xpath("//input[@id='category-name']");
	By cancel = By.xpath("//button[contains(text(),'Cancel')]");
	By createcategory = By.xpath("//button[contains(text(),'Create category')]");

	WebDriverWait wait;
	
	public void addUsername() {
		driver.findElement(username).sendKeys("rjadhav1@affinionds.com");
	}
	
	public void addPass() {
		driver.findElement(pass).sendKeys("R@sika2541998");
	}
	
	public void clickSubmit() {
		driver.findElement(submit).click();
	}
	
	public void clickOnSendPush() {
		driver.findElement(sendpush).click();
	}
	
	public void clickOnAddProjectButton() {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addproject)).click();
		//driver.findElement(addproject).click();
	}
	
	
	public void clickOnAddCategoryButton() {
		driver.findElement(addcategory).click();
	}
	
	public void addCategory() {
		driver.findElement(categoryname).sendKeys(Utils.getRandomText());
	}
	
	
	public void clickOnCancelCategoryButton() {
		driver.findElement(cancel).click();
	}
	
	
	
	public void clickOnCreateCategoryButton() {
		driver.findElement(createcategory).click();
	}
	
	
	
	
	
	
	
	
	}
