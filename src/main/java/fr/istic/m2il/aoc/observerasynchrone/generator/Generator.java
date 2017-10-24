package fr.istic.m2il.aoc.observerasynchrone.generator;

import fr.istic.m2il.aoc.observerasynchrone.observer.Subject;

public interface Generator extends Subject<Generator> {
    public Integer getValue();
    public void generate();
}
