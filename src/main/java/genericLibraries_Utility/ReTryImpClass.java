package genericLibraries_Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTryImpClass implements IRetryAnalyzer{
	int counter=0;
	int retrylimit=3;
	
	@Override
	public boolean retry(ITestResult result) {
		if(counter<retrylimit) {
			counter++;
			return true;
		}
		return false;
	}

}
