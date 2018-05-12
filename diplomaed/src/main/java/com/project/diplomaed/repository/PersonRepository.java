package com.project.diplomaed.repository;

import com.project.diplomaed.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Administrator on 4/30/2018.
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query("SELECT p FROM Person p WHERE LOWER(p.firstName) = LOWER(:firstName)")
    List<Person> findConverter(@Param("firstName") String firstName);
}
