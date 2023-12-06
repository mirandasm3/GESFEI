
package gesfei.controllers;

import gesfei.dao.ConstanciaDAO;
import gesfei.dao.PeriodoDAO;
import gesfei.pojo.Constancia;
import gesfei.pojo.ConstanciaImparticion;
import gesfei.pojo.ConstanciaJurado;
import gesfei.pojo.ConstanciaPLADEA;
import gesfei.pojo.ConstanciaProyecto;
import gesfei.pojo.PeriodoEscolar;
import gesfei.util.Utilidades;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author miran
 */
public class FXMLConsultarConstanciasPendientesController implements Initializable {

    @FXML
    private TableView<ConstanciaImparticion> tvImparticion;
    @FXML
    private TableColumn clDirectorImparticion;
    @FXML
    private TableColumn clPeriodoImparticion;
    @FXML
    private TableColumn clProgramaEdu;
    @FXML
    private TableView<ConstanciaJurado> tvJurado;
    @FXML
    private TableColumn clDirectorJurado;
    @FXML
    private TableColumn clPuesto;
    @FXML
    private TableColumn clLicenciatura;
    @FXML
    private TableView<ConstanciaPLADEA> tvPladea;
    @FXML
    private TableColumn clDirectorPladea;
    @FXML
    private TableColumn clContribucion;
    @FXML
    private TableColumn clExpedicion;
    @FXML
    private TableView<ConstanciaProyecto> tvProyecto;
    @FXML
    private TableColumn clDirectorProyecto;
    @FXML
    private TableColumn clProyecto;
    @FXML
    private TableColumn clLugar;
    @FXML
    private ComboBox<String> cbPeriodo;
    private ObservableList<String> listaPeriodos;
    private ObservableList<ConstanciaImparticion> listaImparticion = FXCollections.observableArrayList();
    private ObservableList<ConstanciaJurado> listaJurado = FXCollections.observableArrayList();
    private ObservableList<ConstanciaPLADEA> listaPladea = FXCollections.observableArrayList();
    private ObservableList<ConstanciaProyecto> listaProyecto = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarCombo();
        

        clDirectorImparticion.setCellValueFactory(new PropertyValueFactory<>("director"));
        clPeriodoImparticion.setCellValueFactory(new PropertyValueFactory<>("periodoImparticion"));
        clProgramaEdu.setCellValueFactory(new PropertyValueFactory<>("programaEducativo"));
        
        clDirectorJurado.setCellValueFactory(new PropertyValueFactory<>("director"));
        clPuesto.setCellValueFactory(new PropertyValueFactory<>("puesto"));
        clLicenciatura.setCellValueFactory(new PropertyValueFactory<>("licenciatura"));
                
        clDirectorPladea.setCellValueFactory(new PropertyValueFactory<>("director"));
        clContribucion.setCellValueFactory(new PropertyValueFactory<>("fechaContribucion"));
        clExpedicion.setCellValueFactory(new PropertyValueFactory<>("fechaExpedicion"));
        
        clDirectorProyecto.setCellValueFactory(new PropertyValueFactory<>("director"));
        clProyecto.setCellValueFactory(new PropertyValueFactory<>("proyectoRealizado"));
        clLugar.setCellValueFactory(new PropertyValueFactory<>("lugar"));

        tvImparticion.setItems(listaImparticion);
        tvJurado.setItems(listaJurado);
        tvPladea.setItems(listaPladea);
        tvProyecto.setItems(listaProyecto);
    }

    public void llenarCombo(){
        ArrayList<String> pes = new ArrayList<String>();
        ArrayList<PeriodoEscolar> periodoConsulta;
        try {
            periodoConsulta = PeriodoDAO.consultarPeriodos();

            for (PeriodoEscolar pe : periodoConsulta) {
                String clavePeriodo = (pe.getClavePerido());
                pes.add(clavePeriodo);
            }
        } catch (SQLException ex) {
            Utilidades.mostrarAlertaSimple("Error", "Error en la conexión con la base de datos. Intente de nuevo más tarde.", Alert.AlertType.ERROR);
        }
        listaPeriodos = FXCollections.observableArrayList(pes);
        cbPeriodo.setItems(listaPeriodos);
    }    

    @FXML
    private void volver(ActionEvent event) {
        Stage escenario = (Stage) cbPeriodo.getScene().getWindow();
        escenario.close();
    }

    @FXML
    private void consultarConstancia(ActionEvent event) {

    }

    @FXML
    private void buscarConstancias(ActionEvent event) {
        String periodo = cbPeriodo.getValue();
        if(periodo == null || periodo.isEmpty()){
            Utilidades.mostrarAlertaSimple("Campos vacíos", "Debe seleccionar el filtro de búsqueda.", Alert.AlertType.WARNING);           
        }else {
            ConstanciaDAO cDao = new ConstanciaDAO();
            try {
                
                List<ConstanciaImparticion> resultadosI;
                resultadosI = ConstanciaDAO.consultarConstanciasImparticion();       
                listaImparticion.clear();
                if (resultadosI != null) {
                listaImparticion.addAll(resultadosI);
                }else{
                    listaImparticion.addAll(resultadosI);
                }
                
                List<ConstanciaJurado> resultadosJ;
                resultadosJ = ConstanciaDAO.consultarConstanciasJurado();       
                listaJurado.clear();
                if (resultadosJ != null) {
                listaJurado.addAll(resultadosJ);
                }else{
                    listaJurado.addAll(resultadosJ);
                }
                
                List<ConstanciaPLADEA> resultadosPl;
                resultadosPl = ConstanciaDAO.consultarConstanciasPLADEA();
                listaPladea.clear();
                if (resultadosPl != null) {
                listaPladea.addAll(resultadosPl);
                }else{
                    listaPladea.addAll(resultadosPl);
                }
                
                List<ConstanciaProyecto> resultadosP;
                resultadosP = ConstanciaDAO.consultarConstanciasProyecto();       
                listaProyecto.clear();
                if (resultadosP != null) {
                listaProyecto.addAll(resultadosP);
                }else{
                    listaProyecto.addAll(resultadosP);
                }
                
            } catch (SQLException ex) {
                Utilidades.mostrarAlertaSimple("Error", "Error en la conexión con la base de datos. Intente de nuevo más tarde.", Alert.AlertType.ERROR);
            }
        }
    }
}
