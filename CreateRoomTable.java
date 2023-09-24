/*
 * Caleb Eng
 * Cps-510
 * 9/24/2023
 * Creating room tables
 */

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.Scanner;
public class CreateRoomTable {
    public static void main (String[]args)throws SQLException,FileNotFoundException{
        //try to find jdbc divers
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println("Caught error: \n"+e);
        }
        
        String oracleUrl = "jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl";
        
        //getting user login info for the server
        File userfile = new File("user.txt");
        File passfile = new File("password.txt");
        Scanner userScanner = new Scanner(userfile);
        Scanner passScanner = new Scanner(passfile);
        String username = "";
        String password = "";
        
        while(userScanner.hasNextLine()){
            username = userScanner.nextLine();
            password = passScanner.nextLine();
        }
        userScanner.close();
        passScanner.close();

        //try to connect to server and create file
        
        Connection con = DriverManager.getConnection(oracleUrl, username, password);
        System.out.println("Connection successful!");
        //creating the room table
        Statement stm2 = con.createStatement();

        String query2 = "create table ROOM(" 
            + "ROOM_ID INT NOT NULL,"
            + "ROOM_TYPE VARCHAR2(20) NOT NULL,"
            + "CAPACITY INT NOT NULL,"
            + "AVAILABILITY VARCHAR(20) DEFAULT 'Vacant',"
            + "PRICE INT NOT NULL,"
            + "PRIMARY KEY (ROOM_ID))";
        stm2.execute(query2);
        stm2.close();
        System.out.println("Room table Created...");   
    }
    
}
