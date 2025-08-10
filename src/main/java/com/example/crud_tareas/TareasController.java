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

import javax.swing.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
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

    @FXML
    public void agregarDatos(ActionEvent event) {
        if(eTitulo.getText().isEmpty() || eDescripcion.getText().isEmpty() || ePrioridad.getValue() == null || eFecha.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Hay datos vacíos. Por favor llene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Tarea tarea = new Tarea(idActual,eTitulo.getText(),eDescripcion.getText(),ePrioridad.getSelectionModel().getSelectedItem().toString(),eFecha.getValue());
            tablaTareas.getItems().add(tarea);
            eTitulo.clear();
            eDescripcion.clear();
            ePrioridad.getSelectionModel().clearSelection();
            eFecha.setValue(null);
            idActual++;
        }
    }

    @FXML
    public void modificarDatos() {
        titulo.setCellFactory(TextFieldTableCell.<Tarea>forTableColumn());
        titulo.setOnEditCommit(event -> {
            String nuevoTitulo = event.getNewValue();
            if (nuevoTitulo.compareTo("") == 0) {
                JOptionPane.showMessageDialog(null, "Hay datos vacíos. Por favor llene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                event.getTableView().refresh();
            } else {
                Tarea tarea = event.getTableView().getItems().get(event.getTablePosition().getRow());
                tarea.setTitulo(nuevoTitulo);
            }
        });

        descripcion.setCellFactory(TextFieldTableCell.<Tarea>forTableColumn());
        descripcion.setOnEditCommit(event -> {
            String nuevaDescripcion = event.getNewValue();
            if (nuevaDescripcion.compareTo("") == 0) {
                JOptionPane.showMessageDialog(null, "Hay datos vacíos. Por favor llene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                event.getTableView().refresh();
            } else {
                Tarea tarea = (Tarea) event.getTableView().getItems().get(event.getTablePosition().getRow());
                tarea.setPrioridad(nuevaDescripcion);
            }
        });

        prioridad.setCellFactory(ComboBoxTableCell.forTableColumn(listaPrioridad));
        prioridad.setOnEditCommit(event -> {
            Tarea tarea = (Tarea) event.getTableView().getItems().get(event.getTablePosition().getRow());
            tarea.setPrioridad(event.getNewValue());
        });
    }

    @FXML
    public void eliminarDatos(ActionEvent event) {
        TableView.TableViewSelectionModel <Tarea> selectionModel = tablaTareas.getSelectionModel();
        if (selectionModel.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna tarea.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        ObservableList<Integer> list = selectionModel.getSelectedIndices();
        Integer[] indicesSeleccionados = new Integer[list.size()];
        indicesSeleccionados = list.toArray(indicesSeleccionados);

        Arrays.sort(indicesSeleccionados);

        for(int i = indicesSeleccionados.length - 1; i >= 0; i--) {
            selectionModel.clearSelection(indicesSeleccionados[i].intValue());
            tablaTareas.getItems().remove(indicesSeleccionados[i].intValue());
        }
    }

    @FXML
    public void limpiarTabla(ActionEvent event) {
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere borrar TODOS los datos de la Tabla?", "Borrar Datos", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            tablaTareas.getItems().clear();
            idActual = 1;
        }
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