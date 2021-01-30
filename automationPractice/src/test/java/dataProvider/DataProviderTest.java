package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider = "provideData")
	public void getData(String name, String designation) {
		System.out.println(name+" :"+designation);
	}
	
	@DataProvider
	public String[][] provideData(){
		return new String[][] {
			{"Aditya"},
			{"Beta"},
			{"Charlue","Dtr"}
		};
	}
}
