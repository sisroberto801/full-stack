package com.project.diplomaed.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rOlguin
 */
@Entity
@Table(name = "charge")
public class Charge {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "charge_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "charge", cascade = CascadeType.ALL)
    private List<WorkAssignment> workAssignments;

    public Charge() {
        this.workAssignments = new ArrayList<WorkAssignment>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WorkAssignment> getWorkAssignments() {
        return workAssignments;
    }

    public void setWorkAssignments(List<WorkAssignment> workAssignments) {
        this.workAssignments = workAssignments;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

