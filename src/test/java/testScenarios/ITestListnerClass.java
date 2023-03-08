package testScenarios;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListnerClass extends TS01_Test_Scenarios implements ITestListener {

	public void onTestFailure(ITestResult result) {
				
		try {
			takescreensShot(result.getMethod().getMethodName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void takescreensShot(String name) throws Exception {		
		Date date = new Date();
		String modifiedDate = new SimpleDateFormat("dd MMMM yyyy hh s").format(date);
		String filePath = ".//src//";
		File dest = new File(filePath+"Screenshot//"+modifiedDate+""+name+".jpg");
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, dest);
		System.out.println("Screenshot Capture Successfully");
}

}
