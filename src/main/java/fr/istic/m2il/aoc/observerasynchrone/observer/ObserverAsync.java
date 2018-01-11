package fr.istic.m2il.aoc.observerasynchrone.observer;

import java.util.concurrent.Future;

/**
 * Represents asynchronous Generic Observer in Observer Pattern
 * @param <T> Generic Type
 */
public interface ObserverAsync <T>  {
    Future<Void> update(T subjectasync);

}