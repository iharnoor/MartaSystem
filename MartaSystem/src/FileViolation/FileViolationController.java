package FileViolation;

import LastPage.LastPageController;
import LoginApp.LoginController;
import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

// Class to interact with the GUI of (FileViolation) Page
public class FileViolationController implements Initializable {
    @FXML
    private TextField carriageNo;
    @FXML
    private TextField phoneNo;
    @FXML
    private TextArea description;
    @FXML
    private ComboBox<violations> vComboBox;

    private dbConnection dbConn;
    @FXML
    private ImageView imageView;

    //intialize is like a constructor. to set things up when page launches
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.vComboBox.setItems(FXCollections.observableArrayList(violations.values()));
    }

    // action to be performed when user clicks submit button
    public void onClickSubmit(ActionEvent event) {
        String sqlInsert = "INSERT INTO violations(violationtype,carriageno,phoneno,description) VALUES (?,?,?,?)";
        try {
            Connection connection = dbConn.getConnection();
            PreparedStatement prpStmt = connection.prepareStatement(sqlInsert);
            prpStmt.setString(1, this.vComboBox.getValue().toString());
            prpStmt.setString(2, this.carriageNo.getText());
            prpStmt.setString(3, this.phoneNo.getText());
            prpStmt.setString(4, this.description.getText());

            prpStmt.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //go to Login page now
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/LastPage/LastPage.fxml").openStream());

            LastPageController lastPageController = (LastPageController) loader.getController();
            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Login Page");
            userStage.setResizable(false);
            userStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
