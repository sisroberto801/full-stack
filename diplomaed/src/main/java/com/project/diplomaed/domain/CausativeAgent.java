package com.project.diplomaed.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 5/5/2018.
 */
@Entity
@Table(name = "causative_agent")
public class CausativeAgent {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "causative_agent_id")
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "causativeAgent", cascade = CascadeType.ALL)
    private List<AccidentRegistry> accidentRegistries;

    public CausativeAgent(){
        this.accidentRegistries = new ArrayList<AccidentRegistry>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AccidentRegistry> getAccidentRegistries() {
        return accidentRegistries;
    }

    public void setAccidentRegistries(List<AccidentRegistry> accidentRegistries) {
        this.accidentRegistries = accidentRegistries;
    }
}
