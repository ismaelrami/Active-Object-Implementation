package fr.istic.m2il.aoc.observerasynchrone.observer;

import java.util.concurrent.Future;

public interface ObserverAsync <T>  {
    Future<Void> update(T subjectasync);

}