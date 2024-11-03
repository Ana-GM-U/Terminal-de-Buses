package controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Queue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import clases.*;

public class Controlador {

    @FXML
    private Label titulo;

    @FXML
    private ComboBox<String> tipoTablaComboBox;

    @FXML
    private ComboBox<String> empresaComboBox;

    @FXML
    private VBox tablasHoriosVbox;

    @FXML
    private Button botonAdministrador;

    @FXML
    private ImageView administrdorImg;

    @FXML
    private TableView<HorarioBus> tablaEntradas;

    @FXML
    private TableView<HorarioBus> tablaSalidas;

    @FXML
    private TableColumn<HorarioBus, String> origen;
    
    @FXML
    private TableColumn<HorarioBus, String> destino;

    @FXML
    private TableColumn<HorarioBus, String> horaEntradas;

    @FXML
    private TableColumn<HorarioBus, String> horaSalidas;


    @FXML
    public void initialize() {
        empresaComboBox.getItems().addAll("Compañía A", "Compañía B"); // Ejemplo de compañías
        tipoTablaComboBox.getItems().addAll("Horarios", "Andenes");

        botonAdministrador.setGraphic(administrdorImg);
        botonAdministrador.setOnAction(event -> {
            abrirVentanaAdministrador();
        });

    }

    @FXML
    public void abrirVentanaAdministrador() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/VistaAdministradorInicio.fxml"));
            Parent root = loader.load();

            Stage ventanaAdministrador = new Stage();
            ventanaAdministrador.setScene(new Scene(root));
            ventanaAdministrador.initModality(Modality.APPLICATION_MODAL);
            ventanaAdministrador.setTitle("Administrador");

            ventanaAdministrador.showAndWait();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*public void serializarLista(){
        try (FileOutputStream fileOut = new FileOutputStream("personas.txt");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(listaPersonas);
            System.out.println("La lista ha sido serializada y guardada en personas.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializarLista {
        try (FileInputStream fileIn = new FileInputStream("personas.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            listaPersonas = (ArrayList<Persona>) objectIn.readObject();
            System.out.println("La lista ha sido deserializada:");
            listaPersonas.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

  */  
    public static <E> void serializarObjeto(E objeto, String nombreArchivo) { 
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(objeto);
            //System.out.println("El objeto Persona ha sido serializado y guardado en persona.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <E> E deserializarObjeto(String nombreArchivo) { 
        try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (E) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* 
    public void serializarCola() { 
        try (FileOutputStream fileOut = new FileOutputStream("colaPersonas.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(colaPersonas);
            System.out.println("La cola ha sido serializada y guardada en colaPersonas.txt");
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public void deserializarCola() { 
        try (FileInputStream fileIn = new FileInputStream("colaPersonas.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            colaPersonas = (Queue<Persona>) objectIn.readObject();
            System.out.println("La cola deserializada es:");
            colaPersonas.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
*/

    public static boolean estaVacio(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        return archivo.length() == 0;
    }
}
