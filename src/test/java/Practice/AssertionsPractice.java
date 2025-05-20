package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	public void sampleHardAssert()
	{
				
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		/*
		 * if(1==1) { System.out.println("PASS"); } else { System.out.println("FAIL"); }
		 */
		Assert.assertEquals(0, 1);
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
		
	}
// ====================================================================================	
	@Test
	public void sampleSoftAssert()
	{
		SoftAssert sa=new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		/*
		 * if(1==1) { System.out.println("PASS"); } else { System.out.println("FAIL"); }
		 */
		sa.assertEquals(1, 1);
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
		
		sa.assertAll();    //logs the failure. Important to mention in Soft Assert
		
		
	}

}
