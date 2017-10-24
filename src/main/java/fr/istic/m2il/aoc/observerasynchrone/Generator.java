package fr.istic.m2il.aoc.observerasynchrone;

import fr.istic.m2il.aoc.observerasynchrone.observer.Subject;

public interface Generator extends Subject <Displayer>{
    public Integer getValue();
    public void generate();
}
