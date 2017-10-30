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

    public Channel(Generator generator) {
        this.generator = generator;
        this.scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
    }


    public Future<Void> update(Generator subjectasync) {
        Callable<Void> update = new Update(this, this.observersChannel);
        Random randomGenerator = new Random();
        int delay = randomGenerator.nextInt(1);
        return this.scheduler.schedule(update,delay, TimeUnit.SECONDS);


    }

   public Future<Integer> getValue() {
        Callable<Integer> getValue = new GetValue(this.generator);
        Random randomGenerator = new Random();
        int delay = randomGenerator.nextInt(1);
        return this.scheduler.schedule(getValue, delay, TimeUnit.SECONDS);
    }

    public void attach(Observer<GeneratorAsync> observer) {
        this.observersChannel = observer;
    }

    public void detach(Observer<GeneratorAsync> observer) {
        this.observersChannel = null;
    }

    public void notifyObservers() {

    }

   /* public void attach(ObserverAsync<Generator> observerAsync) {
        this.generator.attach(observerAsync);
    }

    public void detach(ObserverAsync<Generator> observerAsync) {
        this.generator.detach(observerAsync);
    }

    public void notifyObservers() {
        this.generator.notifyObservers();
    }*/
}


