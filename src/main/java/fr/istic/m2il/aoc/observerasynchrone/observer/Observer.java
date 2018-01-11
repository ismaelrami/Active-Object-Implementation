package fr.istic.m2il.aoc.observerasynchrone.observer;

/**
 * Represents synchronous Generic Observer in Observer Pattern
 * @param <T> generic type
 */
public interface Observer <T>  {
    void update(T subject);

}
