package com.nPlusOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private School school;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Pencil> pencil = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pencil> getPencil() {
        return pencil;
    }

    public void setPencil(List<Pencil> pencil) {
        this.pencil = pencil;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
