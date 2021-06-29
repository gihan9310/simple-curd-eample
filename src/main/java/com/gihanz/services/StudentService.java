package com.gihanz.services;

import com.gihanz.entities.Student;
import com.gihanz.exceptions.StudentException;
import com.gihanz.models.StudentDTO;
import com.gihanz.repositories.StudentContactRepository;
import com.gihanz.repositories.StudentRepositoroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepositoroy studentRepositoroy;

    @Autowired
    private StudentContactRepository studentContactRepository;

    @Transactional
    public StudentDTO createStudent(StudentDTO student){

        try {
            log.debug("Calling student saving.");
            return studentRepositoroy.save(student.getEntity()).getDto();
        }catch (Exception e){
            e.printStackTrace();
            throw new StudentException("Student can not create");
        }

    }

    public List<StudentDTO> getAll() {
        try {
            List<StudentDTO> list = new ArrayList<>();
            studentRepositoroy.findAll().forEach(student -> list.add(student.getDto()));
            log.info("List--->>"+list);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            throw new StudentException("Student can not create");
        }
    }

    public StudentDTO getStudentById(Long id) {
        try {
            List<StudentDTO> list = new ArrayList<>();
            Optional<Student> student = studentRepositoroy.findById(id);
            return student.isPresent() ? student.get().getDto() :null;
        }catch (Exception e){
            e.printStackTrace();
            throw new StudentException("Student can not create");
        }
    }

    public Long deleteStudentById(Long id) {
        try {
            List<StudentDTO> list = new ArrayList<>();
              studentRepositoroy.deleteById(id);
            return id;
        }catch (Exception e){
            e.printStackTrace();
            throw new StudentException("Student can not create");
        }
    }

}
