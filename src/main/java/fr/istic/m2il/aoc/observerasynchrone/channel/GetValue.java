package fr.istic.m2il.aoc.observerasynchrone.channel;

import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;

import java.util.concurrent.Callable;

public class GetValue implements Callable<Integer>{

    private Generator generator;

    public GetValue(Generator generator) {
        this.generator = generator;
    }

    private Integer getValue(){
        return generator.getValue();
    }

    public Integer call() throws Exception {
        return this.getValue();
    }
}
