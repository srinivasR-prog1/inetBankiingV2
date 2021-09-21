package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.BaseClass;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_001 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		
		logger.info("Username is Provided");
		lp.setPassword(pwd);
		logger.info("Password is Provided");
		lp.btnSubmit();
		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");

		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.btnLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			
		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {

			return false;

		}

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/Logindata.xlsx";

		int rowNum = XLUtils.getRowCount(path, "loginData");
		int colCount = XLUtils.getCellCount(path, "loginData", 1);

		String logindata[][] = new String[rowNum][colCount];

		for (int i = 1; i <= rowNum; i++) {

			for (int j = 0; j < colCount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "loginData", i, j);

			}

		}

		return logindata;

	}

}
