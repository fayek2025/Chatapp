package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public  TextField txtName;

    public void initialize(){

    }

    public void logInButtonOnAction(ActionEvent actionEvent) throws IOException {
        if (!txtName.getText().isEmpty()&&txtName.getText().matches("[A-Za-z0-9]+")){
            Stage primaryStage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ClientForm.fxml"));
            Font.loadFont(getClass().getResourceAsStream("/Fonts/BIG_JOHN.otf"), 14);
            ClientFormController controller = new ClientFormController();
            controller.setClientName(txtName.getText()); // Set the parameter
            fxmlLoader.setController(controller);
            txtName.setFont(Font.font("BIG_JOHN", FontWeight.NORMAL, 12));

            primaryStage.setScene(new Scene(fxmlLoader.load()));

            primaryStage.getScene().getStylesheets().add(getClass().getResource("/styles/loginform.css").toExternalForm());
            primaryStage.setTitle(txtName.getText());
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
            primaryStage.setOnCloseRequest(windowEvent -> {
                controller.shutdown();
            });
            primaryStage.show();

            txtName.clear();
        }else{
            new Alert(Alert.AlertType.ERROR, "Please enter your name").show();
        }
    }
}
