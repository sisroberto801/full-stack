package com.project.diplomaed.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rOlguin
 */
@Entity
public class WorkAssignment implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;
	
    @Id
    @ManyToOne
    @JoinColumn(name = "charge_id")
    @JsonIgnore
    private Charge charge;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "area_id")
    @JsonIgnore
    private Area area;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}

