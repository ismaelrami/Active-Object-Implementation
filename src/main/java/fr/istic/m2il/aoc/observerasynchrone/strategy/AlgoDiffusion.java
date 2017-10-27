package fr.istic.m2il.aoc.observerasynchrone.strategy;

import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;

public interface AlgoDiffusion {
    void configure(Generator generator);
    void execute();
}
