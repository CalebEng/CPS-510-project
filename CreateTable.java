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
    /**
     * Creates all tables at once.
     * @param con
     * @throws SQLException
     */
    public static void createAll(Connection con) throws SQLException{
        
        createCustomerTable(con);
        createRoomTable(con);
        createEmployeeTable(con);
        createParkingSpotTable(con);
        createAmenitiesTable(con);
        createOnlineBookingTable(con);
        createValetTable(con);
        createBooked(con);
        createReserved(con);
        createExtras(con);
        createParked(con);
        createINUSE(con);
        
    }

    /**
     * Creates the table for customers. only call ONCE
     * @param con
     * @throws SQLException
     */
    private static void createCustomerTable(Connection con) throws SQLException{
        Statement stm1 = con.createStatement();

        String query = "create table CUS1("
            +"ID INT NOT NULL,"
            +"PHONE_NUMBER INT NOT NULL,"
            +"CREDIT_CARD INT NOT NULL,"
            +"VALET INT DEFAULT 0 NOT NULL,"
            +"PRIMARY KEY (ID))";
        stm1.execute(query);
        stm1.close();
        
        Statement stm2 = con.createStatement();
        query = "create table CUS2("
            +"PHONE_NUMBER INT NOT NULL,"
            +"NAME VARCHAR2(20) NOT NULL,"
            +"PRIMARY KEY (PHONE_NUMBER))";
        stm2.execute(query);
        stm2.close();

        Statement stm3 = con.createStatement();
        query = "create table CUS3("
            +"CREDIT_CARD INT NOT NULL,"
            +"NAME VARCHAR2(20) NOT NULL,"
            +"PRIMARY KEY (CREDIT_CARD))";
        stm3.execute(query);
        stm3.close();
        
        System.out.println("Customer table Created...");     
    }

    /**
     * Creates the table for Rooms. only call ONCE
     * @param con
     * @throws SQLException
     */
    private static void createRoomTable(Connection con)throws SQLException{
        Statement stm1 = con.createStatement();

        String query = "create table ROO1(" 
            + "ROOM_ID INT NOT NULL,"
            + "ROOM_TYPE VARCHAR2(20) NOT NULL,"
            + "CAPACITY INT NOT NULL,"
            + "AVAILABILITY VARCHAR(20) DEFAULT 'Vacant',"
            + "PRIMARY KEY (ROOM_ID))";
        stm1.execute(query);
        stm1.close();
        System.out.println("Room table Created...");   

        Statement stm2 = con.createStatement();

        query = "create table ROO2(" 
            + "ROOM_TYPE VARCHAR2(20) NOT NULL,"
            + "CAPACITY INT NOT NULL,"
            + "PRICE INT NOT NULL,"
            + "PRIMARY KEY (ROOM_ID, CAPACITY))";
        stm2.execute(query);
        stm2.close();
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
            + "A_ID INT NOT NULL,"
            + "GYM VARCHAR(20) NOT NULL,"
            + "POOL VARCHAR(20) NOT NULL,"
            + "ROOM_SERVICE VARCHAR(20) NOT NULL,"
            + "BREAKFAST VARCHAR(20) NOT NULL,"
            + "PRIMARY KEY (A_ID))";
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
        Statement stm1 = con.createStatement();

        String query = "create table ONLINEBOOKING("
            + "B_ID INT NOT NULL,"
            + "A_ID INT NOT NULL,"
            + "CHECK_IN date NOT NULL,"
            + "CHECK_OUT date NOT NULL,"
            + "ROOM_ID INT NOT NULL,"
            + "FOREIGN KEY (ROOM_ID) REFERENCES ROOM(ROOM_ID),"
            + "FOREIGN KEY (A_ID) REFERENCES AMENITIES(ID),"
            + "PRIMARY KEY (B_ID))";

        stm1.execute(query);
        stm1.close();

        Statement stm2 = con.createStatement();

        query = "create table ONLINEBOOKING("
            + "ID INT NOT NULL,"
            + "NUMBER_OF_GUESTS INT NOT NULL,"
            + "CHECK_IN date NOT NULL,"
            + "CHECK_OUT date NOT NULL,"
            + "ROOM_ID INT NOT NULL,"
            + "FOREIGN KEY (ID) REFERENCES CUSTOMER(ID),"
            + "FOREIGN KEY (ROOM_ID) REFERENCES ROOM(ROOM_ID),"
            + "PRIMARY KEY (CHECK_IN,CHECK_OUT,ROOM_ID))";

        stm2.execute(query);
        stm2.close();
        System.out.println("Online Booking table Created...");
    }


    /**
     * creates valet table. only call ONCE
     * @param con
     * @throws SQLException
     */
    private static void createValetTable(Connection con)throws SQLException{
        Statement stm1 = con.createStatement();

        String query = "create table VALET("
            + "L_PLATE VARCHAR(20) NOT NULL,"
            + "ID INT NOT NULL,"
            + "E_ID INT NOT NULL,"
            + "FOREIGN KEY (ID) REFERENCES CUSTOMER(ID),"
            + "FOREIGN KEY (E_ID) REFERENCES EMPLOYEE(E_ID),"
            + "PRIMARY KEY (L_PLATE, ID))";

        stm1.execute(query);
        stm1.close();

        Statement stm2 = con.createStatement();

        query = "create table VALET("
            + "L_PLATE VARCHAR(20) NOT NULL,"
            + "SPOT_NUMB INT NOT NULL,"
            + "FOREIGN KEY (SPOT_NUMB) REFERENCES PARKINGSPOT(SPOT_NUMBER),"
            + "PRIMARY KEY (L_PLATE))";

        stm2.execute(query);
        stm2.close();

        System.out.println("Valet table Created...");
    }


    /**
     * Creates the booked realation table, only call once
     * @param con
     * @throws SQLException
     */
    private static void createBooked(Connection con)throws SQLException{
        Statement stm = con.createStatement();

        String query = "create table BOOKED("
            + "ID INT REFERENCES CUSTOMER(ID) NOT NULL,"
            + "B_ID INT NOT NULL REFERENCES ONLINEBOOKING(B_ID),"
            + "PRIMARY KEY(B_ID))";

            stm.execute(query);
            stm.close();
            System.out.println("Booked table Created...");
    }   

    /**
     * Creates reserved table, only call once
     * @param con
     * @throws SQLException
     */
    private static void createReserved(Connection con)throws SQLException{
        Statement stm = con.createStatement();

        String query = "create table RESERVED("
            + "ROOM_NUMB INT NOT NULL REFERENCES ROOM(ROOM_ID),"
            + "B_ID INT NOT NULL REFERENCES ONLINEBOOKING(B_ID),"
            + "PRIMARY KEY(B_ID))";

        stm.execute(query);
        stm.close();
        System.out.println("Reserved table Created...");
    }



    /**
     * Creates extras table, only call once
     * @param con
     * @throws SQLException
     */
    private static void createExtras(Connection con)throws SQLException{
        Statement stm = con.createStatement();

        String query = "create table EXTRAS("
            + "A_ID INT NOT NULL REFERENCES AMENITIES(ID),"
            + "B_ID INT NOT NULL REFERENCES ONLINEBOOKING(B_ID) ,"
            + "PRIMARY KEY(B_ID))";

        stm.execute(query);
        stm.close();
        System.out.println("Extras table Created...");
    }


    /**
     * created parked table, only call once
     * @param con
     * @throws SQLException
     */
    private static void createParked(Connection con)throws SQLException{
        Statement stm = con.createStatement();

        String query = "create table PARKED("
            + "E_ID INT NOT NULL REFERENCES EMPLOYEE(E_ID),"
            + "ID INT NOT NULL REFERENCES CUSTOMER(ID),"
            + "PRIMARY KEY(E_ID, ID))";
            
        stm.execute(query);
        stm.close();
        System.out.println("Parked table Created...");
    }
    
    /**
     * creates inuse tables, only call
     * @param con
     * @throws SQLException
     */
    private static void createINUSE(Connection con)throws SQLException{
        
        Statement stm = con.createStatement();

        String query = "create table INUSE("
            + "L_PLATE VARCHAR(20) NOT NULL REFERENCES VALET(L_PLATE),"
            + "SPOT_NUMBER INT NOT NULL REFERENCES PARKINGSPOT(SPOT_NUMBER),"
            + "PRIMARY KEY(L_PLATE, SPOT_NUMBER))";

        stm.execute(query);
        stm.close();
        System.out.println("INUSE table Created...");
    }
}

