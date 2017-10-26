package fr.istic.m2il.aoc.observerasynchrone.observer;

public interface SubjectAsync <T>{

    void attach(ObserverAsync<T> observerAsync);
    void detach(ObserverAsync<T> observerAsync);
    void notifyObservers();
}