package fr.istic.m2il.aoc.observerasynchrone.generator;

import fr.istic.m2il.aoc.observerasynchrone.observer.ObserverAsync;
import fr.istic.m2il.aoc.observerasynchrone.observer.SubjectAsync;

import java.util.List;

/**
 * Represents Generator Interface
 */
public interface Generator extends SubjectAsync<Generator> {
    Integer getValue();
    void generate();
    List<ObserverAsync<Generator>> getAsyncObservers();
}
