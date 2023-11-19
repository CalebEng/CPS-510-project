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

//populates the customer table with data
private static void populateCustomer(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      // CUS 1 - ID, PHONE_NUMBER, CREDIT_CARD, VALET
      stmt.executeUpdate("insert into CUS1 (ID, PHONE_NUMBER, CREDIT_CARD, VALET)" +
                         "values(1029384, 4161231234, 4444444444444444, 1)");
      stmt.executeUpdate("insert into CUS1 (ID, PHONE_NUMBER, CREDIT_CARD, VALET)" +
                         "values(1230948, 6471231234, 1234123412341234, 1)");
      stmt.executeUpdate("insert into CUS1 (ID, PHONE_NUMBER, CREDIT_CARD, VALET)" +
                         "values(1030707, 6476476477, 7777777700003333, 1)");
      stmt.executeUpdate("insert into CUS1 (ID, PHONE_NUMBER, CREDIT_CARD, VALET)" +
                         "values(1031011, 4166471011, 1111222233334444, 0)");
      stmt.executeUpdate("insert into CUS1 (ID, PHONE_NUMBER, CREDIT_CARD, VALET)" +
                         "values(1031213, 6471234567, 9999888877776666, 0)");

      // CUS 2 - PHONE_NUMBER, NAME
      stmt.executeUpdate("insert into CUS2 (PHONE_NUMBER, NAME)" +
                         "values(4161231234, 'Joe Smith')");
      stmt.executeUpdate("insert into CUS2 (PHONE_NUMBER, NAME)" +
                         "values(6471231234, 'Nancy Fancy')");
      stmt.executeUpdate("insert into CUS2 (PHONE_NUMBER, NAME)" +
                         "values(6476476477, 'Theresa Slay')");
      stmt.executeUpdate("insert into CUS2 (PHONE_NUMBER, NAME)" +
                         "values(4166471011, 'Caleb Belac')");
      stmt.executeUpdate("insert into CUS2 (PHONE_NUMBER, NAME)" +
                         "values(6471234567,'Jordan Jordan')");

      // CUS 3 - CREDIT_CARD, NAME
      stmt.executeUpdate("insert into CUS3 (CREDIT_CARD, NAME)" +
                         "values(4444444444444444, 'Joe Smith')");
      stmt.executeUpdate("insert into CUS3 (CREDIT_CARD, NAME)" +
                         "values(1234123412341234, 'Nancy Fancy')");
      stmt.executeUpdate("insert into CUS3 (CREDIT_CARD, NAME)" +
                         "values(7777777700003333, 'Theresa Slay')");
      stmt.executeUpdate("insert into CUS3 (CREDIT_CARD, NAME)" +
                         "values(1111222233334444, 'Caleb Belac')");
      stmt.executeUpdate("insert into CUS3 (CREDIT_CARD, NAME)" +
                         "values(9999888877776666, 'Jordan Jordan')");
    } catch (SQLException e) {
      e.printStackTrace();
    }
}

