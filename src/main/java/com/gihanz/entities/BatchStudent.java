package com.gihanz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BATCH_STUENTS")
public class BatchStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime registrationDate;
    @Column(updatable = false)
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentId",referencedColumnName = "id")
    @JsonIgnore
    private Student student ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "batchId",referencedColumnName = "id")
    @JsonIgnore
    private Batch batch;

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
