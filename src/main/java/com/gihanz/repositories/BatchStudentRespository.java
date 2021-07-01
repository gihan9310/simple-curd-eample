package com.gihanz.repositories;

import com.gihanz.entities.BatchStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchStudentRespository extends JpaRepository<BatchStudent,Long> {
}
