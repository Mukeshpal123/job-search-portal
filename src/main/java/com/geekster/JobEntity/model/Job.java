package com.geekster.JobEntity.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @NotNull(message = "Salary is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary should be greater than 0")
    private Double salary;

    @NotBlank(message = "Company name is mandatory")
    private String companyName;

    @NotBlank(message = "Employer name is mandatory")
    private String employerName;

    @NotNull(message = "Job type is mandatory")
    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private LocalDate appliedDate;
}
