package javalangClassFunction;

import java.util.Scanner;

public class PrimeNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			System.out.println("Enter the range for finding the prime number : ");
			Integer range = sc.nextInt();
		
			for (int i =1;i<=range;i++)
			{
				int flag=0;
				for(int j=2;j<i;j++)
				{
					if(i%j==0)
					{
						flag=1;
					}
				}
				if(flag!=1){
					System.out.println(i);
				}
			}
}
}
