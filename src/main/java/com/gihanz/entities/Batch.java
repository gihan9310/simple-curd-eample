package com.gihanz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEGREE_BATCHES")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false,unique = true,length = 20)
    private String batchNumber;
    private int nextBachId;
    private LocalDate starDate;
    private LocalDate endDate;
    private Double batchPrice;
    private Double registrationFee;
    private String batchStatus;
    private int NumberOfistrolments;
    private double instrollmentAmount;
    private double fistTimeAmount;
    private Double discount;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degreeId",updatable = false,nullable = false)
    @JsonIgnore
    private Degree degree;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "batch",cascade = CascadeType.REFRESH,orphanRemoval = true)
    List<BatchStudent> batchStudents;

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
