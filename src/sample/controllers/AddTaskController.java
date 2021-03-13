package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DB.Database;
import sample.Task;

public class AddTaskController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddTaskButton;

    @FXML
    private TextField TaskTitleField;

    @FXML
    private TextField ProjectNameField;

    @FXML
    private TextField DateField;

    @FXML
    private Button QuitButton;

    @FXML
    void initialize() {
        QuitButton.setOnAction(event ->{
            QuitButtonAction();
        });
        AddTaskButton.setOnAction(event ->{
            Database db = new Database();

            String title = TaskTitleField.getText().trim();
            String project = ProjectNameField.getText().trim();
            String date = DateField.getText().trim();

            Task task = new Task(title, project, date);

            db.addTask(task);
        });
    }

    private void QuitButtonAction(){
        Stage stage = (Stage) QuitButton.getScene().getWindow();
        stage.close();
    }
}
