package fr.istic.m2il.aoc.observerasynchrone.observer;

/**
 * Represents asynchronous Generic Subject in Observer Pattern
 * @param <T> Generic Type
 */
public interface SubjectAsync <T>{

    void attach(ObserverAsync<T> observerAsync);
    void detach(ObserverAsync<T> observerAsync);
    void notifyObservers();
}