package fr.istic.m2il.aoc.observerasynchrone;

public class DisplayerImpl implements Displayer{


    public void update(Generator subject) {
        System.out.println(subject.getValue());
    }
}
