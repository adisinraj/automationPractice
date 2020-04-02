package javalangClassFunction;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer rows = sc.nextInt();
		Integer column = sc.nextInt();
		for(int i = 1;i<= rows;i++)
		{
			if(i==1||i==(rows))
			{
				for(int j=1; j<= column; j++)
				{
					System.out.print("*");
				}
			}
			else
			{
				for(int j=1;j<=column;j++)
				{
					if(j==1 || j==column)
					{
						System.out.print("*");
					}
					else
					{
						System.out.print("_");
					}
				}
			}
			System.out.println();
		}
	}
}
