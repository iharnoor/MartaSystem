package SignUpPage;

import LoginApp.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import dbUtil.dbConnection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private Label print;
    @FXML
    private TextField userName;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField martaCardNo;
    @FXML
    private TextField phoneNo;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confPassword;
    private dbConnection dbConn;
    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.dbConn = new dbConnection();
    }

    @FXML
    public void onClickSignUp(ActionEvent event) {
        if (this.password.getText().equals(this.confPassword.getText()))
            pushToDBC();
        else print.setText("Passwords don't Match");
    }

    public void pushToDBC() {
        String sqlInsert = "INSERT INTO login(username,password,firstname,lastname,martacardno,phone) VALUES (?,?,?,?,?,?)";
        try {
            Connection connection = dbConn.getConnection();
            PreparedStatement prpStmt = connection.prepareStatement(sqlInsert);
            prpStmt.setString(1, this.userName.getText());
            prpStmt.setString(2, this.password.getText());
            prpStmt.setString(3, this.firstName.getText());
            prpStmt.setString(4, this.lastName.getText());
            prpStmt.setString(5, this.martaCardNo.getText());
            prpStmt.setString(6, this.phoneNo.getText());

            prpStmt.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //launch next page
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/LoginApp/login.fxml").openStream());

            LoginController loginController = (LoginController) loader.getController();
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
