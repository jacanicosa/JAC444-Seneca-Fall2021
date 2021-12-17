/**********************************************
Workshop 8
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:24 November 2021
**********************************************/
package maps;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Capitals extends Application {
    private final Label lblCountry = new Label("Choose a Country:");
    private Label lblAnswer = new Label();

    private TextField txtCountry = new TextField();

    private final Button btnSubmit = new Button("Submit");

    private static Map<String,String> capitals = new HashMap<>();

    public void start(Stage primaryStage) {
        VBox main = new VBox(10);
        main.setAlignment(Pos.CENTER);

        HBox states = new HBox(10);
        states.setAlignment(Pos.CENTER);
        states.getChildren().addAll(lblCountry,txtCountry);

        main.getChildren().addAll(states,lblAnswer,btnSubmit);

        initialize();

        txtCountry.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                btnSubmit.fire();
            }
        });

        btnSubmit.setOnAction(e -> {
            lblAnswer.setText("");
            String query = txtCountry.getText();

            if(capitals.containsKey(query.toUpperCase())) {
                lblAnswer.setText("The capital of " + query + " is " + capitals.get(query.toUpperCase()));
            }
            else if(query.isEmpty()) {
                lblAnswer.setText("Please enter a Country.");
            }
            else {
                lblAnswer.setText("Country not found.");
            }
        });

        Scene scene = new Scene(main,300,200);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Capital Finder");
        primaryStage.show();
    }

    private static void initialize() {
    	capitals.put("AFGHANISTAN", "Kabul");
        capitals.put("ARGENTINA", "Buenos Aires");
        capitals.put("AUSTRALIA", "Canberra");
        capitals.put("AUSTRIA", "Vienna");
        capitals.put("BELGIUM", "Brussels");
        capitals.put("CANADA", "Ottawa");
        capitals.put("CHINA", "Beijing");
        capitals.put("CZECH REPUBLIC", "Prague");
        capitals.put("DENMARK", "Copenhagen");
        capitals.put("FRANCE", "Paris");
        capitals.put("GERMANY", "Berlin");
        capitals.put("ICELAND", "Reykjavik");
        capitals.put("IRELAND", "Dublin");
        capitals.put("ITALY", "Rome");
        capitals.put("JAPAN", "Tokyo");
        capitals.put("MEXICO", "Mexico City");
        capitals.put("NETHERLANDS", "Amsterdam");
        capitals.put("SOUTH KOREA", "Seoul");
        capitals.put("SPAIN", "Madrid");
        capitals.put("SLOVENIA", "Ljubljana");
        capitals.put("SCOTLAND", "Edinburgh");
        capitals.put("TURKEY", "Ankara");
        capitals.put("UNITED ARAB EMIRATES", "Abu Dhabi");
        capitals.put("UNITED STATES", "Washington D.C.");
        capitals.put("UNITED KINGDOM", "London");

    }

    public static void main(String[] args) { launch(args); }
}
