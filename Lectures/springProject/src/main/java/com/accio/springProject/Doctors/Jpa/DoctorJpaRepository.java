package com.accio.springProject.Doctors.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorJpaRepository extends JpaRepository<DoctorJpaEntity, Long> {

    List<DoctorJpaEntity> findByName(String name);
}
