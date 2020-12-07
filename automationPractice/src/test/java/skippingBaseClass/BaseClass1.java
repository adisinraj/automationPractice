package skippingBaseClass;

import org.testng.annotations.BeforeClass;

public class BaseClass1 {

	@BeforeClass
	public void initialize() {
		System.out.println("inside before class1 ");
	}
}
