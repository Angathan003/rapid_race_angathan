package assignment_april_12.rapid_race_angathan;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;
import java.util.Map;

public class UpdateHorseDetails {

    @FXML
    private TextField horseIdField;
    @FXML
    private TextField horseNameField;
    @FXML
    private TextField jockeyNameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField breedField;
    @FXML
    private TextField raceRecordField;
    @FXML
    private ChoiceBox<String> groupChoiceBox;
    @FXML
    private Button updateButton;

    private List<Map<String, Object>> horses; // Assuming each horse is a Map<String, Object>

    public void setHorsesList(List<Map<String, Object>> horses) {
        this.horses = horses;
    }

    @FXML
    public void initialize() {
        groupChoiceBox.setItems(FXCollections.observableArrayList("A", "B", "C", "D"));
    }

    @FXML
    public void checkHorseId() {
        int userInputId;
        try {
            userInputId = Integer.parseInt(horseIdField.getText());
        } catch (NumberFormatException e) {
            showError("Invalid input. Horse ID must be an integer.");
            return;
        }

        for (Map<String, Object> horse : horses) {
            if (horse.get("horse_id").equals(userInputId)) {
                horseNameField.setDisable(false);
                jockeyNameField.setDisable(false);
                ageField.setDisable(false);
                breedField.setDisable(false);
                raceRecordField.setDisable(false);
                groupChoiceBox.setDisable(false);
                updateButton.setDisable(false);

                horseNameField.setText((String) horse.get("horse_name"));
                jockeyNameField.setText((String) horse.get("jockey_name"));
                ageField.setText(horse.get("age").toString());
                breedField.setText((String) horse.get("breed"));
                raceRecordField.setText((String) horse.get("race_record"));
                groupChoiceBox.setValue((String) horse.get("group"));

                return;
            }
        }

        showError("Horse not found!");
    }

    @FXML
    public void updateDetails() {
        if (horseNameField.getText().isEmpty() || jockeyNameField.getText().isEmpty() || ageField.getText().isEmpty() ||
                breedField.getText().isEmpty() || raceRecordField.getText().isEmpty() || groupChoiceBox.getValue() == null) {
            showError("All fields are required.");
            return;
        }

        int userInputId;
        try {
            userInputId = Integer.parseInt(horseIdField.getText());
        } catch (NumberFormatException e) {
            showError("Invalid input. Horse ID must be an integer.");
            return;
        }

        for (Map<String, Object> horse : horses) {
            if (horse.get("horse_id").equals(userInputId)) {
                String horseName = horseNameField.getText();
                String jockeyName = jockeyNameField.getText();

                int age;
                try {
                    age = Integer.parseInt(ageField.getText());
                } catch (NumberFormatException ex) {
                    showError("Invalid input. Age must be an integer.");
                    return;
                }

                String breed = breedField.getText();
                String raceRecord = raceRecordField.getText();
                String group = groupChoiceBox.getValue();

                // Update the horse details
                horse.put("horse_name", horseName);
                horse.put("jockey_name", jockeyName);
                horse.put("age", age);
                horse.put("breed", breed);
                horse.put("race_record", raceRecord);
                horse.put("group", group);

                showError("Horse details updated successfully!");
                return;
            }
        }

        showError("Horse not found!");
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}