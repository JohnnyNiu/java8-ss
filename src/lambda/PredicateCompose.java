package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by xiaomingniu on 29/05/15.
 */
public class PredicateCompose {
    public static void main(String[] args) {
        List<Apple> apples = Apple.getSomeApple(10);
        Apple.showApples(apples);

        System.out.println("after pick out red");
        List<Apple> greenApples = filterRedAppleOut(apples);
        Apple.showApples(greenApples);

    }

    private static List<Apple> filterRedAppleOut(List<Apple> apples) {


//        prior Java 8
//        List<Apple> result = new ArrayList<>();
//        for(Apple a: apples) {
//            if(a.getColor().equals("green")) {
//                result.add(a);
//            }
//        }
//        return result;

        //Using predicator
//        Predicate<Apple> p = new Predicate<Apple>() {
//            @Override
//            public boolean test(Apple apple) {
//                return apple.getColor().equals(Apple.RED);
//            }
//        };
//
//        apples.removeIf(p);

        //using lambda and compose , filter out red and small ones
//        apples.removeIf(((Predicate<Apple>)(a->a.getColor().equals(Apple.RED))).or(a->a.getWeight()<50));
        apples.removeIf(((Predicate<Apple>)(a->a.getColor().equals(Apple.RED))).negate());

        return apples;

    }
}
