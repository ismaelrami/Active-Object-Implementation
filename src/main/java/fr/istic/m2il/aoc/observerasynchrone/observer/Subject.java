package fr.istic.m2il.aoc.observerasynchrone.observer;

public interface Subject <T>{

    void attach(T observer);
    void detach(T observer);
    void notifyObservers();
}
