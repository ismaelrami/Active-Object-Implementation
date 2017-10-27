package fr.istic.m2il.aoc.observerasynchrone.generator;

import fr.istic.m2il.aoc.observerasynchrone.observer.ObserverAsync;
import fr.istic.m2il.aoc.observerasynchrone.observer.SubjectAsync;

import java.util.List;

public interface Generator extends SubjectAsync<Generator> {
    Integer getValue();
    void generate();
    public List<ObserverAsync<Generator>> getAsyncObservers();
}
