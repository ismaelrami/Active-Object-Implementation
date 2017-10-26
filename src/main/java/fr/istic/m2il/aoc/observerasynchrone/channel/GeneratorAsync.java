package fr.istic.m2il.aoc.observerasynchrone.channel;

import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;
import fr.istic.m2il.aoc.observerasynchrone.observer.SubjectAsync;

import java.util.concurrent.Future;


public interface GeneratorAsync extends SubjectAsync<Generator>{
    Future<Integer> getValue();
}
