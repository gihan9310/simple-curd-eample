package com.gihanz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SEMESTERS")
public class Semester implements BaseClass{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int semester;
    private String semesterCode;
    private Double semesterFee;
    private Double discount ;
    private Double examFee;
    private Double repeatExamFeeForSubject;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batchId",updatable = false,nullable = false)
    @JsonIgnore
    private Batch batch;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "semester",cascade = CascadeType.REFRESH,orphanRemoval = true)
    Set<BatchSemesterStudentPayment> semesterStudentPayments;

    @PrePersist
    @JsonIgnore
    protected void onCreate(){
        this.created_at=  LocalDateTime.now();
    }

    @PreUpdate
    @JsonIgnore
    protected void onUpdate(){
        this.updated_at=  LocalDateTime.now();
    }
}
