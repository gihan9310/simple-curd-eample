package com.gihanz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO implements BaseClassDTO{

    Long id ;
    @NotBlank(message = "Subject code required")
    @Size(max = 30,message = "Subject code maximum length 30 characters")
    private String subjectCode;
    @NotBlank(message = "Subject code required")
    @Size(max = 50,message = "Subject code maximum length 30 characters")
    private String subjectDescription;
    private double cridit;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
