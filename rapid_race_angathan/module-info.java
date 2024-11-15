module assignment_april_12.rapid_race_angathan {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens assignment_april_12.rapid_race_angathan to javafx.fxml;
    exports assignment_april_12.rapid_race_angathan;

    // Include resources directory
    opens assignment_april_12.resources to javafx.fxml;
}
x