/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIUtilities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Hao
 */
@Entity
@Table(name = "population_record_table", catalog = "itm411db", schema = "")
@NamedQueries({
    @NamedQuery(name = "PopulationRecordTable.findAll", query = "SELECT p FROM PopulationRecordTable p"),
    @NamedQuery(name = "PopulationRecordTable.findBySumLev", query = "SELECT p FROM PopulationRecordTable p WHERE p.sumLev = :sumLev"),
    @NamedQuery(name = "PopulationRecordTable.findByRegion", query = "SELECT p FROM PopulationRecordTable p WHERE p.region = :region"),
    @NamedQuery(name = "PopulationRecordTable.findByDivision", query = "SELECT p FROM PopulationRecordTable p WHERE p.division = :division"),
    @NamedQuery(name = "PopulationRecordTable.findByState", query = "SELECT p FROM PopulationRecordTable p WHERE p.state = :state"),
    @NamedQuery(name = "PopulationRecordTable.findByName", query = "SELECT p FROM PopulationRecordTable p WHERE p.name = :name"),
    @NamedQuery(name = "PopulationRecordTable.findByCensus2010pop", query = "SELECT p FROM PopulationRecordTable p WHERE p.census2010pop = :census2010pop"),
    @NamedQuery(name = "PopulationRecordTable.findByEstimatesBase2010", query = "SELECT p FROM PopulationRecordTable p WHERE p.estimatesBase2010 = :estimatesBase2010"),
    @NamedQuery(name = "PopulationRecordTable.findByPopEstimate2010", query = "SELECT p FROM PopulationRecordTable p WHERE p.popEstimate2010 = :popEstimate2010"),
    @NamedQuery(name = "PopulationRecordTable.findByPopEstimate2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.popEstimate2011 = :popEstimate2011"),
    @NamedQuery(name = "PopulationRecordTable.findByNPopCHG2010", query = "SELECT p FROM PopulationRecordTable p WHERE p.nPopCHG2010 = :nPopCHG2010"),
    @NamedQuery(name = "PopulationRecordTable.findByNPopCHG2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.nPopCHG2011 = :nPopCHG2011"),
    @NamedQuery(name = "PopulationRecordTable.findByBirths2010", query = "SELECT p FROM PopulationRecordTable p WHERE p.births2010 = :births2010"),
    @NamedQuery(name = "PopulationRecordTable.findByBirths2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.births2011 = :births2011"),
    @NamedQuery(name = "PopulationRecordTable.findByDeath2010", query = "SELECT p FROM PopulationRecordTable p WHERE p.death2010 = :death2010"),
    @NamedQuery(name = "PopulationRecordTable.findByDeath2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.death2011 = :death2011"),
    @NamedQuery(name = "PopulationRecordTable.findByNaturalInc2010", query = "SELECT p FROM PopulationRecordTable p WHERE p.naturalInc2010 = :naturalInc2010"),
    @NamedQuery(name = "PopulationRecordTable.findByNaturalInc2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.naturalInc2011 = :naturalInc2011"),
    @NamedQuery(name = "PopulationRecordTable.findByInternationalMig2010", query = "SELECT p FROM PopulationRecordTable p WHERE p.internationalMig2010 = :internationalMig2010"),
    @NamedQuery(name = "PopulationRecordTable.findByInternationalMig2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.internationalMig2011 = :internationalMig2011"),
    @NamedQuery(name = "PopulationRecordTable.findByDomesticMig2010", query = "SELECT p FROM PopulationRecordTable p WHERE p.domesticMig2010 = :domesticMig2010"),
    @NamedQuery(name = "PopulationRecordTable.findByDomesticMig2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.domesticMig2011 = :domesticMig2011"),
    @NamedQuery(name = "PopulationRecordTable.findByNetMig2010", query = "SELECT p FROM PopulationRecordTable p WHERE p.netMig2010 = :netMig2010"),
    @NamedQuery(name = "PopulationRecordTable.findByNetMig2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.netMig2011 = :netMig2011"),
    @NamedQuery(name = "PopulationRecordTable.findByResidual2010", query = "SELECT p FROM PopulationRecordTable p WHERE p.residual2010 = :residual2010"),
    @NamedQuery(name = "PopulationRecordTable.findByResidual2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.residual2011 = :residual2011"),
    @NamedQuery(name = "PopulationRecordTable.findByRBirth2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.rBirth2011 = :rBirth2011"),
    @NamedQuery(name = "PopulationRecordTable.findByRDeath2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.rDeath2011 = :rDeath2011"),
    @NamedQuery(name = "PopulationRecordTable.findByRNaturalInc2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.rNaturalInc2011 = :rNaturalInc2011"),
    @NamedQuery(name = "PopulationRecordTable.findByRInternationalMig2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.rInternationalMig2011 = :rInternationalMig2011"),
    @NamedQuery(name = "PopulationRecordTable.findByRDomesticMig2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.rDomesticMig2011 = :rDomesticMig2011"),
    @NamedQuery(name = "PopulationRecordTable.findByRNetMig2011", query = "SELECT p FROM PopulationRecordTable p WHERE p.rNetMig2011 = :rNetMig2011")})
