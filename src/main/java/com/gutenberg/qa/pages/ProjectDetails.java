package com.gutenberg.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.gutenberg.qa.base.base;
import com.gutenberg.qa.utils.Utils;

public class ProjectDetails extends base{
	
	By back = By.xpath("//i[contains(text(),'keyboard_arrow_left')]");
	By browse = By.xpath("//a[contains(text(),'Browse')]");
	By pickname = By.xpath("//input[@id='site-name']");
	By domainurl = By.xpath("//input[@id='site-url']");
	By projectcategory = By.xpath("//div[@class='category-selector__value-container category-selector__value-container--has-value css-1hwfws3'][contains(.,'Other')]");
	By addmetadata = By.xpath("//i[contains(text(),'expand_more')]");
	By metadatadescription = By.xpath("//textarea[@id='site-description']");
	By metatags = By.xpath("//div[contains(@class,'project-tag-control')]");
	By createproject = By.xpath("//button[@id='save-add-sit-btn']");
	By cancel = By.xpath("//button[contains(text(),'Cancel')]");
	
	public void clickOnBackButton() {
		driver.findElement(back).click();
	}
	
	public void addpickName() {
		driver.findElement(pickname).sendKeys(Utils.getRandomText());
	}
	
	public void clickMetaData() {
		driver.findElement(addmetadata).click();
	}
	
	public void addMetaDataDescription() {
		driver.findElement(metadatadescription).sendKeys(Utils.getRandomText());
	}
	
	public void addMetaTags() {
		driver.findElement(metatags).sendKeys(Keys.ENTER);	
	}
	
	
	public void clickOnBrowseButton() {
		driver.findElement(browse).sendKeys(System.getProperty("user.dir") + "\\src\\main\\java\\com\\gutenberg\\qa\\utils\\cars.jpg");
		
	}
	
	
	public void clickOnCreateButton() {
		driver.findElement(createproject).click();
	}
	
	public void clickOnCancelButton() {
		driver.findElement(cancel).click();
	}
	

}
