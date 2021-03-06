package com.project.diplomaed.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rOlguin
 */
@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "area_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

	@Column(name = "status")
    private Boolean status;
	
    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL)
    private List<WorkAssignment> workAssignments;

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL)
    private List<AccidentRegistry> accidentRegistries;

    public Area() {
        this.workAssignments = new ArrayList<WorkAssignment>();
        this.accidentRegistries = new ArrayList<AccidentRegistry>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<WorkAssignment> getWorkAssignments() {
        return workAssignments;
    }

    public void setWorkAssignments(List<WorkAssignment> workAssignments) {
        this.workAssignments = workAssignments;
    }

    public List<AccidentRegistry> getAccidentRegistries() {
        return accidentRegistries;
    }

    public void setAccidentRegistries(List<AccidentRegistry> accidentRegistries) {
        this.accidentRegistries = accidentRegistries;
    }
}

