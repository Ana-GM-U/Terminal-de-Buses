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
    private Tab pestanaEmpresa;


    @FXML
    private Button adelanteBoton;

    @FXML
    private Button agregarEmpresaBoton;

    @FXML
    private TextField cantidadAndenLlegadaCampo;

    @FXML
    private TextField cantidadAndenSalidaCampo;

    @FXML
    private TextField empresaCampo;

    @FXML
    private Button editarHorasAndenesBoton;

    @FXML
    private Button editarEmpresaBoton;

    @FXML
    private Button eliminarEmpresaBoton;

    @FXML
    private Button ingresarHorasAndenesBoton;

    @FXML
    private ListView<String> listaEmpresaView;
    
    private ObservableList<String> listaEmpresas;

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

    private ObservableList<String> listaOrigen;

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

    private ObservableList<String> listaDestino;

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

    private ObservableList<String> listaHora;

    @FXML
    private Button atrasBoton;

    @FXML
    private Button adelanteBoton1;

    @FXML
    private TextField horaAperturaCampo;

    @FXML
    private TextField horaCierreCampo;


    int cantidadAndenesLlegada;
    int cantidadAndenesSalida;
    List<Empresa> empresas;

    @FXML
    public void initialize() {
        //tabPane.getSelectionModel().select(pestanaTerminal);

        listaEmpresas = FXCollections.observableArrayList();
        listaOrigen = FXCollections.observableArrayList();
        listaDestino = FXCollections.observableArrayList();
        listaHora = FXCollections.observableArrayList();
        listaEmpresaView.setItems(listaEmpresas);

        editarHorasAndenesBoton.setDisable(true);
        editarEmpresaBoton.setDisable(true);
        eliminarEmpresaBoton.setDisable(true);

        ingresarHorasAndenesBoton.setOnAction(event -> {
            agregarHorasAndenes();
            
        });

        editarHorasAndenesBoton.setOnAction(event -> {
            cantidadAndenLlegadaCampo.clear();
            cantidadAndenSalidaCampo.clear();
            ingresarHorasAndenesBoton.setDisable(false);
            editarHorasAndenesBoton.setDisable(true);
            cantidadAndenLlegadaCampo.setDisable(false);
            cantidadAndenSalidaCampo.setDisable(false);
        });

        agregarEmpresaBoton.setOnAction(event -> {
            agregarAList(empresaCampo, listaEmpresas);
            agregarEmpresaBoton.setDisable(true);
            editarEmpresaBoton.setDisable(false);
            empresaCampo.setDisable(true);
            eliminarEmpresaBoton.setDisable(false);
        });

        editarEmpresaBoton.setOnAction(event -> {
            agregarEmpresaBoton.setDisable(false);
            editarEmpresaBoton.setDisable(true);
            empresaCampo.setDisable(false);
            editarList(listaEmpresaView, empresaCampo, listaEmpresas);
        });

        eliminarEmpresaBoton.setOnAction(event -> {
            agregarEmpresaBoton.setDisable(false);
            empresaCampo.setDisable(false);
            eliminarDeList(listaEmpresaView, listaEmpresas, empresaCampo);
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


        adelanteBoton.setOnAction(event -> {abrirPestanaEmpresas(listaEmpresas); System.out.println("ffgbhnmj,");});


    }


    private void agregarHorasAndenes(){
        if(validarHora(horaAperturaCampo.getText()) && validarHora(horaCierreCampo.getText())){
    
            if((!cantidadAndenLlegadaCampo.getText().isEmpty() && esEntero(cantidadAndenLlegadaCampo.getText()))){
                if((!cantidadAndenSalidaCampo.getText().isEmpty() && esEntero(cantidadAndenSalidaCampo.getText()))){
                    int cantidadIngresadaLlegada = Integer.parseInt(cantidadAndenLlegadaCampo.getText().strip());
                    int cantidadIngresadaSalida = Integer.parseInt(cantidadAndenSalidaCampo.getText().strip());
                    if((0<cantidadIngresadaLlegada && cantidadIngresadaLlegada<15) && (0<cantidadIngresadaSalida && cantidadIngresadaSalida<15) ){
                        cantidadAndenesLlegada =cantidadIngresadaLlegada;
                        cantidadAndenesSalida = cantidadIngresadaLlegada;
                        ingresarHorasAndenesBoton.setDisable(true);
                        editarHorasAndenesBoton.setDisable(false);
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
                    ingresarHorasAndenesBoton.setDisable(false);
                    editarHorasAndenesBoton.setDisable(true);
                }
            }
            else{
                abrirVentanaError("Cantidad/es inválida/s");
                cantidadAndenLlegadaCampo.clear();
                cantidadAndenSalidaCampo.clear();
                ingresarHorasAndenesBoton.setDisable(false);
                editarHorasAndenesBoton.setDisable(true);
            }
        }
        else{
            abrirVentanaError("Hora inválida");
            horaAperturaCampo.clear();
            horaCierreCampo.clear();
            ingresarHorasAndenesBoton.setDisable(false);
            editarHorasAndenesBoton.setDisable(true);
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


    public void abrirPestanaEmpresas(ObservableList<String> listaEmpresas){

        System.out.println("eee");
        pestanaEmpresa.setDisable(false);
        pestanaTerminal.setDisable(true);
        tabPane.getSelectionModel().select(pestanaEmpresa);

    }


    public void abrirVentanaError(String mensaje){

        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText("Error de ingreso");
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }



}
