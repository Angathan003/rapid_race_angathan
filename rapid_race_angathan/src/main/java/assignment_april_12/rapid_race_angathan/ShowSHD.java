//package assignment_april_12.rapid_race_angathan;
//
//import assignment_april_12.rapid_race_angathan.AddHorseDetails;
//
//import javafx.fxml.FXML;
//
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.*;
//
//
//AddHorseDetails Add = new AddHorseDetails();
//public class ShowSHD() {
//    public void save(){
//    try (FileWriter file = new FileWriter("details.txt")) {
//
//        for (Object horse : AddHorseDetails.totalHorse) {
//            file.write(horse + "\n");
//        }
//
//
//    } catch (IOException e) {
//        e.printStackTrace();
//
//    }
//
//}
//    // Write horses to text file
////    try (BufferedWriter writer = new BufferedWriter(new FileWriter("HorseDetails.txt"))) {
////        for (String group : new String[]{"A", "B", "C", "D"}) {
////            writer.write("Group: " + group);
////            writer.newLine();
////
////            for (Object horse : AddHorseDetails.totalHorse) {
////                String Group_name = horse.get(7);
////                if (.equals(group)) {
////                    writer.write("Horse ID: " + horse.get("horseId") +
////                            ", Horse Name: " + horse.get("horseName") +
////                            ", Jockey Name: " + horse.get("jockeyName") +
////                            ", Age: " + horse.get("age") +
////                            ", Breed: " + horse.get("breed") +
////                            ", Race Record: " + horse.get("raceRecord"));
////                    writer.newLine();
////                }
////            }
////            writer.newLine();
////        }
////        System.out.println("Horse details saved to HorseDetails.txt");
////    } catch (IOException e) {
////        e.printStackTrace();
////    }
//}
