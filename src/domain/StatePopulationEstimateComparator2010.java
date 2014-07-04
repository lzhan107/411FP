/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Comparator;

/**
 * This comparator is used for Sorting the elements according to the state estimated population in ascending order for the year 2010
 * @author Lei
 */
public class StatePopulationEstimateComparator2010 implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        PopulationRecord pr1 = (PopulationRecord) o1;
        PopulationRecord pr2 = (PopulationRecord) o2;
        
        if (pr1.getPopestimate2010() > pr2.getPopestimate2010()){
            return 1;
        }else if (pr1.getPopestimate2010() < pr2.getPopestimate2010()){
            return -1;
        }else {
            return 0;
        }
    }
}
