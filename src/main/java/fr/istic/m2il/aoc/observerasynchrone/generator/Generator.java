package fr.istic.m2il.aoc.observerasynchrone.generator;

import fr.istic.m2il.aoc.observerasynchrone.observer.SubjectAsync;

public interface Generator extends SubjectAsync<Generator> {
    Integer getValue();
    void generate();
}
