package fr.istic.m2il.aoc.observerasynchrone.displayer;


import fr.istic.m2il.aoc.observerasynchrone.channel.GeneratorAsync;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.concurrent.ExecutionException;

public class DisplayerImpl implements Displayer{
    @FXML
    private Label displayer;

    public DisplayerImpl(Label displayer) {
        this.displayer = displayer;
    }

    public void update(GeneratorAsync subject) {
        try {
            System.out.println(subject.getValue().get());
            String value = subject.getValue().get().toString();
            Platform.runLater(() -> displayer.setText(value));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
