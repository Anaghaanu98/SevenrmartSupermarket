package com.sevenmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {

	public String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String getCSSValue(WebElement element, String cssProperty) {
		return element.getCssValue(cssProperty);
	}

	public List<String> getTextOfElements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();

		for (WebElement element : elements) {
			data.add(element.getText());
		}
		return data;
	}

	public boolean isDataPresent(WebElement element, String data) {
		return element.getText().contains(data);
	}

	public static String getRandomName() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}

}
