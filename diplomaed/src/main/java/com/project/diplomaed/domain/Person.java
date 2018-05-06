package com.project.diplomaed.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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

    @Column(name = "last_name2")
    private String lastName2;

    @Column(name = "birth_date")
    private Date birthdate;

    @Column(name = "dni")
    private Integer dni;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "academic_formation")
    private String academicFormation;

    @Column(name = "family_contact_name")
    private String familyContactName;

    @Column(name = "family_contact_phone")
    private Integer familyContactPhone;

	@Column(name = "status")
    private Boolean status;

    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    private User user;
	
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<ProtectionEquipmentAssignment> protectionEquipmentAssignments;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<WorkAssignment> workAssignments;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<AccidentRegistry> accidentRegistries;

    public Person (){
        this.user = new User();
		this.protectionEquipmentAssignments = new ArrayList<ProtectionEquipmentAssignment>();
		this.workAssignments = new ArrayList<WorkAssignment>();
		this.accidentRegistries = new ArrayList<AccidentRegistry>();
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

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAcademicFormation() {
        return academicFormation;
    }

    public void setAcademicFormation(String academicFormation) {
        this.academicFormation = academicFormation;
    }

    public String getFamilyContactName() {
        return familyContactName;
    }

    public void setFamilyContactName(String familyContactName) {
        this.familyContactName = familyContactName;
    }

    public Integer getFamilyContactPhone() {
        return familyContactPhone;
    }

    public void setFamilyContactPhone(Integer familyContactPhone) {
        this.familyContactPhone = familyContactPhone;
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

    public List<ProtectionEquipmentAssignment> getProtectionEquipmentAssignments() {
        return protectionEquipmentAssignments;
    }

    public void setProtectionEquipmentAssignments(List<ProtectionEquipmentAssignment> protectionEquipmentAssignments) {
        this.protectionEquipmentAssignments = protectionEquipmentAssignments;
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
