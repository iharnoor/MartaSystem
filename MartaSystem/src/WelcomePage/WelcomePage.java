package WelcomePage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Main method class which launches the first page
public class WelcomePage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("welcomeFXML.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Welcome to MARTA Panic Station");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


