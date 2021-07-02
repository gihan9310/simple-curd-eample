package com.gihanz.services;

import com.gihanz.entities.Degree;
import com.gihanz.entities.Duration;
import com.gihanz.exceptions.ProjectCreationException;
import com.gihanz.models.DegreeDTO;
import com.gihanz.repositories.DegreeRepository;
import com.gihanz.repositories.DurationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DegreeService {

    @Autowired
    private DegreeRepository degreeRepository;

    @Autowired
    private DurationRepository durationRepository;

    @Transactional
    public DegreeDTO createDegree(DegreeDTO degree) {

        log.debug("Create Degree Save.");
        if(degreeRepository.existsByDegreeCode(degree.getDegreeCode())){
            throw new ProjectCreationException("Degree code already exist.");
        }
        if(degreeRepository.existsByDegreeName(degree.getDegreeName())){
            throw new ProjectCreationException("Degree name already exist.");
        }

        try {
            return degreeRepository.save(degree.getEntity()).getDto();
        }catch (Exception e){
            throw new ProjectCreationException("Degree creation error occur.");
        }

    }

    public List<DegreeDTO> findAll() {

        try {
            List<Degree> degrees = degreeRepository.findAll();
            List<DegreeDTO> list = new ArrayList<>();
            degrees.forEach(i->{
                DegreeDTO dto = i.getDto();
                Duration duration = durationRepository.findByDegree_Id(i.getId());
                dto.setDuration(duration==null?null:duration.getDto());
                list.add(dto);
            });
            return list;
        }catch (Exception e){
            e.printStackTrace();
            throw new ProjectCreationException("Degree data finding error .");
        }
    }
}
