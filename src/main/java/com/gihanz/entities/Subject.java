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
@Table(name = "SUBJECTS")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @Column(unique = true,length = 30,nullable = false)
    private String subjectCode;
    @Column(length = 60,nullable = false)
    private String subjectDescription;
    private double cridit;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

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
