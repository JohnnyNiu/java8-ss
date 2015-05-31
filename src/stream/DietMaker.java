package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by xiaomingniu on 31/05/15.
 */
public class DietMaker {
    public static void main(String[] args) {

        Dish.showDishes(Dish.menu);

        System.out.println("after make diet");
        // find low caloric dishes
        List<String> lowCalorisDishes = Dish.menu.stream()
                .filter(d->d.getCalories()<400)
                .sorted((d1,d2)->d1.getCalories()-d2.getCalories())
                .map(d->d.getName())
                .collect(Collectors.toList());

        System.out.println(lowCalorisDishes);

        //same functionality but using Method Reference instead of lambda and parallel stream
        lowCalorisDishes = Dish.menu.parallelStream()
                .filter(d->d.getCalories()<400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(lowCalorisDishes);

        //group your dishes by type
        //todo every time the group sequence is not the same
        Map<Dish.Type, List<Dish>> groups = Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(groups);

        //find 3 high calorie dish
        List<String> highCalorDishes = Dish.menu.parallelStream()
                .filter(d->d.getCalories()>300)
                .limit(3)
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(highCalorDishes);
    }
}
