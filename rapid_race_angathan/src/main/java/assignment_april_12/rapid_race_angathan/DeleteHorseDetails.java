package assignment_april_12.rapid_race_angathan;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;
import java.util.Map;

public class DeleteHorseDetails {

    @FXML
    private TextField horseIdField;
    @FXML
    private Button deleteButton;

    private List<Map<String, Object>> horses; // Assuming each horse is a Map<String, Object>

    public void setHorsesList(List<Map<String, Object>> horses) {
        this.horses = horses;
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
                deleteButton.setDisable(false);
                return;
            }
        }

        showError("Horse not found!");
    }

    @FXML
    public void deleteHorse() {
        int userInputId;
        try {
            userInputId = Integer.parseInt(horseIdField.getText());
        } catch (NumberFormatException e) {
            showError("Invalid input. Horse ID must be an integer.");
            return;
        }

        for (Map<String, Object> horse : horses) {
            if (horse.get("horse_id").equals(userInputId)) {
                horses.remove(horse);
                deleteButton.setDisable(true);
                horseIdField.clear();
                showError("Horse details deleted successfully!");
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