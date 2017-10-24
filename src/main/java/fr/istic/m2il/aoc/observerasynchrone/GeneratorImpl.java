package fr.istic.m2il.aoc.observerasynchrone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorImpl implements Generator {

    private List<Displayer> observers = new ArrayList<Displayer>();
    private Integer value;

    public Integer getValue() {
        return this.value;
    }


    public void attach(Displayer observer) {

    }

    public void detach(Displayer observer) {

    }

    public void notifyObservers() {
        for (Displayer observer:this.observers){
            observer.update(this);
        }
    }

    public void generate() {
        Random r = new Random();
        this.value = r.nextInt(100);
        notifyObservers();
    }
}
