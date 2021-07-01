package com.gihanz.repositories;

import com.gihanz.entities.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepository extends JpaRepository<Degree,Long> {
    boolean existsByDegreeCode(String degreeCode);
    boolean existsByDegreeName(String degreeName);
}
