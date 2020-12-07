package skippingBaseClass;

import org.testng.annotations.BeforeClass;

public class BaseClass2 extends BaseClass1{

	@BeforeClass
	public void initialize() {
		System.out.println("inside before class2 ");
	}
}
