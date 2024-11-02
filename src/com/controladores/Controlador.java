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

import java.io.IOException;

import clases.*;

public class Controlador {

    @FXML
    private Label titulo;

    
    @FXML
    private ComboBox<String> tipoTablaComboBox;

    @FXML
    private ComboBox<String> companiaComboBox;

    @FXML
    private VBox tablasHoriosVbox;

    @FXML
    private Label entradaLabel;

    @FXML
    private Button botonAdministrador;

    @FXML
    private ImageView administrdorImg;

    @FXML
    private TableView<Viaje> tablaEntradas;

    @FXML
    private TableView<Viaje> tablaSalidas;

    @FXML
    private TableColumn<Viaje, String> origen;
    
    @FXML
    private TableColumn<Viaje, String> destino;

    @FXML
    private TableColumn<Viaje, String> horaEntradas;

    @FXML
    private TableColumn<Viaje, String> horaSalidas;


    @FXML
    public void initialize() {
        companiaComboBox.getItems().addAll("Compañía A", "Compañía B"); // Ejemplo de compañías
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


}
