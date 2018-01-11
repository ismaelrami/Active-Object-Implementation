package fr.istic.m2il.aoc.observerasynchrone.displayer;

import fr.istic.m2il.aoc.observerasynchrone.channel.GeneratorAsync;
import fr.istic.m2il.aoc.observerasynchrone.observer.Observer;

/**
 * Represents Displayers Interface
 */
public interface Displayer extends Observer<GeneratorAsync> {
}
