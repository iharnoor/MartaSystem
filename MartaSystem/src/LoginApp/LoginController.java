package LoginApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import LoginSuccessful.LoginSuccessController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;

    public TextField getUsername() {
        return username;
    }

    @FXML

    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.loginModel.isDatabaseConnected()) {
            this.dbstatus.setText("Connected to Database");
        } else this.dbstatus.setText("Not Connected to Database");
    }

    @FXML
    public void Login(ActionEvent event) {
        try {
            if (this.loginModel.isLogin(this.username.getText(), this.password.getText())) {//match credentials
                Stage stage = (Stage) this.loginButton.getScene().getWindow();//open layout
                stage.close();
                studentLogin();
            } else this.loginStatus.setText("Wrong Credentials");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void studentLogin() {
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/LoginSuccessful/loginSuccess.fxml").openStream());

            LoginSuccessController loginSuccessController = (LoginSuccessController) loader.getController();
            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Marta Dashboard");
            userStage.setResizable(false);
            userStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
