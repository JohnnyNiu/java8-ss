package stream;

import java.util.Collections;
import java.util.Optional;

/**
 * Created by xiaomingniu on 1/06/15.
 */
public class OptionalPractice {
    public static void main(String[] args) {
        Optional aInt = Collections.emptyList().stream().findAny();
        System.out.println(aInt.isPresent());
        System.out.println(aInt.equals(10));
        System.out.println(aInt.orElse(10));
        System.out.println(aInt.equals(10));
        System.out.println(aInt.equals(null));


    }
}
