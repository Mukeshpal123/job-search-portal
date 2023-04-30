package com.geekster.JobEntity.service;

import com.geekster.JobEntity.model.Job;
import com.geekster.JobEntity.model.JobType;
import com.geekster.JobEntity.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return (List<Job>) jobRepository.findAll();
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    public Job updateJob(Job job) {
        return jobRepository.save(job);
    }

    public void deleteJobById(Long id) {
        jobRepository.deleteById(id);
    }

    public List<Job> getJobsByCompanyName(String companyName) {
        return jobRepository.findByCompanyName(companyName);
    }

    public List<Job> getJobsByJobType(JobType jobType) {
        return jobRepository.findByJobType(jobType);
    }

    public List<Job> getJobsBySalaryGreaterThanEqual(Double salary) {
        return jobRepository.findBySalaryGreaterThanEqual(salary);
    }
}
