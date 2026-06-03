package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.*;

public class Main extends Application {
    
    // Store students and their marks
    HashMap<String, ArrayList<Double>> students = new HashMap<>();
    
    // UI components
    ComboBox<String> studentCombo = new ComboBox<>();
    TextField markField = new TextField();
    Label resultLabel = new Label();
    ListView<String> listView = new ListView<>();
    
    @Override
    public void start(Stage primaryStage) {
        
        // Name input section
        TextField nameField = new TextField();
        nameField.setPromptText("Student Name");
        Button addStudentBtn = new Button("Add Student");
        
        // Mark input section
        markField.setPromptText("Mark (0-100)");
        Button addMarkBtn = new Button("Add Mark");
        Button calcBtn = new Button("Calculate Average");
        
        // Layout
        VBox root = new VBox(10);
        root.setPadding(new javafx.geometry.Insets(20));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #ecf0f1;");
        
        // Title
        Label title = new Label("Student Grade Manager");
        title.setFont(Font.font(18));
        title.setTextFill(Color.web("#2c3e50"));
        
        // Add all components
        root.getChildren().addAll(
            title,
            new Label("Add Student:"), nameField, addStudentBtn,
            new Label("Add Marks:"), studentCombo, markField, addMarkBtn,
            new Label("Student List:"), listView,
            calcBtn, resultLabel
        );
        
        // Button actions
        addStudentBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty() && !students.containsKey(name)) {
                students.put(name, new ArrayList<>());  // Create new student
                studentCombo.getItems().add(name);      // Add to dropdown
                nameField.clear();
            }
        });
        
        addMarkBtn.setOnAction(e -> {
            String student = studentCombo.getValue();
            if (student != null && !markField.getText().isEmpty()) {
                double mark = Double.parseDouble(markField.getText());
                if (mark >= 0 && mark <= 100) {
                    students.get(student).add(mark);    // Add mark to student
                    updateList(student);                 // Refresh display
                    markField.clear();
                }
            }
        });
        
        calcBtn.setOnAction(e -> {
            String student = studentCombo.getValue();
            if (student != null && !students.get(student).isEmpty()) {
                double avg = calculateAvg(students.get(student));
                String status = avg >= 50 ? "PASS" : "FAIL";
                resultLabel.setText(String.format("%s - Avg: %.2f - %s", student, avg, status));
                resultLabel.setTextFill(avg >= 50 ? Color.GREEN : Color.RED);
            }
        });
        
        // Setup scene
        Scene scene = new Scene(root, 450, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Grade Manager");
        primaryStage.show();
    }
    
    // Update the list view to show student with all marks
    void updateList(String student) {
        ArrayList<Double> marks = students.get(student);
        String display = student + " → " + marks.toString();
        if (!listView.getItems().contains(display)) {
            listView.getItems().add(display);
        } else {
            listView.getItems().set(listView.getItems().indexOf(display), display);
        }
    }
    
    // Calculate average of marks
    double calculateAvg(ArrayList<Double> marks) {
        double sum = 0;
        for (double m : marks) sum += m;
        return sum / marks.size();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}