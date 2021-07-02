package com.gihanz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.models.DegreeDTO;
import com.gihanz.models.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEGRIES")
public class Degree implements BaseClass{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String degreeCode;
    private String degreeName;
    private String infoUrl;
    private String Description;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "degree",cascade = CascadeType.ALL)
    private Duration duration;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "degree",cascade = CascadeType.REFRESH,orphanRemoval = true)
    private Set<Batch> batches;

    @PrePersist
    @JsonIgnore
    protected void onCreate(){
        this.created_at=  LocalDateTime.now();
    }

    @PreUpdate
    @JsonIgnore
    protected void onUpdate(){
        this.updated_at=  LocalDateTime.now();
    }


    @JsonIgnore
    public DegreeDTO getDto(){
        DegreeDTO dto = new DegreeDTO();
        BeanUtils.copyProperties(this,dto);
        dto.setDuration(this.duration==null?null:this.duration.getDto());
        if(duration!=null) duration.setDegree(this);
        return dto ;
    }

}
