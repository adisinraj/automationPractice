package tests;

import java.util.ArrayList;
import java.util.List;

public class Globant {
    // Online Java Compiler
// Use this editor to write, compile and run your Java code online

        public static void main(String[] args) {
            var result =resultArr(new Integer[]{1,2,3,4,5,6},2,3) ;
            if(result == null){
                System.out.print("Invalid inputs");
            }else
                result.stream().forEach(x->{
                    System.out.println(List.of(x));
                });

        }

        public static List<Integer[]> resultArr(Integer[] arr,int row, int col){
            if(arr.length < (row*col)){
                return null;
            }
            List<Integer[]> finalList = new ArrayList<>();
            int position =0;
            for(int i=0; i< row;i++){
                Integer[] cArr = new Integer[col];
                for(int j=0;j<col;j++){
                    cArr[j]=arr[position];
                    position++;
                }
                finalList.add(cArr);
            }
            return finalList;
        }
}
