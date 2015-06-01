package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by xiaomingniu on 31/05/15.
 */
public class StreamAdhoc {

    public static void main(String[] args) {
        List<Integer> intArray = Arrays.asList(1,3,56,6,6,7,7,8,9,10,1);
        Stream stream = intArray.stream();
        stream.sorted() .collect(toList());

        //todo why collect can not be alone
        /**
         * Illegal
         * stream.sorted();
         * stream.collect(Collectors.toList());
         *
         *
         */

        System.out.println(intArray.stream().sorted().distinct().collect(toList()));
        System.out.println(intArray.stream().sorted().distinct().collect(toList()));

        intArray.stream().skip(0).skip(1).forEach(System.out::print);


        /**
         * Get Squares of numbers
         *
         */
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.stream().map(n->n*n).forEach(System.out::println);


        /**
         * Given two lists of numbers,
         * how would you return all pairs of numbers?
         * For example, given a list [1, 2, 3] and a list [3, 4]
         * you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)].
         * For simplicity, you can represent a pair as an array with two elements.
         */

        List<Integer> l1 = Arrays.asList(1,2,3,4,5);
        List<Integer> l2 = Arrays.asList(25,234,65,99,25);

        class Pair{
            public int a,b;
            public Pair(int a1,int b1){
                a=a1;
                b=b1;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "a=" + a +
                        ", b=" + b +
                        '}';
            }
        }
//todo ,why there is duplications
        List<Pair> pairs = l1.stream()
                .flatMap(
                        i->l2.stream()
                                .filter(j->(i+j)%3 == 0)
                                .map(j->new Pair(i,j)))

                .distinct()
//                .filter(p->(p.a+p.b)%3==0)
                .collect(toList());
        System.out.println(pairs);


    }


}
