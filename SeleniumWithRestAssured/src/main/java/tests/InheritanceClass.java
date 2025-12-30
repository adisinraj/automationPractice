package tests;

public class InheritanceClass {
    public static void main(String[] args) {
        Father obj = new Son2();
        obj.land();
    }
}


class Father{
    public String land(){
        System.out.println("Father has land");
        return "null";
    }
}

class Son1 extends Father
{
    @Override
    public String land(){
        System.out.println("Son1 has land");
        return null;
    }

    public void property(String str,int num){

    }
    public String property(String str){
        return "";
    }
}

class Son2 extends Father{

    @Override
    public String land() {
        System.out.println("Son2 has land");
        return null;
    }
}

class Animal {}
class Dog extends Animal {}

class Parent {
   protected Animal getPet() {
        return new Dog();
    }
}

class Child extends Parent {
    @Override
    public Dog getPet() {
        return new Dog(); // ✅ Dog is a subclass of Animal
    }
}