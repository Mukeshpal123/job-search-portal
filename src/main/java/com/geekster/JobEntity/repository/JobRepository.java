package com.geekster.JobEntity.repository;

import com.geekster.JobEntity.model.Job;
import com.geekster.JobEntity.model.JobType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job,Long> {
    List<Job> findByCompanyName(String companyName);

    List<Job> findByJobType(JobType jobType);

    List<Job> findBySalaryGreaterThanEqual(Double salary);

    @Query("SELECT j FROM Job j WHERE j.employerName = :employerName")
    List<Job> findJobsByEmployerName(@Param("employerName") String employerName);

    @Modifying
    @Query("UPDATE Job j SET j.title = :title WHERE j.id = :id")
    int updateTitleById(@Param("title") String title, @Param("id") Long id);

    @Modifying
    @Query("DELETE FROM Job j WHERE j.id = :id")
    void deleteById(@Param("id") Long id);
}
