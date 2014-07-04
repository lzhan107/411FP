/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Lei
 */
public class PopulationRecord extends Record implements Serializable{

    public PopulationRecord() {
    }

    public PopulationRecord(int sumlev,
                            int region,
                            int division,
                            int state,
                            String name,
                            long census2010pop,
                            long estimatesbase2010,
                            long popestimate2010,
                            long popestimate2011,
                            long npopchg_2010,
                            long npopchg_2011,
                            long births2010,
                            long births2011,
                            long deaths2010,
                            long deaths2011,
                            long naturalinc2010,
                            long naturalinc2011,
                            long internationalmig2010,
                            long internationalmig2011,
                            long demosticmig2010,
                            long demosticmig2011,
                            long netmig2010,
                            long netmig2011,
                            long residual2010,
                            long residual2011,
                            double rbirth2011,
                            double rdeath2011,
                            double rnaturalinc2011,
                            double rinternationalimg2011,
                            double rdomesticimg2011,
                            double rnetimg2011){
        this.sumlev = sumlev;
        this.region = region;
        this.division = division;
        this.state = state;
        this.name = name;
        this.census2010pop = census2010pop;
        this.estimatesbase2010 = estimatesbase2010;
        this.popestimate2010 = popestimate2010;
        this.popestimate2011 = popestimate2011;
        this.npopchg_2010 = npopchg_2010;
        this.npopchg_2011 = npopchg_2011;
        this.births2010 = births2010;
        this.births2011 = births2011;
        this.deaths2010 = deaths2010;
        this.deaths2011 = deaths2011;
        this.naturalinc2010 = naturalinc2010;
        this.naturalinc2011 = naturalinc2011;
        this.internationalmig2010 = internationalmig2010;
        this.internationalmig2011 = internationalmig2011;
        this.demosticmig2010 = demosticmig2010;
        this.demosticmig2011 = demosticmig2011;
        this.netmig2010 = netmig2010;
        this.netmig2010 = netmig2011;
        this.residual2010 = residual2010;
        this.residual2011 = residual2011;
        this.rbirth2011 = rbirth2011;
        this.rdeath2011 = rdeath2011;
        this.rnaturalinc2011 = rnaturalinc2011;
        this.rinternationalimg2011 = rinternationalimg2011;
        this.rdomesticimg2011 = rdomesticimg2011;
        this.rnetimg2011 = rnetimg2011;
    }
}
