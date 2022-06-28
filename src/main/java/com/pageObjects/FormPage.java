package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	public FormPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	public WebElement nameField;

	@AndroidFindBy(xpath = "//*[@text='Female']")
	public WebElement femaleOption;

	@AndroidFindBy(id = "android:id/text1")
	public WebElement countrySelectionDropdown;

	@AndroidFindBy(xpath = "//*[@text='Argentina']")
	public WebElement argentina;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement LetsShopButton;

	public WebElement getNameField() {
		System.out.println("Trying to find Name Field");
		return nameField;
	}

	public WebElement getFemaleOption() {
		System.out.println("Trying to select gender as female");
		return femaleOption;
	}

	public WebElement clickCountrySelectionDropdown() {
		System.out.println("Trying to click country selection dropdown");
		return countrySelectionDropdown;
	}

	public WebElement selectArgentina() {
		System.out.println("Trying to select country as Argentina as female");
		return argentina;
	}

	public WebElement getletsShopButton() {
		System.out.println("Trying to select country as Argentina as female");
		return LetsShopButton;
	}

}
