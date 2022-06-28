package testcases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.FormPage;
import com.pageObjects.ProductsPage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.TapOptions.tapOptions;

import java.io.IOException;

import io.appium.java_client.android.AndroidElement;
import practise.Appium.Base;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class POC extends Base {

	@Test
	public void totalAmountValidation() throws InterruptedException, IOException {

		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		FormPage formPage = new FormPage(driver);

		formPage.getNameField().sendKeys("Hello");
		driver.hideKeyboard();
		formPage.getFemaleOption().click();
		formPage.clickCountrySelectionDropdown().click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"); // Scroll to Argentina from
																							// the dropdown
		formPage.selectArgentina().click();
		formPage.getletsShopButton().click();

		ProductsPage productsPage = new ProductsPage(driver);
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();// click first element doubt
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();// click second element
		productsPage.cartButton().click();

		int count = productsPage.productPrice.size();
		double sum = 0;
		for (int i = 0; i < count; i++) {
			String amount1 = productsPage.productPrice.get(i).getText();
			double amount = getAmount(amount1);
			sum = sum + amount;// 280.97+116.97
		}
		System.out.println(sum + "sum of products");
		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		total = total.substring(1);
		double totalValue = Double.parseDouble(total);
		System.out.println(totalValue + "Total value of products");
		Assert.assertEquals(sum, totalValue);

		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		WebElement tc = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	}

	public static double getAmount(String value) {
		value = value.substring(1);
		double amount2value = Double.parseDouble(value);
		return amount2value;
	}

}