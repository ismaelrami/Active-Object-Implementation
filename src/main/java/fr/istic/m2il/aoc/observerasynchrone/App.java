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
    /*public static void main( String[] args )
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
    }*/

    private Stage primaryStage;
    private AnchorPane mainView;
    @FXML
    private Button start;

    @FXML
    private Button stop;

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

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Observer asynchrone");

        initApplicationView();
        /*DisplayerController displayerController = new DisplayerController();
        displayerController.setMain(mainView);
        displayerController.setPrimaryStage(primaryStage);
        displayerController.initializeDisplayer();*/
        //showWiew();





    }

    public void initApplicationView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("view/displayer.fxml"));
            mainView = (AnchorPane) loader.load();

            Scene scene = new Scene(mainView);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
