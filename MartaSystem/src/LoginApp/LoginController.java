package LoginApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import LoginSuccessful.LoginSuccessController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//controller to interact with the LoginApp Page
public class LoginController implements Initializable {
    private LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbstatus;
    @FXML
    private Label print;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginStatus;
    @FXML
    private ImageView imageView;
    public String userName;

    // like a constructor. check connection when page launches
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.loginModel.isDatabaseConnected()) {
            this.dbstatus.setText("Enter Username and Password");
        } else this.dbstatus.setText("Not Connected to Database");
    }

    // Login Button. Action performed when button is clicked
    @FXML
    public void Login(ActionEvent event) {
        userName = this.username.getText();
        try {
            if (this.loginModel.isLogin(this.username.getText(), this.password.getText())) {//match credentials
                Stage stage = (Stage) this.loginButton.getScene().getWindow();//open layout
                stage.close();
                userLogin();
            } else this.print.setText("Wrong Credentials");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // launch next page .
    public void userLogin() {
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/LoginSuccessful/loginSuccess.fxml").openStream());
            LoginSuccessController loginSuccessController = (LoginSuccessController) loader.getController();
            //set text
            loginSuccessController.sendUserName(userName);// send user name to the next page used for printing.

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