public class PopulationRecordTable implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sumLev")
    private Double sumLev;
    @Column(name = "region")
    private Double region;
    @Column(name = "division")
    private Double division;
    @Column(name = "state")
    private Double state;
    @Id
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "census2010pop")
    private Double census2010pop;
    @Column(name = "estimatesBase2010")
    private Double estimatesBase2010;
    @Column(name = "popEstimate2010")
    private Double popEstimate2010;
    @Column(name = "popEstimate2011")
    private Double popEstimate2011;
    @Column(name = "nPopCHG_2010")
    private Double nPopCHG2010;
    @Column(name = "nPopCHG_2011")
    private Double nPopCHG2011;
    @Column(name = "births2010")
    private Double births2010;
    @Column(name = "births2011")
    private Double births2011;
    @Column(name = "death2010")
    private Double death2010;
    @Column(name = "death2011")
    private Double death2011;
    @Column(name = "naturalInc2010")
    private Double naturalInc2010;
    @Column(name = "naturalInc2011")
    private Double naturalInc2011;
    @Column(name = "internationalMig2010")
    private Double internationalMig2010;
    @Column(name = "internationalMig2011")
    private Double internationalMig2011;
    @Column(name = "domesticMig2010")
    private Double domesticMig2010;
    @Column(name = "domesticMig2011")
    private Double domesticMig2011;
    @Column(name = "netMig2010")
    private Double netMig2010;
    @Column(name = "netMig2011")
    private Double netMig2011;
    @Column(name = "residual2010")
    private Double residual2010;
    @Column(name = "residual2011")
    private Double residual2011;
    @Column(name = "rBirth2011")
    private Double rBirth2011;
    @Column(name = "rDeath2011")
    private Double rDeath2011;
    @Column(name = "rNaturalInc2011")
    private Double rNaturalInc2011;
    @Column(name = "rInternationalMig2011")
    private Double rInternationalMig2011;
    @Column(name = "rDomesticMig2011")
    private Double rDomesticMig2011;
    @Column(name = "rNetMig2011")
    private Double rNetMig2011;

    public PopulationRecordTable() {
    }

    public PopulationRecordTable(String name) {
        this.name = name;
    }

    public Double getSumLev() {
        return sumLev;
    }

    public void setSumLev(Double sumLev) {
        Double oldSumLev = this.sumLev;
        this.sumLev = sumLev;
        changeSupport.firePropertyChange("sumLev", oldSumLev, sumLev);
    }

    public Double getRegion() {
        return region;
    }

    public void setRegion(Double region) {
        Double oldRegion = this.region;
        this.region = region;
        changeSupport.firePropertyChange("region", oldRegion, region);
    }

    public Double getDivision() {
        return division;
    }

    public void setDivision(Double division) {
        Double oldDivision = this.division;
        this.division = division;
        changeSupport.firePropertyChange("division", oldDivision, division);
    }

    public Double getState() {
        return state;
    }

    public void setState(Double state) {
        Double oldState = this.state;
        this.state = state;
        changeSupport.firePropertyChange("state", oldState, state);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Double getCensus2010pop() {
        return census2010pop;
    }

    public void setCensus2010pop(Double census2010pop) {
        Double oldCensus2010pop = this.census2010pop;
        this.census2010pop = census2010pop;
        changeSupport.firePropertyChange("census2010pop", oldCensus2010pop, census2010pop);
    }

    public Double getEstimatesBase2010() {
        return estimatesBase2010;
    }

    public void setEstimatesBase2010(Double estimatesBase2010) {
        Double oldEstimatesBase2010 = this.estimatesBase2010;
        this.estimatesBase2010 = estimatesBase2010;
        changeSupport.firePropertyChange("estimatesBase2010", oldEstimatesBase2010, estimatesBase2010);
    }

    public Double getPopEstimate2010() {
        return popEstimate2010;
    }

    public void setPopEstimate2010(Double popEstimate2010) {
        Double oldPopEstimate2010 = this.popEstimate2010;
        this.popEstimate2010 = popEstimate2010;
        changeSupport.firePropertyChange("popEstimate2010", oldPopEstimate2010, popEstimate2010);
    }

    public Double getPopEstimate2011() {
        return popEstimate2011;
    }

    public void setPopEstimate2011(Double popEstimate2011) {
        Double oldPopEstimate2011 = this.popEstimate2011;
        this.popEstimate2011 = popEstimate2011;
        changeSupport.firePropertyChange("popEstimate2011", oldPopEstimate2011, popEstimate2011);
    }

    public Double getNPopCHG2010() {
        return nPopCHG2010;
    }

    public void setNPopCHG2010(Double nPopCHG2010) {
        Double oldNPopCHG2010 = this.nPopCHG2010;
        this.nPopCHG2010 = nPopCHG2010;
        changeSupport.firePropertyChange("NPopCHG2010", oldNPopCHG2010, nPopCHG2010);
    }

    public Double getNPopCHG2011() {
        return nPopCHG2011;
    }

    public void setNPopCHG2011(Double nPopCHG2011) {
        Double oldNPopCHG2011 = this.nPopCHG2011;
        this.nPopCHG2011 = nPopCHG2011;
        changeSupport.firePropertyChange("NPopCHG2011", oldNPopCHG2011, nPopCHG2011);
    }

    public Double getBirths2010() {
        return births2010;
    }

    public void setBirths2010(Double births2010) {
        Double oldBirths2010 = this.births2010;
        this.births2010 = births2010;
        changeSupport.firePropertyChange("births2010", oldBirths2010, births2010);
    }

    public Double getBirths2011() {
        return births2011;
    }

    public void setBirths2011(Double births2011) {
        Double oldBirths2011 = this.births2011;
        this.births2011 = births2011;
        changeSupport.firePropertyChange("births2011", oldBirths2011, births2011);
    }

    public Double getDeath2010() {
        return death2010;
    }

    public void setDeath2010(Double death2010) {
        Double oldDeath2010 = this.death2010;
        this.death2010 = death2010;
        changeSupport.firePropertyChange("death2010", oldDeath2010, death2010);
    }

    public Double getDeath2011() {
        return death2011;
    }

    public void setDeath2011(Double death2011) {
        Double oldDeath2011 = this.death2011;
        this.death2011 = death2011;
        changeSupport.firePropertyChange("death2011", oldDeath2011, death2011);
    }

    public Double getNaturalInc2010() {
        return naturalInc2010;
    }

    public void setNaturalInc2010(Double naturalInc2010) {
        Double oldNaturalInc2010 = this.naturalInc2010;
        this.naturalInc2010 = naturalInc2010;
        changeSupport.firePropertyChange("naturalInc2010", oldNaturalInc2010, naturalInc2010);
    }

    public Double getNaturalInc2011() {
        return naturalInc2011;
    }

    public void setNaturalInc2011(Double naturalInc2011) {
        Double oldNaturalInc2011 = this.naturalInc2011;
        this.naturalInc2011 = naturalInc2011;
        changeSupport.firePropertyChange("naturalInc2011", oldNaturalInc2011, naturalInc2011);
    }

    public Double getInternationalMig2010() {
        return internationalMig2010;
    }

    public void setInternationalMig2010(Double internationalMig2010) {
        Double oldInternationalMig2010 = this.internationalMig2010;
        this.internationalMig2010 = internationalMig2010;
        changeSupport.firePropertyChange("internationalMig2010", oldInternationalMig2010, internationalMig2010);
    }

    public Double getInternationalMig2011() {
        return internationalMig2011;
    }

    public void setInternationalMig2011(Double internationalMig2011) {
        Double oldInternationalMig2011 = this.internationalMig2011;
        this.internationalMig2011 = internationalMig2011;
        changeSupport.firePropertyChange("internationalMig2011", oldInternationalMig2011, internationalMig2011);
    }

    public Double getDomesticMig2010() {
        return domesticMig2010;
    }

    public void setDomesticMig2010(Double domesticMig2010) {
        Double oldDomesticMig2010 = this.domesticMig2010;
        this.domesticMig2010 = domesticMig2010;
        changeSupport.firePropertyChange("domesticMig2010", oldDomesticMig2010, domesticMig2010);
    }

    public Double getDomesticMig2011() {
        return domesticMig2011;
    }

    public void setDomesticMig2011(Double domesticMig2011) {
        Double oldDomesticMig2011 = this.domesticMig2011;
        this.domesticMig2011 = domesticMig2011;
        changeSupport.firePropertyChange("domesticMig2011", oldDomesticMig2011, domesticMig2011);
    }

    public Double getNetMig2010() {
        return netMig2010;
    }

    public void setNetMig2010(Double netMig2010) {
        Double oldNetMig2010 = this.netMig2010;
        this.netMig2010 = netMig2010;
        changeSupport.firePropertyChange("netMig2010", oldNetMig2010, netMig2010);
    }

    public Double getNetMig2011() {
        return netMig2011;
    }

    public void setNetMig2011(Double netMig2011) {
        Double oldNetMig2011 = this.netMig2011;
        this.netMig2011 = netMig2011;
        changeSupport.firePropertyChange("netMig2011", oldNetMig2011, netMig2011);
    }

    public Double getResidual2010() {
        return residual2010;
    }

    public void setResidual2010(Double residual2010) {
        Double oldResidual2010 = this.residual2010;
        this.residual2010 = residual2010;
        changeSupport.firePropertyChange("residual2010", oldResidual2010, residual2010);
    }

    public Double getResidual2011() {
        return residual2011;
    }

    public void setResidual2011(Double residual2011) {
        Double oldResidual2011 = this.residual2011;
        this.residual2011 = residual2011;
        changeSupport.firePropertyChange("residual2011", oldResidual2011, residual2011);
    }

    public Double getRBirth2011() {
        return rBirth2011;
    }

    public void setRBirth2011(Double rBirth2011) {
        Double oldRBirth2011 = this.rBirth2011;
        this.rBirth2011 = rBirth2011;
        changeSupport.firePropertyChange("RBirth2011", oldRBirth2011, rBirth2011);
    }

    public Double getRDeath2011() {
        return rDeath2011;
    }

    public void setRDeath2011(Double rDeath2011) {
        Double oldRDeath2011 = this.rDeath2011;
        this.rDeath2011 = rDeath2011;
        changeSupport.firePropertyChange("RDeath2011", oldRDeath2011, rDeath2011);
    }

    public Double getRNaturalInc2011() {
        return rNaturalInc2011;
    }

    public void setRNaturalInc2011(Double rNaturalInc2011) {
        Double oldRNaturalInc2011 = this.rNaturalInc2011;
        this.rNaturalInc2011 = rNaturalInc2011;
        changeSupport.firePropertyChange("RNaturalInc2011", oldRNaturalInc2011, rNaturalInc2011);
    }

    public Double getRInternationalMig2011() {
        return rInternationalMig2011;
    }

    public void setRInternationalMig2011(Double rInternationalMig2011) {
        Double oldRInternationalMig2011 = this.rInternationalMig2011;
        this.rInternationalMig2011 = rInternationalMig2011;
        changeSupport.firePropertyChange("RInternationalMig2011", oldRInternationalMig2011, rInternationalMig2011);
    }

    public Double getRDomesticMig2011() {
        return rDomesticMig2011;
    }

    public void setRDomesticMig2011(Double rDomesticMig2011) {
        Double oldRDomesticMig2011 = this.rDomesticMig2011;
        this.rDomesticMig2011 = rDomesticMig2011;
        changeSupport.firePropertyChange("RDomesticMig2011", oldRDomesticMig2011, rDomesticMig2011);
    }

    public Double getRNetMig2011() {
        return rNetMig2011;
    }

    public void setRNetMig2011(Double rNetMig2011) {
        Double oldRNetMig2011 = this.rNetMig2011;
        this.rNetMig2011 = rNetMig2011;
        changeSupport.firePropertyChange("RNetMig2011", oldRNetMig2011, rNetMig2011);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PopulationRecordTable)) {
            return false;
        }
        PopulationRecordTable other = (PopulationRecordTable) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GUIUtilities.PopulationRecordTable[ name=" + name + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
