package com.gihanz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Student name is required")
    private String name;
    @NotBlank(message = "Student initials is required")
    private String initials;
    @NotBlank(message = "Student last name is required")
    private String lastName;
    @NotBlank(message = "Student dob is required")
    private LocalDate dob;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "project")
//    @JsonIgnore
    private StudentContact studentContact;

}
