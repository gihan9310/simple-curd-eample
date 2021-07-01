package com.gihanz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.entities.Degree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DegreeDTO implements BaseClassDTO {

    private Long id;
    private String degreeCode;
    private String degreeName;
    private String infoUrl;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    @Valid
    private DurationDTO duration;
    @Valid
    private Set<BatchDTO> batches;

    @JsonIgnore
    public Degree getEntity(){
        Degree entity = new Degree();
        BeanUtils.copyProperties(this,entity);
        entity.setDuration(this.duration==null ?null :this.duration.getDto());
        return entity ;
    }
}
