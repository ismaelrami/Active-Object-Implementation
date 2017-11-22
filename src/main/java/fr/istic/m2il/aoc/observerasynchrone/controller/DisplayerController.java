package fr.istic.m2il.aoc.observerasynchrone.controller;

import fr.istic.m2il.aoc.observerasynchrone.strategy.Sequential;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.m2il.aoc.observerasynchrone.channel.Channel;
import fr.istic.m2il.aoc.observerasynchrone.displayer.Displayer;
import fr.istic.m2il.aoc.observerasynchrone.displayer.DisplayerImpl;
import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;
import fr.istic.m2il.aoc.observerasynchrone.generator.GeneratorImpl;
import fr.istic.m2il.aoc.observerasynchrone.strategy.AlgoDiffusion;
import fr.istic.m2il.aoc.observerasynchrone.strategy.Atomic;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DisplayerController implements Initializable {

    @FXML
    private Label valueDisplayer1;

    @FXML
    private Label valueDisplayer2;

    @FXML
    private Label valueDisplayer3;

    @FXML
    private Label valueDisplayer4;

    @FXML
    private RadioButton atomic;

    @FXML
    private RadioButton sequential;

    @FXML
    private Button start;

    @FXML
    private Button stop;

    private AlgoDiffusion strategy;
    private Generator generator;
    ScheduledExecutorService service;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        generator = new GeneratorImpl();
        Channel channel1 = new Channel(generator, 0);
        generator.attach(channel1);
        Displayer displayer1 = new DisplayerImpl(valueDisplayer1);

        channel1.attach(displayer1);
        Channel channel2 = new Channel(generator, 50);
        generator.attach(channel2);
        Displayer displayer2 = new DisplayerImpl(valueDisplayer2);
        channel2.attach(displayer2);
        Channel channel3 = new Channel(generator, 200);
        generator.attach(channel3);
        Displayer displayer3 = new DisplayerImpl(valueDisplayer3);
        channel3.attach(displayer3);
        Channel channel4 = new Channel(generator,500);
        generator.attach(channel4);
        Displayer displayer4 = new DisplayerImpl(valueDisplayer4);
        channel4.attach(displayer4);



    }

    @FXML
    private void start(){
        service = Executors.newScheduledThreadPool(Integer.MAX_VALUE);
        service.scheduleAtFixedRate(() -> this.strategy.execute(), 0, 1000, TimeUnit.MILLISECONDS);
        start.setDisable(true);
        stop.setDisable(false);
    }

    @FXML
    public void stop() {

        this.service.shutdown();
        stop.setDisable(true);
        start.setDisable(false);
    }

    @FXML
    public void changeStrategyToSequential(){
        this.strategy = new Sequential();
        this.strategy.configure(this.generator);
    }

    @FXML
    public void changeStrategyToAtomic(){
        this.strategy = new Atomic();
        this.strategy.configure(this.generator);
    }

}
