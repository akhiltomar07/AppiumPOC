package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage {

	public ProductsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
	public List<WebElement> listOfProducts;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productPrice;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cartButton;

	public List<WebElement> getProductsList() {
		System.out.println("Trying to find Name Field");
		return listOfProducts;
	}

	public List<WebElement> getProductPrice() {
		System.out.println("Trying to find Name Field");
		return productPrice;
	}

	public WebElement cartButton() {
		System.out.println("Trying to click Cart Button on Product List");
		return cartButton;
	}

}
