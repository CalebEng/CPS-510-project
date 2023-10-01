/*
 * Theresa Killam
 * 9/30/2023
 * cps510
 * Populating a table using jdbc
 */

import java.sql.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PopulateTable {

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
        
        /*
         * just like the create table file, comment the tables out 
         * once they have been populated or I think they will double 
         * populate them and that would just be silly
         */

         // all the main tables 
         //populateCustomer(con);
         //populateRoom(con);
         //populateEmployee(con);
         //populateParkingSpot(con);
         //populateAmenities(con);
         populateOnlineBooking(con);
         populateValet(con);

         // and the relationship tables
         populateBooked(con);
         populateReserved(con);
         populateExtras(con);
         populateParked(con);
         populateInuse(con);

        con.close();
    }

//populates the customer table with data
private static void populateCustomer(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate("insert into CUSTOMER (ID, NAME, PHONE_NUMBER, CREDIT_CARD, VALET)" +
                         "values(1029384, 'Joe Smith', 4161231234, 4444444444444444, 1)");
      stmt.executeUpdate("insert into CUSTOMER (ID, NAME, PHONE_NUMBER, CREDIT_CARD, VALET)" +
                         "values(1230948, 'Nancy Fancy', 6471231234, 1234123412341234, 1)");
      stmt.executeUpdate("insert into CUSTOMER (ID, NAME, PHONE_NUMBER, CREDIT_CARD, VALET)" +
                         "values(1030707, 'Theresa Slay', 6476476477, 7777777700003333, 1)");
      stmt.executeUpdate("insert into CUSTOMER (ID, NAME, PHONE_NUMBER, CREDIT_CARD, VALET)" +
                         "values(1031011, 'Caleb Belac', 4166471011, 1111222233334444, 0)");
      stmt.executeUpdate("insert into CUSTOMER (ID, NAME, PHONE_NUMBER, CREDIT_CARD, VALET)" +
                         "values(1031213, 'Jordan Jordan', 6471234567, 9999888877776666, 0)");
    } catch (SQLException e) {
      e.printStackTrace();
    }
}

//populates the room table with data
private static void populateRoom(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate("insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)" +
                         "values(500, 'King', 6, 'Occupied', 500)");
      stmt.executeUpdate("insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)" +
                         "values(264, 'Suite', 4, 'Occupied', 400)");
      stmt.executeUpdate("insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)" +
                         "values(773, 'HoneyMoon', 2, 'Occupied', 1000)");
      stmt.executeUpdate("insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)" +
                         "values(100, 'Accessible', 4, 'Vacant', 200)");
      stmt.executeUpdate("insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)" +
                         "values(444, 'Standard', 4, 'Vacant', 300)");
      stmt.executeUpdate("insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)" +
                         "values(510, 'King', 6, 'Vacant', 500)");
      stmt.executeUpdate("insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)" +
                         "values(200, 'Suite', 8, 'Occupied', 800)");
      stmt.executeUpdate("insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)" +
                         "values(615, 'Queen', 4, 'Vacant', 600)");
      stmt.executeUpdate("insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)" +
                         "values(150, 'Accessible', 4, 'Vacant', 200)");
      stmt.executeUpdate("insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)" +
                         "values(360, 'Standard', 4, 'Occupied', 300)");
    } catch (SQLException e) {
      e.printStackTrace();
    }
}


//populates the employee table with data
private static void populateEmployee(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate("insert into EMPLOYEE (E_ID, NAME, PARTTIME_FULLTIME, D_O_H)" +
                         "values(1111, 'Sasha Smith', 'Part_time', TO_DATE('2003-07-07','YYYY-MM-DD'))");
      stmt.executeUpdate("insert into EMPLOYEE (E_ID, NAME, PARTTIME_FULLTIME, D_O_H)" +
                         "values(1678, 'Tim Ford', 'Full_time', TO_DATE('2012-06-27','YYYY-MM-DD'))");
      stmt.executeUpdate("insert into EMPLOYEE (E_ID, NAME, PARTTIME_FULLTIME, D_O_H)" +
                         "values(1000, 'Lizzy Grant', 'Part_time', TO_DATE('2007-02-02','YYYY-MM-DD'))");
      stmt.executeUpdate("insert into EMPLOYEE (E_ID, NAME, PARTTIME_FULLTIME, D_O_H)" +
                         "values(1357, 'Peter Maximoff', 'Full_time', TO_DATE('2021-03-08','YYYY-MM-DD'))");
     
    } catch (SQLException e) {
      e.printStackTrace();
    }
}

