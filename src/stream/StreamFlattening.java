package stream;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * Created by xiaomingniu on 31/05/15.
 */
public class StreamFlattening {
    public static void main(String[] args) {
        List sa=Arrays.asList("Hello", "World").stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(toList());


        System.out.print(sa);
    }

}
