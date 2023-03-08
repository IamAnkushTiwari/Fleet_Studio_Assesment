package testScenarios;

import org.testng.annotations.Test;
import net.jodah.failsafe.internal.util.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pom.TS001_Main_Page_Digital_Law_Suit;


@Listeners(ITestListnerClass.class)
public class TS01_Test_Scenarios {

	static WebDriver driver;
	TS001_Main_Page_Digital_Law_Suit main_Page;

	@BeforeClass
	public void callBrowser() {
		driver = base.Browser.getChromeBrowser();
	}

	@BeforeMethod
	public void callClass() {
		main_Page = new TS001_Main_Page_Digital_Law_Suit(driver);
	}

	@Test(priority = 1)
	public void TC001_getverifyURL() {
		main_Page.getUrl();
		main_Page.acceptCookies();
		Assert.isTrue(true, "Fail to reach URL");
	}

	@Test(priority = 2)
	public void TC002_get_plaintiff_defendant_information() {
		main_Page.getPlaintiffandDefendent_Link(1);
		Assert.isTrue(true, "Fail to reach Plaintiff and Defendent URL");
	}

	@Test(priority = 3)
	public void TC003_fetchPlaintiffData() {
		main_Page.getplaintiff_Name();
		main_Page.getplaintiff_Filingdate();
		main_Page.getplaintiff_Stateoffiling();
		Assert.isTrue(true, "Fail to fetch Plaintiff Data ");
	}

	@Test(priority = 4)
	public void TC004_fetchDefendentData() {
		main_Page.getdefendant_Name();
		main_Page.getdefendant_Summary();
		main_Page.getdefendant_Website();
		main_Page.getdefendant_Industry();
		Assert.isTrue(true, "Fail to Fetch Defendent Data");
	}

	@Test(priority = 5)
	public void TC005_storeDataExcel() throws Exception {
		main_Page.passData();
		Assert.isTrue(true, "Fail to capture data in Excel Sheet Screenshot");
	}

	@Test(priority = 6)
	public void TC006_navigateBackMainMenu() {
		main_Page.navigateback();
		Assert.isTrue(true, "Fail to navigate back to Main Page");
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
