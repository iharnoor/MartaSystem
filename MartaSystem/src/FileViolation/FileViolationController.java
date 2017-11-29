package FileViolation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FileViolationController implements Initializable {
    @FXML
    private TextField carriageNo;
    @FXML
    private TextField phoneNo;
    @FXML
    private TextArea description;
    @FXML
    private ComboBox<violations> vComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
