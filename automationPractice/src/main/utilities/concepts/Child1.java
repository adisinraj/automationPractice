package concepts;

public class Child1 extends P1 implements I1,I2 {

	@Override
	public void in() {
	System.out.println("in the child");	
	}
	
/*	@Override
	  public void hello() { System.out.println("Hello in Child1 "); }
	*/ 
	public static void main(String[] args) {
		Child1 child1 = new Child1();
		P1 child2 = new Child1();
		P2 child3 = new Child1();
		
		P2 p2 = new P2();
		
		child1.hello();
		child2.hello();
		child3.hello();

		p2.hello();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


}
