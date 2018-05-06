package com.project.diplomaed.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 5/5/2018.
 */
@Entity
@Table(name = "accident_form")
public class AccidentForm {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "accident_form_id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "accidentForm", cascade = CascadeType.ALL)
    private List<AccidentRegistry> accidentRegistries;

    public AccidentForm(){
        this.accidentRegistries = new ArrayList<AccidentRegistry>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
