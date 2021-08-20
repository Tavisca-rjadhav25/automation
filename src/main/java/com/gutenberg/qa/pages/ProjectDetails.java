package com.gutenberg.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import com.gutenberg.qa.base.base;
import com.gutenberg.qa.utils.Utils;

public class ProjectDetails extends base{
	
	By backNavigationButton = By.xpath("//i[contains(text(),'keyboard_arrow_left')]");
	By browse = By.xpath("//a[contains(text(),'Browse')]");
	By pickname = By.xpath("//input[@id='site-name']");
	By domainurl = By.xpath("//input[@id='site-url']");
	By projectcategory = By.xpath("//div[@class='category-selector__value-container category-selector__value-container--has-value css-1hwfws3'][contains(.,'new')]");
	By addmetadata = By.xpath("//i[contains(text(),'expand_more')]");
	By metadatadescription = By.xpath("//textarea[@id='site-description']");
	By metatags = By.xpath("//input[contains(@class,'react-tagsinput-input project-tag-input')]");
	By createproject = By.xpath("//button[@id='save-add-sit-btn']");
	By cancel = By.xpath("//button[contains(text(),'Cancel')]");
	By crop = By.xpath("//button[contains(text(),'Crop')]");
	By siteimagedisplay = By.xpath("//img[@id='site-image-display']");
	By addImage = By.xpath("//input[@id='file-selector']");
	
	
	public void clickOnBackButton() {
		driver.findElement(backNavigationButton).click();
	}
	
	public void addpickName() {
		driver.findElement(pickname).sendKeys(Utils.getRandomText());
	}
	
	public void selectCategory() {
		driver.findElement(projectcategory).click();
	}
	
	public void clickMetaData() {
		driver.findElement(addmetadata).click();
	}
	
	public void addMetaDataDescription() {
		driver.findElement(metadatadescription).sendKeys(Utils.getRandomText());
	}
	
	public void addMetaTags() {
		driver.findElement(metatags).sendKeys(Utils.getRandomText());
		driver.findElement(metatags).sendKeys(Keys.ENTER);	
	}
	
	
	public void clickOnBrowseButton() {
		//driver.findElement(browse).click();
		driver.findElement(addImage).sendKeys(System.getProperty("user.dir") + "\\src\\main\\java\\com\\gutenberg\\qa\\utils\\cars.jpg");
		driver.findElement(crop).click();
	}
	
	
	public void clickOnCreateButton() {
		driver.findElement(createproject).click();
	}
	
	public void clickOnCancelButton() {
		driver.findElement(cancel).click();
	}
	

}
