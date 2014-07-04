/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fputil;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import connector.JdbcUtilities;
import domain.PersistentObject;
import domain.PopulationRecord;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lei
 * This class is used for reading data into application, create database, and purge database purpose
 */
public class ImportUtilities {
    private static BufferedReader input = null;//Variable for reading the population data from data file
    private static PrintStream output = null; //PrintStream variable for writing the population record into population-reocrd.txt file
    private static List<PopulationRecord> populationRecords = new ArrayList<>(); //ArrayList for storing each populationRecord array
    private static PopulationRecord[] populationRecord = new PopulationRecord[57]; //Array for storing each populationRecord
    private static PersistentObject persistentObject = null;//Variable for storing the timestamp and population record ArrayList
    private static ObjectOutputStream oos = null;//ObjectStream variable for writing object data into population-record.ser
    private static ObjectInputStream ois = null;//ObjectStream variable for reading object data into program
    private static long serializedTime = 0;//Time variable for storing the timestamp before serializing
    private static long deserializedTime = 0;//Time variable for storing the timestamp after serializing
    /*In MP2, deserializedRecords was used for data analytics, under which user can only do data analysis after deserilization*/
    private static List<PopulationRecord> deserializedRecords = new ArrayList<>();//Variable for storing the deserialized objects
    private static boolean tableCteated = false;//Variable for testing whether table created, data manipulation can be executed only after this

