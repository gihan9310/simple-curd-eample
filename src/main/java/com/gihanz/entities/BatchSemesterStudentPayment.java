package com.gihanz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BATCH_PAYMENTS")
public class BatchSemesterStudentPayment implements BaseClass{
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private PAYMENT_TYPE payementType;
    private double amount;
    private int semesterCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batchId",updatable = false,nullable = false)
    @JsonIgnore
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "semesterId",updatable = false,nullable = false)
    @JsonIgnore
    private Semester semester;
    
}
