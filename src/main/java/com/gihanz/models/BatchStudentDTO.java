package com.gihanz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchStudentDTO implements BaseClassDTO{

    private Long id;
    private LocalDateTime registrationDate;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    @Valid
    private StudentDTO  student ;
    @Valid
    private BatchDTO batch;
}
