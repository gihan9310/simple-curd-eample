package com.gihanz.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEGRIES")
public class Degree {

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
    private List<Batch> batches;

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

}
