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

//NOTE THIS WILL NEED TO BE CHANGED WHEN THE TABLES ARE CHANGED TO 3NF OR BCNF AS THINGS WILL NO LONGER WORK LIKE THIS
//WHEN THAT HAPPENS PLEASE MAKE THE APPROPRIATE CHANGES TO THE FUNCTIONS AFFECTED
    /**
     * query all tables 
     * @param con
     * @throws SQLException
     */
    public static void queryAll(Connection con)throws SQLException{
        getCustomers(con);
        getValetCustomers(con);
        getEmployees(con);
        getDOH(con);
        getKing(con);
        getKingVacant(con);
        getParkingSpots(con);
        getOnlineBookings(con);
        getRoomService(con);
    }

    /**
     * Custom queries for the db. 
     * should take in the connection and the user query q. 
     * should make sure that q is a valid query
     * if q is a valid query then it should proceed and run the query and print the result
     * if q isn't a vlid query then it should say that it isn't valid and not print out anything else
     * @param con
     * @param q
     * @throws SQLException
     */
    public static void customQuery(Connection con,String q)throws SQLException{

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
        int fieldNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=fieldNumb;i++){
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
        int fieldNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=fieldNumb;i++){
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
        int fieldNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=fieldNumb;i++){
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
        int fieldNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=fieldNumb;i++){
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
        int fieldNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=fieldNumb;i++){
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
        int fieldNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=fieldNumb;i++){
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
     * gets all parking spots that are available
     * @param con
     * @throws SQLException
     */
    private static void getParkingSpots(Connection con)throws SQLException{
        System.out.println("All free parking spots:");
        String q= "SELECT * FROM PARKINGSPOT WHERE AVALIABILITY=('Available')";
        PreparedStatement stm = con.prepareStatement(q);

        ResultSet rs = stm.executeQuery();

        ResultSetMetaData data = rs.getMetaData();
        int fieldNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=fieldNumb;i++){
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
     * gets all online bookings
     * @param con
     * @throws SQLException
     */
    private static void getOnlineBookings(Connection con)throws SQLException{
        System.out.println("All online bookings:");
        String q= "SELECT * FROM ONLINEBOOKING";
        PreparedStatement stm = con.prepareStatement(q);

        ResultSet rs = stm.executeQuery();

        ResultSetMetaData data = rs.getMetaData();
        int fieldNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=fieldNumb;i++){
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
     * gets all bookings with room service
     * @param con
     * @throws SQLException
     */
    private static void getRoomService(Connection con)throws SQLException{
        System.out.println("All bookings with room service:");
        String q= "SELECT * FROM AMENITIES WHERE ROOM_SERVICE=('Yes')";
        PreparedStatement stm = con.prepareStatement(q);

        ResultSet rs = stm.executeQuery();

        ResultSetMetaData data = rs.getMetaData();
        int fieldNumb = data.getColumnCount();
        
        while (rs.next()){
            for(int i =1;i<=fieldNumb;i++){
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