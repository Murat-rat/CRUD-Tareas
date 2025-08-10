package com.example.crud_tareas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TareasController implements Initializable {
    Integer idActual = 1;
    @FXML
    private TableColumn <Tarea, Integer> id;

    @FXML
    private TableColumn <Tarea,String> titulo;

    @FXML
    private TableColumn <Tarea,String> descripcion;

    @FXML
    private TableColumn <Tarea,String> prioridad;

    @FXML
    private TableColumn <Tarea,String> fechaLimite;

    @FXML
    private TableView <Tarea> tablaTareas;

    @FXML
    private TextField eTitulo;

    @FXML
    private TextArea eDescripcion;

    @FXML
    private ComboBox ePrioridad;

    @FXML
    private DatePicker eFecha;

    public void agregarDatos(ActionEvent event) {
        Tarea tarea = new Tarea(idActual,eTitulo.getText(),eDescripcion.getText(),ePrioridad.getSelectionModel().getSelectedItem().toString(),eFecha.getValue());
        tablaTareas.getItems().add(tarea);
        idActual++;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Tarea,Integer>("id"));
        titulo.setCellValueFactory(new PropertyValueFactory<Tarea,String>("titulo"));
        descripcion.setCellValueFactory(new PropertyValueFactory<Tarea,String>("descripcion"));
        prioridad.setCellValueFactory(new PropertyValueFactory<Tarea,String>("prioridad"));
        fechaLimite.setCellValueFactory(new PropertyValueFactory<Tarea,String>("fechaLimite"));

        ObservableList<String> listaPrioridad = FXCollections.observableArrayList("Alta", "Media", "Baja");
        ePrioridad.setItems(listaPrioridad);
    }
}