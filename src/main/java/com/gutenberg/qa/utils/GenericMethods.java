package com.gutenberg.qa.utils;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gutenberg.qa.base.base;

public class GenericMethods extends base {
	
	WebDriverWait wait;

	public GenericMethods() throws IOException {
		wait = new WebDriverWait(driver,30);
	}
	
	public void clickElement(String xpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
	}
	
	public void setElementWithInput(By xpath,String input) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath)).sendKeys(input);
	}
	
	public void setElementWithEnterKey(String xpath,Keys key) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).sendKeys(key);
	}
	
	public String getElementText(String xpath) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return element.getText();
	}
	
	public boolean isElementDisplayed(String xpath) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return element.isDisplayed();
	}
	
	public WebElement getElement(String xpath) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public List<WebElement> getElements(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}
	
	public void clearElement(String xpath) {
		driver.findElement(By.xpath(xpath)).clear();
	}
	
	public void waitTillElementIsInvisible(String xpath) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}
}
