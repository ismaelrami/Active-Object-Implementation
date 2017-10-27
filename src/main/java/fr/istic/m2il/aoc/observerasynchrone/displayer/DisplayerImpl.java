package fr.istic.m2il.aoc.observerasynchrone.displayer;


import fr.istic.m2il.aoc.observerasynchrone.channel.GeneratorAsync;

import java.util.concurrent.ExecutionException;

public class DisplayerImpl implements Displayer{
    public void update(GeneratorAsync subject) {
        try {
            System.out.println(subject.getValue().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
