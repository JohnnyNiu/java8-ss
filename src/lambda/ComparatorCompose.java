package lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaomingniu on 29/05/15.
 */
public class ComparatorCompose {

    public static void main(String[] args) {
        List<Apple> apples = Apple.getSomeApple(10);

        Apple.showApples(apples);
        sortApplesByWeightASC(apples);
        System.out.println("after sort by weight");
        Apple.showApples(apples);

        System.out.println("after sort by weight, and color");
        apples.addAll(Apple.duplicateWithReverseColorSameWeight(apples));
        sortAppleByWeightAndColor(apples);
        Apple.showApples(apples);

    }


    private static void sortApplesByWeightASC(List<Apple> apples) {

        //prior java 8
//        Collections.sort(apples, new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight()-o2.getWeight();
//            }
//        });

        //using lambda
//        Collections.sort(apples, (o1,o2)->o1.getWeight()-o2.getWeight());

        /**
        using method reference
        comparator's strategy includes two things:
        1. how to compare
        2. what to compare
        how to comapre is the body of comparating method
        what to compare is the paramter (a function) of the comparing method
         */
//        Collections.sort(apples, Comparator.comparing(Apple::getWeight));

        //collection's new sort?
        apples.sort(Comparator.comparing(Apple::getWeight));
    }

    private static void sortAppleByWeightAndColor(List<Apple> apples) {
         //inside lambda body
//        apples.sort((o1,o2)->
//                (o1.getWeight()-o2.getWeight() != 0? o1.getWeight()-o2.getWeight():(o1.getColor().equals(Apple.GREEEN)?-1:1)));

        //
        Comparator<Apple> weightComparator =(o1,o2)->(o1.getWeight() - o2.getWeight());
        Comparator<Apple> colorComparator =(o1,o2)->(o1.getColor().equals("green")? -1:1);

//        apples.sort(weightComparator.thenComparing(colorComparator));
//        apples.sort(colorComparator.thenComparing(weightComparator));

//        apples.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor));

        //reversing
        apples.sort(Comparator.comparing(Apple::getWeight).thenComparing(Apple::getColor).reversed());
    }

}
