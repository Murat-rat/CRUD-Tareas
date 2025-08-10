package com.example.crud_tareas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TareasController implements Initializable {
    Integer idActual = 1;
    ObservableList<String> listaPrioridad = FXCollections.observableArrayList("Alta", "Media", "Baja");

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

    public void modificarDatos() {
        titulo.setCellFactory(TextFieldTableCell.<Tarea>forTableColumn());
        titulo.setOnEditCommit(event -> {
            Tarea tarea = (Tarea) event.getTableView().getItems().get(event.getTablePosition().getRow());
            tarea.setTitulo(event.getNewValue());
        });

        descripcion.setCellFactory(TextFieldTableCell.<Tarea>forTableColumn());
        descripcion.setOnEditCommit(event -> {
            Tarea tarea = (Tarea) event.getTableView().getItems().get(event.getTablePosition().getRow());
            tarea.setDescripcion(event.getNewValue());
        });

        prioridad.setCellFactory(ComboBoxTableCell.forTableColumn(listaPrioridad));
        prioridad.setOnEditCommit(event -> {
            Tarea tarea = (Tarea) event.getTableView().getItems().get(event.getTablePosition().getRow());
            tarea.setPrioridad(event.getNewValue());
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Tarea,Integer>("id"));
        titulo.setCellValueFactory(new PropertyValueFactory<Tarea,String>("titulo"));
        descripcion.setCellValueFactory(new PropertyValueFactory<Tarea,String>("descripcion"));
        prioridad.setCellValueFactory(new PropertyValueFactory<Tarea,String>("prioridad"));
        fechaLimite.setCellValueFactory(new PropertyValueFactory<Tarea,String>("fechaLimite"));

        ePrioridad.setItems(listaPrioridad);

        modificarDatos();
    }
}