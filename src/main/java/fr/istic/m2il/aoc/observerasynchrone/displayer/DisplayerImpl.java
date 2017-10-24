package fr.istic.m2il.aoc.observerasynchrone.displayer;

import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;

public class DisplayerImpl implements Displayer{


    public void update(Generator subject) {
        System.out.println(subject.getValue());
    }
}
