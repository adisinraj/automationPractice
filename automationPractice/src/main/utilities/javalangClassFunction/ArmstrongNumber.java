package javalangClassFunction;

import java.util.Scanner;

public class ArmstrongNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the range for finding the Armstrong number number : ");
		Integer from = sc.nextInt();
		Integer to = sc.nextInt();
		while(from<=to)
		{
		int sum = 0;
		int temp=from;
		int remainder=0;
		while(temp!=0)
		{
			remainder = temp%10;
			sum = (remainder*remainder*remainder)+sum;
			temp = temp/10;
		}
		if(sum== from)
		{
			System.out.println("nmber "+from +"  is armstrong number");
		}
		from++;
	}

	}
}
