package com.gihanz.repositories;

import com.gihanz.entities.BatchSemesterStudentPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchSemesterStudentPaymentRepository extends JpaRepository<BatchSemesterStudentPayment,Long> {
}
