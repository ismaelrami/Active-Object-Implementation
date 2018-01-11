package fr.istic.m2il.aoc.observerasynchrone.channel;

import fr.istic.m2il.aoc.observerasynchrone.observer.Observer;

import java.util.concurrent.Callable;

public class Update implements Callable<Void> {

    private GeneratorAsync generatorAsync;
    private Observer<GeneratorAsync> obsever;

    public Update(GeneratorAsync generatorAsync, Observer<GeneratorAsync> obsever) {
        this.generatorAsync = generatorAsync;
        this.obsever = obsever;
    }

    /**
     * Update the Displayer with the new value generate by generator asynchronously
     * @return value of Displayer.update() method synchronously
     */
    private void update(){
        this.obsever.update(this.generatorAsync);
    }
    public Void call() throws Exception {
        update();
        return null;
    }
}
