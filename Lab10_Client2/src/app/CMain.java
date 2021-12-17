package app;

import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CMain extends Application {
	private TextArea messages = new TextArea();
	private Net connection = createClient();
	TextField input;
	String name = "";
	public String address = "127.0.0.1";
	public int port = 8000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage pm) throws Exception {
		// TODO Auto-generated method stub
		pm.setScene(new Scene(createContent()));
		pm.setTitle(name);
		pm.show();
	}

	@Override
	public void init() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your name before start: ");
		name = scan.nextLine();
		connection.startConnection();
	}

	public void stop() throws Exception {
		connection.close();
	}

	private Client createClient() {
		return new Client("127.0.0.1", 8000, data -> {
			Platform.runLater(() -> {
				messages.appendText(data.toString() + "\n");
			});
		});
	}

	private Parent createContent() {
		// TODO Auto-generated method stub
		messages.setPrefHeight(500);
		messages.setEditable(false);
		input = new TextField();
		input.setPrefWidth(500);
		Button send = new Button("Send");
		send.setOnAction(e -> {
			String message = name + ": ";
			message += input.getText();
			input.clear();

			messages.appendText(message + "\n");

			try {
				connection.send(message);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				messages.appendText("Failed" + "\n");
			}
		});
		HBox hbox = new HBox();
		hbox.getChildren().addAll(input, send);
		VBox root = new VBox(20, messages, hbox);
		root.setPrefSize(600, 300);
		return root;
	}

}
