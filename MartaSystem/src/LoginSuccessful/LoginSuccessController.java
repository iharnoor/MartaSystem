package LoginSuccessful;

import FileViolation.FileViolationController;
import dbUtil.dbConnection;
import javafx.collections.FXCollections;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginSuccessController implements Initializable {
    public ImageView imageView;
    @FXML
    private Label print;
    private dbConnection dc;
    private String sql = "SELECT * FROM login";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void sendUserName(String name) {
        String firstName = loadFirstName(name);
        print.setText(firstName);
    }


    public String loadFirstName(String userName) {
        try {
            Connection conn = dbConnection.getConnection();

            ResultSet rs = conn.createStatement().executeQuery(sql);

            String fName = "";
            while (rs.next()) {
                if (rs.getString(1).equals(userName)) {
                    fName = rs.getString(3);
                }
            }
            return fName;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Something went wrong";
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
            //if you need to close the scene
//            Stage stage = (Stage) closeButton.getScene().getWindow();
//            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
