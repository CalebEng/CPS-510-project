/*
 * Caleb Eng
 * 10/01/2023
 * Basic queries for tables 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Queries{

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


        getCustomers(con);
        getValetCustomers(con);
        getEmployees(con);
        getDOH(con);
        getKing(con);
        getKingVacant(con);
        con.close();


    }
    /**
     * Gets the list of customers in the tables
     * @param con
     * @throws SQLException
     */
    private static void getCustomers(Connection con)throws SQLException{
        System.out.println("All Customers:");
        String q= "SELECT * FROM CUSTOMER";
        PreparedStatement stm = con.prepareStatement(q);

        ResultSet rs = stm.executeQuery();

        ResultSetMetaData data = rs.getMetaData();
        int feildNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=feildNumb;i++){
                if (i>1){
                    
                    System.out.print(" | ");
                    
                }
                System.out.print(data.getColumnName(i)+": ");
                System.out.print(rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Prints all valet customers
     * @param con
     * @throws SQLException
     */
    private static void getValetCustomers(Connection con)throws SQLException{
        System.out.println("All Customers with Valet:");
        String q= "SELECT * FROM CUSTOMER WHERE VALET=(1)";
        PreparedStatement stm = con.prepareStatement(q);
        ResultSet rs = stm.executeQuery();

        ResultSetMetaData data = rs.getMetaData();
        int feildNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=feildNumb;i++){
                if (i>1){
                    
                    System.out.print(" | ");
                    
                }
                System.out.print(data.getColumnName(i)+": ");
                System.out.print(rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * prints all employees
     * @param con
     * @throws SQLException
     */
    private static void getEmployees(Connection con)throws SQLException{
        System.out.println("All Employees:");
        String q= "SELECT * FROM EMPLOYEE";
        PreparedStatement stm = con.prepareStatement(q);

        ResultSet rs = stm.executeQuery();

        ResultSetMetaData data = rs.getMetaData();
        int feildNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=feildNumb;i++){
                if (i>1){
                    
                    System.out.print(" | ");
                    
                }
                System.out.print(data.getColumnName(i)+": ");
                System.out.print(rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Gets all dates of hire from employees
     * @param con
     * @throws SQLException
     */
    private static void getDOH(Connection con)throws SQLException{
        System.out.println("All Employee Hire Dates:");
        String q= "SELECT D_O_H FROM EMPLOYEE";
        PreparedStatement stm = con.prepareStatement(q);

        ResultSet rs = stm.executeQuery();

        ResultSetMetaData data = rs.getMetaData();
        int feildNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=feildNumb;i++){
                if (i>1){
                    
                    System.out.print(" | ");
                    
                }
                System.out.print(data.getColumnName(i)+": ");
                System.out.print(rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * gets all king rooms
     * @param con
     * @throws SQLException
     */
    private static void getKing(Connection con)throws SQLException{
        System.out.println("All King Suites:");
        String q= "SELECT * FROM ROOM WHERE ROOM_TYPE=('King')";
        PreparedStatement stm = con.prepareStatement(q);

        ResultSet rs = stm.executeQuery();

        ResultSetMetaData data = rs.getMetaData();
        int feildNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=feildNumb;i++){
                if (i>1){
                    
                    System.out.print(" | ");
                    
                }
                System.out.print(data.getColumnName(i)+": ");
                System.out.print(rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * gets all king rooms that are vacant
     * @param con
     * @throws SQLException
     */
    private static void getKingVacant(Connection con)throws SQLException{
        System.out.println("All Vacant King Rooms:");
        String q= "SELECT * FROM ROOM WHERE AVAILABILITY=('Vacant') AND ROOM_TYPE=('King')";
        PreparedStatement stm = con.prepareStatement(q);

        ResultSet rs = stm.executeQuery();

        ResultSetMetaData data = rs.getMetaData();
        int feildNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=feildNumb;i++){
                if (i>1){
                    
                    System.out.print(" | ");
                    
                }
                System.out.print(data.getColumnName(i)+": ");
                System.out.print(rs.getString(i));
            }
            System.out.println();
        }
        System.out.println();
    }

}