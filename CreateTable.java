/*
 * Caleb Eng
 * 9/24/2023
 * cps510
 * Creating a table using jdbc
 * this program requires the use of the openVPN as well as two txt files in the same folder. user.txt and password.txt
 * these files will not be on the git hub as they are in the gitnore. so create these files with your own credientials 
 * in them on the first line. ojdbc11.jar need to be added to the refrenced libraries in order for this to work
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreateTable {
    public static void main(String args[]) throws SQLException, FileNotFoundException{

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

        //creating the customer table
        Statement stm = con.createStatement();

        String query = "create table CUSTOMER("
            +"ID INT NOT NULL,"
            +"NAME VARCHAR2(20) NOT NULL,"
            +"PHONE_NUMBER INT NOT NULL,"
            +"CREDIT_CARD INT NOT NULL,"
            +"VALET INT DEFAULT 0,"
            +"PRIMARY KEY (ID))";
        stm.execute(query);
        System.out.println("Customer table Created...");     

    }
}
