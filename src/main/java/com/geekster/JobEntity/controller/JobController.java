package com.geekster.JobEntity.controller;

import com.geekster.JobEntity.model.Job;
import com.geekster.JobEntity.model.JobType;
import com.geekster.JobEntity.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/job")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping(value = "/add")
    public ResponseEntity<Job> createJob(@RequestBody @Valid Job job) {
        Job createdJob = jobService.createJob(job);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Optional<Job> job = jobService.getJobById(id);
        return job.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody @Validated Job job) {
        Optional<Job> existingJob = jobService.getJobById(id);
        if (existingJob.isPresent()) {
            job.setId(id);
            Job updatedJob = jobService.updateJob(job);
            return new ResponseEntity<>(updatedJob, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobById(@PathVariable Long id) {
        Optional<Job> existingJob = jobService.getJobById(id);
        if (existingJob.isPresent()) {
            jobService.deleteJobById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/companyName/{companyName}")
    public ResponseEntity<List<Job>> getJobsByCompanyName(@PathVariable String companyName) {
        List<Job> jobs = jobService.getJobsByCompanyName(companyName);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/jobType/{jobType}")
    public ResponseEntity<List<Job>> getJobsByJobType(@PathVariable JobType jobType) {
        List<Job> jobs = jobService.getJobsByJobType(jobType);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/salary/{salary}")
    public ResponseEntity<List<Job>> getJobsBySalaryGreaterThanEqual(@PathVariable Double salary) {
        List<Job> jobs = jobService.getJobsBySalaryGreaterThanEqual(salary);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
}
