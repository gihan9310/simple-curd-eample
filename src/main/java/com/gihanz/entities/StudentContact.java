package com.gihanz.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.models.StudentContactDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CONTACTS")
public class StudentContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mobileNumber;
    private String address;

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "studentId",referencedColumnName = "id")
    @JsonIgnore
    private Student student;


    @JsonIgnore
    public StudentContactDTO getDto(){
        StudentContactDTO student = new StudentContactDTO();
        BeanUtils.copyProperties(this,student);
        return student;
    }

}
