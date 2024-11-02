package controladores;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorAdministradorInicio {

    @FXML
    private TextField contrasenaCampo;

    @FXML
    private TextField rutCampo;

    @FXML
    private Button ingresarBoton;

    @FXML
    public void initialize() {
        ingresarBoton.setOnAction(event -> {
            validarIngreso(rutCampo.getText().strip(), contrasenaCampo.getText().strip() );
        });

    }

    @FXML
    public void validarIngreso(String rut, String contrasena) {
        if(validarRut(rut)){
            if(contrasena.equals("9")){
                abrirVentanaDatos();
            }
            else{
                abrirVentanaError("Rut inválido");
                contrasenaCampo.clear();
            }
        }
        else{
            abrirVentanaError("Contraseña incorrecta");
            rutCampo.clear();
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
            stage.close();
            ventanaTerminal.showAndWait();
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
