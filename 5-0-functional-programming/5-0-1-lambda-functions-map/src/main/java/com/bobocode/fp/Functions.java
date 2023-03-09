package com.bobocode.fp;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * An util class that provides a factory method for creating an instance of a {@link FunctionMap}
 * filled with a list
 * of functions.
 * <p>
 * TODO: implement a method and verify it by running {@link FunctionsTest}
 * <p>
 * TODO: if you find this exercise valuable and you want to get more like it,
 * <a href="https://www.patreon.com/bobocode">
 *     please support us on Patreon</a>
 *
 * @author Taras Boychuk
 */
public class Functions {
    private Functions() {
    }

    /**
     * A static factory method that creates an integer function map with basic functions:
     * - abs (absolute value)
     * - sgn (signum function)
     * - increment
     * - decrement
     * - square
     *
     * @return an instance of {@link FunctionMap} that contains all listed functions
     */
    public static FunctionMap<Integer, Integer> intFunctionMap() {
        FunctionMap<Integer, Integer> intFunctionMap = new FunctionMap<>();

        // todo: according to the javadoc add functions using lambda expression
        UnaryOperator<Integer> abs = integer -> {
            return integer >= 0 ? integer : integer * -1;
        };
        intFunctionMap.addFunction("abs", abs);

        Function<Integer, Integer> sgn = integer -> {
            return integer == 0 ? 0 : integer > 0 ? 1 : -1;
        };
        intFunctionMap.addFunction("sgn", sgn);

        UnaryOperator<Integer> increment = integer -> integer + 1;
        intFunctionMap.addFunction("increment", increment);

        UnaryOperator<Integer> decrement = integer -> integer - 1;
        intFunctionMap.addFunction("decrement", decrement);

        UnaryOperator<Integer> square = integer -> integer * integer;
        intFunctionMap.addFunction("square", square);

        return intFunctionMap;
    }
}
