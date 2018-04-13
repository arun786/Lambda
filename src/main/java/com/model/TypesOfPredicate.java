package com.model;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;

/**
 * Created by Adwiti on 4/12/2018.
 */
public class TypesOfPredicate {
    public static void main(String[] args) {

        IntPredicate greaterThan15 = i -> i > 15;
        System.out.println(greaterThan15.test(10)); //false

        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(lessThan100.test(50)); //true

        boolean flag = lessThan100.and(greaterThan15).test(25);
        System.out.println(flag); //returns true

        flag = lessThan100.or(greaterThan15).test(5);
        System.out.println(flag); //returns true

        flag = lessThan100.negate().test(101);
        System.out.println(flag); //returns true

        DoublePredicate greaterThan12 = i -> i > 12.0;
        System.out.println(greaterThan12.test(13.1)); //returns true
    }
}
