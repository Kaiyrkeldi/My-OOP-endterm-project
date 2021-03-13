package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class toDoListController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ShowTaskButton;

    @FXML
    private Button AddTaskButton;

    @FXML
    private Button RemoveTaskButton;

    @FXML
    private Button QuitButton;

    @FXML
    void initialize() {
        ShowTaskButton.setOnAction(event -> {
            openScene("/sample/fxml/ShowTasks.fxml");
        });
        AddTaskButton.setOnAction(event ->{
            openScene("/sample/fxml/addTask.fxml");
        });
        RemoveTaskButton.setOnAction(event ->{

        });
        QuitButton.setOnAction(event ->{
            QuitButtonAction();
        });
    }

    private void QuitButtonAction(){
        Stage stage = (Stage) QuitButton.getScene().getWindow();
        stage.close();
    }
    private void openScene(String window) {
        QuitButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
