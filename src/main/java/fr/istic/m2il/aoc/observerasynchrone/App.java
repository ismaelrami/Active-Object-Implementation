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
        Channel channel1 = new Channel(generator);
        generator.attach(channel1);
        Displayer displayer1 = new DisplayerImpl();
        channel1.attach(displayer1);
        Channel channel2 = new Channel(generator);
        generator.attach(channel2);
        Displayer displayer2 = new DisplayerImpl();
        channel2.attach(displayer2);


        generator.generate();
    }
}
