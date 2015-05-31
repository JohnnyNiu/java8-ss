package lambda;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by xiaomingniu on 29/05/15.
 *
 * todo
 */
public class MethodReference {

    public static void main(String[] args) {


        Predicate<Apple> p1 = a->a.getColor().equals("green");
        Predicate<Apple> p2 = Apple::isGreen;

        Apple a = new Apple("green",11);
        Function<Apple, Boolean> isGreen = Apple::isGreen;
        System.out.println(isGreen.apply(a));

        //static method
        Function<Integer, List<Apple>> getList = Apple::getSomeApple;
        System.out.println(getList.apply(10));
    }
}
