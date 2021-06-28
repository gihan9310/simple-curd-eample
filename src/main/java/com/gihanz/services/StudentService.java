package com.gihanz.services;

import com.gihanz.entities.Student;
import com.gihanz.exceptions.StudentException;
import com.gihanz.repositories.StudentContactRepository;
import com.gihanz.repositories.StudentRepositoroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepositoroy studentRepositoroy;

    @Autowired
    private StudentContactRepository studentContactRepository;

    public Student createStudent(Student student){

        try {
            log.debug("Calling student saving.");
            return studentRepositoroy.save(student);
        }catch (Exception e){
            e.printStackTrace();
            throw new StudentException("Student can not create");
        }

    }
}
