package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.DB.Database;
import sample.DB.Tasks;
import sample.Task;

import java.sql.SQLException;

public class ShowTasksController {

    @FXML
    private TableView<Tasks> table_view;

    @FXML
    private TableColumn<Tasks, String> id;

    @FXML
    private TableColumn<Tasks, String> project_name;

    @FXML
    private TableColumn<Tasks, String> task_title;

    @FXML
    private TableColumn<Tasks, String> date;

    @FXML
    private Label Title;

    ObservableList<Tasks> oblist = FXCollections.observableArrayList();

    void initialize() {
//        initDate();
//
//        id.setCellValueFactory(new PropertyValueFactory<>("id"));
//        project_name.setCellValueFactory(new PropertyValueFactory<>("project_name"));
//        task_title.setCellValueFactory(new PropertyValueFactory<>("task_title"));
//        date.setCellValueFactory(new PropertyValueFactory<>("date"));
//        table_view.setItems(oblist);
//        table_view.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /*private void initDate() {
        Database db = new Database();
        Tasks task = new Tasks();
        //db.getTask();

        while(true){
            try {
                while (db.getTask().next()){
                    oblist.add(new Tasks(db.getTask().getString("id"), db.getTask().getString("project_name"))
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }*/

}

