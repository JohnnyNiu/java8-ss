package lambda;

import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by xiaomingniu on 28/05/15.
 *
 * a functional interface is an interface that specifies exactly one abstract method
 *
 */
public class WhatIsFunctionalInterface {
    public static void main(String[] args) {


        //Assigning lambda to variable
        Runnable runnable = ()->System.out.println("I am a lambda runnable");
        runnable.run();

        Comparator<Integer> comparator = (Integer a, Integer b)->a-b;
        comparator.compare(1,2);

        Callback<String> callback = ()->"callback get called back";
        System.out.println(callback.call());

        Callback<Integer> callbackAgain = ()->{ return 123; };
        System.out.println(callbackAgain.call());

        PriviledgedAction<Runnable> priviledgedAction = ()-> runnable;
        priviledgedAction.run().run();

        AnyToIntFunction<String> anyToIntFunction = (String s)->Integer.parseInt(s);
        System.out.println(anyToIntFunction.apply("123"));

        Predicate<Integer> oddNumbers = (Integer i)->i%2==1;
        oddNumbers.test(1000);
    }

}
interface AnyToIntFunction<T> extends Function<T, Integer>{}

//java.util.Comparator
interface Comparator<T> {
    int compare(T o1, T o2);
}

//java.lang.Runnable
interface Runnable {
    void run();
}

//java.awt.event.ActionListener
interface ActionListener extends AWTEventListener {
    void actionPerformed(ActionEvent e);
}

//java Util.concurrent.Callable
interface Callback<V> {
    V call();
}

//java.security.PriviledgeAction
interface PriviledgedAction<V> {
    V run();
}

