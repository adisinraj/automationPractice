package javalangClassFunction;

public class ReverseArray {

	public static void main(String[] args) {
		Integer[] numbers={5,4,2,1,3};
		Integer size = numbers.length;	//length keyword is reserved for the arrays for their length
		System.out.println(size);
		for(int i =0 ; i < size-1 ;i++){
			if(numbers[i]<numbers[i+1]){
				int temp=numbers[i];
				numbers[i]=numbers[i+1];
				numbers[i+1]= temp;
			}
		}
		for (int i = 0; i< size;i++){
			System.out.println(numbers[i]);
		}
	}

}
