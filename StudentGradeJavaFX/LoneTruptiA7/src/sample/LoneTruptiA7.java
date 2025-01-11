package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class LoneTruptiA7 extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Student Grade Tracker");

        GridPane grid = new GridPane();
        //grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        // Create labels for column headers
        Label assignmentLabel = new Label("Assignment Type");
        Label gradeLabel = new Label("Grade");
        Label weightageLabel = new Label("Weightage");

        // Use setConstraints to specify positions (optional)
        grid.add(assignmentLabel, 0, 0);
        grid.add(gradeLabel, 1, 0);
        grid.add(weightageLabel, 2, 0);

        // Add labels to the GridPane
        //grid.getChildren().addAll(assignmentLabel, gradeLabel, weightageLabel);


        // Input fields
        TextField[] assignmentFields = new TextField[5];
        TextField[] gradeFields = new TextField[5];
        TextField[] weightageFields = new TextField[5];

        for (int i = 0; i < 5; i++) {
            assignmentFields[i] = new TextField();
            gradeFields[i] = new TextField();
            weightageFields[i] = new TextField();

            grid.add(assignmentFields[i], 0, i + 1);
            grid.add(gradeFields[i], 1, i + 1);
            grid.add(weightageFields[i], 2, i + 1);
        }


        window.show();


    }
}
