package com.sevenmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class GeneralUtility {
	
	public String GET_ATTRIBUTE(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String GET_CSSVALUE(WebElement element, String cssProperty) {
		return element.getCssValue(cssProperty);
	}

	public List<String> GET_TEXTOF_ELEMENTS(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();

		for (WebElement element : elements) {
			data.add(element.getText());
		}
		return data;
	}
	public boolean ISDATA_PRESENT(WebElement element, String data )
	{
		return element.getText().contains(data);
	}

}
