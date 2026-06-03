package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentApp extends Application {

    @Override
    public void start(Stage stage) {

        // Champs
        TextField nameField = new TextField();
        TextField levelField = new TextField();
        TextField emailField = new TextField();

        // Labels
        Label nameLabel = new Label("Name:");
        Label levelLabel = new Label("Level:");
        Label emailLabel = new Label("Email:");

        // Boutons
        Button saveBtn = new Button("Enregistrer");
        Button clearBtn = new Button("Clear");

        // Message
        Label message = new Label();

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);

        grid.add(levelLabel, 0, 1);
        grid.add(levelField, 1, 1);

        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);

        grid.add(saveBtn, 0, 3);
        grid.add(clearBtn, 1, 3);

        grid.add(message, 1, 4);

        // ACTION SAVE (JDBC)
        saveBtn.setOnAction(e -> {
            try {
                Connection conn = DBConnection.connect();

                String sql = "INSERT INTO student(name, level, email) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, nameField.getText());
                ps.setString(2, levelField.getText());
                ps.setString(3, emailField.getText());

                ps.executeUpdate();

                message.setText("student registered !");
                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                message.setText("Error !");
            }
        });

        // ACTION CLEAR
        clearBtn.setOnAction(e -> {
            nameField.clear();
            levelField.clear();
            emailField.clear();
            message.setText("");
        });

        // Scene
        Scene scene = new Scene(grid, 400, 250);

        stage.setTitle("student manager with DB");
        stage.setScene(scene);
        stage.show();
    }
}