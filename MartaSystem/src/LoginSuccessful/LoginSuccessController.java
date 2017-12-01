package LoginSuccessful;

import FileViolation.FileViolationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginSuccessController implements Initializable {
    public ImageView imageView;
    @FXML
    private Label print;

    LoginSuccessModel loginSuccessModel = new LoginSuccessModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setUserName(String name) {

//        try {
////            print.setText(loginSuccessModel.getFirstName(name));
//        } catch (Exception e) {
//            e.printStackTrace();
            print.setText("Exception");
//        }
        print.setText(name);
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
