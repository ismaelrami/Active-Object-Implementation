package fr.istic.m2il.aoc.observerasynchrone.channel;

import fr.istic.m2il.aoc.observerasynchrone.channel.Channel;
import fr.istic.m2il.aoc.observerasynchrone.displayer.Displayer;
import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;

import java.util.concurrent.Callable;

public class Update implements Callable<Void> {

    private Displayer displayer;
    private Channel channel;

    public Update(Displayer displayer, Channel channel) {

        this.displayer = displayer;
        this.channel = channel;

    }

    private void update(Channel channel){
        this.displayer.update(channel);
    }
    public Void call() throws Exception {
        this.displayer.update(this.channel);
        return null;
    }
}
