
package gesfei.controllers;

import gesfei.dao.ClaseDAO;
import gesfei.pojo.Clase;
import gesfei.util.Utilidades;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author diana
 */
public class FXMLPruebaController implements Initializable {

    private ObservableList<String> listaClases;
    @FXML
    private ComboBox<String> cbClases;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarCombo();
    }    

    
    public void llenarCombo(){
        ArrayList<String> clases = new ArrayList<String>();
        ArrayList<Clase> clasesConsulta;
        try {
            clasesConsulta = ClaseDAO.consultarClases();

            for (Clase cl : clasesConsulta) {
                String nombre = cl.getNombre();
                clases.add(nombre);
            }
        } catch (SQLException ex) {
            Utilidades.mostrarAlertaSimple("Error", "Error en la conexión con la base de datos. Intente de nuevo más tarde.", Alert.AlertType.ERROR);
        }
        listaClases = FXCollections.observableArrayList(clases);
        cbClases.setItems(listaClases);
    }
    
}
