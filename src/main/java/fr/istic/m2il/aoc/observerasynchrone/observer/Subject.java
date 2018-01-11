package fr.istic.m2il.aoc.observerasynchrone.observer;

/**
 * Represents synchronous Generic Subject in Observer Pattern
 * @param <T> generic Type
 */
public interface Subject <T>{

    void attach(Observer<T> observer);
    void detach(Observer<T> observer);
    void notifyObservers();
}
