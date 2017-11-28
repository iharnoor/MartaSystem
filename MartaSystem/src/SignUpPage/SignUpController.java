package SignUpPage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import dbUtil.dbConnection;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.dbConn = new dbConnection();
    }

    @FXML
    public void onClickSignUp(ActionEvent event) {
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
            print.setText("Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
