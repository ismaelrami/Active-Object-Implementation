package fr.istic.m2il.aoc.observerasynchrone.generator;

import fr.istic.m2il.aoc.observerasynchrone.observer.Observer;
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



/*    public void attach(Observer<Generator> observer) {
        this.observers.add(observer);
    }

    public void detach(Observer<Generator> observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer<Generator> observer:this.observers){
            observer.update(this);
        }
    }*/

    public void generate() {
        //this.strategy.execute();
        Random r = new Random();
        this.value = r.nextInt(100);
        notifyObservers();
    }

    public void attach(ObserverAsync<Generator> observerAsync) {
        this.observers.add(observerAsync);
    }

    public void detach(ObserverAsync<Generator> observerAsync) {
        this.observers.remove(observerAsync);
    }

    public void notifyObservers() {
        for(ObserverAsync<Generator> observerAsync:this.observers){
            observerAsync.update(this);
        }
    }

    public AlgoDiffusion getStrategy() {
        return strategy;
    }

    public void setStrategy(AlgoDiffusion strategy) {
        this.strategy = strategy;
    }
}
