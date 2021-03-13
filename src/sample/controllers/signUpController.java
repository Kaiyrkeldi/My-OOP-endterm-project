package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import sample.DB.Database;
import sample.DB.User;

public class signUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField SignUpName;

    @FXML
    private TextField SignUpLastName;

    @FXML
    private TextField SignUpCountry;

    @FXML
    private RadioButton SignUpRadioButtonMale;

    @FXML
    private RadioButton SignUpRadioButtonFemale;

    @FXML
    void initialize() {
        SignUpButton.setOnAction(event -> {

            signUpNewUser();


        });
    }

    private void signUpNewUser() {
        Database db = new Database();

        String firstName = SignUpName.getText();
        String lastName = SignUpLastName.getText();
        String userName = login_field.getText();
        String password = password_field.getText();
        String location = SignUpCountry.getText();
        String gender = "";

        if(SignUpRadioButtonMale.isSelected())
            gender = "Male";
        else
            gender = "female";

        User user = new User(firstName,lastName, userName, password, location, gender);

        db.signUpUser(user);
    }
}
