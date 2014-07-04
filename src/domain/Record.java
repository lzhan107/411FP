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
public abstract class Record implements Serializable{
    protected int sumlev;
    protected int region;
    protected int division;
    protected int state;
    protected String name;
    protected long census2010pop;
    protected long estimatesbase2010;
    protected long popestimate2010;
    protected long popestimate2011;
    protected long npopchg_2010;
    protected long npopchg_2011;
    protected long births2010;
    protected long births2011;
    protected long deaths2010;
    protected long deaths2011;
    protected long naturalinc2010;
    protected long naturalinc2011;
    protected long internationalmig2010;
    protected long internationalmig2011;
    protected long demosticmig2010;
    protected long demosticmig2011;
    protected long netmig2010;
    protected long netmig2011;
    protected long residual2010;
    protected long residual2011;
    protected double rbirth2011;
    protected double rdeath2011;
    protected double rnaturalinc2011;
    protected double rinternationalimg2011;
    protected double rdomesticimg2011;
    protected double rnetimg2011;

    public int getSumlev() {
        return sumlev;
    }

    public int getRegion() {
        return region;
    }

    public int getDivision() {
        return division;
    }

    public int getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public long getCensus2010pop() {
        return census2010pop;
    }

    public long getEstimatesbase2010() {
        return estimatesbase2010;
    }

    public long getPopestimate2010() {
        return popestimate2010;
    }

    public long getPopestimate2011() {
        return popestimate2011;
    }

    public long getNpopchg_2010() {
        return npopchg_2010;
    }

    public long getNpopchg_2011() {
        return npopchg_2011;
    }

    public long getBirths2010() {
        return births2010;
    }

    public long getBirths2011() {
        return births2011;
    }

    public long getDeaths2010() {
        return deaths2010;
    }

    public long getDeaths2011() {
        return deaths2011;
    }

    public long getNaturalinc2010() {
        return naturalinc2010;
    }

    public long getNaturalinc2011() {
        return naturalinc2011;
    }

    public long getInternationalmig2010() {
        return internationalmig2010;
    }

    public long getInternationalmig2011() {
        return internationalmig2011;
    }

    public long getDemosticmig2010() {
        return demosticmig2010;
    }

    public long getDemosticmig2011() {
        return demosticmig2011;
    }

    public long getNetmig2010() {
        return netmig2010;
    }

    public long getNetmig2011() {
        return netmig2011;
    }

    public long getResidual2010() {
        return residual2010;
    }

    public long getResidual2011() {
        return residual2011;
    }

    public double getRbirth2011() {
        return rbirth2011;
    }

    public double getRdeath2011() {
        return rdeath2011;
    }

    public double getRnaturalinc2011() {
        return rnaturalinc2011;
    }

    public double getRinternationalimg2011() {
        return rinternationalimg2011;
    }

    public double getRdomesticimg2011() {
        return rdomesticimg2011;
    }

    public double getRnetimg2011() {
        return rnetimg2011;
    }

    public void setSumlev(int sumlev) {
        this.sumlev = sumlev;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCensus2010pop(long census2010pop) {
        this.census2010pop = census2010pop;
    }

    public void setEstimatesbase2010(long estimatesbase2010) {
        this.estimatesbase2010 = estimatesbase2010;
    }

    public void setPopestimate2010(long popestimate2010) {
        this.popestimate2010 = popestimate2010;
    }

    public void setPopestimate2011(long popestimate2011) {
        this.popestimate2011 = popestimate2011;
    }

    public void setNpopchg_2010(long npopchg_2010) {
        this.npopchg_2010 = npopchg_2010;
    }

    public void setNpopchg_2011(long npopchg_2011) {
        this.npopchg_2011 = npopchg_2011;
    }

    public void setBirths2010(long births2010) {
        this.births2010 = births2010;
    }

    public void setBirths2011(long births2011) {
        this.births2011 = births2011;
    }

    public void setDeaths2010(long deaths2010) {
        this.deaths2010 = deaths2010;
    }

    public void setDeaths2011(long deaths2011) {
        this.deaths2011 = deaths2011;
    }

    public void setNaturalinc2010(long naturalinc2010) {
        this.naturalinc2010 = naturalinc2010;
    }

    public void setNaturalinc2011(long naturalinc2011) {
        this.naturalinc2011 = naturalinc2011;
    }

    public void setInternationalmig2010(long internationalmig2010) {
        this.internationalmig2010 = internationalmig2010;
    }

    public void setInternationalmig2011(long internationalmig2011) {
        this.internationalmig2011 = internationalmig2011;
    }

    public void setDemosticmig2010(long demosticmig2010) {
        this.demosticmig2010 = demosticmig2010;
    }

    public void setDemosticmig2011(long demosticmig2011) {
        this.demosticmig2011 = demosticmig2011;
    }

    public void setNetmig2010(long netmig2010) {
        this.netmig2010 = netmig2010;
    }

    public void setNetmig2011(long netmig2011) {
        this.netmig2011 = netmig2011;
    }

    public void setResidual2010(long residual2010) {
        this.residual2010 = residual2010;
    }

    public void setResidual2011(long residual2011) {
        this.residual2011 = residual2011;
    }

    public void setRbirth2011(double rbirth2011) {
        this.rbirth2011 = rbirth2011;
    }

    public void setRdeath2011(double rdeath2011) {
        this.rdeath2011 = rdeath2011;
    }

    public void setRnaturalinc2011(double rnaturalinc2011) {
        this.rnaturalinc2011 = rnaturalinc2011;
    }

    public void setRinternationalimg2011(double rinternationalimg2011) {
        this.rinternationalimg2011 = rinternationalimg2011;
    }

    public void setRdomesticimg2011(double rdomesticimg2011) {
        this.rdomesticimg2011 = rdomesticimg2011;
    }

    public void setRnetimg2011(double rnetimg2011) {
        this.rnetimg2011 = rnetimg2011;
    }

    @Override
    public String toString() {
        return "Record{" + "sumlev=" + sumlev + ", region=" + region + ", division=" + division + ", state=" + state + ", name=" + name + ", census2010pop=" + census2010pop + ", estimatesbase=" + estimatesbase2010 + ", popestimate2010=" + popestimate2010 + ", popestimate2011=" + popestimate2011 + ", npopchg_2010=" + npopchg_2010 + ", npopchg_2011=" + npopchg_2011 + ", births2010=" + births2010 + ", births2011=" + births2011 + ", deaths2010=" + deaths2010 + ", deaths2011=" + deaths2011 + ", naturalinc2010=" + naturalinc2010 + ", naturalinc2011=" + naturalinc2011 + ", internationalmig2010=" + internationalmig2010 + ", internationalmig2011=" + internationalmig2011 + ", demosticmig2010=" + demosticmig2010 + ", demosticmig2011=" + demosticmig2011 + ", netmig2010=" + netmig2010 + ", netmig2011=" + netmig2011 + ", residual2010=" + residual2010 + ", residual2011=" + residual2011 + ", rbirth2011=" + rbirth2011 + ", rdeath2011=" + rdeath2011 + ", rnaturalinc2011=" + rnaturalinc2011 + ", rinternationalimg2011=" + rinternationalimg2011 + ", rdomesticimg2011=" + rdomesticimg2011 + ", rnetimg2011=" + rnetimg2011 + '}';
    }
}