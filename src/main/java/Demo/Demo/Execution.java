package Demo.Demo;

import java.io.IOException;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import Demo.Demo.TestList;

public class Execution {
	
	public static void main (String args[]) throws IOException, InterruptedException {
		
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { TestList.class });
		testng.addListener(tla);
		testng.run();  	
		//Execution Done
		 
	}

}
