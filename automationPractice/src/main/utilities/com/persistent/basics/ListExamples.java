package com.persistent.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListExamples {
	public static void main(String[] args) {
		// arrayList1();
		
	//	compareByComparable();
		compareByComparator();
		

	}

	private static void compareByComparator() {
		ListExamples examples = new ListExamples();
		Employee empArr[] = new Employee[4];
		empArr[0] = new Employee(10, "Mikey", 300);
		empArr[1] = new Employee(20, "Arun", 550);
		empArr[2] = new Employee(5, "Lisa", 875);
		empArr[3] = new Employee(1, "Pankaj", 400);

		for (Employee employee : empArr)
			System.out.println(employee.toString());
		Comparator<Employee> comparator = new Comparator<Employee>() {

			public int compare(Employee o1, Employee o2) {
				if (o1.getSalary() > o2.getSalary())
					return 1;
				else if (o1.getSalary() == o2.getSalary())
					return 0;
				else
					return -1;

			}
		};

		Arrays.sort(empArr, comparator); // sorting is done based on salary
		for (Employee employee : empArr)
			System.out.println(employee);
	}

	private static void compareByComparable() {
		List<Employee> listofemp = new ArrayList<Employee>();
		listofemp.add(new Employee(10, "Mikey", 300));
		listofemp.add(new Employee(20, "Arun", 875));
		listofemp.add(new Employee(5, "Lisa", 400));
		listofemp.add(new Employee(1, "Pankaj", 550));

		System.out.println(listofemp.toString());

		Collections.sort(listofemp);  //sorting is done based on the id
		
		System.out.println(listofemp.toString());
		}

	
	private static void arrayList1() {
		List<String> listofitems = new LinkedList();
		listofitems.add("first");
		listofitems.add("second");
		listofitems.add("3rd");
		listofitems.add("first");
		listofitems.add("2nd");

		System.out.println(listofitems.toString());

		for (String string : listofitems) {
			// System.out.println(string);
		}
		Iterator<String> myiterator = listofitems.iterator();
		while (myiterator.hasNext()) {
			System.out.println(myiterator.next());
			if (myiterator.equals("second")) {
				listofitems.remove(2);
			}
		}

	}

}
