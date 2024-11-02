package controladores;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import clases.*;

public class ControladorAdministradorTerminal {

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab pestanaTerminal;

    @FXML
    private Tab pestanaCompania;


    @FXML
    private Button adelanteBoton;

    @FXML
    private Button agregarCompaniaBoton;

    @FXML
    private TextField cantidadAndenLlegadaCampo;

    @FXML
    private TextField cantidadAndenSalidaCampo;

    @FXML
    private TextField companiaCampo;

    @FXML
    private Button editarAndenesBoton;

    @FXML
    private Button editarCompaniaBoton;

    @FXML
    private Button eliminarCompaniaBoton;

    @FXML
    private Button ingresarAndenesBoton;

    @FXML
    private ListView<String> listaCompaniaView;
    
    private ObservableList<String> listaCompanias = FXCollections.observableArrayList();

    @FXML
    private TextField origenCampo;

    @FXML
    private Button ingresarOrigenBoton;

    @FXML
    private Button editarOrigenBoton;

    @FXML
    private Button eliminarOrigenBoton;

    @FXML
    private ListView<String> listaOrigenView;

    private ObservableList<String> listaOrigen = FXCollections.observableArrayList();

    @FXML
    private TextField destinoCampo;

    @FXML
    private Button ingresarDestinoBoton;

    @FXML
    private Button editarDestinoBoton;

    @FXML
    private Button eliminarDestinoBoton;

    @FXML
    private ListView<String> listaDestinoView;

    private ObservableList<String> listaDestino = FXCollections.observableArrayList();

    @FXML
    private TextField horaCampo;

    @FXML
    private Button ingresarHoraBoton;

    @FXML
    private Button editarHoraBoton;

    @FXML
    private Button eliminarHoraBoton;

    @FXML
    private ListView<String> listaHoraView;

    private ObservableList<String> listaHora = FXCollections.observableArrayList();

    @FXML
    private Button atrasBoton;

    @FXML
    private Button adelanteBoton1;


    int cantidadAndenesLlegada;
    int cantidadAndenesSalida;
    List<Compania> companias;

    @FXML
    public void initialize() {
        //tabPane.getSelectionModel().select(pestanaTerminal);

        editarAndenesBoton.setDisable(true);
        editarCompaniaBoton.setDisable(true);
        eliminarCompaniaBoton.setDisable(true);

        ingresarAndenesBoton.setOnAction(event -> {
            agregarCantidadAndenes();
            
        });

        editarAndenesBoton.setOnAction(event -> {
            cantidadAndenLlegadaCampo.clear();
            cantidadAndenSalidaCampo.clear();
            ingresarAndenesBoton.setDisable(false);
            editarAndenesBoton.setDisable(true);
            cantidadAndenLlegadaCampo.setDisable(false);
            cantidadAndenSalidaCampo.setDisable(false);
        });

        agregarCompaniaBoton.setOnAction(event -> {
            agregarAList(companiaCampo, listaCompanias);
            agregarCompaniaBoton.setDisable(true);
            editarCompaniaBoton.setDisable(false);
            companiaCampo.setDisable(true);
            eliminarCompaniaBoton.setDisable(false);
        });

        editarCompaniaBoton.setOnAction(event -> {
            agregarCompaniaBoton.setDisable(false);
            editarCompaniaBoton.setDisable(true);
            companiaCampo.setDisable(false);
            editarList(listaCompaniaView, companiaCampo, listaCompanias);
        });

        eliminarCompaniaBoton.setOnAction(event -> {
            agregarCompaniaBoton.setDisable(false);
            companiaCampo.setDisable(false);
            eliminarDeList(listaCompaniaView, listaCompanias, companiaCampo);
        });


        ingresarOrigenBoton.setOnAction(event -> {
            agregarAList(origenCampo, listaOrigen);
            ingresarOrigenBoton.setDisable(true);
            editarOrigenBoton.setDisable(false);
            origenCampo.setDisable(true);
            eliminarOrigenBoton.setDisable(false);
        });

        editarOrigenBoton.setOnAction(event -> {
            ingresarOrigenBoton.setDisable(false);
            editarOrigenBoton.setDisable(true);
            origenCampo.setDisable(false);
            editarList(listaOrigenView, origenCampo, listaOrigen);
        });

        eliminarOrigenBoton.setOnAction(event -> {
            ingresarOrigenBoton.setDisable(false);
            origenCampo.setDisable(false);
            eliminarDeList(listaOrigenView, listaOrigen, origenCampo);
        });


        ingresarDestinoBoton.setOnAction(event -> {
            agregarAList(destinoCampo, listaDestino);

            ingresarDestinoBoton.setDisable(true);
            editarDestinoBoton.setDisable(false);
            destinoCampo.setDisable(true);
            eliminarDestinoBoton.setDisable(false);
        });

        editarDestinoBoton.setOnAction(event -> {
            ingresarDestinoBoton.setDisable(false);
            editarDestinoBoton.setDisable(true);
            destinoCampo.setDisable(false);
            editarList(listaDestinoView, destinoCampo, listaDestino);
        });

        eliminarDestinoBoton.setOnAction(event -> {
            ingresarDestinoBoton.setDisable(false);
            destinoCampo.setDisable(false);
            eliminarDeList(listaDestinoView, listaDestino, destinoCampo);
        });

        
        ingresarHoraBoton.setOnAction(event -> {
            if(validarHora(horaCampo.getText())){
                agregarAList(horaCampo, listaHora);
                ingresarHoraBoton.setDisable(true);
                editarHoraBoton.setDisable(false);
                horaCampo.setDisable(true);
                eliminarHoraBoton.setDisable(false);
            }
            else{
                abrirVentanaError("Hora inválida");
            }
        });

        editarHoraBoton.setOnAction(event -> {
            if(validarHora(horaCampo.getText())){
                ingresarHoraBoton.setDisable(false);
                editarDestinoBoton.setDisable(true);
                horaCampo.setDisable(false);
                editarList(listaHoraView, horaCampo, listaHora);
            }
            else{
                abrirVentanaError("Hora inválida");
            }
        });

        eliminarHoraBoton.setOnAction(event -> {
            if(validarHora(horaCampo.getText())){
                ingresarHoraBoton.setDisable(false);
                horaCampo.setDisable(false);
                eliminarDeList(listaHoraView, listaHora, horaCampo);
                
            }
            else{
                abrirVentanaError("Hora inválida");
            }
        
        });


        adelanteBoton.setOnAction(event -> {abrirPestanaCompanias(listaCompanias); System.out.println("ffgbhnmj,");});


    }


