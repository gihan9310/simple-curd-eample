package com.gihanz.controllers;

import com.gihanz.entities.Student;
import com.gihanz.models.StudentDTO;
import com.gihanz.services.StudentService;
import com.gihanz.utils.BindingErrorsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/students")
@Slf4j
public class StudentServiceControllers {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentDTO student, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BindingErrorsResponse.errorFlields(bindingResult.getFieldErrors());
        }
        StudentDTO result = studentService.createStudent(student);
        log.info("SAVED..........");
        return new ResponseEntity(result, HttpStatus.OK);

    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAll(){

        log.info("-->> GET ALL");
        List<StudentDTO> students = studentService.getAll();
        return new ResponseEntity(students, HttpStatus.OK);

    }
    @GetMapping(value = "/findBy/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){

        log.info("-->> /findBy/{id}");
        StudentDTO students = studentService.getStudentById(id);
        return new ResponseEntity(students, HttpStatus.OK);

    }

    @DeleteMapping(value = "/deleteBy/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){

        log.info("-->> /deleteBy/{id}");
        Long students = studentService.deleteStudentById(id);
        return new ResponseEntity(students, HttpStatus.OK);

    }

}
