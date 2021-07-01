package com.gihanz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.entities.Duration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DurationDTO implements BaseClassDTO{

    private Long id;
    private int durationYears;
    private int durationInMoths;
    private int semesters;
    private int semestersMoths;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private DegreeDTO degree;
    @JsonIgnore
    public Duration getDto(){
        Duration entity = new Duration();
        BeanUtils.copyProperties(this,entity);
        return entity ;
    }
}
