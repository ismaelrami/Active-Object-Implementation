package fr.istic.m2il.aoc.observerasynchrone.displayer;

import fr.istic.m2il.aoc.observerasynchrone.channel.Channel;
import java.util.concurrent.ExecutionException;

public class DisplayerImpl implements Displayer{


    public void update(Channel channel) {

        try {
            System.out.println(channel.getValue().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
