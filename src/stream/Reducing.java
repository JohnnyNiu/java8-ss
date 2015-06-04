package stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaomingniu on 3/06/15.
 */
public class Reducing {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,6,21,634,357,454,1);
        System.out.println(list.stream().reduce(0, (a,b)-> {System.out.println("a: "+a+";b:" +b);return a+b;}));

        //Find the minimum value
        //optional 1  ?  because no initial value
        System.out.println(list.stream().reduce( (a,b)-> a>b?b:a));


        //method reference
        System.out.println(list.stream().reduce(Integer::min));



        // -20 . wrong initial value
        System.out.println(list.stream().reduce(-20, (a,b)-> a>b?b:a));



    }
}
