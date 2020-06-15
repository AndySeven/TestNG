package com.practice;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.syntax.util.CommonMethods;

public class DynamicElements extends CommonMethods {
	String url = "https://rahulshettyacademy.com/seleniumPractise/";

	@Test
	public void addToCart() {
		driver.get(url);
		String[] items = { "Brocolli", "Beans", "Carrot" };
		List<WebElement> list = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < list.size(); i++) {
			String it = list.get(i).getText();
			String[] arr = it.split("-");
			String finalItem = arr[0].trim();
			// System.out.println(i+"-->"+finalItem);

			List<String> arrItemList = Arrays.asList(items);
			int count = 0;
			if (arrItemList.contains(finalItem)) {
				List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='product-action']/button"));
				// System.out.println(i);
				list2.get(i).click();
				count++;
				if (count == items.length) {
					break;
				}
			}
		}

		wait(6);
	}
}
