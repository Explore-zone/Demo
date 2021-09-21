package Demo.Demo;


import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import atu.testng.reports.ATUReports;

//import com.unitedinternet.portal.selenium.utils.logging.LoggingUtils;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;



@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
//@Listeners({ ATUReportsListener.class, MethodListener.class })

public class TestList extends BasicSetup 
{
	@BeforeMethod
	public static void Application_Launch1() 
	{
		Application_Launch();
		wait(3);		 
	}

	@AfterMethod
	public static void Application_Quit()
	{
		Application_Close();
		
	}

	@Test
	public static void Verify_Product_Details() 
	{
		TestCases.Add_Product_To_Cart();		 
	}

	




	//@AfterMethod(alwaysRun =true)
	public static void teartdown(ITestResult result)
	{
		if(!result.isSuccess())
		{
			///Take Screenshot

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {


				FileUtils.copyFile(scrFile, new File("C:/workspace/Entes/Screenshot/"+"TestSuite"+"_"+""
						+"_"+ System.currentTimeMillis()+ ".png"));


			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}


	}


}

