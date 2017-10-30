package fr.istic.m2il.aoc.observerasynchrone;

import fr.istic.m2il.aoc.observerasynchrone.channel.Channel;
import fr.istic.m2il.aoc.observerasynchrone.displayer.Displayer;
import fr.istic.m2il.aoc.observerasynchrone.displayer.DisplayerImpl;
import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;
import fr.istic.m2il.aoc.observerasynchrone.generator.GeneratorImpl;
import fr.istic.m2il.aoc.observerasynchrone.strategy.AlgoDiffusion;
import fr.istic.m2il.aoc.observerasynchrone.strategy.Atomic;
import fr.istic.m2il.aoc.observerasynchrone.strategy.Sequential;

/**
 *
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
        Channel channel3 = new Channel(generator);
        generator.attach(channel3);
        Displayer displayer3 = new DisplayerImpl();
        channel3.attach(displayer3);
        Channel channel4 = new Channel(generator);
        generator.attach(channel4);
        Displayer displayer4 = new DisplayerImpl();
        channel4.attach(displayer4);

        for(int i=0; i< 15;i++){
            strategy1.execute();
        }
    }
}
