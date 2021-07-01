package com.gihanz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.entities.StudentContact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentContactDTO implements BaseClassDTO{

    private Long id;
    @NotBlank(message = "Student lastName is required.")
    @Size(max = 10,min = 10,message = "Invalid phone number.")
    @NotBlank(message = "Student mobileNumber is required.")
    private String mobileNumber;
    @NotBlank(message = "Student address lastName is required.")
    private String address;

    @JsonIgnore
    public StudentContact getDto(){
        StudentContact student = new StudentContact();
        BeanUtils.copyProperties(this,student);
        return student;
    }
}
