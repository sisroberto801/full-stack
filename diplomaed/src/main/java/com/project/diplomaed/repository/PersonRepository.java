package com.project.diplomaed.repository;

import com.project.diplomaed.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 4/30/2018.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
}
