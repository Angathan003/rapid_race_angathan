package assignment_april_12.rapid_race_angathan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
//    private List<Map<String, Object>> horses = new ArrayList<Map<String, Object>>();
    @FXML
    private AnchorPane contentPane;

    private List<Map<String, Object >> horses; // Assuming each horse is a Map<String, Object>

    public void setHorsesList(List<Map<String, Object>> horses) {
        this.horses = horses;
    }

    @FXML
    public void showAHD() {
        loadFXML("/assignment_april_12/resources/AddHorseDetails.fxml");
    }

    @FXML
    public void showUHD() {
        loadFXML("/assignment_april_12/resources/UpdateHorseDetails.fxml");
    }

    @FXML
    public void showDHD() {
        loadFXML("/assignment_april_12/resources/DeleteHorseDetails.fxml");
    }

    @FXML
    public void showVHD() {
        loadFXML("/assignment_april_12/resources/ViewHorseDetails.fxml");
    }

    @FXML
    public void save(ActionEvent event) {
        try (FileWriter file = new FileWriter("/assignment_april_12/resources/details.txt")) {

            for (Object horse : AddHorseDetails.totalHorse) {
                file.write(horse + "\n");
            }


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    public void endApplication() {
        // Handle end of application
    }

    @FXML
    public void startApplication() {
        // Handle start of application
    }

    private void loadFXML(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/assignment_april_12/resources/main.fxml"));
            AnchorPane newPane = loader.load();

            if (fxml.equals("/assignment_april_12/resources/DeleteHorseDetails.fxml")) {
                DeleteHorseDetails controller = loader.getController();
                controller.setHorsesList(horses);
            } else if (fxml.equals("/assignment_april_12/resources/UpdateHorseDetails.fxml")) {
                UpdateHorseDetails controller = loader.getController();
                controller.setHorsesList(horses);
            } else if (fxml.equals("/assignment_april_12/resources/ViewHorseDetails.fxml")) {
                ViewHorseDetails controller = loader.getController();
                controller.setHorsesList(horses);
            }

            contentPane.getChildren().setAll(newPane.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}