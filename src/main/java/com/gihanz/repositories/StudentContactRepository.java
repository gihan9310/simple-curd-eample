package com.gihanz.repositories;

import com.gihanz.entities.StudentContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentContactRepository extends JpaRepository<StudentContact,Long> {
}
