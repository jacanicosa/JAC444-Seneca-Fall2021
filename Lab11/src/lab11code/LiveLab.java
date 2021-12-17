package lab11code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class LiveLab {
	static Connection conn = null;
	static PreparedStatement st = null;
	static ResultSet rs = null;
	static String dbURL = "jdbc:sqlite:C:\\Users\\Albert\\eclipse-workspace\\Lab11\\src\\Lab11db.db";
	static String dbID = "root";
	static String dbPW = "*wogur95*";
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		/*
		In "main", there are three main tasks.
		1) Create tables.
		2) Enter items for each table.
		3) Reorganize the "AGSLog" table based on the entered data and Print the "AGSLog" table. 
		*/
		System.out.println("===== STEP 1: CREATE TABLES =====\n");
		//"AGSLog", "AGSStudent" and "ExerciseAssigned" tables 
		//are created by "create_tables()" in "choi" database.
		create_tables();
		System.out.println("===== STEP 2: INPUT =====\n");
		System.out.println("1: Input items to AGSStudent");
		System.out.println("2: Input items to ExerciseAssigned");
		System.out.println("3: Input items to AGSLog\n");
		/*
		Use the "switch" statement to select a table and enter an item.
		At this time, enter the table number (select) 
		and the number of data to be input (num).
		select 1: Input items to AGSStudent
		select 2: Input items to ExerciseAssigned
		select 3: Input items to AGSLog
		If select is greater than 3, exit from the switch statement. 
		After that, it goes to the step of rearranging the AGSLog and printing it.
		*/
		int select=0;
		int num;
		while (select <= 3) {
			System.out.print("Table Number: ");
			select = scan.nextInt();
			switch(select) {
			case 1:
				System.out.print("Number of items: ");
				num = scan.nextInt();
				input_AGSStudent(num);
				break;
			case 2:
				System.out.print("Number of items: ");
				num = scan.nextInt();
				input_ExerciseAssigned(num);
				break;
			case 3:
				System.out.print("Number of items: ");
				num = scan.nextInt();
				input_AGSLog(num);
				break;
			default:
				break;
			}
		}
		System.out.println("\n\n\n===== STEP 3: OUTPUT =====\n");
		System.out.println("AGSLog after the program runs");
		
		//Reorganize the "AGSLog" table based on the entered data.
		arrange_tables();
		
		//Print the "AGSLog" table.
		output_AGSLog();
	}
	/*
	In "create_tables()", It works like this.
	1) Request to DB, using JDBC.
	
	2) If the table is not in the DB, 
	   Create tables by sending the "create table" SQL statements 
	   suggested in the problem to the DB.
	
	Since there are 3 tables 
	with "GASLog", "AGE Student" and "Exercise Assigned", 
	repeat this process 3 times.
	*/
	static void create_tables() {
		String[] sql_array = {
				"create table AGSStudent (" + 
				"username varchar(50) not null," + 
				"password varchar(50) not null," + 
				"fullname varchar(200) not null," + 
				"instructorEmail varchar(100) not null," + 
				"constraint pkAGSStudent primary key (username)"+
				");",
				
				"create table ExerciseAssigned (" + 
				"instructorEmail varchar(100)," + 
				"exerciseName varchar(100)," + 
				"maxscore double default 10," + 
				"constraint pkCustomExercise primary key(instructorEmail, exerciseName)"+
				");",
				
				"create table AGSLog (" + 
				"username varchar(50)," + 
				"exerciseName varchar(100)," + 
				"score double default null," + 
				"submitted bit default 0," + 
				"constraint pkLog primary key (username, exerciseName)"
				+ ");"
		};
		try {
			for (int i=0;i<sql_array.length;i++) {
				conn = DriverManager.getConnection(dbURL,dbID,dbPW);
				Statement out_st = conn.createStatement();
				out_st.executeUpdate(sql_array[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st!=null  ) try {st.close();  }  catch (SQLException sqle) {}
			if (conn!=null) try {conn.close();}  catch (SQLException sqle) {}
		}
		System.out.println("Finish creating the tables");
	}
	/*
	In "arrange_tables()", It works like this.
	1) Request to DB, using JDBC.
	   For a line that matches "instructorEmail" in "AGSStudent" 
	   and "instructorEmail" in "ExerciseAssigned", 
	   if this does not exist in "AGSLog",
	   Select "username" of "AGSStudent" and "exerciseName" of "ExerciseAssigned". 
	
	2) Save the selected items in ArrayList (Item_list) as an array.
	
	3) Add the elements of ArrayList to "AGSLog".
	   At this time, each element has a score and submitted of 0, 
	   so input it in the form (username, exerciseName, 0, 0).
	*/
	static void arrange_tables() {
		 ArrayList<String[]> Item_list = new ArrayList<String[]>();
		try {
			//1) Request to DB, using JDBC.
			// For a line that matches "instructorEmail" in "AGSStudent" 
			// and "instructorEmail" in "ExerciseAssigned", 
			// if this does not exist in "AGSLog",
			// Select "username" of "AGSStudent" and "exerciseName" of "ExerciseAssigned". 
			conn = DriverManager.getConnection(dbURL,dbID,dbPW);
			String sql = "SELECT a.username, b.exerciseName "
					+ "FROM AGSStudent AS a, ExerciseAssigned AS b "
					+ "WHERE a.instructorEmail = b.instructorEmail "
					+ "AND (a.username, b.exerciseName) "
					+ "NOT IN (SELECT username, exerciseName FROM AGSLog)";
			Statement out_st = conn.createStatement();
			rs = out_st.executeQuery(sql);
			//2) Save the selected items in ArrayList (Item_list) as an array.
			while (rs.next()) {
				String username, exerciseName;
				username = rs.getString("username");
				exerciseName = rs.getString("exerciseName");
				String[] tmp= {username, exerciseName};
				Item_list.add(tmp);
			}
			//3) Request the DB to add the elements of ArrayList to "AGSLog",using JDBC.
			//   At this time, each element has a score and submitted of 0, 
			//   so input it in the form (username, exerciseName, 0, 0).
			for(int i=0; i<Item_list.size();i++) {
				sql = "INSERT INTO AGSLog values (?,?,?,?)";
				st = conn.prepareStatement(sql);
				st.setString(1, Item_list.get(i)[0]);
				st.setString(2, Item_list.get(i)[1]);
				st.setInt(3, 0);
				st.setInt(4, 0);
				st.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st!=null  ) try {st.close();  }  catch (SQLException sqle) {}
			if (conn!=null) try {conn.close();}  catch (SQLException sqle) {}
		}
	}
	/*
	In "arrange_tables()", It works like this.
	
	1) Requests the DB to select all items in "AGSLog" 
	   in descending order based on score using JDBC.
	   
	2) The elements of each row are parsed and output.
	*/
	static void output_AGSLog() {
		try {
			//1) Requests the DB to select all items in "AGSLog" 
			//   in descending order based on score using JDBC.
			conn = DriverManager.getConnection(dbURL,dbID,dbPW);
			String sql = "SELECT * FROM AGSLog ORDER BY score DESC";
			Statement out_st = conn.createStatement();
			rs = out_st.executeQuery(sql);
			System.out.format("%-8s  %-12s  %-5s  %-9s\n",
					"username","exerciseName","score","submitted");
			
			//2) The elements of each row are parsed and output.
			while (rs.next()) {
				String username, exerciseName;
				int  score, submitted;
				username = rs.getString("username");
				exerciseName = rs.getString("exerciseName");
				score = rs.getInt("score");
				submitted = rs.getInt("submitted");
				
				System.out.format("%-8s  %-12s  %-5d  %-9d\n", 
						username, exerciseName, score, submitted);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st!=null  ) try {st.close();  }  catch (SQLException sqle) {}
			if (conn!=null) try {conn.close();}  catch (SQLException sqle) {}
		}
		
	}
	/*
	In "input_AGSStudent(int num)", It works like this.
	1) One row consists of four elements: 
	   "username", "password", "fullname", and "instructorEmail".
	
	2) The user inputs 4 elements as much as "num(int)".
	
	3) Using JDBC, Requests the DB to insert 
	   the 4 items entered by the user into "AGSStudent".
	*/
	static void input_AGSStudent(int num) {
		try {
			conn = DriverManager.getConnection(dbURL,dbID,dbPW);
			String sql = "INSERT INTO AGSStudent values (?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setQueryTimeout(30);
			//1) One row consists of four elements: 
			//   "username", "password", "fullname", and "instructorEmail".
			String username, password, fullname, instructorEmail;
			
			//2) The user inputs 4 elements as much as "num(int)".
			for(int i=0;i<num;i++) {
				username = scan.next();
				password = scan.next();
				fullname = scan.next();
				instructorEmail = scan.next();
				//3) Using JDBC, Requests the DB to insert 
				//   the 4 items entered by the user into "AGSStudent".
				st.setString(1, username);
				st.setString(2, password);
				st.setString(3, fullname);
				st.setString(4, instructorEmail);
				st.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st!=null  ) try {st.close();  }  catch (SQLException sqle) {}
			if (conn!=null) try {conn.close();}  catch (SQLException sqle) {}
		}
	}
	/*
	In "input_ExerciseAssigned(int num)", It works like this.
	1) One row consists of four elements: 
	   "instructorEmail", "exerciseName", "maxScore".
	
	2) The user inputs 3 elements as much as "num(int)".
	
	3) Using JDBC, Requests the DB to insert 
	   the 3 items entered by the user into "ExerciseAssigned".
	*/
	static void input_ExerciseAssigned(int num) {
		try {
			conn = DriverManager.getConnection(dbURL,dbID,dbPW);
			String sql = "INSERT INTO ExerciseAssigned values (?,?,?)";
			st = conn.prepareStatement(sql);
			st.setQueryTimeout(30);
			//1) One row consists of four elements: 
			//	   "instructorEmail", "exerciseName", "maxScore".
			String instructorEmail, exerciseName;
			int maxScore;
			
			//2) The user inputs 3 elements as much as "num(int)".
			for(int i=0;i<num;i++) {
				instructorEmail = scan.next();
				exerciseName = scan.next();
				maxScore = scan.nextInt();
				
				//3) Using JDBC, Requests the DB to insert 
				//   the 3 items entered by the user into "ExerciseAssigned".
				st.setString(1, instructorEmail);
				st.setString(2, exerciseName);
				st.setInt(3, maxScore);
				st.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st!=null  ) try {st.close();  }  catch (SQLException sqle) {}
			if (conn!=null) try {conn.close();}  catch (SQLException sqle) {}
		}
	}
	
	/*
	In "input_AGSLog(int num)", It works like this.
	1) One row consists of four elements: 
	   "username", "exerciseName", "score", and "submitted".
	
	2) The user inputs 4 elements as much as "num(int)".
	
	3) Using JDBC, Requests the DB to insert 
	   the 4 items entered by the user into "AGSLog".
	*/
	static void input_AGSLog(int num) {
		try {
			conn = DriverManager.getConnection(dbURL,dbID,dbPW);
			String sql = "INSERT INTO AGSLog values (?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setQueryTimeout(30);
			//1) One row consists of four elements: 
			//   "username", "exerciseName", "score", and "submitted".
			String username, exerciseName;
			int  score, submitted;
			
			//2) The user inputs 4 elements as much as "num(int)".
			for(int i=0;i<num;i++) {
				username = scan.next();
				exerciseName = scan.next();
				score = scan.nextInt();
				submitted = scan.nextInt();
				
				//3) Using JDBC, Requests the DB to insert 
				//   the 4 items entered by the user into "AGSLog".
				st.setString(1, username);
				st.setString(2, exerciseName);
				st.setInt(3, score);
				st.setInt(4, submitted);
				st.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st!=null  ) try {st.close();  }  catch (SQLException sqle) {}
			if (conn!=null) try {conn.close();}  catch (SQLException sqle) {}
		}
	}
}
