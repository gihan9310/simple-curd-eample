package com.gihanz.services;

import com.gihanz.exceptions.ProjectCreationException;
import com.gihanz.models.DegreeDTO;
import com.gihanz.repositories.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DegreeService {

    @Autowired
    private DegreeRepository degreeRepository;

    @Transactional
    public DegreeDTO createDegree(DegreeDTO degree) {

        try {
            if(degreeRepository.existsByDegreeCode(degree.getDegreeCode())){
                throw new ProjectCreationException("Degree code already exist.");
            }
            if(degreeRepository.existsByDegreeName(degree.getDegreeCode())){
                throw new ProjectCreationException("Degree name already exist.");
            }
            return degreeRepository.save(degree.getEntity()).getDto();
        }catch (Exception e){
            throw new ProjectCreationException("Degree creation error occur.");
        }

    }

    public List<DegreeDTO> findAll() {

        try {
            return  null;
        }catch (Exception e){
            throw new ProjectCreationException("Degree data finding error .");
        }
    }
}
