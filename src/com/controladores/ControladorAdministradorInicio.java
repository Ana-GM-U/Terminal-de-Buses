package controladores;

import java.io.File;
import java.io.IOException;

import clases.*;
import controladores.Controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorAdministradorInicio {

    @FXML
    private TextField contrasenaCampo;

    @FXML
    private TextField contrasenaCampo1;

    @FXML
    private Button ingresarBoton;

    @FXML
    private Button iniciarBoton;

    @FXML
    private TextField nombreCampo;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab pestanaInicioSesion;

    @FXML
    private Tab pestanaRegistro;

    @FXML
    private TextField rutCampo;

    @FXML
    private TextField rutCampo1;

    @FXML
    private Button registrarBoton;

    Administrador administrador;

    @FXML
    public void initialize() {
        if(!Controlador.estaVacio("src/recursos/archivos/administrador.txt")){
            administrador = Controlador.deserializarObjeto("src/recursos/archivos/administrador.txt");
        }
        iniciarBoton.setOnAction(event -> {
            validarInicio(rutCampo.getText().strip(), contrasenaCampo.getText().strip() );
        });

        registrarBoton.setOnAction(event -> {
            abrirPestanaResgistro();
        });

        ingresarBoton.setOnAction(event -> {
            validarIngreso(nombreCampo.getText().strip(), rutCampo1.getText().strip(), contrasenaCampo1.getText().strip());
        });


    }

    @FXML
    public void validarInicio(String rut, String contrasena) {
        if(administrador != null){
            if(validarRut(rut)){
                if(contrasena.equals(administrador.getContrasena())){
                    abrirVentanaDatos();
                }
                else{
                    abrirVentanaError("Contraseña incorrecta");
                    contrasenaCampo.clear();
                }
            }
            else{
                abrirVentanaError("Rut inválido");
                rutCampo.clear();
                
            }          
        }
        else{
            abrirVentanaError("No se ha registrado un administrador");
            rutCampo.clear();
            contrasenaCampo.clear();
        }
    
    }

    public void validarIngreso(String nombre, String rut, String contrasena){
        if(administrador == null){
            if(nombre!=""){
                if(validarRut(rut)){
                    if(contrasena.length()==8){
                        System.out.println(contrasena.length());
                        nombreCampo.clear();
                        rutCampo1.clear();
                        contrasenaCampo1.clear();
                        administrador = new Administrador(nombre, rut, contrasena);
                        Controlador.serializarObjeto(administrador, "src/recursos/archivos/administrador.txt");
                        abrirPestanaInicio();
                    }
                    else{
                        abrirVentanaError("Contraseña inválida");
                        contrasenaCampo1.clear();
                    }
                }
                else{
                    abrirVentanaError("Rut inválido");
                    rutCampo1.clear();
                }
            }
            else{
                abrirVentanaError("Nombre inválido");
                nombreCampo.clear();
            }

        }
        else{
            abrirVentanaError("Ya se ha registrado un administrador");
            pestanaRegistro.setDisable(true);
            pestanaInicioSesion.setDisable(false);
            nombreCampo.clear();
            rutCampo1.clear();
            contrasenaCampo1.clear();
            abrirPestanaInicio();
        }
   
    }


    boolean validarRut(String rut){
        /*try {
            rut = rut.replace(".", "").replace("-", "");

            String rutNumber = rut.substring(0, rut.length() - 1);
            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; Integer.parseInt(rutNumber) != 0; rutNumber = String.valueOf(Integer.parseInt(rutNumber) / 10)) {
                s = (s + Integer.parseInt(rutNumber) % 10 * (9 - m++ % 6)) % 11;
            }
            char dvCalculado = (s != 0) ? (char) (s + 47) : 'K';

            return dv == dvCalculado;
        } catch (Exception e) {
            return false; 
        }*/

        return true;
    }


    public void abrirPestanaResgistro(){
        pestanaInicioSesion.setDisable(true);
        pestanaRegistro.setDisable(false);
        tabPane.getSelectionModel().select(pestanaRegistro);
    }

    public void abrirPestanaInicio(){
        pestanaInicioSesion.setDisable(false);
        pestanaRegistro.setDisable(true);
        tabPane.getSelectionModel().select(pestanaInicioSesion);
    }

    @FXML
    public void abrirVentanaDatos() {
        try {
            System.out.println("si");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/VistaAdministradorTerminal.fxml"));
            Parent root = loader.load();

            Stage ventanaTerminal = new Stage();
            ventanaTerminal.setScene(new Scene(root));
            ventanaTerminal.initModality(Modality.APPLICATION_MODAL);
            ventanaTerminal.setTitle("Terminal");
            Stage stage = (Stage) rutCampo.getScene().getWindow();
            ventanaTerminal.showAndWait();
            stage.close();
            //ventanaTerminal.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
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
