package controladores;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Tab pestanaEmpresa1;

    @FXML
    private Button siguienteBoton;

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
    private ListView<String> listaEmpresasView;
    
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
    private TextField horaAperturaCampo;

    @FXML
    private TextField horaCierreCampo;

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
    private Label empresaLabel;

    @FXML
    private TextField  duracionCampo;

    @FXML
    private Button ingresarDuracionBoton;

    @FXML
    private Button editarDuracionBoton;


    @FXML
    private Button  eliminarDuracionBoton;

    @FXML
    private ListView<String> listaDuracionView;

    private ObservableList<String> listaDuracion;

    @FXML
    private Button siguienteBoton1;
    
    int cantidadAndenesLlegada;
    int cantidadAndenesSalida;
    int horaApertura;
    int horaCierre;
    List<Empresa> empresas = new ArrayList<>();

    @FXML
    public void initialize() {
        editarHorasAndenesBoton.setDisable(true);
        tabPane.getSelectionModel().select(pestanaTerminal);

        listaEmpresas = FXCollections.observableArrayList();
        listaOrigen = FXCollections.observableArrayList();
        listaDestino = FXCollections.observableArrayList();
        listaHora = FXCollections.observableArrayList();
        listaDuracion = FXCollections.observableArrayList();;

        listaEmpresasView.setItems(listaEmpresas);
        listaOrigenView.setItems(listaOrigen);
        listaDestinoView.setItems(listaDestino);
        listaHoraView.setItems(listaHora);
        listaDuracionView.setItems(listaDuracion);

        ingresarHorasAndenesBoton.setOnAction(event -> {
            agregarHorasAndenes();
            
        });

        editarHorasAndenesBoton.setOnAction(event -> {
            ingresarHorasAndenesBoton.setDisable(false);
            editarHorasAndenesBoton.setDisable(true);
            cantidadAndenLlegadaCampo.setDisable(false);
            cantidadAndenSalidaCampo.setDisable(false);
            horaAperturaCampo.setDisable(false);
            horaCierreCampo.setDisable(false);
        });

        agregarEmpresaBoton.setOnAction(event -> {
            agregarAList(empresaCampo, listaEmpresas);
        });

        editarEmpresaBoton.setOnAction(event -> {
            editarList(listaEmpresasView, empresaCampo, listaEmpresas);
        });

        eliminarEmpresaBoton.setOnAction(event -> {
            eliminarDeList(listaEmpresasView, listaEmpresas, empresaCampo);
        });


        ingresarOrigenBoton.setOnAction(event -> {
            agregarAList(origenCampo, listaOrigen);
        });

        editarOrigenBoton.setOnAction(event -> {
            editarList(listaOrigenView, origenCampo, listaOrigen);
        });

        eliminarOrigenBoton.setOnAction(event -> {
            eliminarDeList(listaOrigenView, listaOrigen, origenCampo);
        });


        ingresarDestinoBoton.setOnAction(event -> {
            agregarAList(destinoCampo, listaDestino);
        });

        editarDestinoBoton.setOnAction(event -> {
            editarList(listaDestinoView, destinoCampo, listaDestino);
        });

        eliminarDestinoBoton.setOnAction(event -> {
            eliminarDeList(listaDestinoView, listaDestino, destinoCampo);
        });

        
        ingresarHoraBoton.setOnAction(event -> {
            if(validarHora(horaCampo.getText())){
                agregarAList(horaCampo, listaHora);
            }
            else{
                abrirVentanaError("Hora inválida");
            }
        });

        editarHoraBoton.setOnAction(event -> {
            if(validarHora(horaCampo.getText())){
                editarList(listaHoraView, horaCampo, listaHora);
            }
            else{
                abrirVentanaError("Hora inválida");
            }
        });

        eliminarHoraBoton.setOnAction(event -> {
            if(validarHora(horaCampo.getText())){
                eliminarDeList(listaHoraView, listaHora, horaCampo);
                
            }
            else{
                abrirVentanaError("Hora inválida");
            }
        
        });

        ingresarDuracionBoton.setOnAction(event -> {
            if(validarHora(horaCampo.getText())){
                agregarAList(horaCampo, listaHora);
            }
            else{
                abrirVentanaError("Hora inválida");
            }
        });

        editarDuracionBoton.setOnAction(event -> {
            if(validarHora(horaCampo.getText())){
                editarList(listaHoraView, horaCampo, listaHora);
            }
            else{
                abrirVentanaError("Hora inválida");
            }
        });

        editarDuracionBoton.setOnAction(event -> {
            if(validarHora(horaCampo.getText())){
                eliminarDeList(listaHoraView, listaHora, horaCampo);
                
            }
            else{
                abrirVentanaError("Hora inválida");
            }
        
        });


        siguienteBoton.setOnAction(event -> {abrirPestanaEmpresa();});
        siguienteBoton1.setOnAction(event -> {abrirPestanaEmpresa2(); System.out.println("ffgbhnmj,");});

    }


    private void agregarHorasAndenes(){
        if(validarHora(horaAperturaCampo.getText()) && validarHora(horaCierreCampo.getText())){
    
            if((!cantidadAndenLlegadaCampo.getText().isEmpty() && esEntero(cantidadAndenLlegadaCampo.getText()))){
                if((!cantidadAndenSalidaCampo.getText().isEmpty() && esEntero(cantidadAndenSalidaCampo.getText()))){
                    int cantidadIngresadaLlegada = Integer.parseInt(cantidadAndenLlegadaCampo.getText().strip());
                    int cantidadIngresadaSalida = Integer.parseInt(cantidadAndenSalidaCampo.getText().strip());
                    if((0<cantidadIngresadaLlegada && cantidadIngresadaLlegada<15) && (0<cantidadIngresadaSalida && cantidadIngresadaSalida<15) ){
                        cantidadAndenesLlegada =cantidadIngresadaLlegada;
                        cantidadAndenesSalida = cantidadIngresadaSalida;
                        Controlador.terminal  = new Terminal(horaApertura, horaCierre, cantidadIngresadaLlegada, cantidadIngresadaSalida);
                        ingresarHorasAndenesBoton.setDisable(true);
                        editarHorasAndenesBoton.setDisable(false);
                        cantidadAndenLlegadaCampo.setDisable(true);
                        cantidadAndenSalidaCampo.setDisable(true);
                        horaAperturaCampo.setDisable(true);
                        horaCierreCampo.setDisable(true);
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
        return;
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
        return;
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
        return;
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
        return;
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


    public void abrirPestanaEmpresa(){
        if(Controlador.terminal != null && !listaEmpresas.isEmpty()){
            for (String nombreEmpresa : listaEmpresas) {
                Empresa empresa = new Empresa(nombreEmpresa);
                empresas.add(empresa);
            }
            Controlador.terminal.agregarEmpresas(empresas);
            Controlador.serializarObjeto(Controlador.terminal, "src/recursos/archivos/terminal.txt");
    
            pestanaEmpresa.setDisable(false);
            tabPane.getSelectionModel().select(pestanaEmpresa);
            pestanaTerminal.setDisable(true);
    
        }
        else{
            abrirVentanaError("No se han ingresado datos");
            return;
        }
    }

    public void abrirPestanaEmpresa2(){
        if(Controlador.terminal != null && !listaEmpresas.isEmpty()){
            for (String nombreEmpresa : listaEmpresas) {
                Empresa empresa = new Empresa(nombreEmpresa);
                empresas.add(empresa);
            }
            Controlador.terminal.agregarEmpresas(empresas);
            Controlador.serializarObjeto(Controlador.terminal, "src/recursos/archivos/terminal.txt");
    
            pestanaEmpresa.setDisable(false);
            tabPane.getSelectionModel().select(pestanaEmpresa);
            pestanaTerminal.setDisable(true);
    
        }
        else{
            abrirVentanaError("No se han ingresado datos");
            return;
        }


    }


    public void abrirVentanaError(String mensaje){

        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText("Error de ingreso");
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }



}
