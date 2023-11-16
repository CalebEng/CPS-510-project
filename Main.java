/*
 * Caleb Eng
 * 11/16/2023
 * CPS510
 * main file for assignment 9:
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class Main {
     public static void main (String[]args) throws FileNotFoundException, SQLException{
        Connection con = createCon();
        Scanner scanner = new Scanner(System.in);   
        Scanner temp = new Scanner(System.in);
        Scanner cus = new Scanner(System.in);
   

        while(true){
        
            //formatting the menu choices
            System.out.println("Hotel DB Management System:");
            System.out.println("Please select an option below:");
            System.out.println("----------------------------------------------------");
            System.out.println("\t [1] Create All Tables");
            System.out.println("\t [2] Populate All Tables");
            System.out.println("\t [3] Query All Tables");
            System.out.println("\t [4] User Query");
            System.out.println("\t [5] Delete All Tables");
            System.out.println("\t [0] Exit");
            System.out.println("----------------------------------------------------");

            System.out.print("Answer: ");
            String ans = scanner.nextLine();

            //creating tables
            if(ans.equals("1")){
                CreateTable.createAll(con);
                System.out.println("Tables Created...\nHit Enter to Continue...");
                
                while(true){
                    String moveOn = temp.nextLine();
                    if(moveOn==""){
                        System.out.print("\033c");
                        break;
                    }
                }
            }

            //populating tables
            else if(ans.equals("2")){
                PopulateTable.populateAll(con);   
                System.out.println("Tables populated...\nHit Enter to Continue...");
                
                while(true){
                    String moveOn = temp.nextLine();
                    if(moveOn==""){
                        System.out.print("\033c");
                        break;
                    }
                }
            }

            //query tables
            else if(ans.equals("3")){
                Queries.queryAll(con);
                System.out.println("Queries ran...\nHit Enter to Continue...");
                
                while(true){
                    String moveOn = temp.nextLine();
                    if(moveOn==""){
                        System.out.print("\033c");
                        break;
                    }
                }

            }


            //user query
            else if(ans.equals("4")){
                System.out.print("\033c");


                System.out.println("Enter Query: ");
                String q = cus.nextLine();

                Queries.customQuery(con, q);

                System.out.println("Query ran...\nHit Enter to Continue...");
                
                while(true){
                    String moveOn = temp.nextLine();
                    if(moveOn==""){
                        System.out.print("\033c");
                        break;
                    }
                }

            }

            //Delete all 
            else if(ans.equals("5")){
                deleteTable.dropAll(con);
                System.out.println("Tables Deleted...\nHit Enter to Continue...");
                
                while(true){
                    String moveOn = temp.nextLine();
                    if(moveOn==""){
                        System.out.print("\033c");
                        break;
                    }
                }

            }

            //Exit
            else if(ans.equals("0")){
                con.close();
                scanner.close();
                temp.close();
                cus.close();
                break;
            }

            //Invalid options
            else{
                System.out.println("That is not a valid option, please try again");
            }
        }
    }
    

/**
 * Tries to create a connection with the ryerson db servers
 * @return the connection con
 * @throws SQLException
 * @throws FileNotFoundException
 */
private static Connection createCon() throws SQLException, FileNotFoundException{
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

    return con;
}
}
