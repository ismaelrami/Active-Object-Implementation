package fr.istic.m2il.aoc.observerasynchrone.channel;

import java.util.concurrent.Future;

/**
 * Represents the  Asynchronous Generator
 */
public interface GeneratorAsync {
    /**
     * Gets result of GetValue Method Invocation (to make the execution of update method asynchronous)
     * @return Future of Integer of the GetValue Method Invocation
     */
    Future<Integer> getValue();
}
