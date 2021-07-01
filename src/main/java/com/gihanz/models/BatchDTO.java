package com.gihanz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gihanz.entities.Batch;
import com.gihanz.entities.Degree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BatchDTO implements BaseClassDTO {

    private Long id;
    @NotBlank(message = "Batch number is required")
    private String batchNumber;
    private int nextBachId;
    private LocalDate starDate;
    private LocalDate endDate;
    private Double batchPrice;
    private Double registrationFee;
    private String batchStatus;
    private int NumberOfistrolments;
    private double instrollmentAmount;
    private double fistTimeAmount;
    private Double discount;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Valid
    private DegreeDTO degree;

    Set<SemesterDTO> semesters;

    Set<BatchStudentDTO> batchStudents;

    @JsonIgnore
    public Batch getEntity(){
        Batch entity = new Batch();
        BeanUtils.copyProperties(this,entity);
        entity.setDegree(this.degree==null?null:this.degree.getEntity());
        return entity ;
    }
}
