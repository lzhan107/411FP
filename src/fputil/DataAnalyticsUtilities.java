/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fputil;

import domain.PopulationBirthRecordComparator2010;
import domain.PopulationBirthRecordComparator2011;
import domain.PopulationDeathRecordComparator2010;
import domain.PopulationDeathRecordComparator2011;
import domain.PopulationRecord;
import domain.StatePopulationEstimateComparator2010;
import domain.StatePopulationEstimateComparator2011;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Lei
 */
public class DataAnalyticsUtilities {
    private static List<PopulationRecord> deserializedRecords = new ArrayList<>();//Variable for storing the deserialized objects
    /*Need add an additional button for data dump to .txt file*/
    private static PrintStream statisticsOutput = null;//PrintStream variable for writing the statistical results in the mp2out.txt file
    /**
     * Below variables are for statistical analysis 1 - population %increase
     * based on estimate per region per year
     *
     * @param atgs
     */
    private static int regionId;
    private static float NPopChng2010Region0 = 0;
    private static float NPopChng2011Region0 = 0;
    private static float NPopChng2010Region1 = 0;
    private static float NPopChng2011Region1 = 0;
    private static float NPopChng2010Region2 = 0;
    private static float NPopChng2011Region2 = 0;
    private static float NPopChng2010Region3 = 0;
    private static float NPopChng2011Region3 = 0;
    private static float NPopChng2010Region4 = 0;
    private static float NPopChng2011Region4 = 0;
    private static float estimateBase2010Region0 = 0;
    private static float popEstimate2011Region0 = 0;
    private static float estimateBase2010Region1 = 0;
    private static float popEstimate2011Region1 = 0;
    private static float estimateBase2010Region2 = 0;
    private static float popEstimate2011Region2 = 0;
    private static float estimateBase2010Region3 = 0;
    private static float popEstimate2011Region3 = 0;
    private static float estimateBase2010Region4 = 0;
    private static float popEstimate2011Region4 = 0;
    private static DecimalFormat df = new DecimalFormat("#0.##");
    /**
     * Below variables are for statistical analysis 4 & 5 - Number of states
     * with estimated population increase - Number of states with estimated
     * population decrease
     *
     * @param atgs
     */
    private static int numOfStateWithEstimatePopInc2010 = 0;
    private static int numOfStateWithEstimatePopDes2010 = 0;
    private static int numOfStateWithEstimatePopInc2011 = 0;
    private static int numOfStateWithEstimatePopDes2011 = 0;

