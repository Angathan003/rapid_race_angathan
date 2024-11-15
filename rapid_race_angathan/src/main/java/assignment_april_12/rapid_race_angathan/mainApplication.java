package assignment_april_12.rapid_race_angathan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class mainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL url = getClass().getResource("/assignment_april_12/resources/main.fxml");
        System.out.println("URL: " + url);
        System.out.println("Classpath: " + System.getProperty("java.class.path"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/assignment_april_12/resources/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Horse Race Event");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}