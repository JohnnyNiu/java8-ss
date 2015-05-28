package function;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static com.sun.tools.javac.util.List.filter;

/**
 * Created by xiaomingniu on 28/05/15.
 */
public class PredictorTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,5,-1,3,8,20,-8,-10);
        filterNumber(numbers, (Integer i) -> i.compareTo(3)<0);

    }

    public static void filterNumber(List<Integer> list, Predicate<Integer> p) {
        for(Integer o: list) {
            if(p.test(o)) {
                System.out.println(o);
            }
        }
    }

}
