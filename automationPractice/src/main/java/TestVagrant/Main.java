package TestVagrant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Employees> listOfEmployees = new ArrayList<>();
		listOfEmployees.add(new Employees(5, "Alpha", "Address1", "dept1"));
		listOfEmployees.add(new Employees(2, "Beta", "Address2", "dept2"));
		listOfEmployees.add(new Employees(4, "Catch", "Address3", "dept3"));
		listOfEmployees.add(new Employees(1, "Delta", "Address4", "dept4"));
		listOfEmployees.add(new Employees(3, "Epsilon", "Address5", "dept5"));
		
		System.out.println(listOfEmployees);
		Collections.sort(listOfEmployees, new Comparator<Employees>() {

			@Override
			public int compare(Employees o1, Employees o2) {
				
				return o1.getEmpNo()-o2.getEmpNo();
			}
			
		});
		
		System.out.println(listOfEmployees);
	}
}