    public static String calcPopIncreOnRegionPerYear() {
        StringBuilder statisticsOutput1 = new StringBuilder();
        deserializedRecords = ImportUtilities.getDeserializedRecords();
        for (int i = 0; i < deserializedRecords.size(); i++) {
            regionId = deserializedRecords.get(i).getRegion(); // Get ith element in the ArrayList
            if (regionId == 0) {
                NPopChng2010Region0 += deserializedRecords.get(i).getNpopchg_2010();
                NPopChng2011Region0 += deserializedRecords.get(i).getNpopchg_2011();
                estimateBase2010Region0 += deserializedRecords.get(i).getEstimatesbase2010();
                popEstimate2011Region0 += deserializedRecords.get(i).getPopestimate2011();
            } else if (regionId == 1) {
                NPopChng2010Region1 += deserializedRecords.get(i).getNpopchg_2010();
                NPopChng2011Region1 += deserializedRecords.get(i).getNpopchg_2011();
                estimateBase2010Region1 += deserializedRecords.get(i).getEstimatesbase2010();
                popEstimate2011Region1 += deserializedRecords.get(i).getPopestimate2011();
            } else if (regionId == 2) {
                NPopChng2010Region2 += deserializedRecords.get(i).getNpopchg_2010();
                NPopChng2011Region2 += deserializedRecords.get(i).getNpopchg_2011();
                estimateBase2010Region2 += deserializedRecords.get(i).getEstimatesbase2010();
                popEstimate2011Region2 += deserializedRecords.get(i).getPopestimate2011();
            } else if (regionId == 3) {
                NPopChng2010Region3 += deserializedRecords.get(i).getNpopchg_2010();
                NPopChng2011Region3 += deserializedRecords.get(i).getNpopchg_2011();
                estimateBase2010Region3 += deserializedRecords.get(i).getEstimatesbase2010();
                popEstimate2011Region3 += deserializedRecords.get(i).getPopestimate2011();
            } else if (regionId == 4) {
                NPopChng2010Region4 += deserializedRecords.get(i).getNpopchg_2010();
                NPopChng2011Region4 += deserializedRecords.get(i).getNpopchg_2011();
                estimateBase2010Region4 += deserializedRecords.get(i).getEstimatesbase2010();
                popEstimate2011Region4 += deserializedRecords.get(i).getPopestimate2011();
            }
        }

        statisticsOutput1.append("1> Statistics for the population increase based on estimate");
        statisticsOutput1.append("\r\n");
        statisticsOutput1.append("   • For the year 2010, the population increases based on estimate are:");
        statisticsOutput1.append("\r\n");
        for (int regionNum = 0; regionNum < 5; regionNum++) {
            if (regionNum == 0) {
                statisticsOutput1.append("   • For region ").append(regionNum).append("," + "the increase rate is: ").append(df.format((NPopChng2010Region0 / estimateBase2010Region0) * 100)).append("%");
                statisticsOutput1.append("\r\n");
            } else if (regionNum == 1) {
                statisticsOutput1.append("   • For region ").append(regionNum).append("," + "the increase rate is: ").append(df.format((NPopChng2010Region1 / estimateBase2010Region1) * 100)).append("%");
                statisticsOutput1.append("\r\n");
            } else if (regionNum == 2) {
                statisticsOutput1.append("   • For region ").append(regionNum).append("," + "the increase rate is: ").append(df.format((NPopChng2010Region2 / estimateBase2010Region2) * 100)).append("%");
                statisticsOutput1.append("\r\n");
            } else if (regionNum == 3) {
                statisticsOutput1.append("   • For region ").append(regionNum).append("," + "the increase rate is: ").append(df.format((NPopChng2010Region3 / estimateBase2010Region3) * 100)).append("%");
                statisticsOutput1.append("\r\n");
            } else {
                statisticsOutput1.append("   • For region ").append(regionNum).append("," + "the increase rate is: ").append(df.format((NPopChng2010Region4 / estimateBase2010Region4) * 100)).append("%");
                statisticsOutput1.append("\r\n");
            }
        }

        statisticsOutput1.append("-----------------------------------------------------------------------------");
        statisticsOutput1.append("\r\n");
        statisticsOutput1.append("   • For the year 2011, the population increases based on estimate are:");
        statisticsOutput1.append("\r\n");
        for (int regionNum = 0; regionNum < 5; regionNum++) {
            if (regionNum == 0) {
                statisticsOutput1.append("   • For region ").append(regionNum).append("," + "the increase rate is: ").append(df.format((NPopChng2011Region0 / (popEstimate2011Region0 - NPopChng2011Region0)) * 100)).append("%");
                statisticsOutput1.append("\r\n");
            } else if (regionNum == 1) {
                statisticsOutput1.append("   • For region ").append(regionNum).append("," + "the increase rate is: ").append(df.format((NPopChng2011Region1 / (popEstimate2011Region1 - NPopChng2011Region1)) * 100)).append("%");
                statisticsOutput1.append("\r\n");
            } else if (regionNum == 2) {
                statisticsOutput1.append("   • For region ").append(regionNum).append("," + "the increase rate is: ").append(df.format((NPopChng2011Region2 / (popEstimate2011Region2 - NPopChng2011Region2)) * 100)).append("%");
                statisticsOutput1.append("\r\n");
            } else if (regionNum == 3) {
                statisticsOutput1.append("   • For region ").append(regionNum).append("," + "the increase rate is: ").append(df.format((NPopChng2011Region3 / (popEstimate2011Region3 - NPopChng2011Region3)) * 100)).append("%");
                statisticsOutput1.append("\r\n");
            } else {
                statisticsOutput1.append("   • For region ").append(regionNum).append("," + "the increase rate is: ").append(df.format((NPopChng2011Region4 / (popEstimate2011Region4 - NPopChng2011Region4)) * 100)).append("%");
            }
        }
        statisticsOutput1.append("\r\n");
        statisticsOutput1.append("\r\n");

        return statisticsOutput1.toString();
    }