//populates the parking spot table with data
private static void populateParkingSpot(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate("insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)" +
                         "values(01, 'Unavailable')");
      stmt.executeUpdate("insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)" +
                         "values(02, 'Unavailable')");
      stmt.executeUpdate("insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)" +
                         "values(03, 'Unavailable')");
      stmt.executeUpdate("insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)" +
                         "values(04, 'Available')");
      stmt.executeUpdate("insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)" +
                         "values(05, 'Available')");
      stmt.executeUpdate("insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)" +
                         "values(06, 'Unavailable')");
      stmt.executeUpdate("insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)" +
                         "values(07, 'Available')");
      stmt.executeUpdate("insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)" +
                         "values(08, 'Available')");
      stmt.executeUpdate("insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)" +
                         "values(09, 'Available')");
      stmt.executeUpdate("insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)" +
                         "values(10, 'Available')");
     
    
    } catch (SQLException e) {
      e.printStackTrace();
    }
}

//populates the amenities table with data
private static void populateAmenities(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate("insert into AMENITIES (ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)" +
                         "values(0, 'No', 'No', 'No', 'No')");
      stmt.executeUpdate("insert into AMENITIES (ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)" +
                         "values(1, 'Yes', 'No', 'No', 'No')");
      stmt.executeUpdate("insert into AMENITIES (ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)" +
                         "values(2, 'No', 'Yes', 'No', 'No')");
      stmt.executeUpdate("insert into AMENITIES (ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)" +
                         "values(3, 'No', 'No', 'Yes', 'No')");
      stmt.executeUpdate("insert into AMENITIES (ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)" +
                         "values(4, 'No', 'No', 'No', 'Yes')");
     
    
    } catch (SQLException e) {
      e.printStackTrace();
    }
}

//populates the online booking table with data
private static void populateOnlineBooking(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate("insert into ONLINEBOOKING (B_ID, ID, A_ID, NUMBER_OF_GUESTS, CHECK_IN, CHECK_OUT, ROOM_ID)" +
                         "values(12345, 1030707, 2, 2, TO_DATE('2023-07-06','YYYY-MM-DD'), TO_DATE('2023-07-08','YYYY-MM-DD'), 773)");
      stmt.executeUpdate("insert into ONLINEBOOKING (B_ID, ID, A_ID, NUMBER_OF_GUESTS, CHECK_IN, CHECK_OUT, ROOM_ID)" +
                         "values(11111, 1029384, 1, 4, TO_DATE('2023-12-02','YYYY-MM-DD'), TO_DATE('2023-12-12','YYYY-MM-DD'), 264)");
      stmt.executeUpdate("insert into ONLINEBOOKING (B_ID, ID, A_ID, NUMBER_OF_GUESTS, CHECK_IN, CHECK_OUT, ROOM_ID)" +
                         "values(45678, 1230948, 3, 2, TO_DATE('2023-09-29','YYYY-MM-DD'), TO_DATE('2023-09-30','YYYY-MM-DD'), 500)");
      stmt.executeUpdate("insert into ONLINEBOOKING (B_ID, ID, A_ID, NUMBER_OF_GUESTS, CHECK_IN, CHECK_OUT, ROOM_ID)" +
                         "values(32121, 1031011, 4, 4, TO_DATE('2023-10-06','YYYY-MM-DD'), TO_DATE('2023-10-11','YYYY-MM-DD'), 360)");
      stmt.executeUpdate("insert into ONLINEBOOKING (B_ID, ID, A_ID, NUMBER_OF_GUESTS, CHECK_IN, CHECK_OUT, ROOM_ID)" +
                         "values(23456, 1031213, 0, 1, TO_DATE('2023-04-17','YYYY-MM-DD'), TO_DATE('2023-04-19','YYYY-MM-DD'), 200)");
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
}

