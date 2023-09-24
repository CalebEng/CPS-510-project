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
        
        //edit your needed createtion calls here. only call them once each. 
        //comment the ones you dont need out.
        //-------------------------------------------------------------------------
        createCustomerTable(con);
        createRoomTable(con);
        createEmployeeTable(con);
        createParkingSpotTable(con);
        createAmenitiesTable(con);
        createOnlineBookingTable(con);
        createValetTable(con);
        //-------------------------------------------------------------------------
        
        con.close();
    }
    
    /**
     * Creates the table for customers. only call ONCE
     * @param con
     * @throws SQLException
     */
    private static void createCustomerTable(Connection con) throws SQLException{
        Statement stm = con.createStatement();

        String query = "create table CUSTOMER("
            +"ID INT NOT NULL,"
            +"NAME VARCHAR2(20) NOT NULL,"
            +"PHONE_NUMBER INT NOT NULL,"
            +"CREDIT_CARD INT NOT NULL,"
            +"VALET INT DEFAULT 0,"
            +"PRIMARY KEY (ID))";
        stm.execute(query);
        stm.close();
        
        System.out.println("Customer table Created...");     
    }

    /**
     * Creates the table for Rooms. only call ONCE
     * @param con
     * @throws SQLException
     */
    private static void createRoomTable(Connection con)throws SQLException{
        Statement stm = con.createStatement();

        String query = "create table ROOM(" 
            + "ROOM_ID INT NOT NULL,"
            + "ROOM_TYPE VARCHAR2(20) NOT NULL,"
            + "CAPACITY INT NOT NULL,"
            + "AVAILABILITY VARCHAR(20) DEFAULT 'Vacant',"
            + "PRICE INT NOT NULL,"
            + "PRIMARY KEY (ROOM_ID))";
        stm.execute(query);
        stm.close();
        System.out.println("Room table Created...");   
    }

    /**
     * Creates the table for Employees. only call ONCE
     * @param con
     * @throws SQLException
     */
    private static void createEmployeeTable(Connection con)throws SQLException{
        Statement stm = con.createStatement();

        String query = "create table EMPLOYEE(" 
            + "E_ID INT NOT NULL,"
            + "NAME VARCHAR(20) NOT NULL,"
            + "PARTTIME_FULLTIME VARCHAR(20) NOT NULL,"
            + "D_O_H date NOT NULL,"
            + "PRIMARY KEY (E_ID))";
        stm.execute(query);
        stm.close();
        System.out.println("Employee table Created..."); 
    }

    /**
     * Creates 
     * @param con
     * @throws SQLException
     */
    private static void createParkingSpotTable(Connection con)throws SQLException{
        Statement stm = con.createStatement();

        String query = "create table PARKINGSPOT(" 
            + "SPOT_NUMBER INT NOT NULL,"
            + "AVALIABILITY VARCHAR(20) DEFAULT'Available' NOT NULL,"
            + "PRIMARY KEY (SPOT_NUMBER))";
        stm.execute(query);
        stm.close();
        System.out.println("Parking Spot table Created..."); 
    }

    /**
     * Creates amenities table. only CALL ONCE
     * @param con
     * @throws SQLException
     */
    private static void createAmenitiesTable(Connection con)throws SQLException{
        Statement stm = con.createStatement();

        String query = "create table AMENITIES(" 
            + "ID INT NOT NULL,"
            + "GYM VARCHAR(20) NOT NULL,"
            + "POOL VARCHAR(20) NOT NULL,"
            + "ROOM_SERVICE VARCHAR(20) NOT NULL,"
            + "BREAKFAST VARCHAR(20) NOT NULL,"
            + "PRIMARY KEY (ID))";
        stm.execute(query);
        stm.close();
        System.out.println("Amenities table Created..."); 
    }

    /**
     * Creates online booking table. only call ONCE
     * @param con
     * @throws SQLException
     */
    private static void createOnlineBookingTable(Connection con)throws SQLException{

    }


    /**
     * creates valet table. only call ONCE
     * @param con
     * @throws SQLException
     */
    private static void createValetTable(Connection con)throws SQLException{

    }
}