    public static String calcMaxAndMinBirhPerStatePerYear() {
        StringBuilder statisticsOutput2 = new StringBuilder();
        deserializedRecords = ImportUtilities.getDeserializedRecords();
        //Get the sublist from the population record list, since we only need to consider the state
        statisticsOutput2.append("2> Statistics for max & min births per state per year(Including Puerto Rico Commonwealth)");
        statisticsOutput2.append("\r\n");
        Collections.sort(deserializedRecords.subList(5, 56), new PopulationBirthRecordComparator2010());
        statisticsOutput2.append("   • For the year 2010, the state with minimum births is: ").append(deserializedRecords.subList(5, 56).get(0).getName()).append(" | " + "And the birth number is: ").append(deserializedRecords.subList(5, 56).get(0).getBirths2010());
        statisticsOutput2.append("\r\n");
        statisticsOutput2.append("   • For the year 2010, the state with maximum births is: ").append(deserializedRecords.subList(5, 56).get(50).getName()).append(" | " + "And the birth number is: ").append(deserializedRecords.subList(5, 56).get(50).getBirths2010());
        statisticsOutput2.append("\r\n");

        Collections.sort(deserializedRecords.subList(5, 56), new PopulationBirthRecordComparator2011());
        statisticsOutput2.append("   • For the year 2010, the state with minimum births is: ").append(deserializedRecords.subList(5, 56).get(0).getName()).append(" | " + "And the birth number is: ").append(deserializedRecords.subList(5, 56).get(0).getBirths2011());
        statisticsOutput2.append("\r\n");
        statisticsOutput2.append("\r\n");
        statisticsOutput2.append("\r\n");
        
        return statisticsOutput2.toString();
    }

    public static String clacMaxAndMinDeathPerStatePerYear() {
        StringBuilder statisticsOutput3 = new StringBuilder();
        deserializedRecords = ImportUtilities.getDeserializedRecords();
        statisticsOutput3.append("3> Statistics for max & min deaths per state per year(Including Puerto Rico Commonwealth)");
        statisticsOutput3.append("\r\n");
        Collections.sort(deserializedRecords.subList(5, 56), new PopulationDeathRecordComparator2010());
        statisticsOutput3.append("   • For the year 2010, the state with minimum deaths is: ").append(deserializedRecords.subList(5, 56).get(0).getName()).append(" | " + "And the death number is: ").append(deserializedRecords.subList(5, 56).get(0).getDeaths2010());
        statisticsOutput3.append("\r\n");
        statisticsOutput3.append("   • For the year 2010, the state with minimum deaths is: ").append(deserializedRecords.subList(5, 56).get(50).getName()).append(" | " + "And the death number is: ").append(deserializedRecords.subList(5, 56).get(50).getDeaths2010());
        statisticsOutput3.append("\r\n");

        Collections.sort(deserializedRecords.subList(5, 56), new PopulationDeathRecordComparator2011());
        statisticsOutput3.append("   • For the year 2011, the state with minimum deaths is: ").append(deserializedRecords.subList(5, 56).get(0).getName()).append(" | " + "And the death number is: ").append(deserializedRecords.subList(5, 56).get(0).getDeaths2011());
        statisticsOutput3.append("\r\n");
        statisticsOutput3.append("   • For the year 2011, the state with minimum deaths is: ").append(deserializedRecords.subList(5, 56).get(50).getName()).append(" | " + "And the death number is: ").append(deserializedRecords.subList(5, 56).get(50).getDeaths2011());
        statisticsOutput3.append("\r\n");
        statisticsOutput3.append("\r\n");
        statisticsOutput3.append("\r\n");
        
        return statisticsOutput3.toString();
    }

    public static String calcNumOfStateWithPopIncre() {
        StringBuilder statisticsOutput4 = new StringBuilder();
        deserializedRecords = ImportUtilities.getDeserializedRecords();
        for (int i = 0; i < deserializedRecords.subList(5, 56).size(); i++) {
            if (deserializedRecords.subList(5, 56).get(i).getNpopchg_2010() > 0) {
                numOfStateWithEstimatePopInc2010++;
            } else if (deserializedRecords.subList(5, 56).get(i).getNpopchg_2010() < 0) {
                numOfStateWithEstimatePopDes2010++;
            }
        }

        statisticsOutput4.append("4> Statistics for Number of states with estimated population increase(Including Puerto Rico Commonwealth)");
        statisticsOutput4.append("\r\n");
        statisticsOutput4.append("   • For the year 2010, the number of states with estimate population increase is: ").append(numOfStateWithEstimatePopInc2010);
        statisticsOutput4.append("\r\n");
        statisticsOutput4.append("   • For the year 2011, the number of states with estimate population increase is: ").append(numOfStateWithEstimatePopInc2011);
        statisticsOutput4.append("\r\n");
        statisticsOutput4.append("\r\n");
        
        return statisticsOutput4.toString();
    }

