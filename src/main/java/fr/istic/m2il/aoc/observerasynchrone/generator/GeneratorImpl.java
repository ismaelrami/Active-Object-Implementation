package fr.istic.m2il.aoc.observerasynchrone.generator;

import fr.istic.m2il.aoc.observerasynchrone.observer.ObserverAsync;
import fr.istic.m2il.aoc.observerasynchrone.strategy.AlgoDiffusion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorImpl implements Generator {

    private List<ObserverAsync<Generator>> observers = new ArrayList<ObserverAsync<Generator>>();
    private Integer value;
    private AlgoDiffusion strategy;

    public Integer getValue() {
        return this.value;
    }

    public void generate() {
        Random r = new Random();
        this.value = r.nextInt(100);
    }

    public void attach(ObserverAsync<Generator> observerAsync) {
        this.observers.add(observerAsync);
    }

    public void detach(ObserverAsync<Generator> observerAsync) {
        this.observers.remove(observerAsync);
    }

    public void notifyObservers() {

    }

    public AlgoDiffusion getStrategy() {
        return strategy;
    }

    public void setStrategy(AlgoDiffusion strategy) {
        this.strategy = strategy;
    }

    public List<ObserverAsync<Generator>> getAsyncObservers(){
        return this.observers;
    }
}
