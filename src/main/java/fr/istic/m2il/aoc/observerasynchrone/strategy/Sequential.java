package fr.istic.m2il.aoc.observerasynchrone.strategy;

import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;
import fr.istic.m2il.aoc.observerasynchrone.observer.ObserverAsync;

/**
 * Represnts the sequential coherence diffusion strategy
 */
public class Sequential implements AlgoDiffusion{
    private Generator generator;
    @Override
    public void configure(Generator generator) {
        this.generator = generator;
    }

    @Override
    public void execute() {
        this.generator.generate();
        for(ObserverAsync<Generator> observerAsync:this.generator.getAsyncObservers()){
            observerAsync.update(this.generator);
        }
    }
}
