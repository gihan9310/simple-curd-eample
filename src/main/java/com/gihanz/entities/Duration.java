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
@Table(name = "DEGREE_DUERATIONS")
public class Duration implements BaseClass{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int durationYears;
    private int durationInMoths;
    private int semesters;
    private int semestersMoths;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "degreeId",referencedColumnName = "id")
    @JsonIgnore
    private Degree degree;

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
