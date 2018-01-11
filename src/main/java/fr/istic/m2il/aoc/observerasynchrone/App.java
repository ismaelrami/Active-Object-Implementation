package fr.istic.m2il.aoc.observerasynchrone;

import fr.istic.m2il.aoc.observerasynchrone.channel.Channel;
import fr.istic.m2il.aoc.observerasynchrone.controller.DisplayerController;
import fr.istic.m2il.aoc.observerasynchrone.displayer.Displayer;
import fr.istic.m2il.aoc.observerasynchrone.displayer.DisplayerImpl;
import fr.istic.m2il.aoc.observerasynchrone.generator.Generator;
import fr.istic.m2il.aoc.observerasynchrone.generator.GeneratorImpl;
import fr.istic.m2il.aoc.observerasynchrone.strategy.AlgoDiffusion;
import fr.istic.m2il.aoc.observerasynchrone.strategy.Atomic;
import fr.istic.m2il.aoc.observerasynchrone.strategy.Sequential;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 *
 */
public class App extends Application
{
    private Stage primaryStage;
    private AnchorPane mainView;
    private DisplayerController controller;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Observer asynchrone");

        initApplicationView();

        primaryStage.setOnCloseRequest((event)-> {
            controller.stop();
            System.exit(0);
        });
    }

    public void initApplicationView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/displayer.fxml"));
            mainView = (AnchorPane) loader.load();
            controller = loader.getController();

            Scene scene = new Scene(mainView);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
