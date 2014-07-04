/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Comparator;

/**
 * This comparator is used for Sorting the elements according to the births rate in ascending order for the year 2011
 * @author Lei
 */
public class PopulationBirthRecordComparator2011 implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        PopulationRecord pr1 = (PopulationRecord) o1;
        PopulationRecord pr2 = (PopulationRecord) o2;
        if (pr1.getBirths2011() > pr2.getBirths2011()){
            return 1;
        }else if (pr1.getBirths2011() < pr2.getBirths2011()){
            return -1;
        }else{
            return 0;
        }
    }
}
