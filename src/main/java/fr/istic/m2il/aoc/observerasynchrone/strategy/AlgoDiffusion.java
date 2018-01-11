package fr.istic.m2il.aoc.observerasynchrone.strategy;

import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;

/**
 * Represent the diffusion strategy use to make synchronisation in Active Object Pattern.
 * It is an application of Strategy Design Pattern
 */
public interface AlgoDiffusion {
    /**
     * Configures the strategy with the generator instance
     * @param generator instance use in strategy
     */
    void configure(Generator generator);

    /**
     * Executes the algorithm strategy
     */
    void execute();
}
