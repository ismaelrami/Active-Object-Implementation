package fr.istic.m2il.aoc.observerasynchrone;

import fr.istic.m2il.aoc.observerasynchrone.channel.Channel;
import fr.istic.m2il.aoc.observerasynchrone.displayer.Displayer;
import fr.istic.m2il.aoc.observerasynchrone.displayer.DisplayerImpl;
import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;
import fr.istic.m2il.aoc.observerasynchrone.generator.GeneratorImpl;
import fr.istic.m2il.aoc.observerasynchrone.strategy.AlgoDiffusion;
import fr.istic.m2il.aoc.observerasynchrone.strategy.Atomic;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Generator generator = new GeneratorImpl();
        AlgoDiffusion strategy1 = new Atomic();
        strategy1.configure(generator);
        Channel channel1 = new Channel(generator);
        generator.attach(channel1);
        Displayer displayer1 = new DisplayerImpl();
        channel1.attach(displayer1);
        Channel channel2 = new Channel(generator);
        generator.attach(channel2);
        Displayer displayer2 = new DisplayerImpl();
        channel2.attach(displayer2);


        //generator.generate();
        for(int i=0; i< 6;i++){
            strategy1.execute();
        }
    }
}
