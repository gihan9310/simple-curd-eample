package com.gihanz.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STUDENTS")
public class StudentContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Student lastName is required")
    @Size(max = 10,min = 10,message = "")
    @NotBlank(message = "Student mobileNumber is required")
    private String mobileNumber;
    @NotBlank(message = "Student address lastName is required")
    private String address;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentId",nullable = false)
    @JsonIgnore
    private Student student;

}