    private void agregarCantidadAndenes(){
        if((!cantidadAndenLlegadaCampo.getText().isEmpty() && esEntero(cantidadAndenLlegadaCampo.getText()))){
            if((!cantidadAndenSalidaCampo.getText().isEmpty() && esEntero(cantidadAndenSalidaCampo.getText()))){
                int cantidadIngresadaLlegada = Integer.parseInt(cantidadAndenLlegadaCampo.getText().strip());
                int cantidadIngresadaSalida = Integer.parseInt(cantidadAndenSalidaCampo.getText().strip());
                if((0<cantidadIngresadaLlegada && cantidadIngresadaLlegada<15) && (0<cantidadIngresadaSalida && cantidadIngresadaSalida<15) ){
                    cantidadAndenesLlegada =cantidadIngresadaLlegada;
                    cantidadAndenesSalida = cantidadIngresadaLlegada;
                    ingresarAndenesBoton.setDisable(true);
                    editarAndenesBoton.setDisable(false);
                    cantidadAndenLlegadaCampo.setDisable(true);
                    cantidadAndenSalidaCampo.setDisable(true);
                }
                else{
                    abrirVentanaError("Cantidad/es inválida/s");
                    cantidadAndenLlegadaCampo.clear();
                    cantidadAndenSalidaCampo.clear();
                }
            }
            else{
                abrirVentanaError("Cantidad/es inválida/s");
                cantidadAndenLlegadaCampo.clear();
                cantidadAndenSalidaCampo.clear();
                ingresarAndenesBoton.setDisable(false);
                editarAndenesBoton.setDisable(true);
            }
        }
        else{
            abrirVentanaError("Cantidad/es inválida/s");
            cantidadAndenLlegadaCampo.clear();
            cantidadAndenSalidaCampo.clear();
            ingresarAndenesBoton.setDisable(false);
            editarAndenesBoton.setDisable(true);
        }
    }

    private void agregarAList(TextField ingreso, ObservableList<String> lista) {
        String nuevo = ingreso.getText().strip();
        if (!nuevo.isEmpty() && !lista.contains(nuevo)) {
            lista.add(nuevo);
            ingreso.clear();
        }
        else{
            abrirVentanaError("Ingreso inválido");
        }
    }
    
    private void editarList(ListView<String> listView, TextField ingreso, ObservableList<String> lista) {
        String seleccion = listView.getSelectionModel().getSelectedItem();
        String nuevo = ingreso.getText().strip();
    
        if (seleccion != null && !nuevo.isEmpty()) {
            int indice = lista.indexOf(seleccion);
            lista.set(indice, nuevo);
            ingreso.clear();
            listView.getSelectionModel().clearSelection();
        }
        else{
            abrirVentanaError("Ingreso inválido");
        }
    }
    
    private void eliminarDeList(ListView<String> listView, ObservableList<String> lista, TextField ingreso) {
        String seleccion = listView.getSelectionModel().getSelectedItem();
    
        if (seleccion != null) {
            lista.remove(seleccion);
            ingreso.clear();
            listView.getSelectionModel().clearSelection();
        }
        else{
            abrirVentanaError("Selección inválida");
        }
    }


    public boolean validarHora(String hora){
        String patronHora = "^([01]?\\d|2[0-3]):[0-5]\\d$"; 
        return hora.matches(patronHora);
    }


    public boolean esEntero(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public void abrirPestanaCompanias(ObservableList<String> listaCompanias){

        System.out.println("eee");
        pestanaCompania.setDisable(false);
        pestanaTerminal.setDisable(true);
        tabPane.getSelectionModel().select(pestanaCompania);

    }


    public void abrirVentanaError(String mensaje){

        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText("Error de ingreso");
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }



}
