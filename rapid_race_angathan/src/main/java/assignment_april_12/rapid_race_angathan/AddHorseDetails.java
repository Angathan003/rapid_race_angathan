package assignment_april_12.rapid_race_angathan;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class AddHorseDetails {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField horseIdTextField;
    @FXML
    private TextField horseNameTextField;
    @FXML
    private TextField jockeyNameTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField breedTextField;
    @FXML
    private TextField raceRecordTextField;
    @FXML
    private ChoiceBox<String> groupChoiceBox;
    @FXML
    private Button addDetailsButton;
    @FXML
    private Button browseButton;

    private File selectedImageFile;

    @FXML
    public void initialize() {
        // Initialize the choice box with group options
        groupChoiceBox.setItems(FXCollections.observableArrayList("A", "B", "C", "D"));
    }


    public static ArrayList totalHorse = new ArrayList();
    @FXML
    public void browseImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Horse Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        selectedImageFile = fileChooser.showOpenDialog(stage);

        if (selectedImageFile != null) {
            System.out.println("Selected Image: " + selectedImageFile.getAbsolutePath());
        }
    }

    @FXML
    public void addHorse() {
        String horseId = horseIdTextField.getText();
        String horseName = horseNameTextField.getText();
        String jockeyName = jockeyNameTextField.getText();
        String age = ageTextField.getText();
        String breed = breedTextField.getText();
        String raceRecord = raceRecordTextField.getText();
        String group = groupChoiceBox.getValue();

        // Validate input fields
        if (horseId.isEmpty() || horseName.isEmpty() || jockeyName.isEmpty() || age.isEmpty() || breed.isEmpty() || raceRecord.isEmpty() || group == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("All fields are required!");
            alert.showAndWait();
            return;
        }

        // Get Base64 encoded image string
        String horseImageBase64 = getImageBase64(selectedImageFile);

        // Add the horse details to the list
        ArrayList horse = new ArrayList();
        horse.add( horseId);
        horse.add( horseName);
        horse.add( jockeyName);
        horse.add( age);
        horse.add( breed);
        horse.add( raceRecord);
        horse.add(group);
        horse.add( horseImageBase64);

        totalHorse.add(horse);

        // Add the horse details to the database or list
        // For demonstration, let's just print the details
        System.out.println("Horse Details:");
        System.out.println(horse);

        // Clear input fields
        clearFields();

        // Display success message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Horse added successfully!");
        alert.showAndWait();
    }

    private String getImageBase64(File file) {
        if (file == null) {
            return null;
        }

        try {
            byte[] fileContent = Files.readAllBytes(file.toPath());
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void clearFields() {
        horseIdTextField.clear();
        horseNameTextField.clear();
        jockeyNameTextField.clear();
        ageTextField.clear();
        breedTextField.clear();
        raceRecordTextField.clear();
        groupChoiceBox.getSelectionModel().clearSelection();
    }
}