//populates the room table with data
private static void populateRoom(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
     
      // ROO1 - ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY
      stmt.executeUpdate("insert into ROO1 (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY)" +
                         "values(500, 'King', 6, 'Occupied')");
      stmt.executeUpdate("insert into ROO1 (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY)" +
                         "values(264, 'Suite', 4, 'Occupied')");
      stmt.executeUpdate("insert into ROO1 (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY)" +
                         "values(773, 'HoneyMoon', 2, 'Occupied')");
      stmt.executeUpdate("insert into ROO1 (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY)" +
                         "values(100, 'Accessible', 6, 'Vacant')");
      stmt.executeUpdate("insert into ROO1 (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY)" +
                         "values(444, 'Standard', 5, 'Vacant')");
      stmt.executeUpdate("insert into ROO1 (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY)" +
                         "values(510, 'King', 8, 'Vacant')");
      stmt.executeUpdate("insert into ROO1 (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY)" +
                         "values(200, 'Suite', 8, 'Occupied')");
      stmt.executeUpdate("insert into ROO1 (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY)" +
                         "values(615, 'Queen', 4, 'Vacant')");
      stmt.executeUpdate("insert into ROO1 (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY)" +
                         "values(150, 'Accessible', 4, 'Vacant')");
      stmt.executeUpdate("insert into ROO1 (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY)" +
                         "values(360, 'Standard', 4, 'Occupied')");

      // ROO2 - ROOM_TYPE, CAPACITY, PRICE            
      stmt.executeUpdate("insert into ROO2 (ROOM_TYPE, CAPACITY, PRICE)" +
                         "values('King', 6, 500)");
      stmt.executeUpdate("insert into ROO2 (ROOM_TYPE, CAPACITY, PRICE)" +
                         "values('Suite', 4, 400)");
      stmt.executeUpdate("insert into ROO2 (ROOM_TYPE, CAPACITY, PRICE)" +
                         "values('HoneyMoon', 2, 1000)");
      stmt.executeUpdate("insert into ROO2 (ROOM_TYPE, CAPACITY, PRICE)" +
                         "values('Accessible', 6, 300)");
      stmt.executeUpdate("insert into ROO2 (ROOM_TYPE, CAPACITY, PRICE)" +
                         "values('Standard', 5, 400)");
      stmt.executeUpdate("insert into ROO2 (ROOM_TYPE, CAPACITY, PRICE)" +
                         "values('King', 8, 600)");
      stmt.executeUpdate("insert into ROO2 (ROOM_TYPE, CAPACITY, PRICE)" +
                         "values('Suite', 8, 800)");
      stmt.executeUpdate("insert into ROO2 (ROOM_TYPE, CAPACITY, PRICE)" +
                         "values('Queen', 4, 600)");
      stmt.executeUpdate("insert into ROO2 (ROOM_TYPE, CAPACITY, PRICE)" +
                         "values('Accessible', 4, 200)");
      stmt.executeUpdate("insert into ROO2 (ROOM_TYPE, CAPACITY, PRICE)" +
                         "values('Standard', 4, 300)");
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
      stmt.executeUpdate("insert into AMENITIES (A_ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)" +
                         "values(0, 'No', 'No', 'No', 'No')");
      stmt.executeUpdate("insert into AMENITIES (A_ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)" +
                         "values(1, 'Yes', 'No', 'No', 'No')");
      stmt.executeUpdate("insert into AMENITIES (A_ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)" +
                         "values(2, 'No', 'Yes', 'No', 'No')");
      stmt.executeUpdate("insert into AMENITIES (A_ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)" +
                         "values(3, 'No', 'No', 'Yes', 'No')");
      stmt.executeUpdate("insert into AMENITIES (A_ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)" +
                         "values(4, 'No', 'No', 'No', 'Yes')");
     
    
    } catch (SQLException e) {
      e.printStackTrace();
    }
}

