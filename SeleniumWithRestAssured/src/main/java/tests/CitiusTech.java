package tests;

import java.util.Arrays;

public class CitiusTech {
    public static void main(String[] args) {
        String str = "Hi Aditya Singh Hello";
        String[] strarr = str.split(" ");
        System.out.println(Arrays.asList(strarr).reversed().toString());
    }
}

@FunctionalInterface
interface MyInter{
    void my();
}

class Main2{
    public static void main(String[] args) {
        MyInter obj = ()->{
            System.out.println("displayed");
        };
        obj.my();
        MyInter inter = new MyInter() {
            @Override
            public void my() {

            }
        };
    }
}
