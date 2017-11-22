package fr.istic.m2il.aoc.observerasynchrone.channel;

import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;
import fr.istic.m2il.aoc.observerasynchrone.observer.Observer;
import fr.istic.m2il.aoc.observerasynchrone.observer.ObserverAsync;
import fr.istic.m2il.aoc.observerasynchrone.observer.Subject;


import java.util.Random;
import java.util.concurrent.*;

public class Channel implements ObserverAsync<Generator>, GeneratorAsync , Subject<GeneratorAsync>{

    private Generator generator;
    ScheduledExecutorService scheduler;
    private Observer<GeneratorAsync> observersChannel ;
    private int delay;

    public Channel(Generator generator, int delay) {
        this.delay = delay;
        this.generator = generator;
        this.scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
    }


    public Future<Void> update(Generator subjectasync) {
        Callable<Void> update = new Update(this, this.observersChannel);
        return this.scheduler.schedule(update,this.delay, TimeUnit.MILLISECONDS);


    }

   public Future<Integer> getValue() {
        Callable<Integer> getValue = new GetValue(this.generator);
        return this.scheduler.schedule(getValue,this.delay, TimeUnit.MILLISECONDS);
    }

    public void attach(Observer<GeneratorAsync> observer) {
        this.observersChannel = observer;
    }

    public void detach(Observer<GeneratorAsync> observer) {
        this.observersChannel = null;
    }

    public void notifyObservers() {

    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}


