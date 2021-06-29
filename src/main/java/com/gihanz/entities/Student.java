package com.gihanz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.models.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
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
    private String name;
    private String initials;
    private String lastName;
    private LocalDate dob;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "student",cascade = CascadeType.ALL)
    private StudentContact studentContact;


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

    @JsonIgnore
    public StudentDTO getDto(){
        StudentDTO student = new StudentDTO();
        BeanUtils.copyProperties(this,student);
        student.setStudentContact(this.studentContact==null? null:this.studentContact.getDto());
        return student;
    }

}
