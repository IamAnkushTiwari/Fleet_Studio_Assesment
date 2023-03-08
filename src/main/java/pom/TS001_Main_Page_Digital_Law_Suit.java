package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Utility;

public class TS001_Main_Page_Digital_Law_Suit extends Utility {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='post-item ']//div//div//div//h3//a")
	WebElement searchbox;
	
	@FindBy(xpath="//a[@role='button'and@id='hs-eu-confirmation-button']")
	WebElement acceptCookies;
	
	@FindBy(xpath = "(//div[@class='plaintiff_content']//descendant::li)[1]")
	WebElement name;
	
	@FindBy(xpath = "(//div[@class='plaintiff_content']//descendant::li)[2]")
	WebElement filingdate;
	
	@FindBy(xpath = "(//div[@class='plaintiff_content']//descendant::li)[3]")
	WebElement stateoffiling;
	
	@FindBy(xpath="(//div[@class='defendant_content']//descendant::li)[1]")
	WebElement defname;
	
	@FindBy(xpath="(//div[@class='defendant_content']//descendant::li)[2]")
	WebElement industry;
	
	@FindBy(xpath="(//div[@class='defendant_content']//descendant::li)[3]")
	WebElement website;
	
	@FindBy(xpath="(//div[@class='defendant_content']//descendant::li)[4]")
	WebElement summary;		
	
	public  TS001_Main_Page_Digital_Law_Suit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);		
	}
	
	public void getUrl() {
		driver.get("https://www.accessibility.com/digital-lawsuits");
		driver.manage().window().maximize();
		}
	
	public void acceptCookies() {
		acceptCookies.click();
	//	hover(driver, searchbox);
		
	}
	
	public void getPlaintiffandDefendent_Link(int num) {
		
		if(num==1) {
		 isElementVisible(driver, searchbox);
		 driver.findElement(By.linkText("LINDA SLADE v. JACOBSON GROUP (USA) LLC")).click();
		}
		else if(num==2) {
			driver.findElement(By.linkText("WARREN ZINNAMON v. ALLSTATE HOME LEISURE LLC")).click();	
		}	
	}
	
	public String getplaintiff_Name() {	
		String sort = name.getText();
		String Name = sort.substring(6); 
		return Name;
	}
	
	public String getplaintiff_Filingdate() {	
		String sort = filingdate.getText();
		String Filingdate= sort.substring(13);
		return Filingdate;
	}
	
	public String getplaintiff_Stateoffiling() {	
		String sort = stateoffiling.getText();
		String Stateoffiling= sort.substring(17);
		return Stateoffiling;
	}
	
	public String getdefendant_Name() {
		isElementVisible(driver, defname);
		String sort = defname.getText();
		String DefName= sort.substring(6);
		return DefName;
	}
	
	public String getdefendant_Website() {
		isElementVisible(driver, website);
		String sort = website.getText();
		String Website= sort.substring(9);
		return Website;
	}
	
	public String getdefendant_Industry() {
		isElementVisible(driver, industry);
		String sort = industry.getText();
		String Industry= sort.substring(9);
		return Industry;
	}
	
	public String getdefendant_Summary() {
		isElementVisible(driver, summary);
		String sort = summary.getText();
		String Summary= sort.substring(9);
		return Summary;
	}
	
	public void navigateback() {
		driver.navigate().back();
	}
	
	
	
	public void passData() throws Exception  {			
		Object[][] inputs =	{{"Sr. no.","PLAINTIFF NAME","FILING DATE","STATE OF FILLING","DEFANDANT NAME","WEBSITE","INDUSTRY","SUMMARY"},
				{"1",getplaintiff_Name(),getplaintiff_Filingdate(),getplaintiff_Stateoffiling(),getdefendant_Name(),getdefendant_Website(),getdefendant_Industry(),getdefendant_Summary()}};
							
		writeExcel(inputs);
	}
	
	

}
