package com.sevenmartsupermarket.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name ="Manage News")
	public Object[][] productsSearch()
	{
		return new Object [][] {{"Rainy day"},{"Sunny day"},{"Its too hottt!!"}};
	}
	
	@DataProvider(name="Login Credentials")
	public Object[][] UserPassword()
	{
		return new Object[][] {{"admin12","1234"},{"admi","admi"},{"admin","aaa12345"}};
	}

}
