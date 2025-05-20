package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice1 {
	
	@Test(dataProvider = "getData")
	public void createSample(String name, int id)
	{
		System.out.println("Name is - "+name+ " and id is - "+id);
		System.out.println("--------------------------------------");
	}
	
	
	//Create Customer-Create emp data - Datarovider
	
	@DataProvider
	public Object[][] getData()
	{
		//3 row- 3 data sets and each has 2 columns - 2 information
		Object[][] data=new Object[3][2];
		
		//1st Data set
		data[0][0]= "Seema";
		data[0][1]=12;
		
		//2nd Data set
		data[1][0]= "Tanvi";
		data[1][1]=14;
				
		//3rd Data set
		data[2][0]= "Riya";
		data[2][1]=16;
				
				
		return data;
		
	}

}
