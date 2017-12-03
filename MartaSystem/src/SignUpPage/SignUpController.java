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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ResourceBundle;

import static org.sqlite.SQLiteErrorCode.SQLITE_CONSTRAINT_UNIQUE;

public class SignUpController implements Initializable {
    @FXML
    private Label print;
    @FXML
    private Label print2;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.dbConn = new dbConnection();
    }

    @FXML
    public void onClickSignUp(ActionEvent event) {
        boolean execute = false;
        print.setText("");
        print2.setText("");
        if (userName.getText().isEmpty() || password.getText().isEmpty() || martaCardNo.getText().isEmpty() ||
                phoneNo.getText().isEmpty() || firstName.getText().isEmpty() || lastName.getText().isEmpty()) {
            print2.setText("Incomplete Credentials");
        } else {
            if (!this.password.getText().equals(this.confPassword.getText()))
                print.setText("Passwords don't Match");
            else if (!phoneNo.getText().matches("[1-9][0-9]{9}"))
                print.setText(print.getText() + " Invalid Phone Number");
            else if (!martaCardNo.getText().matches("[1-9][0-9]{19}"))
                print2.setText(print2.getText() + " Invalid Marta Card Number");
            else
                pushToDBC();
        }
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
            launchLoginPage();
        } catch (SQLException e) {
            print.setText("Data Already Exists. Please enter Unique");
        }
    }

    private void launchLoginPage() {
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
