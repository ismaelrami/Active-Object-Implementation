package fr.istic.m2il.aoc.observerasynchrone.channel;

import fr.istic.m2il.aoc.observerasynchrone.GetValue;
import fr.istic.m2il.aoc.observerasynchrone.Update;
import fr.istic.m2il.aoc.observerasynchrone.displayer.Displayer;
import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;
import fr.istic.m2il.aoc.observerasynchrone.observer.Observer;
import fr.istic.m2il.aoc.observerasynchrone.observer.ObserverAsync;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Channel implements DisplayerAsync, GeneratorAsync/*, Subject<GeneratorAsync>*/ {

    private Displayer displayer;
    private Generator generator;
    ScheduledExecutorService scheduler;
    private List<Observer<GeneratorAsync>> observersGeneratorAsync = new ArrayList<Observer<GeneratorAsync>>();

    public Channel(Generator generator, Displayer displayer) {
        this.generator = generator;
        this.displayer = displayer;
        this.scheduler = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
    }


    public Future<Void> update(Generator subjectasync) {
        Callable<Void> update = new Update(this.displayer, this);

        Random randomGenerator = new Random();
        int delay = randomGenerator.nextInt(5);
        return this.scheduler.schedule(update,delay, TimeUnit.SECONDS);

    }

   public Future<Integer> getValue() {
        Callable<Integer> getValue = new GetValue(this.generator);
        Random randomGenerator = new Random();
        int delay = randomGenerator.nextInt(1);
        return this.scheduler.schedule(getValue, delay, TimeUnit.SECONDS);
    }

    public void attach(ObserverAsync<Generator> observerAsync) {
        this.generator.attach(observerAsync);
    }

    public void detach(ObserverAsync<Generator> observerAsync) {
        this.generator.detach(observerAsync);
    }

    public void notifyObservers() {
        this.generator.notifyObservers();
    }
}


