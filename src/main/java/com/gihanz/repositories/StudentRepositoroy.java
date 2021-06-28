package com.gihanz.repositories;

import com.gihanz.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoroy extends JpaRepository<Student ,Long> {
}
