package com.project.diplomaed.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rOlguin
 */
@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<RoleAssignment> roleAssignments;

    @OneToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ProtectionEquipmentAssignment> protectionEquipmentAssignments;
	
    public User() {
        this.roleAssignments = new ArrayList<RoleAssignment>();
        this.protectionEquipmentAssignments = new ArrayList<ProtectionEquipmentAssignment>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<RoleAssignment> getRoleAssignments() {
        return roleAssignments;
    }

    public void setRoleAssignments(List<RoleAssignment> roleAssignments) {
        this.roleAssignments = roleAssignments;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

