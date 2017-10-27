package fr.istic.m2il.aoc.observerasynchrone.displayer;

import fr.istic.m2il.aoc.observerasynchrone.channel.Channel;
import fr.istic.m2il.aoc.observerasynchrone.channel.DisplayerAsync;
import fr.istic.m2il.aoc.observerasynchrone.channel.GeneratorAsync;
import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;
import fr.istic.m2il.aoc.observerasynchrone.observer.Observer;
import fr.istic.m2il.aoc.observerasynchrone.observer.ObserverAsync;

public interface Displayer extends Observer<GeneratorAsync> {


}
