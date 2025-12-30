package POJO;

import java.util.HashMap;
import java.util.Map;

public class Test {
   /* public static void main(String[] args) {
        String str ="India is my country";
        Map<Character,Integer> map = new HashMap<>();
        for(Character c : str.toCharArray()){
            if((c+"").matches("[aeiouAEIOU]")){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        map.forEach((x,value)-> System.out.println( x + " : "+value));
    }*/

    public static void main(String[] args) {
        Map<Integer,String> fname =new HashMap<>();
        fname.put(1,"aditya");
        fname.put(2,"tieto");
        Map<Integer,String> lname =new HashMap<>();
        lname.put(1,"rajput");
        lname.put(3,"evry");

        fname.forEach((key,value)->{
               if(lname.containsKey(key)){
                   System.out.println("For id:"+key+", first name :"+value+", last name :"+lname.get(key));
               }
           });

    }
}
