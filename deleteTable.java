/*
 * Caleb Eng
 * 11/16/2023
 * CPS510
 * deletes tables
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class deleteTable {



    //NOTE THE TABLES ARRAY WILL NEED TO BE UPDATED AND ADD ANY NEW TABLES 
    /**
     * drops all tables in the db
     * @param con
     */
    public static void dropAll(Connection con){
        try (Statement stmt = con.createStatement()) {
             String[] tables = {"AMENITIES","BOOKED","CUS1","CUS2","CUS3","EMPLOYEE","EXTRAS","INUSE","OB1","OB2","PARKED","PARKINGSPOT","RESERVED","ROO1","ROO2","VAL1","VAL2"};

            String q = "DROP TABLE ";
            for(int i =0;i<tables.length;i++){

                if (tableExists(con,tables[i])==true){
                    stmt.executeUpdate(q+tables[i]+" CASCADE CONSTRAINTS");
                    System.out.println("Droped "+tables[i]+" Table");
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

    private static boolean tableExists(Connection con, String name) throws SQLException{
        DatabaseMetaData meta = con.getMetaData();
        ResultSet results = meta.getTables(null,null, name, new String[] {"TABLE"});
        return results.next();
    }
}