    public static void buildPopulationRecordList() {
        try {
            input = new BufferedReader(new FileReader(".\\data\\NST_EST2011_ALLDATA.csv"));
            output = new PrintStream(".\\output\\population-record.txt");
            //Redirect Print Stream to population-record.txt file
            System.setOut(output);

            String line;
            int prIndex = 0;
            boolean isHeadLine = true;
            while (null != (line = input.readLine())) {
                //Writing all data into population-record.txt
                System.out.println(line);
                System.out.println();
                //Ignoring the headline
                if (isHeadLine) {
                    isHeadLine = false;
                    continue;
                }
                //Splitting the data, assign each line of data to a String array
                String[] details = line.split(",");
                for (int i = 0; i < 31; i++) {
                    if (details[i].equals("X")) {
                        details[i] = "-1";
                    }
                }
                int sumlev = Integer.parseInt(details[0]);
                int region = Integer.parseInt(details[1]);
                int division = Integer.parseInt(details[2]);
                int state = Integer.parseInt(details[3]);
                String name = details[4];
                long census2010pop = Long.parseLong(details[5]);
                long estimatesbase2010 = Long.parseLong(details[6]);
                long popestimate2010 = Long.parseLong(details[7]);
                long popestimate2011 = Long.parseLong(details[8]);
                long npopchg_2010 = Long.parseLong(details[9]);
                long npopchg_2011 = Long.parseLong(details[10]);
                long births2010 = Long.parseLong(details[11]);
                long births2011 = Long.parseLong(details[12]);
                long deaths2010 = Long.parseLong(details[13]);
                long deaths2011 = Long.parseLong(details[14]);
                long naturalinc2010 = Long.parseLong(details[15]);
                long naturalinc2011 = Long.parseLong(details[16]);
                long internationalmig2010 = Long.parseLong(details[17]);
                long internationalmig2011 = Long.parseLong(details[18]);
                long demosticmig2010 = Long.parseLong(details[19]);
                long demosticmig2011 = Long.parseLong(details[20]);
                long netmig2010 = Long.parseLong(details[21]);
                long netmig2011 = Long.parseLong(details[22]);
                long residual2010 = Long.parseLong(details[23]);
                long residual2011 = Long.parseLong(details[24]);
                double rbirth2011 = Double.parseDouble(details[25]);
                double rdeath2011 = Double.parseDouble(details[26]);
                double rnaturalinc2011 = Double.parseDouble(details[27]);
                double rinternationalimg2011 = Double.parseDouble(details[28]);
                double rdomesticimg2011 = Double.parseDouble(details[29]);
                double rnetimg2011 = Double.parseDouble(details[30]);
                //Initantiating the PopulationRecord intance
                populationRecord[prIndex] = new PopulationRecord(sumlev, region, division, state, name, census2010pop,
                        estimatesbase2010, popestimate2010, popestimate2011,
                        npopchg_2010, npopchg_2011, births2010, births2011,
                        deaths2010, deaths2011, naturalinc2010, naturalinc2011,
                        internationalmig2010, internationalmig2011, demosticmig2010,
                        demosticmig2011, netmig2010, netmig2011, residual2010,
                        residual2011, rbirth2011, rdeath2011, rnaturalinc2011,
                        rinternationalimg2011, rdomesticimg2011, rnetimg2011);
                //Adding each PopultaionRecord object into the ArrayList
                populationRecords.add(populationRecord[prIndex]);
                prIndex++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //Done with reading data from CVS file, putting data into list, also write PopulationRecords into PopulationRecords.txt
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (output != null) {
                output.close();
            }
        }
    }

    public static void serializePopulationRecords() {
        try {
            //Creating an instance of PersistentObject with the current timestamp and the ArrayList object.
            serializedTime = System.currentTimeMillis();
            persistentObject = new PersistentObject(serializedTime, populationRecords);
            //Serializing the persistent object to a file called population-record.ser
            oos = new ObjectOutputStream(new FileOutputStream(".\\data\\population-record.ser"));
            oos.writeLong(persistentObject.getSerializedTime());
            oos.writeObject(persistentObject.getPopulationRecords());
            //Making the application sleep for 5 seconds
            Thread.sleep(5000);
            System.out.println("Applicaiton is waking up");
            //Write applicatoin is now waking up
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public static long deserializePopulationRecords() {
        try {
            //Deserializing the persisted object into a date object and an ArrayList object called deserializedPopulationRecords
            ois = new ObjectInputStream(new FileInputStream(".\\data\\population-record.ser"));
            deserializedTime = ois.readLong();
            deserializedRecords = (List<PopulationRecord>) ois.readObject();
            //Display the time difference between serialization and deserialization
            System.out.println("The time difference between serialization and deserialization is " + (System.currentTimeMillis() - deserializedTime) / 1000 + " seconds");
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return (System.currentTimeMillis() - deserializedTime) / 1000;
    }

    public static void createAndLoadDatabaseTables() {
        Connection conn = null;
        Statement stat = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String check = "show tables like 'population_record_table';";
            String drop = "drop table population_record_table;";
            String create = "create table population_record_table ( sumLev double, region double, division double, state double, name VARCHAR(30),census2010pop double, estimatesBase2010 double, popEstimate2010 double, popEstimate2011 double, nPopCHG_2010 double, nPopCHG_2011 double,births2010 double, births2011 double, death2010 double, death2011 double,naturalInc2010 double, naturalInc2011 double, internationalMig2010 double,internationalMig2011 double, domesticMig2010 double, domesticMig2011 double,netMig2010 double, netMig2011 double, residual2010 double, residual2011 double,rBirth2011 double, rDeath2011 double, rNaturalInc2011 double,rInternationalMig2011 double, rDomesticMig2011 double, rNetMig2011 double, PRIMARY KEY(name));";
            String insert = "insert into population_record_table values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            conn = (Connection) JdbcUtilities.getConnection();
            stat = conn.createStatement();
            //Find if there existing table
            rs = stat.executeQuery(check);
            //Drop the existing table
            if (rs.next()) {
                stat.execute(drop);
            }
            stat.executeUpdate(create);
            pstmt = (PreparedStatement) conn.prepareStatement(insert);
            for (int i = 0; i < populationRecords.size(); i++) {
                pstmt.setDouble(1, populationRecords.get(i).getSumlev());
                pstmt.setDouble(2, populationRecords.get(i).getRegion());
                pstmt.setDouble(3, populationRecords.get(i).getDivision());
                pstmt.setDouble(4, populationRecords.get(i).getState());
                pstmt.setString(5, populationRecords.get(i).getName());
                pstmt.setDouble(6, populationRecords.get(i).getCensus2010pop());
                pstmt.setDouble(7, populationRecords.get(i).getEstimatesbase2010());
                pstmt.setDouble(8, populationRecords.get(i).getPopestimate2010());
                pstmt.setDouble(9, populationRecords.get(i).getPopestimate2011());
                pstmt.setDouble(10, populationRecords.get(i).getNpopchg_2010());
                pstmt.setDouble(11, populationRecords.get(i).getNpopchg_2011());
                pstmt.setDouble(12, populationRecords.get(i).getBirths2010());
                pstmt.setDouble(13, populationRecords.get(i).getBirths2011());
                pstmt.setDouble(14, populationRecords.get(i).getDeaths2010());
                pstmt.setDouble(15, populationRecords.get(i).getDeaths2011());
                pstmt.setDouble(16, populationRecords.get(i).getNaturalinc2010());
                pstmt.setDouble(17, populationRecords.get(i).getNaturalinc2011());
                pstmt.setDouble(18, populationRecords.get(i).getInternationalmig2010());
                pstmt.setDouble(19, populationRecords.get(i).getInternationalmig2011());
                pstmt.setDouble(20, populationRecords.get(i).getDemosticmig2010());
                pstmt.setDouble(21, populationRecords.get(i).getDemosticmig2011());
                pstmt.setDouble(22, populationRecords.get(i).getNetmig2010());
                pstmt.setDouble(23, populationRecords.get(i).getNetmig2011());
                pstmt.setDouble(24, populationRecords.get(i).getResidual2010());
                pstmt.setDouble(25, populationRecords.get(i).getResidual2011());
                pstmt.setDouble(26, populationRecords.get(i).getRbirth2011());
                pstmt.setDouble(27, populationRecords.get(i).getRdeath2011());
                pstmt.setDouble(28, populationRecords.get(i).getRnaturalinc2011());
                pstmt.setDouble(29, populationRecords.get(i).getRinternationalimg2011());
                pstmt.setDouble(30, populationRecords.get(i).getRdomesticimg2011());
                pstmt.setDouble(31, populationRecords.get(i).getRnetimg2011());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            //Set tableCreated status to be true
            tableCteated = true;
        } catch (SQLException ex) {
            Logger.getLogger(ImportUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        JdbcUtilities.closeResultSet(rs);
        JdbcUtilities.closePreparedStatement(pstmt);
        JdbcUtilities.closeStatement(stat);
        JdbcUtilities.closeConnection(conn);
    }

    public static void purgeDatabase() {
        Connection conn = null;
        Statement stat = null;

        String purge = "drop table population_record_table;";
        conn = (Connection) JdbcUtilities.getConnection();
        try {
            stat = conn.prepareStatement(purge);
            stat.execute(purge);
            //Set tableCreated equal to false
            tableCteated = false;
        } catch (SQLException ex) {
            Logger.getLogger(ImportUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        JdbcUtilities.closeStatement(stat);
        JdbcUtilities.closeConnection(conn);
    }

    public static List<PopulationRecord> getDeserializedRecords() {
        return deserializedRecords;
    }

    public static List<PopulationRecord> getPopulationRecords() {
        return populationRecords;
    }

    public static boolean isTableCteated() {
        return tableCteated;
    }
    
}
