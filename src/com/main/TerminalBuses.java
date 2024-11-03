package main;
//import controladores.Controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Queue;

import clases.Administrador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TerminalBuses extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/Vista.fxml"));
        Parent root = loader.load();
        //Controlador controlador = loader.getController();
        //controlador.setMainWindow(primaryStage);
        primaryStage.setTitle("App");
        primaryStage.setScene(new Scene(root));
        //primaryStage.setResizable(false);
        primaryStage.show();
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}