////populates the valet table with data
private static void populateValet(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate("insert into VALET (L_PLATE, ID, E_ID, SPOT_NUMB)" +
                         "values('CYBM-209', 1230948, 1357, 1)");
      stmt.executeUpdate("insert into VALET (L_PLATE, ID, E_ID, SPOT_NUMB)" +
                         "values('TRPD-101', 1029384, 1111, 2)");
      stmt.executeUpdate("insert into VALET (L_PLATE, ID, E_ID, SPOT_NUMB)" +
                         "values('SLAY-377', 1030707, 1000, 3)");
     

    } catch (SQLException e) {
      e.printStackTrace();
    }
}

//populates the booked table with data
private static void populateBooked(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate("insert into BOOKED (ID, B_ID)" +
                         "values(1230948, 45678)");
      stmt.executeUpdate("insert into BOOKED (ID, B_ID)" +
                         "values(1029384, 11111)");
      stmt.executeUpdate("insert into BOOKED (ID, B_ID)" +
                         "values(1030707, 12345)");
      stmt.executeUpdate("insert into BOOKED (ID, B_ID)" +
                         "values(1031011, 32121)");
      stmt.executeUpdate("insert into BOOKED (ID, B_ID)" +
                         "values(1031213, 23456)");
     

    } catch (SQLException e) {
      e.printStackTrace();
    }
}

//populates the reserved table with data
private static void populateReserved(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate("insert into RESERVED (ROOM_NUMB, B_ID)" +
                         "values(500, 45678)");
      stmt.executeUpdate("insert into RESERVED (ROOM_NUMB, B_ID)" +
                         "values(264, 11111)");
      stmt.executeUpdate("insert into RESERVED (ROOM_NUMB, B_ID)" +
                         "values(773, 12345)");
      stmt.executeUpdate("insert into RESERVED (ROOM_NUMB, B_ID)" +
                         "values(360, 32121)");
      stmt.executeUpdate("insert into RESERVED (ROOM_NUMB, B_ID)" +
                         "values(200, 23456)");
     

    } catch (SQLException e) {
      e.printStackTrace();
    }
}

//populates the extras table with data
private static void populateExtras(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate("insert into EXTRAS (A_ID, B_ID)" +
                         "values(3, 45678)");
      stmt.executeUpdate("insert into EXTRAS (A_ID, B_ID)" +
                         "values(1, 11111)");
      stmt.executeUpdate("insert into EXTRAS (A_ID, B_ID)" +
                         "values(2, 12345)");
      stmt.executeUpdate("insert into EXTRAS (A_ID, B_ID)" +
                         "values(4, 32121)");
      stmt.executeUpdate("insert into EXTRAS (A_ID, B_ID)" +
                         "values(0, 23456)");
     
   
    } catch (SQLException e) {
      e.printStackTrace();
    }
}

//populates the parked table with data
private static void populateParked(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate("insert into PARKED (E_ID, ID)" +
                         "values(1357, 1230948)");
      stmt.executeUpdate("insert into PARKED (E_ID, ID)" +
                         "values(1111, 1029384)");
      stmt.executeUpdate("insert into PARKED (E_ID, ID)" +
                         "values(1000, 1030707)");
     
 
    } catch (SQLException e) {
      e.printStackTrace();
    }
}

//populates the inuse table with data
private static void populateInuse(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate("insert into INUSE (L_PLATE, SPOT_NUMBER)" +
                         "values('CYBM-209', 1)");
      stmt.executeUpdate("insert into INUSE (L_PLATE, SPOT_NUMBER)" +
                         "values('TRPD-101', 2)");
      stmt.executeUpdate("insert into INUSE (L_PLATE, SPOT_NUMBER)" +
                         "values('SLAY-377', 3)");
     
   
    } catch (SQLException e) {
      e.printStackTrace();
    }
}


}
