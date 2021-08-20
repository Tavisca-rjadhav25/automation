package com.gutenberg.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.gutenberg.qa.base.base;
import com.gutenberg.qa.utils.Utils;

public class HomePage extends base {
	
	By username = By.id("userNameInput");
	By pass = By.id("passwordInput");
	By submit = By.id("submitButton");
	By addproject = By.xpath("//button[contains(text(),'Add project')]");
	By addcategory = By.xpath("//button[contains(text(),'Add category')]");
	By categoryname = By.xpath("//input[@id='category-name']");
								
	By cancel = By.xpath("//button[contains(text(),'Cancel')]");
	By createcategory = By.xpath("//button[contains(text(),'Create category')]");
	By renameCategory = By.xpath("//button[contains(text(),'Rename category')]");
	By updateCategory = By.xpath("(//*[local-name()='svg'])[6]");
	By deleteCategory = By.xpath("(//*[local-name()='svg'])[7]");
	By confirmDeleteCategory = By.xpath("//button[contains(text(),'Yes, Delete')]");
	
	
	By projectImage=By.xpath("//body/div[@id='root']/section[1]/section[1]/section[2]/section[1]/section[1]/section[2]/section[1]/div[2]/div[1]/section[1]/div[1]/img[1]");
	By deleteProjectOption=By.xpath("//i[contains(text(),'delete')]");
	By editProject=By.xpath("//i[contains(text(),'edit')]");
	By saveProject=By.id("save-add-sit-btn");
	By deleteProject = By.xpath("//button[@class='btn btn delete-btn'][contains(.,'Yes, delete project')]");
	By delete1=By.xpath("(//i[@class='material-icons'])[4]");
	By delete2=By.xpath("(//i[@class='material-icons'])[5]");
	By delete3=By.xpath("(//i[@class='material-icons'])[6]");
	By delete4=By.xpath("(//i[@class='material-icons'])[7]");
	public By projectDeleteMessage= By.xpath("//p[@class='message-title'][contains(.,'Project deleted successfully')]");
	
	By searchicon = By.xpath("//img[@class='search-icon']");
	By searchtextbox = By.xpath("//input[@id='search-project']");
	By listview = By.xpath("//button[@title='Switch to List View']");
	
	By optionIcon=By.xpath("//body/div[@id='root']/section[1]/section[1]/section[2]/section[1]/section[1]/section[2]/section[1]/div[2]/div[1]/section[1]/div[2]/div[1]/i[1]");
	
	public By header= By.xpath("//p[contains(text(),'Gutenberg')]");
	public By categorySuccessMessage= By.xpath("//p[@class='message-title'][contains(.,'Project category added!')]");
	
	
	

	WebDriverWait wait=new WebDriverWait(driver,30);
	
	public void addUsername() {
		driver.findElement(username).sendKeys("rjadhav1@affinionds.com");
	}
	
	public void addPass() {
		driver.findElement(pass).sendKeys("R@sika2541998");
	}
	
	public void clickSubmit() {
		driver.findElement(submit).click();
	}
	
	
	public void clickOnAddProjectButton() {
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addproject)).click();
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
	
	public void updateProject() throws InterruptedException {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(projectImage));
		driver.findElement(optionIcon).click();
		driver.findElement(editProject).click();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.findElement(saveProject).click();
		
	}
	
	public void deleteProject() {
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(projectImage));
		driver.findElement(optionIcon).click();
		driver.findElement(deleteProjectOption).click();
		wait.until(ExpectedConditions.elementToBeClickable(delete1));
		driver.findElement(delete1).click();
		driver.findElement(delete2).click();
		driver.findElement(delete3).click();
		driver.findElement(delete4).click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteProject));
		driver.findElement(deleteProject).click();
	}
	
	public void updateCategory() {
		wait.until(ExpectedConditions.elementToBeClickable(updateCategory));
		driver.findElement(updateCategory).click();
		driver.findElement(categoryname).sendKeys(Utils.getRandomText());
		driver.findElement(renameCategory).click();
		
	}
	
	
	public void deleteCategory() {
		driver.findElement(deleteCategory).click();
		driver.findElement(confirmDeleteCategory).click();
	}
	
	public void clickOnSearchIcon() {
		driver.findElement(searchicon).click();
	}
	
	public void enterTextInSearch() {
		driver.findElement(searchtextbox).sendKeys("auto");;
	}
	
	public void clickListViewIcon() {
		driver.findElement(listview).click();
	}
	
	
	public String getElement(By xpath) {
		WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		return element.getText();	
	}
	
	public boolean isElementDisplayed(By xpath) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		return element.isDisplayed();
	}
	
	
	
	
	
	
	
	
	}
