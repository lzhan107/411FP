/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lei
 */
public class PersistentObject implements Serializable{
    private long serializedTime = 0;
    private List<PopulationRecord> populationRecords = new ArrayList<>();
    private static boolean populationRecordsHasValue = false;

    public PersistentObject() {
    }
    
    public PersistentObject(long serializedTime, List<PopulationRecord> populationRecords){
        this.serializedTime = serializedTime;
        this.populationRecords = populationRecords;
        populationRecordsHasValue = true;
    }

    public long getSerializedTime() {
        return serializedTime;
    }

    public List<PopulationRecord> getPopulationRecords() {
        return populationRecords;
    }

    public void setSerializedTime(long serializedTime) {
        this.serializedTime = serializedTime;
    }

    public void setPopulationRecords(ArrayList<PopulationRecord> populationRecords) {
        this.populationRecords = populationRecords;
    }

    public static boolean isPopulationRecordsHasValue() {
        return populationRecordsHasValue;
    }
    
    @Override
    public String toString() {
        return "PersistentObject{" + "serializedTime=" + serializedTime + ", populationRecords=" + populationRecords + '}';
    }
}

