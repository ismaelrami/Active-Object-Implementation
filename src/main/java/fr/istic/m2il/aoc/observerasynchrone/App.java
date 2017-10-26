package fr.istic.m2il.aoc.observerasynchrone;

import fr.istic.m2il.aoc.observerasynchrone.channel.Channel;
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
        Channel channel1 = new Channel(generator, displayer1);
        generator.attach(channel1);
        Displayer displayer2 = new DisplayerImpl();
        Channel channel2 = new Channel(generator, displayer2);
        generator.attach(channel2);
        generator.generate();
    }
}
