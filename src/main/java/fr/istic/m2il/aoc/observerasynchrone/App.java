package fr.istic.m2il.aoc.observerasynchrone;

import fr.istic.m2il.aoc.observerasynchrone.displayer.Displayer;
import fr.istic.m2il.aoc.observerasynchrone.displayer.DisplayerImpl;
import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;
import fr.istic.m2il.aoc.observerasynchrone.generator.GeneratorImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Generator generator = new GeneratorImpl();
        Displayer displayer1 = new DisplayerImpl();
        generator.attach(displayer1);
        Displayer displayer2 = new DisplayerImpl();
        generator.attach(displayer2);
        generator.generate();
    }
}