//populates the online booking table with data
private static void populateOnlineBooking(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {

      //OB1 - B_ID, A_ID, CHECK_IN, CHECK_OUT, ROOM_ID
      stmt.executeUpdate("insert into OB1 (B_ID, A_ID, CHECK_IN, CHECK_OUT, ROOM_ID)" +
                         "values(12345, 2, TO_DATE('2023-07-06','YYYY-MM-DD'), TO_DATE('2023-07-08','YYYY-MM-DD'), 773)");
      stmt.executeUpdate("insert into OB1 (B_ID, A_ID, CHECK_IN, CHECK_OUT, ROOM_ID)" +
                         "values(11111, 1, TO_DATE('2023-12-02','YYYY-MM-DD'), TO_DATE('2023-12-12','YYYY-MM-DD'), 264)");
      stmt.executeUpdate("insert into OB1 (B_ID, A_ID, CHECK_IN, CHECK_OUT, ROOM_ID)" +
                         "values(45678, 3, TO_DATE('2023-09-29','YYYY-MM-DD'), TO_DATE('2023-09-30','YYYY-MM-DD'), 500)");
      stmt.executeUpdate("insert into OB1 (B_ID, A_ID, CHECK_IN, CHECK_OUT, ROOM_ID)" +
                         "values(32121, 4, TO_DATE('2023-10-06','YYYY-MM-DD'), TO_DATE('2023-10-11','YYYY-MM-DD'), 360)");
      stmt.executeUpdate("insert into OB1 (B_ID, A_ID, CHECK_IN, CHECK_OUT, ROOM_ID)" +
                         "values(23456, 0, TO_DATE('2023-04-17','YYYY-MM-DD'), TO_DATE('2023-04-19','YYYY-MM-DD'), 200)");
      
      //OB2 - CHECK_IN, CHECK_OUT, ROOM_ID, ID, NUMBER_OF_GUESTS
      stmt.executeUpdate("insert into OB2 (CHECK_IN, CHECK_OUT, ROOM_ID, ID, NUMBER_OF_GUESTS)" +
                         "values(TO_DATE('2023-07-06','YYYY-MM-DD'), TO_DATE('2023-07-08','YYYY-MM-DD'), 773, 1030707, 2)");
      stmt.executeUpdate("insert into OB2 (CHECK_IN, CHECK_OUT, ROOM_ID, ID, NUMBER_OF_GUESTS)" +
                         "values(TO_DATE('2023-12-02','YYYY-MM-DD'), TO_DATE('2023-12-12','YYYY-MM-DD'), 264, 1029384, 4)");
      stmt.executeUpdate("insert into OB2 (CHECK_IN, CHECK_OUT, ROOM_ID, ID, NUMBER_OF_GUESTS)" +
                         "values(TO_DATE('2023-09-29','YYYY-MM-DD'), TO_DATE('2023-09-30','YYYY-MM-DD'), 500, 1230948, 2)");
      stmt.executeUpdate("insert into OB2 (CHECK_IN, CHECK_OUT, ROOM_ID, ID, NUMBER_OF_GUESTS)" +
                         "values(TO_DATE('2023-10-06','YYYY-MM-DD'), TO_DATE('2023-10-11','YYYY-MM-DD'), 360, 1031011, 4)");
      stmt.executeUpdate("insert into OB2 (CHECK_IN, CHECK_OUT, ROOM_ID, ID, NUMBER_OF_GUESTS)" +
                         "values(TO_DATE('2023-04-17','YYYY-MM-DD'), TO_DATE('2023-04-19','YYYY-MM-DD'), 200, 1031213, 1)");

    } catch (SQLException e) {
      e.printStackTrace();
    }
}

////populates the valet table with data
private static void populateValet(Connection con) throws SQLException {
    try (Statement stmt = con.createStatement()) {
      
      //VAL1 - L_PLATE, ID, E_ID
      stmt.executeUpdate("insert into VAL1 (L_PLATE, ID, E_ID)" +
                         "values('CYBM-209', 1230948, 1357)");
      stmt.executeUpdate("insert into VAL1 (L_PLATE, ID, E_ID)" +
                         "values('TRPD-101', 1029384, 1111)");
      stmt.executeUpdate("insert into VAL1 (L_PLATE, ID, E_ID)" +
                         "values('SLAY-377', 1030707, 1000)");
     
      //VAL2 - L_PLATE, SPOT_NUMB
      stmt.executeUpdate("insert into VAL2 (L_PLATE, SPOT_NUMB)" +
                         "values('CYBM-209', 1)");
      stmt.executeUpdate("insert into VAL2 (L_PLATE, SPOT_NUMB)" +
                         "values('TRPD-101', 2)");
      stmt.executeUpdate("insert into VAL2 (L_PLATE, SPOT_NUMB)" +
                         "values('SLAY-377', 3)");

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


//NOTE THIS WILL NEED TO BE CHANGES IF MORE TABLES ARE ADDED TO MAKE DB 3NF/BCNF 
//PLEASE CREATE AND FOLLOW THE FORMATTING OF THE OTHER POPULATE FUNCTIONS AND ADD THE FUNCTION CALL BELOW ACCORDINGLY
/**
 * Populates all tables
 * @param con
 * @throws SQLException
 */

public static void populateAll(Connection con) throws SQLException {
  // all the main tables 
    populateCustomer(con);
    populateRoom(con);
    populateEmployee(con);
    populateParkingSpot(con);
    populateAmenities(con);
    populateOnlineBooking(con);
    populateValet(con);

    // and the relationship tables
    populateBooked(con);
    populateReserved(con);
    populateExtras(con);
    populateParked(con);
    populateInuse(con);
}
}
