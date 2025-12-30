package tests;

import lombok.ToString;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareClass {
    public static void main(String[] args) {
        List<Integer> list  = Arrays.asList(2,4,1,5,8,6,7);
        Collections.sort(list);
        System.out.println(list);

        var comlist = Arrays.asList(new ComparableImpl(2,"Shas"),new ComparableImpl(3,"deb"),new ComparableImpl(1,"cat"));
        Collections.sort(comlist);
        System.out.println(comlist);
    }
}

@ToString
class ComparableImpl implements Comparable<ComparableImpl>{

    private Integer id;
    private String name;

    public ComparableImpl(Integer i, String name) {
        this.id=i;
        this.name= name;
    }

    @Override
    public int compareTo(ComparableImpl o) {
       // return Integer.compare(this.id,  o.id );
        return this.name.compareTo(o.name);
    }
}

class ComparitiveImpl implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
