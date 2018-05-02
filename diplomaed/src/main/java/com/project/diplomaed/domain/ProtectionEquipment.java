package com.project.diplomaed.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author rOlguin
 */
@Entity
public class ProtectionEquipment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "protection_equipment_id")
    private Long id;

    @Column(name = "name_equipment")
    private String nameEquipment;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "status_equipment")
    private Integer statusEquipment;

	@OneToMany(mappedBy = "protectionEquipment", cascade = CascadeType.ALL)
    private List<ProtectionEquipmentAssignment> protectionEquipmentAssignments;

	public ProtectionEquipment(){
		this.protectionEquipmentAssignments = new ArrayList<ProtectionEquipmentAssignment>();
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEquipment() {
        return nameEquipment;
    }

    public void setNameEquipment(String nameEquipment) {
        this.nameEquipment = nameEquipment;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getStatusEquipment() {
        return statusEquipment;
    }

    public void setStatusEquipment(Integer statusEquipment) {
        this.statusEquipment = statusEquipment;
    }

    public List<ProtectionEquipmentAssignment> getProtectionEquipmentAssignments() {
        return protectionEquipmentAssignments;
    }

    public void setProtectionEquipmentAssignments(List<ProtectionEquipmentAssignment> protectionEquipmentAssignments) {
        this.protectionEquipmentAssignments = protectionEquipmentAssignments;
    }
}

