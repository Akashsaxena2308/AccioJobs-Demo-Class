package com.accio.springProject.Doctors.Jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class DoctorJpaEntity {

    @Id
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    protected DoctorJpaEntity(){

    }

    public DoctorJpaEntity(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
