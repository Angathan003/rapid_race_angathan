package assignment_april_12.rapid_race_angathan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ViewHorseDetails {

    @FXML
    private TableView<Map<String, Object>> horseTableView;

    @FXML
    private TableColumn<Map<String, Object>, Integer> horseIdColumn;

    @FXML
    private TableColumn<Map<String, Object>, String> horseNameColumn, jockeyNameColumn, breedColumn, raceRecordColumn, groupColumn;

    @FXML
    private TableColumn<Map<String, Object>, Integer> ageColumn;

    private List<Map<String, Object>> horses; // Assuming each horse is a Map<String, Object>

    public void setHorsesList(List<Map<String, Object>> horses) {
        this.horses = horses;
        ObservableList<Map<String, Object>> horseData = FXCollections.observableArrayList(horses);
        horseTableView.setItems(horseData);
    }

    @FXML
    public void initialize() {
        horseIdColumn.setCellValueFactory(new PropertyValueFactory<>("horse_id"));
        horseNameColumn.setCellValueFactory(new PropertyValueFactory<>("horse_name"));
        jockeyNameColumn.setCellValueFactory(new PropertyValueFactory<>("jockey_name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        breedColumn.setCellValueFactory(new PropertyValueFactory<>("breed"));
        raceRecordColumn.setCellValueFactory(new PropertyValueFactory<>("race_record"));
        groupColumn.setCellValueFactory(new PropertyValueFactory<>("group"));

        Short();
    }

    @FXML
    public void refreshTable() {
        ObservableList<Map<String, Object>> horseData = FXCollections.observableArrayList(horses);
        horseTableView.setItems(horseData);
    }

    public static void Short() {
            for (int i = 0; i < AddHorseDetails.totalHorse.size() - 1; i++) {
                for (int j = 0; j < AddHorseDetails.totalHorse.size() - i - 1; j++) {
                    ArrayList<Object> horse1 = (ArrayList<Object>) AddHorseDetails.totalHorse.get(j);
                    ArrayList<Object> horse2 = (ArrayList<Object>) AddHorseDetails.totalHorse.get(j + 1);

                    // Comparing  the first elements of the horses
                    int horse1FirstElement = (int) horse1.getFirst();
                    int horse2FirstElement = (int) horse2.getFirst();

                    if (horse1FirstElement > horse2FirstElement) {
                        // Swap the horses
                        AddHorseDetails.totalHorse.set(j, horse2);
                        AddHorseDetails.totalHorse.set(j + 1, horse1);
                    }
                }
            }
    }
}