package stream;

/**
 * Created by xiaomingniu on 1/06/15.
 */
public class Finding {
    public static void main(String[] args) {

        /**
         * checking to see if at least one element match predicate
         */

        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is vegetarian friendly");
        }


        /**
         * checking to see if a predicate matches all element
         */
        if(Dish.menu.stream().allMatch(d->d.getCalories()<1000)) {
            System.out.println("The menu is very healthy");
        }

        /**
         * none match
         */
        if(Dish.menu.stream().noneMatch(d->d.getCalories()>1000)) {
            System.out.println("Double checked, it's health");
        }

        /*
        Find one element
         */
        System.out.println(Dish.menu.stream().findAny());

    }
}
