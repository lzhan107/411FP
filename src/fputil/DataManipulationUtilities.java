/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fputil;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import connector.JdbcUtilities;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lei
 * This class is used for CRUD operations against database
 */
public class DataManipulationUtilities {

    public static void createRecords(String region) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        String fetch = "select * from population_record_table where name = '"+ region + "';";
        String create = "insert into population_record_table values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        conn = (Connection) JdbcUtilities.getConnection();
        
        
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(fetch);
            //pstmt.setString(1, region);
            System.out.println("One new record inserted into database");
            rs = pstmt.executeQuery(fetch);
            pstmt2 = (PreparedStatement) conn.prepareStatement(create);
            while(rs.next()){
                for (int i=1; i<=31; i++){
                    if (i == 5){
                        String name = rs.getString(i);
                        name = "new_" + name;
                        pstmt2.setString(5,name);
                    }
                    else{
                        pstmt2.setDouble(i, rs.getDouble(i));
                    }
                }
            }
            pstmt2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataManipulationUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        JdbcUtilities.closePreparedStatement(pstmt);
        JdbcUtilities.closeConnection(conn);
    }

    public static void retrieveRecords(String state) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ResultSetMetaData metaData = null;
        StringBuilder s = new StringBuilder();

        String retrieve = "select * from population_record_table where name = ?";
        conn = (Connection) JdbcUtilities.getConnection();
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(retrieve);
            pstmt.setString(1, state);
            rs = pstmt.executeQuery();
            metaData = rs.getMetaData();

            int numOfColumns = metaData.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= numOfColumns; i++) {
                    s = s.append(metaData.getColumnName(i)).append(" = ").append(rs.getObject(i)).append("\r\n");
                }
            }
            System.out.println(s);
        } catch (SQLException ex) {
            Logger.getLogger(DataManipulationUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }

        JdbcUtilities.closeResultSet(rs);
        JdbcUtilities.closePreparedStatement(pstmt);
        JdbcUtilities.closeConnection(conn);
    }

    public static void updateRecords(String name, String field, String value) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        double doubleValue = Double.parseDouble(value);


        String update = "update population_record_table set " + field + " = ? where name = ? ;";
        conn = (Connection) JdbcUtilities.getConnection();
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(update);
            pstmt.setDouble(1, doubleValue);
            pstmt.setString(2, name);

            pstmt.executeUpdate();
            System.out.println(field + " of region " + name + " has been updated to " + value);
        } catch (SQLException ex) {
            Logger.getLogger(DataManipulationUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }

        JdbcUtilities.closePreparedStatement(pstmt);
        JdbcUtilities.closeConnection(conn);
    }

    public static void deleteRecords(String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String delete = "delete from population_record_table where name = ?;";
        conn = (Connection) JdbcUtilities.getConnection();
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(delete);
            pstmt.setString(1, name);
            pstmt.executeUpdate();

            System.out.println("The record for " + name + " has been deleted from database");
        } catch (SQLException ex) {
            Logger.getLogger(DataManipulationUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        JdbcUtilities.closePreparedStatement(pstmt);
        JdbcUtilities.closeConnection(conn);
    }
}
