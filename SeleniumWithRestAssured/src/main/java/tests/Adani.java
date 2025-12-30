package tests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Adani {
    public static void main(String[] args) {
        String yearsStr = "2024, 2025, 2028, 2030, 2032";




        String[] str = yearsStr.split(",");
        List<Integer> list = list = Arrays.asList(str).stream()
                .map(x->x.trim()).map(x->Integer.valueOf(x))
                .filter(x->(((x % 4 == 0) && (x % 100 != 0)) || (x % 400 == 0)))
                .collect(Collectors.toList());
        list.forEach(System.out::print);

        for(String years : str){
            Integer year = Integer.valueOf(years.trim());
            if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
                System.out.println("Leap year: "+year);
            }
        }

    }
}
