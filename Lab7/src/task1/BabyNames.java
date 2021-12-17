/**********************************************
Workshop 7
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:15 November 2021
**********************************************/

package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class BabyNames extends Application{
	
	final ObservableList<String> years = FXCollections.observableArrayList("2009",
			"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017",
			"2018");
	
	@Override
	public void start(Stage ps) {
		try {
			GridPane gp = new GridPane();
			
			gp.setAlignment(Pos.CENTER);
			gp.setHgap(6);
			gp.setVgap(10);
			
			gp.add(new Text(20, 20, "Enter the Year: "), 0, 0);
		    TextField tf_year = new TextField();
		    gp.add(tf_year, 1, 0);
		    Text year_Warning = new Text(20, 20, "");
		    gp.add(year_Warning, 2, 0);
		    
		    gp.add(new Text(20, 20, "Enter the Gender: "), 0, 1);
		    TextField tf_gen = new TextField();
		    tf_gen.setMaxWidth(35);
		    gp.add(tf_gen, 1, 1);
		    Text gen_Warning = new Text(20, 20, "");
		    gp.add(gen_Warning, 2, 1);
		    
		    gp.add(new Text(20, 20, "Enter the Name: "), 0, 2);
		    TextField tf_name = new TextField();
		    gp.add(tf_name, 1, 2);
		    Text name_Warning = new Text(20, 20, "");
		    gp.add(name_Warning, 2, 2);
			
			Button submit = new Button("Submit Query");
			submit.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Boolean empty = tf_year.getText().isEmpty() || tf_gen.getText().isEmpty() || 
		    				tf_year.getText().isEmpty();
					Boolean year_valid = false;
					Boolean gen_valid = false;
					
					year_Warning.setText("");
					gen_Warning.setText("");
					name_Warning.setText("");
					
					if(!empty) {
						for(int i = 0; i < years.size(); i++) {
							if(years.get(i).matches(tf_year.getText())) {
								year_valid = true;
							}
						}
						if(!year_valid) {
							year_Warning.setText("Input a valid Year");
						}
						gen_valid = (tf_gen.getText().matches("m") || tf_gen.getText().matches("f"));
						if(!gen_valid) {
							gen_Warning.setText("Input 'm' or 'f'");
						}
						
						if(year_valid && gen_valid) {
							String fn = "babynamesranking" + tf_year.getText() + ".txt";
							File bn = new File(fn);
							int numRec;
							try {
								numRec = numReco(bn);
								
								NameRank[] nr = new NameRank[numRec * 2]; //number of records times 2 for males and females
								getReco(bn, nr);
								int match = matchReco(nr, tf_name.getText(), tf_gen.getText());

								if(match < 0) {
									name_Warning.setText("Unable to find name in list.");
								}
								else {
									search(nr[match], Integer.parseInt(tf_year.getText()));
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					else {
						if(tf_year.getText().isEmpty()) {
		    				year_Warning.setText("Input a Year");
		    			}
		    			if(tf_gen.getText().isEmpty()) {
		    				gen_Warning.setText("Input a Gender");
		    			}
		    			if(tf_name.getText().isEmpty()) {
		    				name_Warning.setText("Input a Name");
		    			}
					}
				}});
			
			Button exit = new Button("Exit");
			exit.setOnAction(e -> Platform.exit());
			
			HBox hBox = new HBox (submit, exit);
		    hBox.setSpacing(40);
		    
		    hBox.setAlignment(Pos.CENTER);
			
		    BorderPane borderPane = new BorderPane(gp);
		    borderPane.setBottom(hBox);
		    Scene sc = new Scene(borderPane, 450, 160);
		    ps.setTitle("Search Name Ranking Application");
			ps.setScene(sc);
			
			ps.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int numReco(File src) throws IOException { //each file is 1000
		int numRec = 0;
		
		BufferedReader br = new BufferedReader(new FileReader(src));
		while(br.readLine() != null) {
			numRec++;
		}
		br.close();
		
		return numRec;
	}
	
	public static void getReco(File src, NameRank[] nr) throws IOException {
		String temp = null;
		
		BufferedReader br = new BufferedReader(new FileReader(src));
		for(int i = 0; i < nr.length/2; i++) {
			temp = br.readLine();
			if(temp != null) {
				String[] tempSplit = temp.split("\\s+");
				if(tempSplit.length == 5) {
					nr[i*2] = new NameRank(tempSplit[1], Integer.parseInt(tempSplit[0].replaceAll(",", "")), 
							Integer.parseInt(tempSplit[2].replaceAll(",", "")), 'm');
					nr[i*2+1] = new NameRank(tempSplit[3], Integer.parseInt(tempSplit[0].replaceAll(",", "")),
							Integer.parseInt(tempSplit[4].replaceAll(",", "")), 'f'); 
				}
			}
		}
			
		br.close();
	}
	
	public int matchReco(NameRank[] nra, String name, String gender) {
		int matchPos = -1;
		for(int i = 0; i < nra.length; i++) {
			if(nra[i].getName().matches(name) && nra[i].getGender() == gender.charAt(0)) {
				matchPos = i;
			}
		}
		
		return matchPos;
	}
	
	public void search(NameRank src, int year) {
		Stage search_ps = new Stage();
		
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(6);
		gp.setVgap(10);
		
		String text = "";
		if(src.getGender() == 'f') {
			text = "Girl";
		}
		else {
			text = "Boy";
		}
		
		text = text + " name " + src.getName() + " is ranked #" + src.getRank() + " in " + year + " year";
		
		gp.add(new Text(text), 0, 0);
		gp.add(new Text("Do you want to Search for another name:"), 0, 1);
		
		Button yes = new Button("Yes");
		yes.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				search_ps.close();
			}});
		
		Button no = new Button("No");
		no.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Platform.exit();
			}});
		
		HBox hBox = new HBox (yes, no);
	    hBox.setSpacing(20);
	    
	    hBox.setAlignment(Pos.CENTER);
		
		BorderPane borderPane = new BorderPane(gp);
	    borderPane.setBottom(hBox);
	    Scene sc = new Scene(borderPane, 300, 150);
	    search_ps.setTitle("Search Name Ranking Application");
		search_ps.setScene(sc);
		
		search_ps.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}