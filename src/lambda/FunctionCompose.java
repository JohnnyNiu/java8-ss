package lambda;

import java.util.function.Function;

/**
 * Created by xiaomingniu on 29/05/15.
 */
public class FunctionCompose {

    public static void main(String[] args) {
        Function<Integer, Integer> f = x-> x+1;
        Function<Integer, Integer> g = x-> 2*x;

        int x = 10;
        System.out.println(f.apply(x)); //11
        System.out.println(g.apply(x));//20
        System.out.println(f.andThen(g).apply(x));//22
        System.out.println(f.compose(g).apply(x));//21

    }
}
