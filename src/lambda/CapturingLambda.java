package lambda;

import java.lang.*;

/**
 * Created by xiaomingniu on 29/05/15.
 *
 * local variable can only be used by Lambda once, it must be final or effectively final
 */
public class CapturingLambda {
    public static void main(String[] args) {
        String msg = "hello world";
        //illegal
        //java.lang.Runnable runnable = ()->{msg = "lamda can't change local variables";};
        java.lang.Runnable runnable = ()->{System.out.println(msg);};
        runnable.run();

    }
}
