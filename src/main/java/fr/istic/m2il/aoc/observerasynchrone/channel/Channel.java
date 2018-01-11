package fr.istic.m2il.aoc.observerasynchrone.channel;

import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;
import fr.istic.m2il.aoc.observerasynchrone.observer.Observer;
import fr.istic.m2il.aoc.observerasynchrone.observer.ObserverAsync;
import fr.istic.m2il.aoc.observerasynchrone.observer.Subject;


import java.util.Random;
import java.util.concurrent.*;

/**
 * Represents the proxy in Active Object Pattern. Its plays proxy role twice,
 * on one side from Subject of GeneratorAsync to ObserverAsync of Generator as async generator and other side
 * from ObserverAsync of Generator to Subject of GeneratorAsync
 */
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

    /**
     * Gets result of Update Method Invocation (to make the execution of update method asynchronous)
     * @param subjectasync the generator asynchronous which notify its asynchronous observers
     * @return Future of void of the Update Method Invocation
     */
    public Future<Void> update(Generator subjectasync) {
        Callable<Void> update = new Update(this, this.observersChannel);
        return this.scheduler.schedule(update,this.delay, TimeUnit.MILLISECONDS);
    }

    /**
     * Gets result of GetValue Method Invocation (to make the execution of getValue method asynchronous)
     * @return Future of Integer of the GetValue Method Invocation
     */
   public Future<Integer> getValue() {
        Callable<Integer> getValue = new GetValue(this.generator);
        return this.scheduler.schedule(getValue,this.delay, TimeUnit.MILLISECONDS);
    }

    @Override
    public void attach(Observer<GeneratorAsync> observer) {
        this.observersChannel = observer;
    }

    @Override
    public void detach(Observer<GeneratorAsync> observer) {
        this.observersChannel = null;
    }

    @Override
    public void notifyObservers() {

    }

    /**
     * Gets the value of delay attribute
     * @return value of delay attribute
     */
    public int getDelay() {
        return delay;
    }

    /**
     * Sets delay attribute
     * @param delay value set to delay attribute
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }
}


