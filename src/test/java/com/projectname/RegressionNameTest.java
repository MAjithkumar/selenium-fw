package com.projectname;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.projectname.basepage.BasePage;
import com.projectname.basepage.LoginPage;
import com.projectname.util.DTO.ProjectNameDTO;
import com.projectname.util.Elements.ElementUtil;
import com.projectname.util.ExcelUtils.Xls_Reader;

public class RegressionNameTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	Xls_Reader reader;
	SoftAssert softAssert;
	ElementUtil eu;
	String ProjectDataFilePath;
	public static ArrayList<ProjectNameDTO> ProjectDTO;

	public static int rowIndex = 2, amendIndex = -1;
	public static int rowIndex1 = 2;
	int i = 0;

	@BeforeTest
	public void setUp() throws Exception {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		eu = new ElementUtil(driver);
		ProjectDataFilePath = System.getProperty("user.dir") + ".\\input_data\\_TestData.xlsx";
	}

	@Test(priority = 0)
	public void Step1_Login() throws IOException, InterruptedException {
		reader = new Xls_Reader(ProjectDataFilePath, "SheetName");
		String username = Xls_Reader.getCellData("SheetName", "Username", rowIndex);
		String password = Xls_Reader.getCellData("SheetName", "Password", rowIndex1);
		loginPage.Login(username, password);
//		String headerValue = loginPage.getHomePageHeader();
//		System.out.println("home page header is: " + headerValue);
//		Assert.assertEquals(headerValue, Constants.HOME_PAGE_TITLE, "home page header mismatched...");
	}
}
