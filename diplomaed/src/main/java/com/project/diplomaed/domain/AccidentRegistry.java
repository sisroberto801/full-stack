package com.project.diplomaed.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Administrator on 5/5/2018.
 */
@Entity
public class AccidentRegistry implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "accident_type_id")
    @JsonIgnore
    private AccidentType accidentType;

    @Id
    @ManyToOne
    @JoinColumn(name = "accident_form_id")
    @JsonIgnore
    private AccidentForm accidentForm;

    @Id
    @ManyToOne
    @JoinColumn(name = "injury_type_id")
    @JsonIgnore
    private InjuryType injuryType;

    @Id
    @ManyToOne
    @JoinColumn(name = "causative_agent_id")
    @JsonIgnore
    private CausativeAgent causativeAgent;

    @Id
    @ManyToOne
    @JoinColumn(name = "area_id")
    @JsonIgnore
    private Area area;

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    public AccidentType getAccidentType() {
        return accidentType;
    }

    public void setAccidentType(AccidentType accidentType) {
        this.accidentType = accidentType;
    }

    public AccidentForm getAccidentForm() {
        return accidentForm;
    }

    public void setAccidentForm(AccidentForm accidentForm) {
        this.accidentForm = accidentForm;
    }

    public InjuryType getInjuryType() {
        return injuryType;
    }

    public void setInjuryType(InjuryType injuryType) {
        this.injuryType = injuryType;
    }

    public CausativeAgent getCausativeAgent() {
        return causativeAgent;
    }

    public void setCausativeAgent(CausativeAgent causativeAgent) {
        this.causativeAgent = causativeAgent;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
