//package assignment_april_12.rapid_race_angathan;
//
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.net.URL;
//import java.util.*;
//
//public class SHR implements Initializable {
//
//    @FXML
//    private TableView<Horse> shrTableView;
//
//    private final List<Horse> horseList = new ArrayList<>();
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        loadDataFromTxt();
//        selectRandomHorses();
//        populateTable();
//    }
//
//    private void loadDataFromTxt() {
//        try (BufferedReader reader = new BufferedReader(new FileReader("HorseDetails.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length == 8) {
//                    String horseImage = parts[0];
//                    String horseId = parts[1];
//                    String horseName = parts[2];
//                    String jockeyName = parts[3];
//                    int age = Integer.parseInt(parts[4]);
//                    String breed = parts[5];
//                    String raceRecord = parts[6];
//                    String group = parts[7];
//
//                    Horse horse = new Horse(horseImage, horseId, horseName, jockeyName, age, breed, raceRecord, group);
//                    horseList.add(horse);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
////    private void selectRandomHorses() {
////        Map<String, Horse> selectedHorses = new HashMap<>();
////        Random random = new Random();
////
////        while (selectedHorses.size() < 4) {
////            Horse horse = horseList.get(random.nextInt(horseList.size()));
////            if (!selectedHorses.containsKey(horse.getGroup())) {
////                selectedHorses.put(horse.getGroup(), horse);
////            }
////        }
////
////        horseList.clear();
////        horseList.addAll(selectedHorses.values());
////    }
//
//    private void populateTable() {
//        shrTableView.getItems().addAll(horseList);
//    }
//
//    public static class Horse {
//        private final Image horseImage;
//        private final String horseId;
//        private final String horseName;
//        private final String jockeyName;
//        private final int age;
//        private final String breed;
//        private final String raceRecord;
//        private final String group;
//
//        public Horse(String horseImage, String horseId, String horseName, String jockeyName, int age, String breed, String raceRecord, String group) {
//            this.horseImage = new Image(horseImage);
//            this.horseId = horseId;
//            this.horseName = horseName;
//            this.jockeyName = jockeyName;
//            this.age = age;
//            this.breed = breed;
//            this.raceRecord = raceRecord;
//            this.group = group;
//        }
//
//        public Image getHorseImage() {
//            return horseImage;
//        }
//
//        public String getHorseId() {
//            return horseId;
//        }
//
//        public String getHorseName() {
//            return horseName;
//        }
//
//        public String getJockeyName() {
//            return jockeyName;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public String getBreed() {
//            return breed;
//        }
//
//        public String getRaceRecord() {
//            return raceRecord;
//        }
//
//        public String getGroup() {
//            return group;
//        }
//    }
//}
