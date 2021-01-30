package TestVagrant;

import java.util.Comparator;

import org.apache.poi.ss.formula.functions.T;

public class Employees implements Comparable<T>{
	private Integer empNo;
	private String name; 
	private String address;
	private String dept;
	
	
	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Employees(Integer empNo, String name, String address, String dept) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.address = address;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employees [empNo=" + empNo + ", name=" + name + ", address=" + address + ", dept=" + dept + "]";
	}

	

	
	@Override
	public int compareTo(T o) {
		
		return 0;
	}
	
	
	
}
