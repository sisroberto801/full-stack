package com.project.diplomaed.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 4/28/2018.
 */
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
	
	@Column(name = "status")
    private Boolean status;

    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;

	
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<ProtectionEquipmentAssignment> protectionEquipmentAssignments;
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<WorkAssignment> workAssignments;
	
    public Person (){
        this.user = new User();
		this.protectionEquipmentAssignments = new ArrayList<ProtectionEquipmentAssignment>();
		this.workAssignments = new ArrayList<WorkAssignment>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
	
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
