package com.project.diplomaed.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author rOlguin
 */
@Entity
public class ProtectionEquipmentAssignment implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
	
    @Id
    @ManyToOne
    @JoinColumn(name = "protection_equipment_id")
    @JsonIgnore
    private ProtectionEquipment protectionEquipment;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @Column(name = "allocation_date")
    private Date allocationDate;

    @Column(name = "devolution_date")
    private Date devolutionDate;

    @Column(name = "amount")
    private Integer amount;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProtectionEquipment getProtectionEquipment() {
        return protectionEquipment;
    }

    public void setProtectionEquipment(ProtectionEquipment protectionEquipment) {
        this.protectionEquipment = protectionEquipment;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(Date allocationDate) {
        this.allocationDate = allocationDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

