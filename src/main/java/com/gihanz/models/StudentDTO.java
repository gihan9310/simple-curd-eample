package com.gihanz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.entities.Student;
import com.gihanz.entities.StudentContact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements BaseClassDTO{

    private Long id;
    @NotBlank(message = "Student name is required.")
    private String name;
    @NotBlank(message = "Student initials is required.")
    private String initials;
    @NotBlank(message = "Student last name is required.")
    private String lastName;

    private LocalDate dob;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    @Valid
    private StudentContactDTO studentContact;

    @JsonIgnore
    public Student getEntity(){
        Student student = new Student();
         BeanUtils.copyProperties(this,student);
         student.setStudentContact(this.studentContact==null ?null:this.studentContact.getDto());
         return student;
    }

}
