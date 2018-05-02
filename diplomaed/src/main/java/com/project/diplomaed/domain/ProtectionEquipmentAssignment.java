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

    @Column(name = "equipment_allocation_date")
    private Date equipmentAllocationDate;

    @Column(name = "equipment_return_date")
    private Date equipmentReturnDate;

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

    public Date getEquipmentAllocationDate() {
        return equipmentAllocationDate;
    }

    public void setEquipmentAllocationDate(Date equipmentAllocationDate) {
        this.equipmentAllocationDate = equipmentAllocationDate;
    }

    public Date getEquipmentReturnDate() {
        return equipmentReturnDate;
    }

    public void setEquipmentReturnDate(Date equipmentReturnDate) {
        this.equipmentReturnDate = equipmentReturnDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

