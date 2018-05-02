package com.project.diplomaed.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rOlguin
 */
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<RoleAssignment> roleAssignments;

    public Role() {
        this.roleAssignments = new ArrayList<RoleAssignment>();
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

    public List<RoleAssignment> getRoleAssignments() {
        return roleAssignments;
    }

    public void setRoleAssignments(List<RoleAssignment> roleAssignments) {
        this.roleAssignments = roleAssignments;
    }
}

