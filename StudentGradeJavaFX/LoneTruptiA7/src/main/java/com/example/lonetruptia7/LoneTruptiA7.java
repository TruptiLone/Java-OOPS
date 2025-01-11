package com.example.lonetruptia7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoneTruptiA7 extends Application {

    // common method for returning float value,
    // return 0 if empty
    public float getFloatValue(TextField textField) {
        if (textField.getText() == null || textField.getText().trim().isEmpty()) {
            return 0;
        } else {
            return Float.parseFloat(textField.getText());
        }
    }

    public boolean isEmpty(TextField textField) {
        return textField.getText() == null || textField.getText().trim().isEmpty();
    }

    @Override
    public void start(Stage primaryStage) {
        // Creating Labels
        Label label1 = new Label("Assignment Type");
        Label label2 = new Label("Grade");
        Label label3 = new Label("Weightage");

        // Creating TextFields for input
        TextField type1 = new TextField();
        type1.setPrefWidth(250);
        TextField grade1 = new TextField();
        grade1.setPrefWidth(200);
        TextField weightage1 = new TextField();
        weightage1.setPrefWidth(200);

        TextField type2 = new TextField();
        TextField grade2 = new TextField();
        TextField weightage2 = new TextField();


        TextField type3 = new TextField();
        TextField grade3 = new TextField();
        TextField weightage3 = new TextField();

        TextField type4 = new TextField();
        TextField grade4 = new TextField();
        TextField weightage4 = new TextField();

        TextField type5 = new TextField();
        TextField grade5 = new TextField();
        TextField weightage5 = new TextField();

        //calculate button
        Button submitButton = new Button("Calculate");
        Label resultLabel = new Label();

        // handle calculate event
        submitButton.setOnAction(event -> {

            try {
                //clear previous label
                resultLabel.setText("");

                // read all weights
                float w1 = getFloatValue(weightage1);
                float w2 = getFloatValue(weightage2);
                float w3 = getFloatValue(weightage3);
                float w4 = getFloatValue(weightage4);
                float w5 = getFloatValue(weightage5);
                //calculate total weights
                float w = w1 + w2 + w3 + w4 + w5;

                if (w == 0) {
                    resultLabel.setText("Please enter details to calculate");
                    return;
                } else if (w != 100) {
                    resultLabel.setText("Total weightage should be 100");
                    return;
                }

                // read all grades
                float g1 = getFloatValue(grade1);
                float g2 = getFloatValue(grade2);
                float g3 = getFloatValue(grade3);
                float g4 = getFloatValue(grade4);
                float g5 = getFloatValue(grade5);

                //error handling for assignment type
                if ((g1 != 0 && w1 != 0 && isEmpty(type1)) ||
                        (g2 != 0 && w2 != 0 && isEmpty(type2)) ||
                        (g3 != 0 && w3 != 0 && isEmpty(type3)) ||
                        (g4 != 0 && w4 != 0 && isEmpty(type4)) ||
                        (g5 != 0 && w5 != 0 && isEmpty(type5))) {
                    resultLabel.setText("Please enter type to calculate grade");
                    return;
                }

                //calculate grades
                float final_grade = (g1 * w1 + g2 * w2 + g3 * w3 + g4 * w4 + g5 * w5) / 100;

                // calculate final grades based on the provided specification
                // and set result label
                if (final_grade <= 100 && final_grade >= 96) {
                    resultLabel.setText("Final grade : A");
                } else if (final_grade <= 95 && final_grade >= 90) {
                    resultLabel.setText("Final grade : A-");
                } else if (final_grade <= 89 && final_grade >= 85) {
                    resultLabel.setText("Final grade : B");
                } else if (final_grade <= 84 && final_grade >= 80) {
                    resultLabel.setText("Final grade : B-");
                } else if (final_grade <= 79 && final_grade >= 75) {
                    resultLabel.setText("Final grade : C");
                } else if (final_grade <= 74 && final_grade >= 70) {
                    resultLabel.setText("Final grade : C-");
                } else if (final_grade <= 69 && final_grade >= 60) {
                    resultLabel.setText("Final grade : D");
                } else if (final_grade < 60) {
                    resultLabel.setText("Final grade : F");
                }
            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter valid grade & weightage");
            }
        });

        // clear button for clearing input text
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(event -> {
            resultLabel.setText("");
            weightage1.clear();
            weightage2.clear();
            weightage3.clear();
            weightage4.clear();
            weightage5.clear();

            grade1.clear();
            grade2.clear();
            grade3.clear();
            grade4.clear();
            grade5.clear();

            type1.clear();
            type2.clear();
            type3.clear();
            type4.clear();
            type5.clear();
        });

        VBox col1 = new VBox(10, label1, type1,type2, type3, type4, type5, submitButton, resultLabel);
        VBox col2 = new VBox(10, label2, grade1,grade2, grade3, grade4, grade5, clearButton);
        VBox col3 = new VBox(10, label3, weightage1,weightage2, weightage3, weightage4, weightage5);


        // Adding Labels and TextFields to VBox
        HBox hBox = new HBox(10, col1, col2, col3);
        hBox.setStyle("-fx-padding: 20; -fx-alignment: top-left;");

        // Setting up the Scene and Stage
        Scene scene = new Scene(hBox, 600, 300);
        primaryStage.setTitle("Student Grade Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
// sources:
// https://www.jetbrains.com/help/idea/javafx.html
// https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
