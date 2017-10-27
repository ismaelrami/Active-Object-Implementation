package fr.istic.m2il.aoc.observerasynchrone.channel;

import java.util.concurrent.Future;


public interface GeneratorAsync {
    Future<Integer> getValue();
}
