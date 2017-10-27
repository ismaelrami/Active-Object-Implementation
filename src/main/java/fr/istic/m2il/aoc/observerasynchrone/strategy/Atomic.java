package fr.istic.m2il.aoc.observerasynchrone.strategy;

import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;
import fr.istic.m2il.aoc.observerasynchrone.observer.ObserverAsync;

import java.util.concurrent.ExecutionException;

public class Atomic implements AlgoDiffusion {
    private Generator generator;
    public void configure(Generator generator) {
        this.generator = generator;
    }

    public void execute() {
        this.generator.generate();
        for(ObserverAsync<Generator> observerAsync: this.generator.getAsyncObservers()){
            try {
                observerAsync.update(this.generator).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
