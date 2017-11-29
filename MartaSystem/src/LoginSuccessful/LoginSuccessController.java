package LoginSuccessful;

import FileViolation.FileViolationController;
import LoginApp.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.security.auth.login.LoginContext;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginSuccessController implements Initializable {
    @FXML
    private Label print;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onReportClick(ActionEvent event) {
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/FileViolation/FileViolation.fxml").openStream());
            FileViolationController fileViolationController = (FileViolationController) loader.getController();
            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Violations Page");
            userStage.setResizable(false);
            userStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
