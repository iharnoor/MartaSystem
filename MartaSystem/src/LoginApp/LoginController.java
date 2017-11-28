package LoginApp;

//import Admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import students.StudentsController;

import java.io.IOException;
import java.lang.invoke.LambdaConversionException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<option> combobox;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginStatus;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.loginModel.isDatabaseConnected()) {
            this.dbstatus.setText("Connected to Database");
        } else this.dbstatus.setText("Not Connected to Database");

        this.combobox.setItems(FXCollections.observableArrayList(option.values()));
    }

    @FXML
    public void Login(ActionEvent event) {
        try {
            if (this.loginModel.isLogin(this.username.getText(), this.password.getText(), ((option) this.combobox.getValue()).toString())) {//match credentials
                Stage stage = (Stage) this.loginButton.getScene().getWindow();//open layout
                stage.close();
                switch (((option) this.combobox.getValue()).toString()) {
//                    case "Admin":
//                        adminLogin();
//                        break;
                    case "Student":
                        studentLogin();
                        break;
                }
            } else this.loginStatus.setText("Wrong Credentials");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void studentLogin() {
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/students/studentsFXML.fxml").openStream());

            StudentsController studentsController = (StudentsController) loader.getController();
            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Marta Dashboard");
            userStage.setResizable(false);
            userStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//    public void studentLogin() {
//        try {
//            Stage adminStage = new Stage();
//            FXMLLoader adminLoader = new FXMLLoader();
//            Pane adminRoot = (Pane) adminLoader.load(getClass().getResource("/Admin/Admin.fxml").openStream());
//
//            AdminController adminController = (AdminController) adminLoader.getController();
//            Scene scene = new Scene(adminRoot);
//            adminStage.setScene(scene);
//            adminStage.setTitle("Admin Dashboard");
//            adminStage.setResizable(false);
//            adminStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
