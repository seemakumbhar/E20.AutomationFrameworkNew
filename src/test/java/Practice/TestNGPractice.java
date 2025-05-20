package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(invocationCount = 2, priority = 2)
	public void CreateSample()
	{
		System.out.println("Create");
	} 
	
	@Test(enabled = false )
	public void removeSample()
	{
		System.out.println("Remove");
	}
	
	@Test
	public void modifySample()  //pass fail
	{
		Assert.fail();   // forcefully fail
		System.out.println("Modify");
	}
	
	@Test(dependsOnMethods = "modifySample")  //skip
	public void deleteSample()
	{
		System.out.println("Delete");
	}

}

//1. Priority has priority ove invocationCount
// Priority accepts integer negative, zero and positive values.
// Least value has highest priority.
// Default priority is zero, if not mentioned.
// Test will execute as per ASCII value.
// e.g. A-Z executes first then a-z.
//2. InvocationCount accepts only integer value from 1 onward.
// For zero and negative values, invocationCount will not be executed.
// InvocationCount means that method will execute mentioned number of times.
//3. enabled - default value is true. If made false ten script will not be executed
//4. dependsOnMethods- it means execution of that method depends upon status/result of another mentioned method.
// If that methos is passed, then this method will be excecuted.
// If that method is failed, this method will be skipped.
// It is used to skip the execution.
// Assert.fail() will forcefully failed that method.

