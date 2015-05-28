package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by xiaomingniu on 28/05/15.
 */
public class UseConsumer {

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for(T i: list) {
            c.accept(i);
        }
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        forEach(list, (Integer i)->System.out.println(i*10000));
    }
}
