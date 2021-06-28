package com.gihanz.services;

import com.gihanz.entities.Student;
import com.gihanz.exceptions.StudentException;
import com.gihanz.repositories.StudentRepositoroy;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Log4j
public class StudentService {

    @Autowired
    private StudentRepositoroy studentRepositoroy;

    public Student createStudent(Student student){

        try {
            return studentRepositoroy.save(student);
        }catch (Exception e){
            throw new StudentException("Student can not create");
        }

    }

}
