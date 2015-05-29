package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xiaomingniu on 29/05/15.
 */
public class Apple {

    public static final String GREEEN = "green";
    public static final String RED = "red";

    private String color;

    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static List<Apple> getSomeApple(int total) {
        List<Apple> apples = new ArrayList<>();
        for(int i=0;i<total;i++) {
            Random random = new Random();
            boolean isGreen = random.nextBoolean();
            Random random2 = new Random();
            int weit = random2.nextInt(100)+0;
            apples.add(new Apple((isGreen?GREEEN:RED), weit));
        }

        return apples;
    }

    public static List<Apple> duplicateWithReverseColorSameWeight(List<Apple> apples) {
        List<Apple> dup = new ArrayList<>();
        apples.forEach(a->{dup.add(a.getReverseColorApple());});
        return dup;
    }

    private Apple getReverseColorApple() {
        if(getColor().equals(GREEEN)) {
            return new Apple(RED, getWeight());
        } else {
            return new Apple(GREEEN, getWeight());
        }
    }
}
