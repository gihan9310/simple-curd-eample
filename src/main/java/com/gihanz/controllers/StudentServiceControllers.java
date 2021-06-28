package com.gihanz.controllers;

import com.gihanz.entities.Student;
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

@RestController
@CrossOrigin
@RequestMapping("/students")
@Slf4j
public class StudentServiceControllers {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student, BindingResult bindingResult){

        log.info("-->>"+bindingResult);

        if(bindingResult.hasErrors()){
            return BindingErrorsResponse.errorFlields(bindingResult.getFieldErrors());
        }
        Student result = studentService.createStudent(student);
        return new ResponseEntity(result, HttpStatus.OK);

    }

}
