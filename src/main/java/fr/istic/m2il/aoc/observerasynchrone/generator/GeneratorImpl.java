package fr.istic.m2il.aoc.observerasynchrone.generator;

import fr.istic.m2il.aoc.observerasynchrone.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorImpl implements Generator {

    private List<Observer<Generator>> observers = new ArrayList<Observer<Generator>>();
    private Integer value;

    public Integer getValue() {
        return this.value;
    }



    public void attach(Observer<Generator> observer) {
        this.observers.add(observer);
    }

    public void detach(Observer<Generator> observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer<Generator> observer:this.observers){
            observer.update(this);
        }
    }

    public void generate() {
        Random r = new Random();
        this.value = r.nextInt(100);
        notifyObservers();
    }
}