    public static String calcNumOfStateWithPopDesc() {
        StringBuilder statisticsOutput5 = new StringBuilder();
        deserializedRecords = ImportUtilities.getDeserializedRecords();
        for (int i = 0; i < deserializedRecords.subList(5, 56).size(); i++) {
            if (deserializedRecords.subList(5, 56).get(i).getNpopchg_2011() > 0) {
                numOfStateWithEstimatePopInc2011++;
            } else if (deserializedRecords.subList(5, 56).get(i).getNpopchg_2011() < 0) {
                numOfStateWithEstimatePopDes2011++;
            }
        }

        statisticsOutput5.append("5> Statistics for Number of states with estimated population decrease(Including Puerto Rico Commonwealth)");
        statisticsOutput5.append("\r\n");
        statisticsOutput5.append("   • For the year 2010, the number of states with estimate population decrease is: ").append(numOfStateWithEstimatePopDes2010);
        statisticsOutput5.append("\r\n");
        statisticsOutput5.append("   • For the year 2011, the number of states with estimate population decrease is: ").append(numOfStateWithEstimatePopDes2011);
        statisticsOutput5.append("\r\n");
        statisticsOutput5.append("\r\n");
        statisticsOutput5.append("\r\n");
        
        return statisticsOutput5.toString();
    }

    public static String calcStateWithMostEstiPopPerYear() {
        StringBuilder statisticsOutput6 = new StringBuilder();
        deserializedRecords = ImportUtilities.getDeserializedRecords();
        Collections.sort(deserializedRecords.subList(5, 56), new StatePopulationEstimateComparator2010());
        statisticsOutput6.append("6> Statistics for state with most estimated population per year(Including Puerto Rico Commonwealth)");
        statisticsOutput6.append("\r\n");
        statisticsOutput6.append("   • For the year 2010, the state with least estimated population is: ").append(deserializedRecords.subList(5, 56).get(0).getName()).append(" | " + "And the estimated population is: ").append(deserializedRecords.subList(5, 56).get(0).getPopestimate2010());
        statisticsOutput6.append("\r\n");
        statisticsOutput6.append("   • For the year 2010, the state with most estimated population is: ").append(deserializedRecords.subList(5, 56).get(50).getName()).append(" | " + "And the estimated population is: ").append(deserializedRecords.subList(5, 56).get(50).getPopestimate2010());
        statisticsOutput6.append("\r\n");
        statisticsOutput6.append("\r\n");
        statisticsOutput6.append("\r\n");
        
        return statisticsOutput6.toString();
    }

    public static String calcStateWithLeastEstiPopPerYear() {
        StringBuilder statisticsOutput7 = new StringBuilder();
        deserializedRecords = ImportUtilities.getDeserializedRecords();
        Collections.sort(deserializedRecords.subList(5, 56), new StatePopulationEstimateComparator2011());
        statisticsOutput7.append("7> Statistics for state with least estimated population per year(Including Puerto Rico Commonwealth)");
        statisticsOutput7.append("\r\n");
        statisticsOutput7.append("   • For the year 2011, the state with least estimated population is: ").append(deserializedRecords.subList(5, 56).get(0).getName()).append(" | " + "And the estimated population is: ").append(deserializedRecords.subList(5, 56).get(0).getPopestimate2011());
        statisticsOutput7.append("\r\n");
        statisticsOutput7.append("   • For the year 2011, the state with most estimated population is: ").append(deserializedRecords.subList(5, 56).get(50).getName()).append(" | " + "And the estimated population is: ").append(deserializedRecords.subList(5, 56).get(50).getPopestimate2011());
        statisticsOutput7.append("\r\n");
        
        return statisticsOutput7.toString();
    }

    public static List<PopulationRecord> getDeserializedRecords() {
        return deserializedRecords;
    }
}
