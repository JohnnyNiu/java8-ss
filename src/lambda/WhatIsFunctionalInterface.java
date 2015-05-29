package lambda;

import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.security.PrivilegedAction;
import java.util.Comparator;
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


        PrivilegedAction<Runnable> priviledgedAction = ()-> runnable;
        priviledgedAction.run().run();

        Predicate<Integer> oddNumbers = (Integer i)->i%2==1;
        oddNumbers.test(1000);
    }

}

