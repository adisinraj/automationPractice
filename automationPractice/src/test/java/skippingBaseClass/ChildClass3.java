package skippingBaseClass;

import org.testng.annotations.Test;

public class ChildClass3 extends BaseClass2{
	@Test
	public void test1() {
		System.out.println("inside test1");
	}
	
	@Test
	public void test2() {
		System.out.println("inside test2");
	}
}
