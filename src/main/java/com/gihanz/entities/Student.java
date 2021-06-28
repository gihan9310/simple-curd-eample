package com.gihanz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Student name is required.")
    private String name;
    @NotBlank(message = "Student initials is required.")
    private String initials;
    @NotBlank(message = "Student last name is required.")
    private String lastName;
//    @NotNull(message = "Student dob is required.")
    private LocalDate dob;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "student",cascade = CascadeType.ALL)
    @Valid
    private StudentContact studentContact;


    @PrePersist
    protected void onCreate(){
        this.created_at=  LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_at=  LocalDateTime.now();
    }

}
