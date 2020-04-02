package javalangClassFunction;

import java.util.Scanner;

public class MathFunction {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//
//				double d =  Math.round(2.5+Math.random());
//				System.out.println(d);
		Scanner sc = new Scanner(System.in);
		Integer rows = sc.nextInt();
		/*for(int i= 0 ; i< rows;i++){
			
			for(int k=0;k<i;k++ ){
				System.out.print("_");
			}
			
			for (int j=rows*2-1; j>=2*i+1;j--){
					System.out.print(i);
				}
			
			for(int k=0;k<i;k++ ){
				System.out.print("_");
			}
			System.out.print("\n");		
		}
		
		*/

	for(int i = 1; i<= rows ; i++){
		for(int j =1; j<2*i+1;j++ )
			System.out.print(j);
		System.out.print("\n");		

	}
	
	}}
