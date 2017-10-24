package fr.istic.m2il.aoc.observerasynchrone;

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
