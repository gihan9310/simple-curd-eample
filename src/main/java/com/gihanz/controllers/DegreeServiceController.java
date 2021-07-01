package com.gihanz.controllers;

import com.gihanz.models.DegreeDTO;
import com.gihanz.models.StudentDTO;
import com.gihanz.services.DegreeService;
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
@RequestMapping("/degreess")
@Slf4j
public class DegreeServiceController {

    @Autowired
   private DegreeService degreeService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStudent(@Valid @RequestBody DegreeDTO dto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return BindingErrorsResponse.errorFlields(bindingResult.getFieldErrors());
        }
        DegreeDTO result = degreeService.createDegree(dto);
        log.info("SAVED..........");
        return new ResponseEntity(result, HttpStatus.OK);

    }

    @PostMapping(value = "/findAll",consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll(){

        List<DegreeDTO> result = degreeService.findAll();
        log.info("SAVED..........");
        return new ResponseEntity(result, HttpStatus.OK);

    }

}
